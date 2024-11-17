import java.util.List;
import java.util.Scanner;

public class Aplication {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Validator validator = new Validator();


        System.out.println("ВЫБЕРИТЕ ПУНКТ МЕНЮ");

        System.out.println("1. Шифрование с ключом");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. Расшифровка при помощи - Brute force");
        System.out.println("0. Выход");

        var var = keyboard.nextInt();
        keyboard.nextLine();

        switch (var) {
            case 1:
                doCrypt(validator, keyboard);
                break;
            case 2:

                doDecrypt(validator, keyboard);
                break;
            case 3:
                doBruteForce(validator, keyboard);
                break;
            case 0:
                System.out.println("Завершение работы программы");
                System.exit(0);
            default:
                System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
        }
    }
    public static void doCrypt(Validator validator, Scanner keyboard) {
        System.out.println("Укажите путь к исходному файлу");
        String inputFile = keyboard.nextLine();
        System.out.println("Напишите ключ (целое число)");
        String key = keyboard.nextLine();
        System.out.println("Укажите путь сохранения файла");
        String saveFile = keyboard.nextLine();

        if (validator.isFileExists(inputFile) && validator.isValidKey(inputFile) && validator.isValidKey(key)) {
            List<String> list = FileManager.readFile(inputFile);
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : list) {
                String crypt = Cypher.crypt(line, Integer.parseInt(key));
                stringBuilder.append(crypt).append("\n");
            }
            FileManager.writeFile(saveFile, stringBuilder.toString());
            System.out.println("Файл зашифрован и сохранен");
        }
    }
    public static void doDecrypt(Validator validator, Scanner keyboard) {
        System.out.println("Укажите путь к исходному зашифрованому файлу");
        String inputFile = keyboard.nextLine();
        System.out.println("Напишите ключ (целое число)");
        String key = keyboard.nextLine();
        System.out.println("Укажите путь сохранения файла");
        String saveFile = keyboard.nextLine();
        if (validator.isFileExists(inputFile) && validator.isValidKey(inputFile) && validator.isValidKey(key)) {
            List<String> list = FileManager.readFile(inputFile);
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : list) {
                String decrypt = Cypher.decrypt(line, Integer.parseInt(key));
                stringBuilder.append(decrypt).append("\n");
            }
            FileManager.writeFile(saveFile, stringBuilder.toString());
            System.out.println("Файл расшифрован и сохранен");
        }
    }public static void doBruteForce(Validator validator, Scanner keyboard) {
        System.out.println("Укажите путь к файлу для расшифровки");
        String path = keyboard.nextLine();
        System.out.println("Укажите путь для сохранения расшифрованных файлов");
        String newPath = keyboard.nextLine();
        if (validator.isFileExists(path) && validator.isValidKey(path)) {
            Cypher.bruteForce(path, newPath);
            System.out.println("Расшифрованные файлы сохранены");
        }
    }
}
