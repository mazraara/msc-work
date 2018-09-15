/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javapanel1;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

/**
 *
 * @author Azraar
 */
class PanelFrame extends JFrame {

 private JPanel pannel1;
 private JPanel pannel2;
 // panel to hold buttons
 private JLabel label1; // array of buttons
 private JLabel label2;
 private JTextField text1;
 private JTextField text2;
 // no-argument constructor
 public PanelFrame() {
  super("Panel Demo");
  label1 = new JLabel("Name"); // create buttons array
  label2 = new JLabel("Salary");
  text1 = new JTextField(10);
  text2 = new JTextField(10);

  pannel1 = new JPanel(); // set up panel    
  pannel2 = new JPanel();

  pannel1.setLayout(new GridLayout(1, 2));
  pannel2.setLayout(new GridLayout(1, 2))
  pannel1.add(label1); // add button to panel
  pannel1.add(text1);

  pannel2.add(label2); // add button to panel
  pannel2.add(text2);

  add(pannel1, BorderLayout.NORTH); // add panel to JFrame
  add(pannel2, BorderLayout.SOUTH);
 } // end PanelFrame constructor

}


/**
 *
 * @author ananda
 */
public class JavaPanel1 {

 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
  // TODO code application logic here

  PanelFrame panelFrame = new PanelFrame();
  panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  panelFrame.setSize(200, 100); // set frame size
  panelFrame.setVisible(true); // display frame

 }
}