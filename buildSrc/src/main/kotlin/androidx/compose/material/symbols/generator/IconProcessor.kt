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

import androidx.compose.material.symbols.generator.variance.Grade
import androidx.compose.material.symbols.generator.variance.Variance
import androidx.compose.material.symbols.generator.variance.Weight
import com.google.common.base.CaseFormat
import java.io.File

/**
 * Processes vector drawables in [iconDirectories] into a list of icons, removing any unwanted
 * attributes (such as android: attributes that reference the theme) from the XML source.
 *
 * Each directory in [iconDirectories] should contain a flat list of icons to process. For example,
 * given the existing structure in raw-icons:
 *
 * // Icon name
 * ├── alarm
 *     // Theme name
 *     ├── materialsymbolsoutlined
 *         // Icon variant xml
 *         ├── alarm_24px.xml
 *         ├── alarm_fill1_24px.xml
 *         ├── alarm_grad200_24px.xml
 *         └── alarm_wght300gradN25fill1_24px.xml
 *     ├── materialsymbolsrounded
 *     └── materialsymbolssharp
 * ├── album
 * └── book
 *
 * Each directory in [iconDirectories] should be a icon directory.
 *
 * @param iconDirectories list of directories containing icon to process
 */
class IconProcessor(
    private val iconDirectories: List<File>
) {
    /**
     * @return a list of processed [Icon]s, from the provided [iconDirectories].
     */
    fun process(): List<Icon> {
        val icons = loadIcons()

        ensureIconsExistInAllThemes(icons)

        return icons
    }

    private fun loadIcons(): List<Icon> {
        val iconDirs = iconDirectories

        return iconDirs.flatMap { iconDir ->
            val iconName = iconDir.name
            val themes = iconDir
                .listFiles { file ->
                    file.isDirectory
                }

            themes?.flatMap { themeDir ->
                val theme = themeDir.name.toIconTheme()
                val variants = themeDir
                    .listFiles { file ->
                        !file.isDirectory && "24px" in file.name
                    }

                variants?.map { file ->
                    val variationsString = file.name.removePrefix(iconName).substringBeforeLast('.')
                    val weight = Weight.extractFromString(variationsString)
                    val grade = Grade.extractFromString(variationsString)
                    val isFilled = variationsString.contains("fill1")
                    val kotlinName = iconName.toKotlinPropertyName()
                    val fileContent = file.readText()
                    Icon(
                        kotlinName = kotlinName,
                        fileContent = processXmlFile(fileContent),
                        autoMirrored = isAutoMirrored(fileContent),
                        variance = Variance(
                            theme = theme,
                            weight = weight,
                            grade = grade,
                            isFilled = isFilled
                        )
                    )
                } ?: emptyList()
            } ?: emptyList()
        }
    }
}

/**
 * Processes the given [fileContent] by removing android theme attributes and values.
 */
private fun processXmlFile(fileContent: String): String {
    // Remove any defined tint for paths that use theme attributes
    val tintAttribute = Regex.escape("""android:tint="?attr/colorControlNormal"""")
    val tintRegex = """\n.*?$tintAttribute""".toRegex(RegexOption.MULTILINE)

    return fileContent
        .replace(tintRegex, "")
        // The imported icons have white as the default path color, so let's change it to be
        // black as is typical on Android.
        .replace("@android:color/white", "@android:color/black")
}

/**
 * Returns true if the given [fileContent] includes an `android:autoMirrored="true"` attribute.
 */
private fun isAutoMirrored(fileContent: String): Boolean =
    fileContent.contains(Regex.fromLiteral("""android:autoMirrored="true""""))

/**
 * Ensures that each icon in each theme is available in every other theme
 */
private fun ensureIconsExistInAllThemes(icons: List<Icon>) {
    val groupedIcons = icons.groupBy { it.variance.theme }

    check(groupedIcons.keys.containsAll(IconTheme.values().toList())) {
        "Some themes were missing from the generated icons"
    }

    val expectedIconNames = groupedIcons.values.map { themeIcons ->
        themeIcons.map { icon -> icon.kotlinName }.sorted()
    }

    expectedIconNames.first().let { expected ->
        expectedIconNames.forEach { actual ->
            check(actual == expected) {
                "Not all icons were found in all themes $actual $expected"
            }
        }
    }
}

/**
 * Converts a snake_case name to a KotlinProperty name.
 *
 * If the first character of [this] is a digit, the resulting name will be prefixed with an `_`
 */
private fun String.toKotlinPropertyName(): String {
    return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, this).let { name ->
        if (name.first().isDigit()) "_$name" else name
    }
}
