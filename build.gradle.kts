plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation("io.ktor:ktor-client-core:2.3.0")                   // Основной клиент Ktor
    implementation("io.ktor:ktor-client-cio:2.3.0")                    // CIO - реализация HTTP клиента
    implementation("io.ktor:ktor-client-serialization:2.3.0")           // Поддержка сериализации
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.0")    // Использование kotlinx.serialization для JSON
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0") // Сериализация JSON
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
    implementation("org.slf4j:slf4j-api:1.7.30") // или последняя версия
    implementation("org.slf4j:slf4j-simple:1.7.30") // для простой реализации
}