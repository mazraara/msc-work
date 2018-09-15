package bankapplication;

import java.util.Random;

public class Depositor extends Thread {

    BankAccount account;

    public Depositor(BankAccount account) {
        this.account = account;
    }

    public void run() {

        Random rnd = new Random();
        double depositAmount = 0.0;

        for (int i = 0; i < 10; i++) {
            depositAmount = rnd.nextDouble();
            account.deposit(depositAmount);
            double balance = account.getAccountBalance();

            System.out.printf("After depositing amount %.2f balance is: %.2f \n",depositAmount,balance);
        }

    }
}
