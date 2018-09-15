/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex61;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class ReadBufferedReader {

    /**
     * @param args the command line arguments
     */
    String [] arr =  new String[6];
    public static void main(String[] args) {
        // TODO code application logic here
        ReadBufferedReader rbf = new ReadBufferedReader();
        rbf.readFile();
        System.out.println("");
        System.out.println("");
        rbf.readArr();
    }
    
    public void readFile(){
        BufferedReader bf = null;
                try {
            int i =0;
            bf = new BufferedReader(new FileReader("output.txt"));
            System.out.println("Reading file from Buffered Reader...");
            String s = null;
            while((s=bf.readLine())!=null){
                System.out.println(s);
                arr[i]=s;
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found!");
            //Logger.getLogger(ReadBufferedReader.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e) {
            System.out.println("Exception: " + e);
        }finally{
            try {
                bf.close();
            } catch (IOException ex) {
                System.out.println(""+ex.getMessage());
               //Logger.getLogger(ReadBufferedReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    public void readArr(){
        int k =0;
    for(String i: arr){
        System.out.println("Array "+k+": " + i);
        k++;
    }
    }
}
