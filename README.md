
# JavaOne MCP Project

A Java application that provides access to JavaOne presentations using the Model Context Protocol (MCP).

## Project Overview

This project demonstrates the use of the Model Context Protocol (MCP) to create a server that provides information about JavaOne presentations. The server exposes a tool called `get_presentations` that returns a list of JavaOne presentations.

## Requirements

- Java 22
- Maven

## Dependencies

- Model Context Protocol SDK (version 0.9.0)
- SLF4J for logging

## Project Structure

- `Application.java`: Main application class that sets up the MCP server
- `Presentation.java`: Record class representing a JavaOne presentation with title, URL, and year
- `PresentationTools.java`: Utility class for managing and retrieving presentations

## Features

- MCP server with stdio transport
- Tool for retrieving JavaOne presentations
- Filtering presentations by year
- Converting presentations to map format

## Building the Project

```bash
mvn clean package
```

This will create a shaded JAR with all dependencies included.

## Running the Application

```bash
java -jar target/javaone-mcp-1.0-SNAPSHOT.jar
```

## Available Presentations

The application includes several JavaOne 2024 presentations:
- Java 24 launch
- Java turns 30
- Concerto for Java and AI
- Stream Gatherers
- AI 202 - Next level AI mastery for Java developers

## MCP Tool Usage

The MCP server exposes a tool called `get_presentations` that returns all available presentations.

## License

[Add license information here]

## Contributors

[Add contributor information here]
