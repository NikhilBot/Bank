package org.example.bank;

import org.example.bank.BankInterface.Bank;

public class User {
    private final String accountNo;
    private String name;
    private final Bank bank;

    User(String accountNo,String name, Bank bank) {
        this.accountNo = accountNo;
        this.name = name;
        this.bank = bank;
    }

    public void createAccount(long money){
        this.bank.createAccount(this.accountNo,money);
    }

    public void depositMoney(long money) {
        this.bank.depositMoney(this.accountNo,money);
    }

    public void transfer(String toAccountNo , long money){
        this.bank.transferMoney(toAccountNo,this.accountNo,money);
    }

    public void withdraw(long money) {
        this.bank.withdrawMoney(this.accountNo,money);
    }

    public void showBalance()
    {
        long bal = this.bank.showBalance(this.accountNo);
        if(bal==-1)
        {
            System.out.println("No Account");
        }
        else{
            System.out.println(bal);
        }
    }

    public void getLoan(long money)
    {
        this.bank.grantLoan(this.accountNo,money);
    }

}
