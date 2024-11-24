import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my Interactive CLI Tool!");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(">>> ");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                System.out.println("bye, thanks for using..");
                break;
            }
            if (input.equals("help")) {
                System.out.println("ls : List of files and directories");
                System.out.println("pwd : show the current working directory");
                System.out.println("touch <filename> : create an empty file");
                System.out.println("java <java_code> : execute a block of Java code");
                System.out.println("exit : exit from the shell !");
            }
            switch (input) {
                case "ls":
                    listOfFilesInCurrentDirectory();
                    break;
                case "pwd":
                    showCurrentLocation();
                    break;
                case "java":
                    executeJavaCode(sc);
                    break;
                default:
                    if (input.startsWith("touch")) {
                        String[] parts = input.split("\\s+", 2);
                        if (parts.length == 2) {
                            createEmptyFile(parts[1]);
                        } else {
                            System.out.println("Usage: touch <filename>");
                        }
                    }
                    else {
                        System.out.println("Unknown command : " + input + "\nType 'help' to show commands..");
                    }
            }
        }
    }

    public static void listOfFilesInCurrentDirectory() {
        File currentDir = new File(".");
        File[] files = currentDir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println(file.getName() + (file.isDirectory() ? "[DIR]" : ""));
            }
        } else {
            System.out.println("No files in current directory");
        }
    }

    public static void createEmptyFile(String fileName) {
        File newFile = new File(fileName);
        try {
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists: " + newFile.getName());
            }
        } catch (IOException e) {
            System.out.println("Error while creating file: " + e.getMessage());
        }
    }

    public static void executeJavaCode(Scanner sc) {
        System.out.print("Enter your java code (end with 'exit' on a new line):");
        StringBuilder javaCode = new StringBuilder();

        while (true) {
            String line = sc.nextLine();
            if (line.equals("exit")) break;
            javaCode.append(line).append("\n");
        }

        String fileName = "JavaProgram.java";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("public class JavaProgram {\n");
            writer.write("    public static void main(String[] args) {\n");
            writer.write(javaCode.toString());
            writer.write("    }\n");
            writer.write("}\n");
        } catch (IOException e) {
            System.out.println("Error while writing Java file: " + e.getMessage());
            return;
        }

        // Compile the Java code using the Java compiler
        try {
            Process compileProcess = new ProcessBuilder("javac", fileName).start();
            int compileExitCode = compileProcess.waitFor();
            if (compileExitCode != 0) {
                System.out.println("Compilation failed.");
                return;
            }

            // Execute the compiled Java code
            Process execProcess = new ProcessBuilder("java", "JavaProgram").start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(execProcess.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            execProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error during compilation or execution: " + e.getMessage());
        } finally {
            // Clean up generated files (if desired)
            new File("JavaProgram.java").delete();
            new File("JavaProgram.class").delete();
        }
    }

    public static void showCurrentLocation() {
        String currentLocation = System.getProperty("user.dir");
        System.out.println(currentLocation);
    }
}