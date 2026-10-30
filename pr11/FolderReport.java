
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FolderReport {
    public static void main(String[] args) {
        Path folder = Paths.get(".").toAbsolutePath().normalize();
        Path report = folder.resolve("folder-report.txt");

        try (Stream<Path> files = Files.walk(folder);
                var writer = Files.newBufferedWriter(report)) {

            for (Path file : (Iterable<Path>) files
                    .filter(Files::isRegularFile)
                    .filter(p -> !p.toAbsolutePath().normalize()
                            .equals(report))::iterator) {

                BasicFileAttributes attr = Files.readAttributes(
                        file, BasicFileAttributes.class);

                writer.write("File Name: " + file.getFileName());
                writer.newLine();

                writer.write("File Size: " + attr.size() + " bytes");
                writer.newLine();

                writer.write("Last Modified: "
                        + attr.lastModifiedTime());
                writer.newLine();

                writer.newLine();
            }

            System.out.println("Folder report generated successfully.");
            System.out.println("Report saved to: " + report);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
