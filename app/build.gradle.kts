plugins {
    id("com.android.application")
    kotlin("android")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

android {
    compileSdk = 35
    buildToolsVersion = "35.0.0"

    namespace = "com.android.gallery3d"

    defaultConfig {
        versionCode = 40030 + 1
        versionName = "1.1.40031"
        minSdk = 35
        //noinspection ExpiredTargetSdkVersion
        targetSdk = 29

        ndk {
            abiFilters.clear()
            abiFilters.addAll(listOf("arm64-v8a", "x86_64"))
        }
    }

    externalNativeBuild {
        cmake {
            path = file("../CMakeLists.txt")
            version = "3.22.1"
        }
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            resValue("string", "app_name", "Gallery d")
        }
    }

    buildFeatures {
        buildConfig = true
    }

    sourceSets.getByName("main") {
        manifest.srcFile("../AndroidManifest.xml")
        java.srcDirs("../src", "../src_pd", "../gallerycommon")
        res.srcDir("../res")
    }
}

dependencies {
    // Required for org.apache.https.legacy
    compileOnly("com.android.tools.build:gradle:4.2.2")

    implementation("androidx.core:core:1.15.0")
    implementation("androidx.print:print:1.1.0-beta01")
    implementation("androidx.fragment:fragment:1.8.5")
    implementation("androidx.legacy:legacy-support-v13:1.0.0")
    implementation("androidx.legacy:legacy-support-core-ui:1.0.0")

    implementation("com.adobe.xmp:xmpcore:5.1.3")

    implementation(project(":mp4parser"))
}
