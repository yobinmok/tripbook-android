@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.tripbook.library")
}

android {
    namespace = "com.tripbook.tripbook.data"
}

dependencies {

    implementation(project(":domain"))


    implementation(libs.retrofit)
    implementation(libs.moshi)

}