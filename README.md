#Java REPL
This is an interactive Command-Line Interface (CLI) tool written in Java. It mimics a shell-like environment, allowing users to execute various commands such as listing files, showing the current directory, creating empty files, and even executing blocks of Java code dynamically.

Features
ls: Lists all files and directories in the current working directory.
pwd: Displays the current working directory.
touch <filename>: Creates an empty file with the specified name in the current directory.
java: Accepts and executes Java code written interactively within the tool.
exit: Exits the CLI tool.
help: Lists all available commands and their descriptions.
How to Use
Prerequisites
Java Development Kit (JDK) installed on your system.
The javac and java commands should be accessible in your system's PATH.
Running the Program
Compile the Java program:

bash
Copy code
javac Main.java
Run the Java program:

bash
Copy code
java Main
Once the program starts, you'll see a prompt like this:

python
Copy code
Welcome to my Interactive CLI Tool!
>>>
Type commands directly into the CLI.

Commands and Usage
Command	Description	Example
help	Displays all available commands with their descriptions.	>>> help
ls	Lists all files and directories in the current directory.	>>> ls
pwd	Prints the full path of the current working directory.	>>> pwd
touch <filename>	Creates an empty file with the given name.	>>> touch example.txt
java	Allows you to write and execute Java code interactively. Type exit to finish writing the code.	>>> java (see below)
exit	Exits the CLI tool.	>>> exit
Writing and Executing Java Code
Type java and press Enter.
Enter your Java code inside the main method, line by line. For example:
arduino
Copy code
>>> java
Enter your Java code (type 'exit' to stop):
System.out.println("Hello, world!");
int x = 5;
System.out.println("x = " + x);
exit
After typing exit, the tool will compile and execute the code. You'll see the output on the console:
makefile
Copy code
Hello, world!
x = 5
Error Handling
File creation errors: If the specified file already exists or cannot be created, an appropriate error message will be shown.
Java compilation errors: If the entered Java code has syntax errors or fails to compile, the tool will display a "Compilation failed" message.
Command errors: If an unknown command is entered, the tool will prompt the user to type help.
Cleanup
The program automatically cleans up temporary files (JavaProgram.java and JavaProgram.class) after execution.

Notes
This CLI tool provides basic functionality for exploring directories and running Java code interactively. It is not a full-fledged shell.
The java command runs user-entered Java code with a default main method. For complex programs, ensure proper syntax and semantics.
License
This project is open-source and available for personal and educational use. Contributions and improvements are welcome!







