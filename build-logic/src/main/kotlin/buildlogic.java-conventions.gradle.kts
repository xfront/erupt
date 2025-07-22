// Define Java conventions for this organization.
// Projects need to use the Java, Checkstyle and Spotbugs plugins.

plugins {
    `java-library`
    checkstyle
    `maven-publish`

    id("io.freefair.lombok")
    id("org.openrewrite.rewrite")
    // NOTE: external plugin version is specified in implementation dependency artifact of the project's build file
    id("com.github.spotbugs")
}
rewrite {
    activeRecipe("org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_3")
    setExportDatatables(true)
}

// Projects should use Maven Central for external dependencies
// This could be the organization's private repository
repositories {
    google {
        content {
            includeGroupByRegex("com\\.google.*")
            includeGroupByRegex("com\\.android.*")
        }
    }
    mavenCentral()
}

group = "xyz.erupt"
version = "1.12.21"

java.sourceCompatibility = JavaVersion.VERSION_21

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

dependencies {
    api("org.projectlombok:lombok:1.18.36")
    rewrite("org.openrewrite.recipe:rewrite-spring:6.10.0")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:deprecation")
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

