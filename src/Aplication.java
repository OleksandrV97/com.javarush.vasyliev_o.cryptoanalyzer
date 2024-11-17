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


        switch (keyboard.nextInt()) {
            case 1:
                System.out.println("Укажите путь к файлу для шифрования");
                String inputFile = keyboard.next();
                FileManager fileManager = new FileManager();
                String readerFile = fileManager.readFile(inputFile);
                System.out.println("Введите ключ для шифрования (целое число)");
                String keyCypher = keyboard.next();
                System.out.println("Укажите путь для сохранения нового файла");
                String saveFile = keyboard.next();


        }
    }
}
