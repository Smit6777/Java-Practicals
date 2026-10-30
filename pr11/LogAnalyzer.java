import java.nio.file.*;
import java.io.*;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        String[] files = { "log1.txt", "log2.txt", "log3.txt" };
        String keyword = "ERROR";

        int totalLines = 0;
        int matchingLines = 0;

        for (String file : files) {
            Path path = Paths.get(file);

            if (!Files.exists(path)) {
                Files.write(path, Arrays.asList(
                        "Application started",
                        "ERROR: Something went wrong",
                        "Application running"));
            }

            int fileLines = 0;
            int fileMatches = 0;

            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line;

                while ((line = reader.readLine()) != null) {
                    fileLines++;

                    if (line.contains(keyword)) {
                        fileMatches++;
                    }
                }
            }

            long size = Files.size(path);

            totalLines += fileLines;
            matchingLines += fileMatches;

            System.out.println("File: " + file);
            System.out.println("Size: " + size + " bytes");
            System.out.println("Lines: " + fileLines);
            System.out.println("Keyword matches: " + fileMatches);
            System.out.println();
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Total lines containing "
                + keyword + ": " + matchingLines);
    }
}