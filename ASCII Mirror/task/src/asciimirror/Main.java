package asciimirror;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        extracted();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String path = scanner.nextLine();

        File file = new File(path);
        List<String> lines = new ArrayList<>();
        int maxLength = 0;
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    lines.add(line);
                    maxLength = Math.max(line.length(), maxLength);
                }
            } catch (Exception e) {
                System.out.println("Error- File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File not found!");
        }

        for (String line : lines) {
            String formattedLine = line + " ".repeat(maxLength - line.length());
            System.out.print(formattedLine);
            System.out.print(" " + "|" + " ");
            //reverse a string
            StringBuilder sb = new StringBuilder(formattedLine);
            String revFormattedLine = sb.reverse().toString();
            revFormattedLine = replaceWithSymmetricalChars(revFormattedLine);

            System.out.println(revFormattedLine);
        }
    }

    private static String replaceWithSymmetricalChars(String revLine) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < revLine.length(); i++) {
            char c = revLine.charAt(i);
            if (c == '(') {
                sb.append(')');
            } else if (c == ')') {
                sb.append('(');
            } else if (c == '[') {
                sb.append(']');
            } else if (c == ']') {
                sb.append('[');
            } else if (c == '{') {
                sb.append('}');
            } else if (c == '}') {
                sb.append('{');
            } else if (c == '<') {
                sb.append('>');
            } else if (c == '>') {
                sb.append('<');
            } else if (c == '/') {
                sb.append('\\');
            } else if (c == '\\') {
                sb.append('/');
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    private static void extracted() {
        System.out.println("Input the file path:");
        String path = new java.util.Scanner(System.in).nextLine();
        String cow = """
                            ^__^
                    _______/(oo)
                /\\/(       /(__)
                   | w----||   \s
                   ||     ||   \s
                   """;
        System.out.println(path);
        System.out.println(cow);
    }


}