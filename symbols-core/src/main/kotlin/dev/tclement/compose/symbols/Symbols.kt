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

package dev.tclement.compose.symbols

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.DefaultFillType
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathBuilder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import dev.tclement.compose.symbols.Symbols.Outlined
import dev.tclement.compose.symbols.Symbols.Rounded
import dev.tclement.compose.symbols.Symbols.Sharp

/**
 * [Material Symbols](https://m3.material.io/styles/icons) as seen on
 * [Google Fonts](https://fonts.google.com/icons).
 *
 * Material Symbols are the new default, and are available in three styles: [Outlined], [Rounded],
 * and [Sharp].
 * Each theme contains the same icons, but with a distinct visual style. You should typically
 * choose one theme and use it across your application for consistency. For example, you may want
 * to use a property or a typealias to refer to a specific theme, so it can be accessed in a
 * semantically meaningful way from inside other composables.
 *
 * Symbols maintain the same names defined by Material, but with their snake_case name converted to
 * PascalCase. For example: add_alarm becomes AddAlarm.
 *
 * Note: Icons that start with a number, such as `360`, are prefixed with a '_', becoming '_360'.
 *
 * To draw an icon, you can use an [androidx.compose.material.Icon]. This component applies tint
 * and provides layout size matching the icon.
 */
object Symbols {

    /**
     * [Outlined symbols](https://fonts.google.com/icons?icon.style=Outlined) use stroke and
     * fill attributes for a light, clean style that works well in dense UIs. The stroke weight
     * of outlined icons can be adjusted to complement or contrast the weight of your typography.
     */
    object Outlined {
        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade 0 is the default grade for dark icons on light backgrounds.
         */
        object Grade0 {
            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 100 is the equivalent of the thin variant of a text font.
             */
            object Weight100 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 200 is the equivalent of the extra-light variant of a text font.
             */
            object Weight200 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 300 is the equivalent of the light variant of a text font.
             */
            object Weight300 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 400 is the equivalent of the regular variant of a text font.
             */
            object Weight400 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 500 is the equivalent of the medium variant of a text font.
             */
            object Weight500 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 600 is the equivalent of the semi-bold variant of a text font.
             */
            object Weight600 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 700 is the equivalent of the bold variant of a text font.
             */
            object Weight700 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade 200 can be used to set an high emphasis on a icon, for example when its selected.
         */
        object Grade200 {
            /**
             * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight100 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight200 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight300 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight400 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight500 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight600 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight700 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade -25 (n25) is the default grade for light icons on dark backgrounds.
         */
        object GradeN25 {
            /**
             * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight100 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight200 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight300 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight400 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight500 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight600 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight700 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * Alias for [Grade0], the default grade.
         */
        val GradeDefault = Grade0
    }

    /**
     * [Rounded symbols](https://fonts.google.com/icons?icon.style=Rounded) use a corner radius
     * that pairs well with brands that use heavier typography, curved logos, or circular
     * elements to express their style.
     */
    object Rounded {
        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade 0 is the default grade for dark icons on light backgrounds.
         */
        object Grade0 {
            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 100 is the equivalent of the thin variant of a text font.
             */
            object Weight100 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 200 is the equivalent of the extra-light variant of a text font.
             */
            object Weight200 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 300 is the equivalent of the light variant of a text font.
             */
            object Weight300 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 400 is the equivalent of the regular variant of a text font.
             */
            object Weight400 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 500 is the equivalent of the medium variant of a text font.
             */
            object Weight500 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 600 is the equivalent of the semi-bold variant of a text font.
             */
            object Weight600 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 700 is the equivalent of the bold variant of a text font.
             */
            object Weight700 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade 200 can be used to set an high emphasis on a icon, for example when its selected.
         */
        object Grade200 {
            /**
             * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight100 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight200 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight300 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight400 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight500 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight600 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight700 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade -25 (n25) is the default grade for light icons on dark backgrounds.
         */
        object GradeN25 {
            /**
             * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight100 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight200 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight300 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight400 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight500 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight600 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight700 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * Alias for [Grade0], the default grade.
         */
        val GradeDefault = Grade0
    }

    /**
     * [Sharp symbols](https://fonts.google.com/icons?icon.style=Sharp) display corners with
     * straight edges, for a crisp style that remains legible even at smaller scales. These
     * rectangular shapes can support brand styles that aren’t well-reflected by rounded shapes.
     */
    object Sharp {
        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade 0 is the default grade for dark icons on light backgrounds.
         */
        object Grade0 {
            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 100 is the equivalent of the thin variant of a text font.
             */
            object Weight100 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 200 is the equivalent of the extra-light variant of a text font.
             */
            object Weight200 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 300 is the equivalent of the light variant of a text font.
             */
            object Weight300 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 400 is the equivalent of the regular variant of a text font.
             */
            object Weight400 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 500 is the equivalent of the medium variant of a text font.
             */
            object Weight500 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 600 is the equivalent of the semi-bold variant of a text font.
             */
            object Weight600 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
             *
             * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
             * and bold (700). Weight can also affect the overall size of the symbol.
             *
             * Weight 700 is the equivalent of the bold variant of a text font.
             */
            object Weight700 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                 *
                 * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                 *
                 * A fill attribute can be used to convey a state of transition, such as unfilled
                 * and filled states. Values range from 0 to 1, with 1 being completely filled.
                 * Along with weight, fill is a primary attribute that impacts the overall look of a
                 * symbol.
                 *
                 * This object is the equivalent of the fill value 1, the default value being 0.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade 200 can be used to set an high emphasis on a icon, for example when its selected.
         */
        object Grade200 {
            /**
             * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight100 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight200 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight300 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight400 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight500 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight600 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight700 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
         *
         * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
         * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
         * compensate for visual bleed, which is when images can look bigger or smaller depending on
         * the color contrast. To match the apparent icon size, the default grade for a dark icon on
         * a light background is 0, and -25 for a light icon on a dark background.
         *
         * Grade -25 (n25) is the default grade for light icons on dark backgrounds.
         */
        object GradeN25 {
            /**
             * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight100 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight200 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight300 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight400 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight500 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight600 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
             * from 100 to 700, the lower the thinner.
             */
            object Weight700 {
                /**
                 * Filled variants of the symbols, similar to the old Filled theme.
                 */
                object Filled
            }

            /**
             * Alias for [Weight400], the default weight.
             */
            val WeightDefault = Weight400
        }

        /**
         * Alias for [Grade0], the default grade.
         */
        val GradeDefault = Grade0
    }

    /**
     * [Material Symbols](https://m3.material.io/styles/icons) as seen on
     * [Google Fonts](https://fonts.google.com/icons).
     *
     * Material Symbols are the new default, and are available in three styles: [Outlined], [Rounded],
     * and [Sharp].
     * Each theme contains the same icons, but with a distinct visual style. You should typically
     * choose one theme and use it across your application for consistency. For example, you may want
     * to use a property or a typealias to refer to a specific theme, so it can be accessed in a
     * semantically meaningful way from inside other composables.
     *
     * Symbols maintain the same names defined by Material, but with their snake_case name converted to
     * PascalCase. For example: add_alarm becomes AddAlarm.
     *
     * Note: Icons that start with a number, such as `360`, are prefixed with a '_', becoming '_360'.
     *
     * To draw an icon, you can use an [androidx.compose.material.Icon]. This component applies tint
     * and provides layout size matching the icon.
     */
    object AutoMirrored {

        /**
         * [Outlined symbols](https://fonts.google.com/icons?icon.style=Outlined) use stroke and
         * fill attributes for a light, clean style that works well in dense UIs. The stroke weight
         * of outlined icons can be adjusted to complement or contrast the weight of your typography.
         */
        object Outlined {
            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade 0 is the default grade for dark icons on light backgrounds.
             */
            object Grade0 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 100 is the equivalent of the thin variant of a text font.
                 */
                object Weight100 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 200 is the equivalent of the extra-light variant of a text font.
                 */
                object Weight200 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 300 is the equivalent of the light variant of a text font.
                 */
                object Weight300 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 400 is the equivalent of the regular variant of a text font.
                 */
                object Weight400 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 500 is the equivalent of the medium variant of a text font.
                 */
                object Weight500 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 600 is the equivalent of the semi-bold variant of a text font.
                 */
                object Weight600 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 700 is the equivalent of the bold variant of a text font.
                 */
                object Weight700 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade 200 can be used to set an high emphasis on a icon, for example when its selected.
             */
            object Grade200 {
                /**
                 * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight100 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight200 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight300 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight400 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight500 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight600 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight700 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade -25 (n25) is the default grade for light icons on dark backgrounds.
             */
            object GradeN25 {
                /**
                 * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight100 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight200 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight300 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight400 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight500 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight600 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight700 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * Alias for [Grade0], the default grade.
             */
            val GradeDefault = Grade0
        }

        /**
         * [Rounded symbols](https://fonts.google.com/icons?icon.style=Rounded) use a corner radius
         * that pairs well with brands that use heavier typography, curved logos, or circular
         * elements to express their style.
         */
        object Rounded {
            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade 0 is the default grade for dark icons on light backgrounds.
             */
            object Grade0 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 100 is the equivalent of the thin variant of a text font.
                 */
                object Weight100 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 200 is the equivalent of the extra-light variant of a text font.
                 */
                object Weight200 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 300 is the equivalent of the light variant of a text font.
                 */
                object Weight300 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 400 is the equivalent of the regular variant of a text font.
                 */
                object Weight400 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 500 is the equivalent of the medium variant of a text font.
                 */
                object Weight500 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 600 is the equivalent of the semi-bold variant of a text font.
                 */
                object Weight600 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 700 is the equivalent of the bold variant of a text font.
                 */
                object Weight700 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade 200 can be used to set an high emphasis on a icon, for example when its selected.
             */
            object Grade200 {
                /**
                 * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight100 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight200 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight300 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight400 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight500 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight600 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight700 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade -25 (n25) is the default grade for light icons on dark backgrounds.
             */
            object GradeN25 {
                /**
                 * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight100 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight200 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight300 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight400 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight500 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight600 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight700 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * Alias for [Grade0], the default grade.
             */
            val GradeDefault = Grade0
        }

        /**
         * [Sharp symbols](https://fonts.google.com/icons?icon.style=Sharp) display corners with
         * straight edges, for a crisp style that remains legible even at smaller scales. These
         * rectangular shapes can support brand styles that aren’t well-reflected by rounded shapes.
         */
        object Sharp {
            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade 0 is the default grade for dark icons on light backgrounds.
             */
            object Grade0 {
                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 100 is the equivalent of the thin variant of a text font.
                 */
                object Weight100 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 200 is the equivalent of the extra-light variant of a text font.
                 */
                object Weight200 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 300 is the equivalent of the light variant of a text font.
                 */
                object Weight300 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 400 is the equivalent of the regular variant of a text font.
                 */
                object Weight400 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 500 is the equivalent of the medium variant of a text font.
                 */
                object Weight500 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 600 is the equivalent of the semi-bold variant of a text font.
                 */
                object Weight600 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * From [material.io](https://m3.material.io/styles/icons/applying-icons#d7f45762-67ac-473d-95b0-9214c791e242):
                 *
                 * Weight defines the symbol’s stroke weight, with a range of weights between thin (100)
                 * and bold (700). Weight can also affect the overall size of the symbol.
                 *
                 * Weight 700 is the equivalent of the bold variant of a text font.
                 */
                object Weight700 {
                    /**
                     * From [material.io](https://m3.material.io/styles/icons/applying-icons#ebb3ae7d-d274-4a25-9356-436e82084f1f):
                     *
                     * Fill gives you the ability to transition from a more outlined style to a reversed or more filled style.
                     *
                     * A fill attribute can be used to convey a state of transition, such as unfilled
                     * and filled states. Values range from 0 to 1, with 1 being completely filled.
                     * Along with weight, fill is a primary attribute that impacts the overall look of a
                     * symbol.
                     *
                     * This object is the equivalent of the fill value 1, the default value being 0.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade 200 can be used to set an high emphasis on a icon, for example when its selected.
             */
            object Grade200 {
                /**
                 * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight100 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight200 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight300 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight400 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight500 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight600 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight700 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * From [material.io](https://m3.material.io/styles/icons/applying-icons#3ad55207-1cb0-43af-8092-fad2762f69f7):
             *
             * Weight and grade affect a symbol’s thickness. Adjustments to grade are more granular than
             * adjustments to weight and have a smaller impact on the size of the symbol. Grade can also
             * compensate for visual bleed, which is when images can look bigger or smaller depending on
             * the color contrast. To match the apparent icon size, the default grade for a dark icon on
             * a light background is 0, and -25 for a light icon on a dark background.
             *
             * Grade -25 (n25) is the default grade for light icons on dark backgrounds.
             */
            object GradeN25 {
                /**
                 * Weight 100 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight100 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 200 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight200 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 300 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight300 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 400 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight400 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 500 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight500 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 600 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight600 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Weight 700 variants of the symbols. Weight defines the thickness of the stroke,
                 * from 100 to 700, the lower the thinner.
                 */
                object Weight700 {
                    /**
                     * Filled variants of the symbols, similar to the old Filled theme.
                     */
                    object Filled
                }

                /**
                 * Alias for [Weight400], the default weight.
                 */
                val WeightDefault = Weight400
            }

            /**
             * Alias for [Grade0], the default grade.
             */
            val GradeDefault = Grade0
        }

        /**
         * Alias for [AutoMirrored.Outlined], the default icon theme.
         */
        val Default = Outlined
    }

    /**
     * Alias for [Outlined], the default icon theme.
     */
    val Default = Outlined
}

/**
 * Utility delegate to construct a Material symbol with default size information.
 * This is used by generated symbols, and should not be used manually.
 *
 * @param name the full name of the generated symbol
 * @param block builder lambda to add paths to this vector asset
 */
inline fun materialSymbol(
    name: String,
    viewportWidth: Float?,
    viewportHeight: Float?,
    block: ImageVector.Builder.() -> ImageVector.Builder
): ImageVector = materialSymbol(
    name = name,
    autoMirror = false,
    viewportWidth = viewportWidth,
    viewportHeight = viewportHeight,
    block = block
)

/**
 * Utility delegate to construct a Material symbol with default size information.
 * This is used by generated symbols, and should not be used manually.
 *
 * @param name the full name of the generated symbol
 * @param autoMirror determines if the vector asset should automatically be mirrored for right to
 * left locales
 * @param viewportWidth the original width of the vector
 * @param viewportHeight the original height of the vector
 * @param block builder lambda to add paths to this vector asset
 */
inline fun materialSymbol(
    name: String,
    autoMirror: Boolean,
    viewportWidth: Float?,
    viewportHeight: Float?,
    block: ImageVector.Builder.() -> ImageVector.Builder
): ImageVector = ImageVector.Builder(
    name = name,
    defaultWidth = MaterialSymbolDimension.dp,
    defaultHeight = MaterialSymbolDimension.dp,
    viewportWidth = viewportWidth ?: MaterialSymbolDimension,
    viewportHeight = viewportHeight ?: MaterialSymbolDimension,
    autoMirror = autoMirror
).block().build()

/**
 * Adds a vector path to this icon with Material defaults.
 *
 * @param fillAlpha fill alpha for this path
 * @param strokeAlpha stroke alpha for this path
 * @param pathFillType [PathFillType] for this path
 * @param pathBuilder builder lambda to add commands to this path
 */
inline fun ImageVector.Builder.materialPath(
    fillAlpha: Float = 1f,
    strokeAlpha: Float = 1f,
    pathFillType: PathFillType = DefaultFillType,
    pathBuilder: PathBuilder.() -> Unit
) =
// TODO: b/146213225
// Some of these defaults are already set when parsing from XML, but do not currently exist
    // when added programmatically. We should unify these and simplify them where possible.
    path(
        fill = SolidColor(Color.Black),
        fillAlpha = fillAlpha,
        stroke = null,
        strokeAlpha = strokeAlpha,
        strokeLineWidth = 1f,
        strokeLineCap = StrokeCap.Butt,
        strokeLineJoin = StrokeJoin.Bevel,
        strokeLineMiter = 1f,
        pathFillType = pathFillType,
        pathBuilder = pathBuilder
    )

// All Material symbols are 24dp by 24dp, with a variable viewport size depending on the symbol file.
@PublishedApi
internal const val MaterialSymbolDimension = 24f
