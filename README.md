# HolyJAR

A lightweight Java utility library providing easy-to-use console input/output and logging functionality.

## Overview

HolyJAR is a utility library that simplifies console I/O operations and logging in Java applications. It includes two main components:

- **Console**: A static utility class for standardized console input and output operations
- **Logger**: A thread-safe logging utility with configurable log levels, rotation and file management

## Installation

### Manual Installation

You can download the JAR file directly from the [releases page](https://github.com/fIyingPhoenix/HolyJAR/releases) and add it to your project's classpath.

## Usage

### Console Class

The `Console` class provides methods for reading various data types from the console and writing to it.

#### Reading Input

```java
import holyjar.Console;

// Read a string with prompt
String name = Console.ReadLine("Enter your name: ");

// Read an integer with prompt and validation
int age = Console.ReadInt("Enter your age: ");

// Read other data types
double height = Console.ReadDouble("Enter your height (in meters): ");
boolean isStudent = Console.ReadBoolean("Are you a student? (true/false): ");
char grade = Console.ReadChar("Enter your grade (A-F): ");
```

#### Writing Output

```java
// Print with newline
Console.WriteLine("Hello, World!");
Console.WriteLine(42);
Console.WriteLine(3.14);

// Print without newline
Console.Write("Enter your choice (1-3): ");

// Print blank line
Console.WriteLine();
```

#### Resource Management

Close the Scanner only when your application is terminating:

```java
// IMPORTANT: Only call this when your application is shutting down
// and no more console input will be needed
Console.closeScanner();
```

> ⚠️ **Warning**: Once the Scanner is closed, you cannot use any of the Console input methods again. The underlying System.in stream will be closed and cannot be reopened without restarting your application. Only close the Scanner at the very end of your application's lifecycle.

### Logger Class

The `Logger` class provides thread-safe logging functionality with configurable log levels.

#### Basic Logging

```java
import holyjar.Logger;

// Log messages with different severity levels
Logger.info("Application started");
Logger.debug("Processing file: example.txt");
Logger.warning("File size exceeds recommended limit");
Logger.error("Failed to connect to database");
Logger.fatal("Critical system failure");

// Log exceptions with stack traces
try {
    // Some code that might throw an exception
    int result = 10 / 0;
} catch (Exception e) {
    Logger.error("Division operation failed", e);
}
```

#### Configuration

```java
// Set custom log file path
Logger.setLogFilePath("path/to/custom/logfile.log");

// Configure log rotation (size in bytes, default is 10MB)
Logger.setMaxLogSize(5 * 1024 * 1024); // 5MB

// Set maximum number of backup log files
Logger.setMaxBackupFiles(3);

// Enable console logging in addition to file logging
Logger.enableConsoleLogging(true);

// Clear the log file
Logger.clearLog();
```

## Features

### Console Features

- Simple API for reading and writing console data
- Input validation with error messages
- Support for various data types (String, int, double, long, boolean, char)
- Clean handling of input/output streams

### Logger Features

- Thread-safe logging with ReentrantLock
- Multiple severity levels (INFO, WARNING, ERROR, DEBUG, FATAL)
- Automatic log file rotation based on file size
- Configurable number of backup log files
- Automatic creation of log directories
- Optional console output
- Detailed exception logging with stack traces
- Timestamp formatting

## Requirements

- Java SE 17 or later

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

Andrei ([@fIyingPhoenix](https://github.com/fIyingPhoenix))
