# unkey-springboot-sdk

'Spring Boot client for [unkey](https://unkey.dev/docs/introduction)'
> Unkey is an open source API authentication and authorization platform for scaling user facing APIs. Create, verify, and manage low latency API keys in seconds. It’s built with security in mind and is easy to use.

## Installation
Step 1: 
#### Configure Build File

Add the Unkey SDK dependency to your `build.gradle` file:

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.5.4'
    id 'io.spring.dependency-management' version '1.0.11.RELEASE'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = 1.8
}

repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/shreyanshtomar/my-registry")
    }
}

dependencies {
    //..other dependencies
    implementation 'com.unkey:unkey-springboot-sdk:0.0.1-SNAPSHOT'
}
```
Step 2:
Refer to the link[TODO] for usage instructions.

## Unkey Root Key

When requesting resources, you will need your root key — you can create a new one in the [settings](https://unkey.dev/app/settings/root-keys).

Always keep your root key safe and reset it if you suspect it has been compromised.
