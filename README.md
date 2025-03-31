# Simple Desktop Application

This is a simple Java Swing desktop application built with Maven. It demonstrates a basic GUI with a button that counts clicks.

## Project Structure

The project follows the standard Maven directory structure:

```
simple-desktop-app/
├── src/
│   ├── main/java/com/example/
│   │   └── App.java
│   └── test/java/com/example/
│       └── AppTest.java
└── pom.xml
```

## Requirements

- Java 21
- Maven

## Building the Application

To build the application, run:

```bash
mvn clean package
```

This will create a JAR file in the `target` directory.

## Running the Application

You can run the application using Maven:

```bash
mvn exec:java
```

Or directly using the JAR file:

```bash
java -jar target/simple-desktop-app-1.0-SNAPSHOT.jar
```

## CI/CD with Jenkins

This project is configured with a Jenkins pipeline that:

1. Clones the repository from GitHub
2. Builds the project using Maven
3. Runs the application
4. Polls for changes in the GitHub repository
5. Sends email notifications on build failures

## License

MIT