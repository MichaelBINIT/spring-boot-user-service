plugins {
	java
	id("org.springframework.boot") version "4.0.7"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "de.init-software"
version = "0.0.1-SNAPSHOT"
val mockitoVersion = "4.5.1"


dependencies {
	testImplementation("org.mockito:mockito-core:$mockitoVersion")
	testImplementation("org.mockito:mockito-inline:$mockitoVersion")
}


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Source: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
	implementation("org.springframework.boot:spring-boot-starter-web:4.0.7")
// Source: https://mvnrepository.com/artifact/com.mashape.unirest/unirest-java
//	implementation("com.mashape.unirest:unirest-java:1.4.9")

	// Source: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:4.0.7")

	// Source: https://mvnrepository.com/artifact/mysql/mysql-connector-java
	implementation("mysql:mysql-connector-java:8.0.33")

	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
