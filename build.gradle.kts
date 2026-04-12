plugins {
    id("java")
    id("com.diffplug.spotless") version "8.4.0"
    id("jacoco")
    id("net.ltgt.errorprone") version "5.1.0"
}

group = "me.graceteng"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    errorprone("com.google.errorprone:error_prone_core:2.49.0")
    testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

jacoco {
    toolVersion = "0.8.14"
}

spotless {
    encoding("UTF-8")
    java {
        googleJavaFormat()
        importOrder()
        removeUnusedImports()
        formatAnnotations()
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
}
