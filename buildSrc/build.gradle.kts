plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(libs.kotlinpoet)
    implementation(libs.xmlpull)
    implementation(libs.xpp3)
    implementation(libs.guava)
}
