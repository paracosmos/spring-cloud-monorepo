plugins {
	kotlin("jvm")
	kotlin("plugin.spring")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
}

group = "com.skdnd.user"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	// Eureka
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	// Exposed
	implementation("org.jetbrains.exposed:exposed-core:0.48.0")
	implementation("org.jetbrains.exposed:exposed-dao:0.48.0")
	implementation("org.jetbrains.exposed:exposed-jdbc:0.48.0")
	implementation("org.jetbrains.exposed:exposed-java-time:0.48.0")
	implementation("org.jetbrains.exposed:exposed-spring-boot-starter:0.48.0")
	// MySQL
	implementation("mysql:mysql-connector-java:8.0.33")
}


dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}


kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
