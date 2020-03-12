package com.company;

public class ATM {

    private  static void depositCard(CashCard card, int money){
        if (isValidDeposit(money)) {

            card.addMoney (money);

            //сообщение пользователю
            System.out.println("Deposit was successful");

            // пересчет баланса
            displayBalance(card);
        }
    }

    //снятие
    private void withdraw(CashCard card, int money) {
        // проверка на снятие суммы
        if (isValidWithdrawal(card,money)) {
            //получить введенные данные


            //вычесть деньги со счета
            card.takeMoney (money);

            //сообщение пользователю
            System.out.println("Withdrawal was successful");

            // пересчет баланса
            displayBalance(card);
        }
    }

    //проверка суммы для пополнения
    private  static boolean isValidDeposit(int money) {
        String message = "";


         if (money < 20) {
            message = "Minimum for deposit: 5";


        } else if (money > 100) {
            message = "Maximum for deposit: 500";

            // если не кратно 5
        } else if (money % 10 != 0) {
            message = "The amount must be a multiple of 5";

        } else {
            return true;
        }

        //сообщение пользователю об ошибке
        System.out.println("Error: " + message);
        return false;
    }

    //проверка суммы для снятия
    private boolean isValidWithdrawal(CashCard card,int money) {
        String message = " ";

         if (money < 20) {
            message = "Minimum for withdrawal: 5";


        } else if (money > 100) {
            message = "Maximum for withdrawal: 500";

            // если не кратно 5
        } else if (money % 10 != 0) {
            message = "The amount must be a multiple of 5";

            // недостаточно средств
        } else if (card.getBalance() - money< 0) {
            message = "Insufficient funds";


        } else {
            return true;
        }

        //сообщение пользователю
        System.out.println("Error: " + message);
        return false;
    }

    //остаток на счету
    private  static void displayBalance(CashCard card) {
        int balanceCard = card.getBalance();
        System.out.println("Account balance: " + balanceCard);
    }

    }

