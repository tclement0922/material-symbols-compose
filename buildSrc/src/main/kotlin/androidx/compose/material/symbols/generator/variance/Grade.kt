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

/**
 * Enum representing the different grades of a Material symbol.
 *
 * @property fileIndicator the keyword in the source xml file name that indicates which grade the symbol has
 * @property packageName the lower case name used for package names
 * @property className the camel case name used for class names
 */
enum class Grade(val fileIndicator: String?, val packageName: String, val className: String) {
    G_0(null, "g0", "Grade0"),
    G_200("grad200", "g200", "Grade200"),
    G_N25("gradN25", "gn25", "GradeN25");

    companion object {
        private val DEFAULT inline get() = G_0

        /**
         * Get the symbol [Grade] from [variationsString].
         */
        fun extractFromString(variationsString: String): Grade {
            return values().firstOrNull {
                it.fileIndicator != null && it.fileIndicator in variationsString
            } ?: DEFAULT
        }
    }
}