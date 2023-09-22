/*
 * Copyright 2020 The Android Open Source Project
 * Copyright 2023 T. Clément (@tclement0922)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.material.symbols.generator

import androidx.compose.material.symbols.generator.vector.FillType
import androidx.compose.material.symbols.generator.vector.PathParser
import androidx.compose.material.symbols.generator.vector.Vector
import androidx.compose.material.symbols.generator.vector.VectorNode
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParser.END_DOCUMENT
import org.xmlpull.v1.XmlPullParser.END_TAG
import org.xmlpull.v1.XmlPullParser.START_TAG
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory

/**
 * Parser that converts [icon]s into [Vector]s
 */
class IconParser(private val icon: Icon) {

    /**
     * @return a [Vector] representing the provided [icon].
     */
    fun parse(): Vector {
        val parser = XmlPullParserFactory.newInstance().newPullParser().apply {
            setInput(icon.fileContent.byteInputStream(), null)
            seekToStartTag()
        }

        check(parser.name == VECTOR) { "The start tag must be <vector>!" }

        val nodes = mutableListOf<VectorNode>()
        var autoMirrored = false
        var viewportWidth: Float? = null
        var viewportHeight: Float? = null

        var currentGroup: VectorNode.Group? = null

        while (!parser.isAtEnd()) {
            when (parser.eventType) {
                START_TAG -> {
                    when (parser.name) {
                        VECTOR -> {
                            autoMirrored = parser.getValueAsBoolean(AUTO_MIRRORED)
                            viewportWidth = parser.getValueAsFloat(VIEWPORT_WIDTH)
                            viewportHeight = parser.getValueAsFloat(VIEWPORT_HEIGHT)
                        }

                        PATH -> {
                            val pathData = parser.getAttributeValue(
                                null,
                                PATH_DATA
                            )
                            val fillAlpha = parser.getValueAsFloat(FILL_ALPHA)
                            val strokeAlpha = parser.getValueAsFloat(STROKE_ALPHA)
                            val fillType = when (parser.getAttributeValue(null, FILL_TYPE)) {
                                // evenOdd and nonZero are the only supported values here, where
                                // nonZero is the default if no values are defined.
                                EVEN_ODD -> FillType.EvenOdd
                                else -> FillType.NonZero
                            }
                            val path = VectorNode.Path(
                                strokeAlpha = strokeAlpha ?: 1f,
                                fillAlpha = fillAlpha ?: 1f,
                                fillType = fillType,
                                nodes = PathParser.parsePathString(pathData)
                            )
                            if (currentGroup != null) {
                                currentGroup.paths.add(path)
                            } else {
                                nodes.add(path)
                            }
                        }
                        // Material icons are simple and don't have nested groups, so this can be simple
                        GROUP -> {
                            val group = VectorNode.Group()
                            currentGroup = group
                            nodes.add(group)
                        }

                        CLIP_PATH -> { /* TODO: b/147418351 - parse clipping paths */
                        }
                    }
                }
            }
            parser.next()
        }

        return Vector(autoMirrored, viewportWidth, viewportHeight, nodes)
    }
}

/**
 * @return the float value for the attribute [name], or null if it couldn't be found
 */
private fun XmlPullParser.getValueAsFloat(name: String) =
    getAttributeValue(null, name)?.toFloatOrNull()

/**
 * @return the boolean value for the attribute [name], or 'false' if it couldn't be found
 */
private fun XmlPullParser.getValueAsBoolean(name: String) =
    getAttributeValue(null, name).toBoolean()

private fun XmlPullParser.seekToStartTag(): XmlPullParser {
    var type = next()
    while (type != START_TAG && type != END_DOCUMENT) {
        // Empty loop
        type = next()
    }
    if (type != START_TAG) {
        throw XmlPullParserException("No start tag found")
    }
    return this
}

private fun XmlPullParser.isAtEnd() =
    eventType == END_DOCUMENT || (depth < 1 && eventType == END_TAG)

// XML tag names
private const val VECTOR = "vector"
private const val CLIP_PATH = "clip-path"
private const val GROUP = "group"
private const val PATH = "path"

// XML attribute names
private const val AUTO_MIRRORED = "android:autoMirrored"
private const val VIEWPORT_WIDTH = "android:viewportWidth"
private const val VIEWPORT_HEIGHT = "android:viewportHeight"
private const val PATH_DATA = "android:pathData"
private const val FILL_ALPHA = "android:fillAlpha"
private const val STROKE_ALPHA = "android:strokeAlpha"
private const val FILL_TYPE = "android:fillType"

// XML attribute values
private const val EVEN_ODD = "evenOdd"
