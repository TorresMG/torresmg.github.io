import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class StudentData extends JFrame {
   private JFrame frame;
   private JPanel panel1; 
   private JLabel label1;
   private JLabel label2;
   private JTextField name; 
   private JTextField id;
    
   private JPanel panel2;
   private JCheckBox trad;
   private JLabel label3;
   private JCheckBox gen;
   private JLabel label4;
   private JCheckBox adult;
   private JLabel label5;
   private JCheckBox vet;
   private JLabel label6;
   
   private JPanel panel3;
   private JRadioButton male;
   private JRadioButton female;
   
   private JPanel panel4;   
   private JButton button1;
   private JButton button2;  
   private JButton button3; 
   
   private JOptionPane exit;
   private JButton yes;
   private JButton no;            
   
   public StudentData() {
      frame = new JFrame();
      frame.setLayout(new GridLayout(4, 1));
      frame.setTitle("Student Data");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setSize(350, 300);
      frame.setLocationRelativeTo(null);
      buildPanel1();
      frame.add(panel1);
      buildPanel2();
      frame.add(panel2);
      buildPanel3();
      frame.add(panel3);
      buildPanel4();
      frame.add(panel4);
      frame.setVisible(true);
   }
   
   private void buildPanel1() {
       panel1 = new JPanel(); 
       name = new JTextField(10);
       label1 = new JLabel("Name:");
       id = new JTextField(7);
       label2 = new JLabel("Student ID:");
       panel1.add(label1);
       panel1.add(name);
       panel1.add(label2);
       panel1.add(id);
                       
   }
   
   private void buildPanel2() {
       panel2 = new JPanel(); 
       trad = new JCheckBox(); 
       trad.setText("Traditional");
       gen = new JCheckBox(); 
       gen.setText("1st Generation");
       adult = new JCheckBox(); 
       adult.setText("Adult Student");
       vet = new JCheckBox();  
       vet.setText("Veteran");  
       
       panel2.add(trad);  
       panel2.add(gen);  
       panel2.add(adult);  
       panel2.add(vet);  
  
   }
   
   private void buildPanel3() {
       panel3 = new JPanel();  
       male = new JRadioButton("Male");
       female = new JRadioButton("Female");
       panel3.add(male);
       panel3.add(female);               
   }
   
   private void buildPanel4() {
       panel4 = new JPanel(); 
       button1 = new JButton("New");
       button1.addActionListener(new buttonListener());
       button2 = new JButton("Save");
       button2.addActionListener(new buttonListener());
       button3 = new JButton("Exit");
       button3.addActionListener(new buttonListener());
       panel4.add(button1);
       panel4.add(button2);
       panel4.add(button3);           
   }
   
   
   private class buttonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) { 
         if (e.getSource() == button1) {
            name.setText("");
            id.setText("");
            trad.setSelected(false);
            gen.setSelected(false);
            adult.setSelected(false);
            vet.setSelected(false);
            male.setSelected(false);
            female.setSelected(false);
         }
         else if (e.getSource() == button2) {
            try {
               PrintWriter writer = new PrintWriter(new File(id.getText()));
               String data = String.format("%s\n%s\n%s%s%s%s%s%s", 
                                    name.getText(), 
                                    id.getText(),
                                    trad.isSelected()?"Traditional\n":"",
                                    gen.isSelected()?"1st Generation\n":"",
                                    adult.isSelected()?"Adult\n":"",
                                    vet.isSelected()?"Veteran\n":"",
                                    male.isSelected()?"Male\n":"",
                                    female.isSelected()?"Female\n":"");
               writer.println(data);                      
               writer.close();
            }
            catch (FileNotFoundException error_object)
            {
               System.out.print("");
            }
         }
         else if (e.getSource() == button3) {
            int select = JOptionPane.showConfirmDialog(null, "Are you sure?",  
                               "Exit Selected", JOptionPane.YES_NO_OPTION);
            if (select == JOptionPane.YES_OPTION) {
               frame.dispose();
            }           
         }   
      }
   }  
} 