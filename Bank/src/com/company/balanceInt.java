package com.company;

public class balanceInt extends Thread{

    private final AcInt account;
    private final long add;
    private final int time;

    balanceInt(AcInt account, long add, int time){
        this.account = account;
        this.add = add;
        this.time = time;
    }

    @Override
    public void run(){
        for (int i = this.time; i>0; i--) {
            account.balanceint(add);
        }
    }
}