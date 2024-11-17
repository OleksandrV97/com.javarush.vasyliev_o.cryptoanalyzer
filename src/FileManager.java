import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {

    public static String readFile(String filePath) {
        StringBuilder strBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath)) {
            char[] buffer = new char[1024];
            while (fileReader.ready()) {
                int read = fileReader.read(buffer);
                strBuilder.append(buffer, 0, read);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str = strBuilder.toString();
        return str;
    }

    public static void writeFile(String content, String filePath) {
        try {
            Path path = Path.of(filePath);
            Files.writeString(path, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
