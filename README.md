# Console & Logger Utility for Java

This repository contains the `Console` utility class, a simple yet powerful helper to simplify input and output operations in Java console applications.

---

## Features

### Console
- Simplified `Write` and `WriteLine` methods for different data types.
- Input reading methods for:
  - `String`
  - `int`, `double`, `float`, `long`
  - `boolean`
  - `char`
- Input validation with automatic re-prompting on invalid user input.
- German error messages for localization.
- Graceful scanner closure to avoid resource leaks.

### Logger (Coming Soon)
The `Logger` utility will allow configurable logging levels (INFO, DEBUG, ERROR) with timestamped outputs to console and file.

---

## Installation

Clone the repository or download the source files manually:
```bash
git clone https://github.com/your-username/holyjar.git
```

---

## How to Use

### Example Usage:
```java
import holyjar.Console;

public class Main {
    public static void main(String[] args) {
        String name = Console.ReadLine("Enter your name: ");
        int age = Console.ReadInt("Enter your age: ");

        Console.WriteLine("Hello, " + name + "!");
        Console.WriteLine("You are " + age + " years old.");

        Console.closeScanner();
    }
}
```

---

## Method Overview

### Writing to Console
```java
Console.Write("Hello ");
Console.WriteLine("World!");
Console.WriteLine(123);
Console.WriteLine(true);
```

### Reading from Console
```java
String input = Console.ReadLine();
int number = Console.ReadInt("Please enter a number: ");
double price = Console.ReadDouble();
```

---

## Closing the Scanner
To prevent memory leaks, call `Console.closeScanner()` once all input operations are finished.

---

## License
MIT License. Feel free to use and modify for personal or commercial projects.

---

## Contributing
Contributions are welcome! If you have ideas for improvement or want to add features like the Logger, feel free to open a pull request.

---

## Author
**Andrei**

For more projects, visit [your GitHub profile](https://github.com/your-username)

---

Happy coding! ✨

