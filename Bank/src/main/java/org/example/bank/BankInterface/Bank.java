package org.example.bank.BankInterface;

public abstract class Bank {


    public abstract void addMoney ( long money );
    public abstract void createAccount ( String accountNo , long money );
    abstract public void grantLoan ( String accountNo , long money );
    public abstract long showBalance(String accountNo);
    public abstract void depositMoney ( String accountNo , long money );
    public abstract void withdrawMoney ( String accountNo , long money );
    public abstract void transferMoney ( String toAccountNo , String fromAccountNo , long money );
}
