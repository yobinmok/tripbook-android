plugins {
    id("com.tripbook.library")
}

android {
    namespace = "com.tripbook.libs.network"
}

dependencies {

    implementation(libs.retrofit)
    implementation(libs.moshi)
}