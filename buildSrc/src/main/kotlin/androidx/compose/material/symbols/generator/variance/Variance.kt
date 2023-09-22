/*
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

package androidx.compose.material.symbols.generator.variance

import androidx.compose.material.symbols.generator.AutoMirroredName
import androidx.compose.material.symbols.generator.AutoMirroredPackageName
import androidx.compose.material.symbols.generator.FilledName
import androidx.compose.material.symbols.generator.FilledPackageName
import androidx.compose.material.symbols.generator.IconTheme
import androidx.compose.material.symbols.generator.PackageNames
import androidx.compose.material.symbols.generator.className
import org.gradle.kotlin.dsl.support.uppercaseFirstChar

data class Variance(
    val theme: IconTheme,
    val weight: Weight,
    val grade: Grade,
    val isFilled: Boolean
) {
    val className get() = PackageNames.MaterialSymbolsPackage.className(
        "Symbols", theme.themeClassName, grade.className, weight.className
    )
    val packageName get() = PackageNames.MaterialSymbolsPackage.packageName + '.' +
        theme.themePackageName + '.' + grade.packageName + '.' + weight.packageName

    val autoMirroredClassName get() = PackageNames.MaterialSymbolsPackage.className(
        "Symbols", AutoMirroredName, theme.themeClassName, grade.className, weight.className
    )
    val autoMirroredPackageName get() = PackageNames.MaterialSymbolsPackage.packageName + '.' +
            theme.themePackageName + '.' + AutoMirroredPackageName + '.' + grade.packageName + '.' + weight.packageName

    val filledClassName get() = PackageNames.MaterialSymbolsPackage.className(
        "Symbols", theme.themeClassName, grade.className, weight.className, FilledName
    )
    val filledPackageName get() = PackageNames.MaterialSymbolsPackage.packageName + '.' +
            theme.themePackageName + '.' + FilledPackageName + '.' + grade.packageName + '.' + weight.packageName

    val autoMirroredFilledClassName get() = PackageNames.MaterialSymbolsPackage.className(
        "Symbols", AutoMirroredName, theme.themeClassName, grade.className, weight.className, FilledName
    )
    val autoMirroredFilledPackageName get() = PackageNames.MaterialSymbolsPackage.packageName + '.' +
            theme.themePackageName + '.' + AutoMirroredPackageName + '.' + FilledPackageName + '.' + grade.packageName + '.' + weight.packageName

    val flavorFolderName get() =
            theme.themePackageName + grade.packageName.uppercaseFirstChar() + weight.packageName.uppercaseFirstChar()
}