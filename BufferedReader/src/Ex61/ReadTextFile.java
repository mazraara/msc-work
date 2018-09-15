/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex61;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class ReadTextFile {
public static void main (String []args){
ReadTextFile read = new ReadTextFile();
read.readFile();
}
    public void readFile() {
        try {
            
            Scanner scanFile = new Scanner(new File("output.txt"));
            System.out.println("Reading file...");
            while (scanFile.hasNext()){
                System.out.println(scanFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }catch (Exception e){
            System.out.println("Exceptio: "+ e.getMessage());
        }
    }
}
