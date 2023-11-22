plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.0.0").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
    id("maven-publish")
}
group = "com.example.notifypro"
version = "1.0"


publishing {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/ashrafdawoud/NotifyPro")
            credentials {
                username = "ashrafdawoud"
                password = "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"
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
