plugins {
    id("com.android.application")
    kotlin ("android")
    kotlin ("kapt")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.plugin.parcelize")
}

android {
    namespace = "com.example.takeitapp"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.takeitapp"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
       getByName("release") {
            isMinifyEnabled = true
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            exclude("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(Dependencies.core)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.testExtJunit)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(Dependencies.composeUiTestJunit)
    debugImplementation(Dependencies.composeUiTooling)
    debugImplementation(Dependencies.composeUiTestManifest)

    //ViewModel for Compose
    implementation(Dependencies.lifecycleViewModelCompose)

    //Navigation for Compose
    implementation(Dependencies.navigationCompose)

    //Hilt navigation compose
    implementation(Dependencies.hiltNavigationCompose)
    kapt(Dependencies.hiltCompiler)

    // Dagger - Hilt
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)

    // Room
    implementation(Dependencies.roomRuntime)
    kapt(Dependencies.roomCompiler)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(Dependencies.roomKtx)

    // Retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.converterGson)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.loggingInterceptor)
    implementation(Dependencies.composeRuntimeLivedata)

    // Coroutines
    implementation(Dependencies.kotlinxCoroutinesCore)
    implementation(Dependencies.kotlinxCoroutinesAndroid)

    // Coroutine Lifecycle Scopes
    implementation(Dependencies.lifecycleViewModelKtx)
    implementation(Dependencies.lifecycleRuntimeKtx)

    //AsyncImage - coil
    implementation(Dependencies.coilCompose)
}