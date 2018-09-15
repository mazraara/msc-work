/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex61;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author Bilal Abdulkany
 * This class writes the input data to a text file
 */

public class WriteToTextFile {
    private String Cusname="";
    private String address="";
    private char sex='b';
    
    private double amount=0;
    private String accNumber="";
    private String branch="";
    
    public static void main (String [] args){
       
    WriteToTextFile wrt = new WriteToTextFile();
    wrt.getAccountDetails();
    }
    
    public void getAccountDetails(){
               Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Name:");
        Cusname = scan.nextLine();
        //System.out.println("Name"+ Cusname);
        System.out.println("Enter the Address:");
        address = scan.nextLine();
        System.out.println("Enter the Sex:");
        sex = scan.nextLine().charAt(0);
        
        System.out.println("Enter the Account number:");
        accNumber = scan.nextLine();
        System.out.println("Enter the Branch:");
        branch = scan.nextLine();
        System.out.println("Enter the Amount:");
        amount = scan.nextDouble();
        
       
               BankAccount bankAcc = new BankAccount(Cusname, address, sex, amount, accNumber, branch);
       // System.out.println("Name"+ bankAcc.getName());
            PrintWriter output =null;
            try {
                 output = new PrintWriter("output.txt");
                
                output.println(bankAcc.getName());
                output.println(bankAcc.getAddress());
                output.println(bankAcc.getSex());
                output.println(bankAcc.getAccNumber());
                output.println(bankAcc.getBranch());
                output.println(bankAcc.getAmount());
                
                
            } catch (FileNotFoundException ex) {
                System.out.println("File not Found!");
            } catch (IOException e){
                    System.out.println("Exception thrown !"+ e.getMessage());
            }finally{
            output.flush();
                output.close();
            
            
            }
        
        
    }
}
