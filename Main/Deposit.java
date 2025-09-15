package ru.mail.winter044.Main;

import java.util.Scanner;

public class Deposit {

    // Метод должен принимать и возвращать баланс
    public static int depositMoney(Scanner scanner, int currentBalance) {
        System.out.println("\n🏦 Пополнение баланса");
        System.out.println("========================");

        System.out.print("Введите номер карты (16 цифр): ");
        String cardNumber = scanner.next();

        System.out.print("Введите CVV (3 цифры): ");
        String cvv = scanner.next();

        System.out.print("Введите сумму пополнения: ");
        int amount = scanner.nextInt();

        if(isValidCardData(cardNumber,cvv,amount)){
            int newBalance = currentBalance + amount;
            System.out.println("Успешно! Баланс пополнен на " + amount +  " " + "кредитов!" );
            System.out.println("Новый баланс "+ newBalance + " " + "кредитов.");
            return newBalance;
        } else{
            System.out.println("Ошибка пополнения, проверьте введённые данные!");
            return currentBalance;
        }
    }
    private static boolean isValidCardData(String cardNumber, String cvv, int amount){
        if (amount <= 0){
            System.out.println("Введите сумму, которая больше нуля!");
            return false;
        }
        if (cardNumber.length() != 16){
            System.out.println("Проверьте номер карты!");
            return false;
        }
        if (cvv.length() != 3){
            System.out.println("Не верный CVV код, проверьте введённые данные!");
            return false;
        }
        return true;
    }
}