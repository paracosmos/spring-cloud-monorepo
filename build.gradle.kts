plugins {
	kotlin("jvm") version "1.9.25" apply false
	kotlin("plugin.spring") version "1.9.25" apply false
	id("org.springframework.boot") version "3.4.3" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false
}

subprojects {

	extra["springCloudVersion"] = "2024.0.0"

	apply(plugin = "org.jetbrains.kotlin.jvm")

	repositories {
		mavenCentral()
	}

}