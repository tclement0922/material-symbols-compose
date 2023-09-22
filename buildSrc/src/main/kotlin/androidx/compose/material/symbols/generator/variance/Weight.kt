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
 * Enum representing the different weights of a Material symbol.
 *
 * @property fileIndicator the keyword in the source xml file name that indicates which weight the symbol has
 * @property packageName the lower case name used for package names
 * @property className the camel case name used for class names
 */
enum class Weight(val fileIndicator: String?, val packageName: String, val className: String) {
    W_100("wght100", "w100", "Weight100"),
    W_200("wght200", "w200", "Weight200"),
    W_300("wght300", "w300", "Weight300"),
    W_400(null, "w400", "Weight400"),
    W_500("wght500", "w500", "Weight500"),
    W_600("wght600", "w600", "Weight600"),
    W_700("wght700", "w700", "Weight700");

    companion object {
        private val DEFAULT inline get() = W_400

        /**
         * Get the symbol [Weight] from [variationsString].
         */
        fun extractFromString(variationsString: String): Weight {
            return values().firstOrNull {
                it.fileIndicator != null && it.fileIndicator in variationsString
            } ?: DEFAULT
        }
    }
}