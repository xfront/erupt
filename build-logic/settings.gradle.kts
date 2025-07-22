
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))  // 引用根项目的版本目录
        }
    }
}

rootProject.name="build-logic"
