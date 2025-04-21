plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

group = "jp.s64.example.ep2basedlib"
version = getArtifactVersion()

android {
    namespace = "${group}"
    compileSdk = 35

    defaultConfig {
        minSdk = 35

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

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(libs.bundles.exoplayer)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        register<MavenPublication>("legacyRelease") {
            artifactId = "legacy"
            afterEvaluate {
                from(components["legacyRelease"])
            }
        }
        register<MavenPublication>("styledRelease") {
            artifactId = "styled"
            afterEvaluate {
                from(components["styledRelease"])
            }
        }
    }
}

private fun getArtifactVersion(): String {
    return System.getenv("EP2BASEDLIB_VERSION") ?: "0.0.1-SNAPSHOT"
}
