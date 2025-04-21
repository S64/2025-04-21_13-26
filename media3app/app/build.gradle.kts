plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "jp.s64.example.media3app"
    compileSdk = 35

    defaultConfig {
        applicationId = "jp.s64.example.media3app"
        minSdk = 35
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    flavorDimensions += "player"
    productFlavors {
        create("legacy") {
            dimension = "player"

        }
        create("styled") {
            dimension = "player"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

val legacyImplementation by configurations
val styledImplementation by configurations

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //noinspection UseTomlInstead
    legacyImplementation("jp.s64.example.ep2basedlib:legacy:${getArtifactVersion()}")
    //noinspection UseTomlInstead
    styledImplementation("jp.s64.example.ep2basedlib:styled:${getArtifactVersion()}")

    implementation(libs.bundles.media3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.test.core.ktx)
}

private fun getArtifactVersion(): String {
    return System.getenv("EP2BASEDLIB_VERSION") ?: "0.0.1-SNAPSHOT"
}

