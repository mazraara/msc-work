/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sumoftwonumbers;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Azraar
 */
class TextFieldFrame extends JFrame {
 private JTextField textField1; // text field with set size
 private JTextField textField2; // text field constructed with text
 private JLabel label1; // text field with text and size
 private JLabel label2; // password field with text
 private JButton button1;

 // TextFieldFrame constructor adds JTextFields to JFrame
 public TextFieldFrame() {
  super("Testing JTextField and JPasswordField");
  setLayout(new FlowLayout()); // set frame layout

  label1 = new JLabel("First Number");
  add(label1); // add textField3 to JFrame
  // construct textfield with 10 columns
  textField1 = new JTextField(15);
  add(textField1); // add textField1 to JFrame

  label2 = new JLabel("Second Number");
  add(label2); // add textField3 to JFrame

  // construct textfield with default text         
  textField2 = new JTextField(15);
  add(textField2); // add textField2 to JFrame

  // construct passwordfield with default text
  button1 = new JButton("Print Sum");
  add(button1); // add passwordField to JFrame

  // Create an ActionListner object (handler)
  // Class name is TextFieldHandler
  ButtonHandler handler = new ButtonHandler();

  button1.addActionListener(handler);
 }
 // private inner class for event handling
 private class ButtonHandler implements ActionListener {
  // process text field events
  // event can be ny event that happens
  public void actionPerformed(ActionEvent event) {
   String s1 = "";
   String s2 = "";
   String s3 = "";

   int n1, n2, sum;
   // declare string to display

   // user pressed Enter in JTextField textField1
   if (event.getSource() == button1) {
    s1 = textField1.getText();
    s2 = textField2.getText();
   }
   n1 = Integer.parseInt(s1);
   n2 = Integer.parseInt(s2);
   sum = n1 + n2;

   JOptionPane.showMessageDialog(null, sum);
  } // end method actionPerformed
 } // end private inner class TextFieldHandler
} // end class TextFieldFrame

}

public class SumofTwoNumbers {

 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
  // TODO code application logic here
  TextFieldFrame textFieldFrame = new TextFieldFrame();
  textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  textFieldFrame.setSize(300, 150); // set frame size
  textFieldFrame.setVisible(true); // display frame
 }
}