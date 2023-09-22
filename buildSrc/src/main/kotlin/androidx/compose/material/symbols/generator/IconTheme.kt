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

import java.util.Locale

/**
 * Enum representing the different themes for Material symbols.
 *
 * @property themePackageName the lower case name used for package names and in xml files
 * @property themeClassName the CameCase name used for the theme objects
 */
enum class IconTheme(val themePackageName: String, val themeClassName: String) {
    Outlined("outlined", "Outlined"),
    Rounded("rounded", "Rounded"),
    Sharp("sharp", "Sharp")
}

/**
 * Returns the matching [IconTheme] from [this] [IconTheme.themePackageName].
 */
fun String.toIconTheme() = requireNotNull(
    IconTheme.values().find {
        it.themePackageName == this.substringAfter("materialsymbols")
    }
) { "No matching theme found for input $this" }

internal const val AutoMirroredName = "AutoMirrored"
internal val AutoMirroredPackageName = AutoMirroredName.lowercase(Locale.ROOT)
internal const val FilledName = "Filled"
internal val FilledPackageName = FilledName.lowercase(Locale.ROOT)
