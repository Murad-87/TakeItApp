object Dependencies {

    const val core = "androidx.core:core-ktx:${Versions.coreVersion}"

    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeVersion}"

    const val activityCompose =
        "androidx.activity:activity-compose:${Versions.activityComposeVersion}"

    const val composeUi = "androidx.compose.ui:ui:${Versions.composeUiVersion}"

    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeUiToolingPreviewVersion}"

    const val composeMaterial =
        "androidx.compose.material:material:${Versions.composeMaterialVersion}"

    const val junit = "junit:junit:${Versions.junitVersion}"

    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunitVersion}"

    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"

    const val composeUiTestJunit =
        "androidx.compose.ui:ui-test-junit4:${Versions.composeUiTestJunitVersion}"

    const val composeUiTooling =
        "androidx.compose.ui:ui-tooling:${Versions.composeUiToolingVersion}"

    const val composeUiTestManifest =
        "androidx.compose.ui:ui-test-manifest:${Versions.composeUiTestManifestVersion}"

    //ViewModel for Compose
    const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewModelComposeVersion}"

    //Navigation for Compose
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationComposeVersion}"

    //Hilt navigation compose
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompilerVersion}"

    // Dagger - Hilt
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHiltVersion}"
    const val daggerHiltCompiler =
        "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltCompilerVersion}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomRuntimeVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomCompilerVersion}"

    // optional - Kotlin Extensions and Coroutines support for Room
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomKtxVersion}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val converterGson =
        "com.squareup.retrofit2:converter-gson:${Versions.converterGsonVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
    const val composeRuntimeLivedata =
        "androidx.compose.runtime:runtime-livedata:${Versions.composeRuntimeLivedataVersion}"

    // Coroutines
    const val kotlinxCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutinesCoreVersion}"
    const val kotlinxCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinxCoroutinesAndroidVersion}"

    // Coroutine Lifecycle Scopes
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtxVersion}"
    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtxVersion}"

    //AsyncImage - coil
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilComposeVersion}"
}