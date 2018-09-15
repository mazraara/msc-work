
package bankapplication;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Withdrawer extends Thread {
    BankAccount account;
    
    public Withdrawer(BankAccount account){
        this.account=account;
    }
    
    public void run(){
        
        Random rnd=new Random();
        double withdrawAmount=0.0;
        for(int i=0; i<10; i++){
            try {
                withdrawAmount=rnd.nextDouble();
                account.withdraw(withdrawAmount);
            } catch (InterruptedException ex) {
                Logger.getLogger(Withdrawer.class.getName()).log(Level.SEVERE, null, ex);
            }
        double balance= account.getAccountBalance();
       
        System.out.printf("After withdrawing amount %.2f balance is: %.2f \n",withdrawAmount,balance);
        }
        
    }
}
