# Simple Desktop App Setup Guide

## Prerequisites
- Java JDK 8+
- Maven
- Docker
- Git

## 1. Create Maven Project
```
mvn archetype:generate -DgroupId=com.example -DartifactId=simple-desktop-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## 2. Git Setup
```
git init
git add .
git commit -m "Initial commit"
```

## 3. Run Java Application
```
mvn clean install
mvn exec:java -Dexec.mainClass="com.example.App"
```

## 4. Docker Setup for Jenkins
```
docker-compose up -d
```

## 5. Jenkins Configuration
1. Access Jenkins at http://localhost:8080
2. Install suggested plugins
3. Create admin user
4. Configure Maven in Global Tools Configuration
5. Create new Pipeline job pointing to this repository

## 6. Build Pipeline
```
mvn clean package
```