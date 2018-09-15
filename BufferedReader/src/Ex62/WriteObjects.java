/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex62;

import Ex61.BankAccount;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class WriteObjects {

    /**
     * @param args the command line arguments
     */
    private String Cusname = "";
    private String address = "";
    private char sex = 'b';
    private double amount = 0;
    private String accNumber = "";
    private String branch = "";
    ObjectOutputStream out;

    public static void main(String[] args) {
        // TODO code application logic here
        WriteObjects writeOb = new WriteObjects();
        writeOb.openFile();
      writeOb.getAccountDetails();
    }

    public void getAccountDetails() {
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
        try {
            out.writeObject(bankAcc);
        } catch (IOException ex) {
            System.out.println("Exception" + ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                System.out.println("Error in closing file");

            }
        }

    }

    public void openFile() {
        try {
            out = new ObjectOutputStream(new FileOutputStream("AccountDetails.ser"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Exception" + e);
        }

    }
}
