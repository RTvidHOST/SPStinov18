package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long add = 5000;
        int time = 3;
        long cost = 10000;

        Account acc = new Account();

        //Потока, пополняющий баланс
        balanceInt balanceReplenishmentThread = new balanceInt(acc, add, time);

        balanceReplenishmentThread.start();

        //Метод, ожидающий пополнения баланса для списания
        acc.threadWithdrawal(cost);

        //Показывает, сколько осталось на балансе
        acc.checkBalance();
    }
}