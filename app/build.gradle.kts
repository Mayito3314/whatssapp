plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.whatssapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.whatssapp"
        minSdk = 24
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        viewBinding= true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


// Navegación basada en fragments con soporte para ViewModel, SafeArgs, etc.
    implementation(libs.androidx.navigation.fragment.ktx)

// Soporte para manejar navegación desde la UI (barra de acciones, botones, etc.)
    implementation(libs.androidx.navigation.ui.ktx)

// Glide: Librería eficiente para carga de imágenes (desde URL, recursos locales, etc.)
    implementation(libs.glide)

// Glide Compiler: Necesario para procesar anotaciones internas de Glide (por ejemplo, GlideApp)
    kapt(libs.compiler)

}
