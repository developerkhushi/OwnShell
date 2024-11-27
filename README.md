# Java REPL CLI Tool

This is a Java-based Command-Line Interface (CLI) tool that functions as a custom shell. It allows users to interact with their system and execute Java code dynamically. Once you install and configure this tool, you can run it globally from anywhere on your system by typing java-repl in the terminal

---

## Features

- **Interactive Shell Commands**:
  - `ls`: List files and directories in the current working directory.
  - `pwd`: Display the current working directory.
  - `touch <filename>`: Create an empty file with the specified name.
  - `java`: Write and execute Java code interactively.
  - `help`: Show a list of available commands.
  - `exit`: Exit the shell.

---

## Installation

### Prerequisites

1. **Java Development Kit (JDK)**:
   - Ensure you have JDK installed on your system.
   - Verify by running:
     ```bash
     java -version
     ```
   - If not installed, download it from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk-downloads.html) or use OpenJDK.

2. **Set `javac` and `java` in your PATH**:
   - Ensure the `bin` directory of your JDK installation is in your system's PATH.

### Steps to Install

1. **Clone the Java REPL repository**:

   ```bash
   git clone https://github.com/developerkhushi/java-repl
   ```

2. **Navigate to the project directory**:

   ```bash
   cd java-repl
   ```
   
3. **Compile the Program**:
   If you only have a Main.java file, run the following command to compile it:
   ```bash
   javac Main.java
    ```

5. **Package it into a JAR file (optional but recommended)**:
	```bash
   jar cfe java-repl.jar Main Main.class
    ```
 
#### Additional Considerations:
- **Dependencies**: If the project relies on external libraries, you must include them in the classpath when compiling and running the program. If the project doesn't have any dependencies, you can skip this step.
- **Manifest File**: When packaging the project into a JAR file, ensure that the Main class is set as the entry point. You can specify this in the MANIFEST.MF file. Here's a sample manifest:
   ```bash
   Manifest-Version: 1.0
   Main-Class: Main
   ```

### Make it Globally Accessible

To make the tool accessible from anywhere, follow these steps:

1. **Move the JAR file (`java-repl.jar`) or compiled class file (`Main.class`)** to a directory included in your system's PATH or any directory of your choice.

2. **Create an alias or script for easier access:**

   - **On Windows**:
     1. Create a batch file named `java-repl.bat` with the following content:
        ```bat
        java -cp <path-to-java-repl> Main
        ```
     2. Add the batch file to a folder that is included in your system's PATH.

   - **On Linux/macOS**:
     1. Create a shell script named `java-repl` with the following content:
        ```bash
        #!/bin/bash
        java -cp <path-to-java-repl> Main
        ```
     2. Make the script executable:
        ```bash
        chmod +x java-repl
        ```
     3. Move the script to a directory in your PATH (e.g., `/usr/local/bin`):
        ```bash
        sudo mv java-repl /usr/local/bin/
        ```

3. **Run the Tool Globally**:
   Open your terminal or command prompt and type:
   ```bash
   java-repl
   ```
   
## Usage

Once installed, type `java-repl` to launch the tool. You'll see the interactive CLI prompt:

```plaintext
Welcome to my Interactive CLI Tool!
>>>
```

### Available Commands

| Command             | Description                                                                                       | Example                     |
|---------------------|---------------------------------------------------------------------------------------------------|-----------------------------|
| `help`              | Displays all available commands.                                                                  | `>>> help`                 |
| `ls`                | Lists all files and directories in the current working directory.                                 | `>>> ls`                   |
| `pwd`               | Prints the full path of the current working directory.                                            | `>>> pwd`                  |
| `touch <filename>`  | Creates an empty file with the given name.                                                        | `>>> touch example.txt`    |
| `java`              | Enter interactive mode to write and execute Java code dynamically.                                | `>>> java` (see example)   |
| `exit`              | Exits the shell.                                                                                  | `>>> exit`                 |


### Example: Running Java Code

1. **Enter the `java` command**:
   ```bash
   >>> java
   ```
   
2. **Start typing your Java code**:
   ```bash
	Enter your Java code (type 'exit' to stop):
	System.out.println("Hello, Java REPL!");
    int x = 10;
    System.out.println("x squared is " + (x * x));
    exit
	```

3.  **The tool compiles and executes the code**:
	```bash
	Hello, Java REPL!
	x squared is 100
	```
	
## Cleanup

The program automatically cleans up temporary files (JavaProgram.java and JavaProgram.class) after execution.

## Contributing

Contributions are welcome for improving functionality or adding features!

## License
This project is free and open-source.
