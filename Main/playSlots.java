package ru.mail.winter044.Main;
import java.util.Random;
import java.util.Scanner;

public class playSlots {

    public static int playSlots(Scanner scanner, int balance) {
        boolean playing = true;
        Random random = new Random();

        while (playing) {
            System.out.println("\n=== ВЫБЕРИТЕ АВТОМАТ ===");
            System.out.println("1. Фруктовый 🍒");
            System.out.println("2. Бриллиантовый 💎");
            System.out.println("3. Цифровой 🔢");
            System.out.println("0. Назад в меню");
            System.out.println("💰 Баланс: " + balance + " кредитов");
            System.out.print("Ваш выбор: ");

            int slotChoise = scanner.nextInt();

            if (slotChoise == 0) {
                playing = false;
                continue;
            }

            if (slotChoise < 1 || slotChoise > 3) {
                System.out.println("❌ Неправильный выбор!");
                continue;
            }

            String[] symbols = {};
            String slotName = "";

            switch (slotChoise) {
                case 1:
                    symbols = new String[]{"🍒", "🍋", "🍊", "🍇", "🍉", "🍓"};
                    slotName = "ФРУКТОВЫЙ";
                    break;
                case 2:
                    symbols = new String[]{"💎", "🔶", "🔷", "✨", "🌟", "💍"};
                    slotName = "БРИЛЛИАНТОВЫЙ";
                    break;
                case 3:
                    symbols = new String[]{"7️⃣", "🔢", "1️⃣", "2️⃣", "3️⃣", "⭐"};
                    slotName = "ЦИФРОВОЙ";
                    break;
            }

            System.out.println("Вы выбрали " + slotName + " автомат.");

            System.out.println("\n💵 ВЫБЕРИТЕ РАЗМЕР СТАВКИ:");
            System.out.println("1. Минимальная (10 кредитов)");
            System.out.println("2. Средняя (25 кредитов)");
            System.out.println("3. Максимальная (50 кредитов)");
            System.out.println("4. Своя ставка");
            System.out.println("0. ↩️ Вернуться назад");
            System.out.print("Ваш выбор: ");

            int betChoise = scanner.nextInt();
            int betAmount = 0;

            switch (betChoise) {
                case 0:
                    continue;
                case 1:
                    betAmount = 10;
                    break;
                case 2:
                    betAmount = 25;
                    break;
                case 3:
                    betAmount = 50;
                    break;
                case 4:
                    System.out.print("Введите вашу ставку: ");
                    betAmount = scanner.nextInt();
                    if (betAmount <= 0) {
                        System.out.println("❌ Ставка должна быть больше 0!");
                        continue;
                    }
                    break;
                default:
                    System.out.println("❌ Неправильный выбор!");
                    continue;
            }

            if (balance < betAmount) {
                System.out.println("❌ У вас недостаточно средств.");
                continue;
            }

            balance -= betAmount;
            System.out.println("💰 Ставка " + betAmount + " кредитов принята!");
            System.out.println("💰 Остаток: " + balance + " кредитов");

            // АНИМАЦИЯ ПРОКРУТКИ С ЗАДЕРЖКОЙ
            System.out.println("\n🎰 Крутим барабаны...");
            sleep(1000);

            System.out.print("🌀 ");
            sleep(300);
            System.out.print("🌀 ");
            sleep(300);
            System.out.println("🌀");
            sleep(500);

            System.out.println("⚡ Барабаны крутятся...");
            sleep(800);

            // Генерируем результат
            int index1 = random.nextInt(symbols.length);
            int index2 = random.nextInt(symbols.length);
            int index3 = random.nextInt(symbols.length);

            String s1 = symbols[index1];
            String s2 = symbols[index2];
            String s3 = symbols[index3];

            // Постепенно показываем результат с задержкой
            System.out.print("🎰 Результат: ");
            sleep(600);
            System.out.print(s1 + " ");
            sleep(500);
            System.out.print(s2 + " ");
            sleep(400);
            System.out.println(s3);
            sleep(300);

            System.out.println("==================");

            int winAmount = 0;
            if (s1.equals(s2) && s2.equals(s3)) {
                System.out.println("🎉 MAXWIN!!! ДЖЕКПОТ!");
                winAmount = betAmount * 1000;
                sleep(1000);
            } else if (s1.equals(s2) || s1.equals(s3) || s2.equals(s3)) {
                System.out.println("👍 Успех! Вы получили 50X!");
                winAmount = betAmount * 50;
                sleep(800);
            } else {
                System.out.println("😢 Не повезло, эта ставка не прошла");
                sleep(500);
            }

            if (winAmount > 0) {
                balance += winAmount;
                System.out.println("💰 Выигрыш: " + winAmount + " кредитов!");
                System.out.println("💰 Новый баланс: " + balance + " кредитов");
            }

            // Проверяем, есть ли еще деньги для игры
            if (balance <= 0) {
                System.out.println("💸 Баланс закончился!");
                playing = false;
            } else {
                // Спрашиваем, хочет ли игрок продолжить
                System.out.print("\n🎯 Продолжить играть? (1 - да, 0 - нет): ");
                int continueChoice = scanner.nextInt();
                if (continueChoice == 0) {
                    playing = false;
                }
            }
        }
        return balance;
    }

    // Вспомогательный метод для задержки
    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
