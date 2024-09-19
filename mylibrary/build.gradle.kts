import com.android.build.gradle.internal.utils.createPublishingInfoForLibrary
import com.android.utils.TraceUtils.simpleId
import io.netty.util.ReferenceCountUtil.release
import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.1"
//    }
}
version = "3.0.1"

dependencies {
   // implementation(libs.androidx.core.ktx)
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
            create<MavenPublication>("release") {
//                from(components["release"])
//                groupId = "com.github.sans16"
//                artifactId = "androidlibrary"
//                version = "3.0.1"
            }
        }
    }
}