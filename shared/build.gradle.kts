plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("maven-publish")
}
group = "com.example.notifypro"
version = "1.0"
publishing {
    repositories {
        maven {
            name = "NotifyProPackages"
            url = uri("https://maven.pkg.github.com/ashrafdawoud/NotifyPro")
            credentials {
                username = "ashraf"
                password = "123456789"
            }
        }
    }
//    publications {
//        gpr(MavenPublication) {
//            from(components.java)
//        }
//    }
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.example.notifypro"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}