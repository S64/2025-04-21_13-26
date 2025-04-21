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

    /**
     * `media3-ui` has a Layout XML named with `exo_player_view.xml`, but doesn't have `exo_styled_player_view.xml`.
     * - https://github.com/androidx/media/blob/839c4a90/libraries/ui/src/main/res/layout/exo_player_view.xml
     * - https://github.com/androidx/media/tree/839c4a90/libraries/ui/src/main/res/layout
     * In Android, if resources with the same name exist, the resource owned by the module with the higher priority is used.
     * Therefore, `exo_player_view.xml` may be overwritten by resource provided by `media3-ui`.
     * > Avoid resource merge conflicts.
     * > The build tools merge resources from a library module with those of a dependent app module. If a given resource name is defined in both modules, the resource from the app is used.
     * > If conflicts occur between multiple AAR libraries, then the resource from the library listed first in the dependencies list (closest to the top of the dependencies block) is used.
     * > To avoid resource conflicts, consider using a prefix or other consistent naming scheme that is unique to the module (or is unique across all project modules).
     * > https://developer.android.com/studio/projects/android-library#Considerations
     * So
     */
    implementation(libs.bundles.media3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.test.core.ktx)
}

private fun getArtifactVersion(): String {
    return System.getenv("EP2BASEDLIB_VERSION") ?: "0.0.1-SNAPSHOT"
}

