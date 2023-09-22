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

package androidx.compose.material.symbols.generator.tasks

import androidx.compose.material.symbols.generator.IconProcessor
import androidx.compose.material.symbols.generator.IconWriter
import androidx.compose.material.symbols.generator.PackageNames
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.TaskAction
import java.io.File

@CacheableTask
open class MaterialSymbolsTask : DefaultTask() {
    private lateinit var fromDir: File
    private lateinit var intoDir: File

    fun from(path: File) {
        fromDir = path
        inputs.dir(fromDir)
    }

    fun into(path: File) {
        intoDir = path
        outputs.dir(intoDir)
    }

    @TaskAction
    fun run() {
        if (!::fromDir.isInitialized || !::intoDir.isInitialized)
            error("Please define both from and into dirs")
        val iconProcessor = IconProcessor(fromDir.listFiles { file -> file.isDirectory }?.toList() ?: emptyList())
        val processedIcons = iconProcessor.process()
        val writer = IconWriter(processedIcons)
        intoDir.mkdirs()
        writer.generateToMultiple(intoDir)
    }
}
