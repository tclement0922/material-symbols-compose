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

/**
 * Represents a icon's Kotlin name, processed XML file name, theme, and XML file content.
 *
 * The [kotlinName] is typically the PascalCase equivalent of the original icon name, with the
 * caveat that icons starting with a number are prefixed with an underscore.
 *
 * @property kotlinName the name of the generated Kotlin property, for example `ZoomOutMap`.
 * @property variance the variance (grade, weight and filled state) of this icon.
 * @property fileContent the content of the source XML file that will be parsed.
 * @property autoMirrored indicates that this Icon can be auto-mirrored on Right to Left layouts.
 */
data class Icon(
    val kotlinName: String,
    val fileContent: String,
    val autoMirrored: Boolean,
    val variance: Variance
)
