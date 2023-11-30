plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.jetbrains:annotations:20.1.0")
	// https://mvnrepository.com/artifact/org.springframework.shell/spring-shell-starter
	implementation("org.springframework.shell:spring-shell-starter:3.1.6")




}

tasks.withType<Test> {
	useJUnitPlatform()
}
