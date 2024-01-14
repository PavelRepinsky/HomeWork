package com.company.Homework28_12_2023;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws TerminalIsLockedException {
        PinValidator.validatePin();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Выберите действие:
                    1. Вывести текущий баланс
                    2. Снять деньги с баланса
                    3. Пополнить счёт
                    4. Выйти""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Ваш баланс: " + TerminalServer.balance);
                    break;
                }
                case 2: {
                    try{System.out.println("Введите сумму, которую желаете снять: ");
                        TerminalServer.withdraw(scanner.nextInt());
                        System.out.println("Ваш баланс после снятия суммы: " + TerminalServer.balance);}
                    catch (NotEnoughMoneyException |NotMultipleOfHundredException e){
                    }
                    break;
                }
                case 3: {
                    try{System.out.println("Введите сумму, которую желаете внести: ");
                        TerminalServer.deposit(scanner.nextInt());
                        System.out.println("Ваш баланс после внесения средств: " + TerminalServer.balance);}
                    catch (NotMultipleOfHundredException e) {
                    }
                    break;
                }
                case 4: {
                    System.out.println("Возвращайтесь, буду скучать!");
                    return;
                }
            }
        }
    }
}
