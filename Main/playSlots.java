package ru.mail.winter044.Main;
import java.util.Random;
import java.util.Scanner;
public class playSlots {
    public static int playSlots(Scanner scanner, int balance) {
        Random random = new Random();

        boolean playing = true;
        while (playing){
            System.out.println("\n=== ВЫБЕРИТЕ АВТОМАТ ===");
            System.out.println("1. Фруктовый 🍒 (ставка: 10 кредитов)");
            System.out.println("2. Цифровой 🔢 (ставка: 15 кредитов)");
            System.out.println("3. Символьный ⭐ (ставка: 20 кредитов)");
            System.out.println("0. Назад в меню");
            System.out.println("💰 Баланс: " + balance + " кредитов");

            int choise = scanner.nextInt();

            if (choise == 0){
                playing = false;
                continue;
            }


        }

    }
}
