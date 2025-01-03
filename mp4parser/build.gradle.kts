plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

android {
    namespace = "com"
    compileSdk = 35

    defaultConfig {
        minSdk = 35
    }

    sourceSets.getByName("main") {
        java.srcDirs("mp4parser/isoparser/src/main/java")
    }
}

dependencies {
    implementation("junit:junit:4.13.2")
    implementation("commons-io:commons-io:2.18.0")
    implementation("commons-codec:commons-codec:1.17.1")
    implementation("org.aspectj:aspectjtools:1.9.22.1")
}
