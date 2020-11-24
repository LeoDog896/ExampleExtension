plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
    compile("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes (
                "Main-Class" to "world.cepi.sabre.SabreKt",
                "Multi-Release" to true
        )
    }

    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) }) {
        exclude("META-INF/*.RSA", "META-INF/*.SF","META-INF/*.DSA")
    }
}