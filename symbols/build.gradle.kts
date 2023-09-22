import androidx.compose.material.symbols.generator.tasks.MaterialSymbolsTask
import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    `maven-publish`
}

val libProperties = loadProperties(rootDir.absolutePath + "/library.properties")
val githubProperties = loadProperties(rootDir.absolutePath + "/github.properties")

android {
    namespace = "dev.tclement.materialsymbols"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensionList += listOf(
        "theme", "grade", "weight"
    )

    productFlavors {
        create("outlined") {
            dimension = "theme"
            isDefault = true
        }
        create("rounded") {
            dimension = "theme"
        }
        create("sharp") {
            dimension = "theme"
        }

        create("g0") {
            dimension = "grade"
            isDefault = true
        }
        create("g200") {
            dimension = "grade"
        }
        create("gn25") {
            dimension = "grade"
        }

        create("w100") {
            dimension = "weight"
        }
        create("w200") {
            dimension = "weight"
        }
        create("w300") {
            dimension = "weight"
        }
        create("w400") {
            dimension = "weight"
            isDefault = true
        }
        create("w500") {
            dimension = "weight"
        }
        create("w600") {
            dimension = "weight"
        }
        create("w700") {
            dimension = "weight"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

val generateSymbolsFiles by tasks.creating(MaterialSymbolsTask::class) {
    from(project.file("source-icons/material-design-icons-master/symbols/android"))
    into(project.file("src"))
}

publishing {
    publications {
        repositories {
            repositories {
                maven {
                    name = "GitHubPackages"
                    url = uri(libProperties.getString("packages-url"))
                    credentials {
                        username = githubProperties.getString("username")
                        password = githubProperties.getString("token")
                    }
                }
            }
        }
        afterEvaluate {
            components.filter { it.name.endsWith("Release") }.forEach { component ->
                register<MavenPublication>(component.name) {
                    groupId = libProperties.getString("group")
                    artifactId = component.name.removeSuffix("Release").replace("(?<=[a-zA-Z0-9])[A-Z]".toRegex()) {
                        "-${it.value}"
                    }.lowercase()
                    version = libProperties.getString("version")

                    from(component)
                }
            }
        }
    }
}

dependencies {
    api(project(":symbols-core"))
    implementation(libs.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}