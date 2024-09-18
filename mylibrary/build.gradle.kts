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
version = "2.0.0"

dependencies {
    implementation(libs.androidx.core.ktx)
   // implementation(libs.androidx.appcompat)
    //implementation(libs.material)
   // testImplementation(libs.junit)
   // androidTestImplementation(libs.androidx.junit)
   // androidTestImplementation(libs.androidx.espresso.core)
}

//publishing {
//    publications {
//        register<MavenPublication>("release") {
//            groupId = "com.github.sans16"
//            artifactId = "mylibrary"
//            version = "2.0.0"
//
//            afterEvaluate {
//                from(components["release"])
//            }
//        }
//    }
//}

afterEvaluate{
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.sans"
                artifactId = "androidlibrary"
                version = "0.0.1"

                afterEvaluate{
                    from(components["release"])
                }
            }
        }
    }
}