package ru.mail.winter044.Main;


import java.util.Scanner;
public class Casino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 100;
        boolean isRunning = true;

        System.out.println("Добро пожаловать в Winter044 Casino!");

        System.out.println("====================================");

        System.out.println("Ваш баланс составляет " + balance + " " + "кредитов");

        while (isRunning){

            if (balance > 0){
                System.out.println("==================================");
                System.out.println("1 - Выбрать слот.");
                System.out.println("2 - Пополнить баланс.");
                System.out.println("3 - Выйти из казиной.");
                System.out.println("==================================");
                System.out.println("Выберите действие...");


                int choise1 = scanner.nextInt();

                switch (choise1){
                    case 1:
                        System.out.println("Переходим к выбору слота...");
                        balance = playSlots.playSlots(scanner, balance);
                        System.out.println("Мы списали у вас 10 кредитов, не волнуйтесь, это просто тест:)");
                        break;  
                    case 2:
                        System.out.println("Переходим к пополнению баланса...");
                        balance = Deposit.depositMoney(scanner, balance);
                        break;
                    case 3:
                        System.out.println("Спасибо за игру! До свидания!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Неверный выбор! Повторите попытку.");
                }
            }else {
                System.out.println("У вас закончились кредиты!");
                System.out.println("==================================");
                System.out.println("1 - Пополнить баланс.");
                System.out.println("2 - Выйти из казиной.");
                System.out.println("==================================");
                System.out.println("Выберите действие...");

                int choise2 = scanner.nextInt();

                switch (choise2){
                    case 1:
                        System.out.println("Переходим к пополнению баланса...");
                        break;
                    case 2:
                        System.out.println("Спасибо за игру! До свидания!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Неверный выбор! Повтоорите попытку.");
                }
            }
        }


    }
}
