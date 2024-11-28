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
            else if (input.equals("help")) {
                System.out.println("<java_code> : execute a block of Java code");
                System.out.println("exit : exit from the REPL !");
            } else {
                executeJavaCode(input, sc);
            }
            //System.out.println("Unknown command : " + input + "\nType 'help' to show commands..");
        }
    }

    public static void executeJavaCode(String firstLine, Scanner sc) {
        StringBuilder javaCode = new StringBuilder();
        javaCode.append(firstLine).append("\n");
        int noOfBraces = 0;
        for (char c : firstLine.toCharArray()) {
            if (c == '{') noOfBraces++;
            if (c == '}') noOfBraces--;
        }
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty() && noOfBraces == 0) {
                break;
            }
            javaCode.append(line).append("\n");
            for (char c : line.toCharArray()) {
                if (c == '{') noOfBraces++;
                if (c == '}') noOfBraces--;
            }
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
                try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()))) {
                    String errorLine;
                    while ((errorLine = errorReader.readLine()) != null) {
                        System.out.println(errorLine);
                    }
                }
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
            new File("JavaProgram.java").delete();
            new File("JavaProgram.class").delete();
        }
    }

}