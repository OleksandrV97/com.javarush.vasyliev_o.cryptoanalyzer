import java.util.Scanner;

public class Aplication {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("ВЫБЕРИТЕ ПУНКТ МЕНЮ");
        System.out.println("1. Шифрование с ключом");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. Brute force");
        System.out.println("0. Выход");


        int k = keyboard.nextInt();
    }
}

