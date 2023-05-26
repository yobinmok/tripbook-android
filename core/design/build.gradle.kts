plugins {
    id("com.tripbook.library")
    id("kotlin-kapt")
}

android {
    namespace = "com.tripbook.tripbook.core.design"

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(libs.glide)
}