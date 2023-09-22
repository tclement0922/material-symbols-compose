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

import androidx.compose.material.symbols.generator.variance.Variance
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FileSpec
import java.io.File

/**
 * Generates programmatic representation of all [icons] using [ImageVectorGenerator].
 *
 * @property icons the list of [Icon]s to generate Kotlin files for
 */
class IconWriter(private val icons: List<Icon>) {
    /**
     * Generates icons and writes them in a single file, grouped by [Variance] to [outputSrcDirectory].
     *
     * @param outputSrcDirectory the directory to generate source files in.
     */
    fun generateToSingle(
        outputSrcDirectory: File
    ) {
        icons.groupBy { it.variance }.forEach { (variance, icons) ->
            val builder = createFileSpecBuilder(variance)
            builder.addSuppressAnnotation()

            for (icon in icons) {
                val vector = IconParser(icon).parse()

                ImageVectorGenerator(
                    icon,
                    vector
                ).editFileSpec(builder)

                // Write additional file specs for auto-mirrored icons. These files will be written into
                // an automirrored package and will hold a similar icons theme structure underneath.
                if (vector.autoMirrored) {
                    ImageVectorGenerator(
                        icon,
                        vector
                    ).editAutoMirroredFileSpec(builder)
                }
            }

            builder.build()
                .writeToWithCopyright(File(outputSrcDirectory.path + '/' + variance.flavorFolderName + "/kotlin"))
        }
    }

    /**
     * Generates icons and writes them in multiple files, one file per icon variant to [outputSrcDirectory].
     *
     * @param outputSrcDirectory the directory to generate source files in.
     */
    fun generateToMultiple(
        outputSrcDirectory: File
    ) {
        icons.forEach { icon ->
            val outDir =
                File(outputSrcDirectory.path + '/' + icon.variance.flavorFolderName + "/kotlin")

            val vector = IconParser(icon).parse()

            ImageVectorGenerator(
                icon,
                vector
            ).createFileSpec()
                .writeToWithCopyright(outDir)

            // Write additional file specs for auto-mirrored icons. These files will be written into
            // an automirrored package and will hold a similar icons theme structure underneath.
            if (vector.autoMirrored) {
                ImageVectorGenerator(
                    icon,
                    vector
                ).createAutoMirroredFileSpec()
                    .writeToWithCopyright(outDir)
            }
        }
    }

    private fun createFileSpecBuilder(variance: Variance): FileSpec.Builder {
        return FileSpec.builder(
            packageName = variance.packageName,
            fileName = "SymbolsExtensions"
        )
    }

    companion object {
        fun FileSpec.Builder.addSuppressAnnotation() {
            addAnnotation(
                AnnotationSpec
                    .builder(Suppress::class)
                    .addMember("\"UnusedReceiverParameter\", \"RedundantVisibilityModifier\", \"ObjectPropertyName\"")
                    .build()
            )
        }
    }
}
