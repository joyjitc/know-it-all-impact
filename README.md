# Know It All for impact.com

Tells you who you are and what you should do.

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Building the Project

Compile the project:
```bash
mvn clean compile
```

## Running the Application

### Show help and available commands
```bash
mvn exec:java -Dexec.mainClass="com.example.App" -Dexec.args="--help"
```

### Run who-am-i command
```bash
mvn exec:java -Dexec.mainClass="com.example.App" -Dexec.args="who-am-i"
```

### Run what-should-i-do command
```bash
mvn exec:java -Dexec.mainClass="com.example.App" -Dexec.args="what-should-i-do"
```

## Commands

- `who-am-i` - Tells you who you are!
- `what-should-i-do` - Provides guidance on what to do.

## About

Built with [picocli](https://picocli.info/) - a modern framework for building powerful command line applications in Java.
