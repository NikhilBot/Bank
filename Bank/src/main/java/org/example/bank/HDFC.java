package org.example.bank;

import org.example.bank.BankInterface.Bank;

import java.util.HashMap;

public class HDFC extends Bank {

    private static String IFSC = "HDFC0000123";
    private static HashMap<String, Long> userAccounts = new HashMap<>();
    private static HashMap<String, Long> loanAccounts = new HashMap<>();
    private static long totalMoney = 999999999999l;
    private static long totalLoan = 0l;


    HDFC(){}

    @Override
    public long showBalance(String accountNo)
    {
        return userAccounts.getOrDefault(accountNo,-1l);
    }

    /**
     * Creates new account for a new user
     * if account already exists it throws an Exception
     *
     * @param accountNo account no of the user
     * @param money     money initially deposited in account
     */

    @Override
    public void createAccount ( String accountNo , long money ) throws RuntimeException {
        if (userAccounts.containsKey(accountNo)) throw new RuntimeException();
        userAccounts.put(accountNo , money);
    }

    /**
     * deposits money in the already existing account
     *
     * @param accountNo account no. of depositor
     * @param money     money to be deposited
     */

    @Override
    public void depositMoney ( String accountNo , long money ) {
        if (userAccounts.containsKey(accountNo)) {
            long oldValue = userAccounts.get(accountNo);
            userAccounts.put(accountNo , userAccounts.get(accountNo) + money);
            addMoney(money);
        } else {
            System.out.println("Please Create an Account first");
        }
    }

    /**
     * method for withdrawl of money
     * if account and sufficient balance exists
     * @param accountNo
     * @param money
     */

    @Override
    public void withdrawMoney ( String accountNo , long money ) {
        if (userAccounts.containsKey(accountNo)) {
            if (userAccounts.getOrDefault(accountNo , 0l) - money >= 500) {
                long oldValue = userAccounts.get(accountNo);
                userAccounts.put(accountNo , userAccounts.get(accountNo) + money);
                totalMoney -= money;
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Please Create an Account first");
        }
    }
    /**
     * Grants loan to user and creates entry in loan account
     * and adds money to user account (creates new entry
     * if not already present)
     *
     * @param accountNo
     * @param money
     */

    @Override
    public void grantLoan ( String accountNo , long money ) {
        long previousLoanAmountLeft = loanAccounts.getOrDefault(accountNo , 0L);
        long amountInUserAccount = userAccounts.getOrDefault(accountNo , 0l);
        if (previousLoanAmountLeft < 5000) {
            loanAccounts.put(accountNo , previousLoanAmountLeft + money);
            userAccounts.put(accountNo , amountInUserAccount + money);
            HDFC.totalMoney -= money;
            HDFC.totalLoan += money;
        }
    }

    /**
     * Adds money to bank
     * when a deposit is made
     *
     * @param money money to be added
     */


    @Override
    public void addMoney ( long money ) {
        HDFC.totalMoney += money;
    }

    /**
     * Transfers money from one account to other
     * if sufficient balance is there
     *
     * @param toAccountNo to Account no
     * @param fromAccountNo from Account no
     * @param money money to be transferred
     */
    @Override
    public void transferMoney ( String toAccountNo , String fromAccountNo , long money ) {

        long totalMoneyToAccount = userAccounts.getOrDefault(fromAccountNo , 0L);
        long totalMoneyFromAccount = userAccounts.getOrDefault(toAccountNo , -1L);
        if (totalMoneyToAccount - money <= 500) {
            System.out.println("Insufficient amount in account");
        } else if (totalMoneyFromAccount == -1) {
            System.out.println("To Account not found!!");
        } else {
            userAccounts.put(fromAccountNo , totalMoneyFromAccount - money);
            userAccounts.put(toAccountNo , totalMoneyToAccount + money);
            System.out.println("Transfer Successful!! Balance left:" + userAccounts.get(fromAccountNo));
        }

    }
}
