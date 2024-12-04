import java.io.File;

public class Validator {
    public boolean isValidKey(String key) {
        if (key == null) {
            System.out.println("Err: не праильный ключ");
            return false;
    }
    return true;
}
    public boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}
