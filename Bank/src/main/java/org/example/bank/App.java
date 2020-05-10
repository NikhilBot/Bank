package org.example.bank;

/**
 * Hello world!
 */
public class App {
    public static void main ( String[] args ) {

        User nikhil = new User("111","Nikhil",new SBI()) ;
        User hrt = new User("123","HRT",new SBI()) ;

        nikhil.createAccount(500);
        nikhil.showBalance();
        nikhil.createAccount(500);
        hrt.showBalance();
        hrt.createAccount(500);
        hrt.depositMoney(5000);
        hrt.showBalance();
        hrt.transfer("111",500);
        nikhil.showBalance();


    }
}
