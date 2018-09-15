
package bankapplication;


public class BankApplication {

   
    public static void main(String[] args) {
        
        BankAccount account=new BankAccount(123);
        Depositor deposit=new Depositor(account);
        Withdrawer withdraw=new Withdrawer(account);
        
        deposit.start();
        withdraw.start();
        
       
    }
}
