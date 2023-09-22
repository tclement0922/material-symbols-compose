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

import androidx.compose.material.symbols.generator.IconWriter.Companion.addSuppressAnnotation
import androidx.compose.material.symbols.generator.vector.FillType
import androidx.compose.material.symbols.generator.vector.Vector
import androidx.compose.material.symbols.generator.vector.VectorNode
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.buildCodeBlock
import java.util.Locale

/**
 * Generator for creating a Kotlin source file with an ImageVector property for the given [vector],
 * from the icon [icon]
 *
 * @param icon the icon used to generate the property and the file.
 * @param vector the parsed vector to generate ImageVector.Builder commands for
 */
class ImageVectorGenerator(
    private val icon: Icon,
    private val vector: Vector
) {
    /**
     * @return a [FileSpec] representing a Kotlin source file containing the property for this
     * programmatic [vector] representation.
     */
    fun editFileSpec(builder: FileSpec.Builder) {
        val backingProperty = getBackingProperty(autoMirror = false)
        // Create a property with a getter. The autoMirror is always false in this case.
        val propertySpecBuilder =
            PropertySpec.builder(name = icon.kotlinName, type = ClassNames.ImageVector)
                .receiver(
                    with(icon.variance) {
                        if (isFilled) filledClassName else className
                    }
                )
                .getter(
                    iconGetter(
                        backingProperty = backingProperty,
                        icon = icon,
                        autoMirror = false
                    )
                )
        // Add a deprecation warning with a suggestion to replace this icon's usage with its
        // equivalent that was generated under the automirrored package.
        if (vector.autoMirrored) {
            val autoMirroredPackage = icon.variance.packageName
            propertySpecBuilder.addAnnotation(
                AnnotationSpec.builder(Deprecated::class)
                    .addMember(
                        "\"\"\"Use the AutoMirrored version at %N.%N.%N.%N.%N.%N\"\"\"",
                        ClassNames.Symbols.simpleName,
                        AutoMirroredName,
                        icon.variance.theme.themeClassName,
                        icon.variance.grade.className,
                        icon.variance.weight.className,
                        icon.kotlinName
                    )
                    .addMember(
                        "ReplaceWith( \"%N.%N.%N.%N.%N.%N\", \"$autoMirroredPackage.%N\")",
                        ClassNames.Symbols.simpleName,
                        AutoMirroredName,
                        icon.variance.theme.themeClassName,
                        icon.variance.grade.className,
                        icon.variance.weight.className,
                        icon.kotlinName,
                        icon.kotlinName
                    )
                    .build()
            )
        }
        builder.addProperty(propertySpecBuilder.build())
        builder.addProperty(backingProperty)
    }

    /**
     * @return a [FileSpec] representing a Kotlin source file containing the property for this
     * programmatic, auto-mirrored, [vector] representation.
     */
    fun editAutoMirroredFileSpec(builder: FileSpec.Builder) {
        val backingProperty = getBackingProperty(autoMirror = true)
        // Create a property with a getter. The autoMirror is always false in this case.
        builder.addProperty(
            PropertySpec.builder(name = icon.kotlinName, type = ClassNames.ImageVector)
                .receiver(
                    with(icon.variance) {
                        if (isFilled) autoMirroredFilledClassName else autoMirroredClassName
                    }
                )
                .getter(
                    iconGetter(
                        backingProperty = backingProperty,
                        icon = icon,
                        autoMirror = true
                    )
                )
                .build()
        )
        builder.addProperty(backingProperty)
    }

    private fun createFileSpecBuilder(): FileSpec.Builder {
        return FileSpec.builder(
            packageName = with (icon.variance) {
                if (isFilled) filledPackageName else packageName
            },
            fileName = icon.kotlinName
        )
    }

    fun createFileSpec(): FileSpec {
        val builder = createFileSpecBuilder()
        builder.addSuppressAnnotation()
        editFileSpec(builder)
        return builder.build()
    }

    private fun createAutoMirroredFileSpecBuilder(): FileSpec.Builder {
        return FileSpec.builder(
            packageName = with (icon.variance) {
                if (isFilled) autoMirroredFilledPackageName else autoMirroredPackageName
            },
            fileName = icon.kotlinName
        )
    }

    fun createAutoMirroredFileSpec(): FileSpec {
        val builder = createAutoMirroredFileSpecBuilder()
        builder.addSuppressAnnotation()
        editAutoMirroredFileSpec(builder)
        return builder.build()
    }

    private fun getBackingProperty(autoMirror: Boolean): PropertySpec {
        // Use a unique property name for the private backing property. This is because (as of
        // Kotlin 1.4) each property with the same name will be considered as a possible candidate
        // for resolution, regardless of the access modifier, so by using unique names we reduce
        // the size from ~6000 to 1, and speed up compilation time for these icons.
        var backingPropertyName =
            "_" + icon.kotlinName.replaceFirstChar { it.lowercase(Locale.ROOT) }
        if (autoMirror)
            backingPropertyName += "_$AutoMirroredPackageName"
        if (icon.variance.isFilled)
            backingPropertyName += "_filled"
        return backingProperty(name = backingPropertyName)
    }

    /**
     * @return the body of the getter for the icon property. This getter returns the backing
     * property if it is not null, otherwise creates the icon and 'caches' it in the backing
     * property, and then returns the backing property.
     */
    private fun iconGetter(
        backingProperty: PropertySpec,
        icon: Icon,
        autoMirror: Boolean
    ): FunSpec {
        return FunSpec.getterBuilder()
            .addCode(
                buildCodeBlock {
                    beginControlFlow("if (%N != null)", backingProperty)
                    addStatement("return %N!!", backingProperty)
                    endControlFlow()
                }
            )
            .addCode(
                buildCodeBlock {
                    val controlFlow = buildString {
                        append("%N = %M(name=\"")
                        if (autoMirror)
                            append("$AutoMirroredName.")
                        append("%N.%N.%N")
                        if (icon.variance.isFilled)
                            append(".Filled")
                        append(".%N")
                        append("\", viewportWidth=${vector.viewportWidth.kotlinString()}, viewportHeight=${vector.viewportHeight.kotlinString()}")
                        if (autoMirror)
                            append(", autoMirror=true")
                        append(")")
                    }
                    beginControlFlow(
                        controlFlow,
                        backingProperty,
                        MemberNames.MaterialSymbol,
                        icon.variance.theme.themeClassName,
                        icon.variance.grade.className,
                        icon.variance.weight.className,
                        icon.kotlinName
                    )
                    vector.nodes.forEach { node -> addRecursively(node) }
                    endControlFlow()
                }
            )
            .addStatement("return %N!!", backingProperty)
            .build()
    }

    /**
     * @return The private backing property that is used to cache the ImageVector for a given
     * icon once created.
     *
     * @param name the name of this property
     */
    private fun backingProperty(name: String): PropertySpec {
        val nullableImageVector = ClassNames.ImageVector.copy(nullable = true)
        return PropertySpec.builder(name = name, type = nullableImageVector)
            .mutable()
            .addModifiers(KModifier.PRIVATE)
            .initializer("null")
            .build()
    }
}

/**
 * Recursively adds function calls to construct the given [vectorNode] and its children.
 */
private fun CodeBlock.Builder.addRecursively(vectorNode: VectorNode) {
    when (vectorNode) {
        // TODO: b/147418351 - add clip-paths once they are supported
        is VectorNode.Group -> {
            beginControlFlow("%M", MemberNames.Group)
            vectorNode.paths.forEach { path ->
                addRecursively(path)
            }
            endControlFlow()
        }

        is VectorNode.Path -> {
            addPath(vectorNode) {
                vectorNode.nodes.forEach { pathNode ->
                    addStatement(pathNode.asFunctionCall())
                }
            }
        }
    }
}

/**
 * Adds a function call to create the given [path], with [pathBody] containing the commands for
 * the path.
 */
private fun CodeBlock.Builder.addPath(
    path: VectorNode.Path,
    pathBody: CodeBlock.Builder.() -> Unit
) {
    // Only set the fill type if it is EvenOdd - otherwise it will just be the default.
    val setFillType = path.fillType == FillType.EvenOdd

    val parameterList = with(path) {
        listOfNotNull(
            "fillAlpha = ${fillAlpha}f".takeIf { fillAlpha != 1f },
            "strokeAlpha = ${strokeAlpha}f".takeIf { strokeAlpha != 1f },
            "pathFillType = %M".takeIf { setFillType }
        )
    }

    val parameters = if (parameterList.isNotEmpty()) {
        parameterList.joinToString(prefix = "(", postfix = ")")
    } else {
        ""
    }

    if (setFillType) {
        beginControlFlow("%M$parameters", MemberNames.MaterialPath, MemberNames.EvenOdd)
    } else {
        beginControlFlow("%M$parameters", MemberNames.MaterialPath)
    }
    pathBody()
    endControlFlow()
}

private fun Float?.kotlinString(): String {
    if (this == null) return "null"
    return "${this}f"
}
