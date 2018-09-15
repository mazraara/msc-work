/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex62;

import Ex61.BankAccount;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class ReadObject {

    /**
     * @param args the command line arguments
     */
    private ObjectInputStream in;
    public static void main(String[] args) {
        // TODO code application logic here
        
        ReadObject readOb = new ReadObject();
        readOb.openFile();
        readOb.readFile();
        readOb.close();
    }
    
    public void openFile(){
        try {
            in = new ObjectInputStream(new FileInputStream("AccountDetails.ser"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: "+ex);
        }catch(IOException e){
            System.out.println("IO Exception occurred: "+e);
            System.exit(1);
        }
    }
    
    public void readFile(){
    while(true){
            try {
                BankAccount bnkAcc = (BankAccount)in.readObject();
                
                System.out.println(bnkAcc.getName());
                System.out.println(bnkAcc.getAddress());
                System.out.println(bnkAcc.getSex());
                System.out.println(bnkAcc.getBranch());
                System.out.println(bnkAcc.getAccNumber());
                System.out.println(bnkAcc.getAmount());
            }catch(EOFException e){
                System.out.println("End of File Exception "+ e);
                System.exit(1);
            } 
            catch (IOException ex) {
                System.out.println("IO Exception occurred: "+ex);
                System.exit(1);
            } catch (ClassNotFoundException ex) {
                System.out.println("Class Not Found!");
            }
        
    }
    }
public void close(){
        try {
            if(in!=null){
            in.close();}
        } catch (IOException ex) {
               System.out.println("IO Exception occurred: "+ex);
               System.exit(1);
        }
}
}

