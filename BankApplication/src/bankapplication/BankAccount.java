
package bankapplication;


public class BankAccount {
  
    int accountNumber;
    double accountBalance;
    
    //Constructor
    public BankAccount(int accountNumber){
        this.accountNumber=accountNumber;
        this.accountBalance=0.0;
    }
    
    //Deposit Method
    public synchronized void deposit(double amount){
        accountBalance=accountBalance+amount;
        notify();//withdraw thread is set to runnable state because it's in waiting state
    }
    
    //Withdraw Method
    public synchronized void withdraw(double amount) throws InterruptedException{
        if (accountBalance<amount){
            wait();
        }else{
        accountBalance=accountBalance-amount;
        }
    }
    
    //Get Method

    public double getAccountBalance() {
        return accountBalance;
    }
    
}
