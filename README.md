> [!WARNING]
> This library won't be updated anymore, use [compose-font-icons]([tclement0922/compose-font-icons](https://github.com/tclement0922/compose-font-icons)) instead

# Material Symbols for Jetpack Compose

ImageVector version of the Material Symbols icons. This library is created by converting xml icons from 
[the material-design-icons repo](https://github.com/google/material-design-icons/tree/master/symbols/android)
using a modified version the 
[AndroidX material icons generator](https://github.com/androidx/androidx/tree/androidx-main/compose/material/material/icons/)
Gradle module. Only for AndroidX Compose, it's not ~~(yet)~~ compatible with JetBrains Compose Multiplatform.

# Usage

This library is ~~for now~~ only available in GitHub Packages. 

For Gradle Dsl:

```kotlin
// in settings.gradle.kts
dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/tclement0922/material-symbols-compose")
            credentials {
                // replace with your username
                username = "YOUR_USERNAME"
                // replace with a personal access token (classic) that has at least the :read_packages scope and linked to the username above
                password = "YOUR_GITHUB_TOKEN"
            }
        }
    }
}

// in your project module build.gradle.kts
dependencies {
    implementation("dev.tclement.compose.symbols:core:1.0.0")

    // the variant you want to use
    // replace THEME with one of these: outlined, rounded, sharp
    // replace GRADE with one of these: g0, g200, gn25
    // replace WEIGHT with one of these: w100, w200, w300, w400, w500, 600, w700
    implementation("dev.tclement.compose.symbols:THEME-GRADE-WEIGHT:1.0.0")
}
```

# How to build

1. [Download](https://github.com/google/material-design-icons/archive/master.zip) and extract the 
    source repo in `symbols/source-icons`. 

    For example on Linux:
    ```shell
    wget -O symbols/source-icons.zip https://github.com/google/material-design-icons/archive/master.zip
    unzip symbols/source-icons.zip "material-design-icons-master/symbols/android/*" -d "symbols/source-icons/"
    ```
2. Run the Gradle task `:symbols:generateSymbolsFiles`.
3. Run the Gradle task `:symbols:assembleRelease` (this might take a while, change the
   `org.gradle.workers.max` property and the Gradle heap size from `gradle.properties` if you have
   enough memory).
4. The AARs will be in the `build/outputs/aar` directory.


# License

```
     Copyright 2023 T. Clément (@tclement0922)
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
      http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```
