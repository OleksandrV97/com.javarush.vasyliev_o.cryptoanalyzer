import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {

    public static List<String> readFile(String filePath) {
        try {
            Path path = Path.of(filePath);
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("ОШИБКА: Программа не может прочитать файл");
        }

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
