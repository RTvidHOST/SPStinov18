package com.company;

public class Account implements AcInt{
    private long balance = 0;

    public void balanceint(long add){
        balance += add;
        System.out.println("Пополнение баланса на " + add + " руб");
    }

    //Cgbcfybt
    public void withdrawal(long cost) throws InterruptedException {
        if(balance>=cost) {
            balance -= cost;
            System.out.println("Списание баланса на " + cost + " руб");
        }
        else {
            Thread.sleep(50000);
            System.out.println("Недостаточно средств");
        }
    }

    public void checkBalance() {
        System.out.println("На балансе: " + balance + " руб");
    }

    public void threadWithdrawal(long cost){
        int waitingTime = 0;
        while (true) {
            waitingTime++;
            if (balance >= cost) {
                balance -= cost;
                System.out.println("Списание баланса на " + cost + " руб");
                break;
            }
            else {
                System.out.println("Недостаточно средств");
            }
            if (waitingTime > 1000000){
                System.out.println("Превышено время ожидания");
                break;
            }
        }
    }
}