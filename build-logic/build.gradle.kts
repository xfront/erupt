plugins {
    `kotlin-dsl`
    `maven-publish`
    `kotlin-dsl-precompiled-script-plugins`  // 支持预编译脚本插件
}

group = "buildlogic.conventions"
version = "1.0"

publishing {
    repositories {
        maven {
            // change to point to your repo, e.g. http://my.org/repo
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

tasks.publish {
    dependsOn("check")
}


testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnit()
        }
    }
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:5.2.1")

    implementation(libs.lombok.plugin)
    //implementation("io.freefair.lombok:io.freefair.lombok.gradle.plugin:8.14")
    implementation("org.openrewrite.rewrite:org.openrewrite.rewrite.gradle.plugin:7.11.0")
}
