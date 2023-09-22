import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    `maven-publish`
}

val libProperties = loadProperties(rootDir.absolutePath + "/library.properties")
val githubProperties = loadProperties(rootDir.absolutePath + "/github.properties")

android {
    namespace = "dev.tclement.symbols.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
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

        register<MavenPublication>("release") {
            groupId = libProperties.getString("group")
            artifactId = libProperties.getString("artifact-core")
            version = libProperties.getString("version")

            afterEvaluate {
                from(components.getByName("release"))
            }
        }
    }
}

dependencies {
    implementation(libs.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}