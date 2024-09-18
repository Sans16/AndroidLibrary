import com.android.build.gradle.internal.utils.createPublishingInfoForLibrary
import com.android.utils.TraceUtils.simpleId
import io.netty.util.ReferenceCountUtil.release

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
    //alias(libs.plugins.maven.library)
}

android {
    namespace = "com.sanusi.mylibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
  //  implementation(libs.androidx.core.ktx)
   // implementation(libs.androidx.appcompat)
    //implementation(libs.material)
   // testImplementation(libs.junit)
   // androidTestImplementation(libs.androidx.junit)
   // androidTestImplementation(libs.androidx.espresso.core)
}

afterEvaluate{
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.github.sans"
                artifactId = "request-shaker"
                version = "1.0"
              //  from(components["java"])
            }
        }
    }
}