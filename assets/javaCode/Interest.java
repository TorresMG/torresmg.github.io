// Import Libaries
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

// Class that creates the Dialog Box for the Interest Calculator
public class Interest extends JFrame {
   private JFrame frame;
   private JTabbedPane tab;
   
   private JPanel panel;
   private JLabel p;
   private JTextField input;
   private JLabel r;
   private JTextField input2;
   private JLabel y;
   private JTextField input3;
   private JLabel f;
   private JTextField input4;
   private JButton c;
   
   private JPanel panel2;
   private JLabel p2;
   private JTextField input5;
   private JLabel r2;
   private JTextField input6;
   private JLabel y2;
   private JTextField input7;
   private JLabel f2;
   private JTextField input8;
   private JButton c2;
   
   private JPanel panel3;
   private JLabel p3;
   private JTextField input9;
   private JLabel r3;
   private JTextField input10;
   private JLabel y3;
   private JTextField input11;
   private JLabel f3;
   private JTextField input12;
   private JButton c3;
   
   public Interest() {
      frame = new JFrame();
      frame.setTitle("Interest Computer");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setSize(400, 300);
      frame.setLocationRelativeTo(null);
      
      tab = new JTabbedPane();
      buildPanel();
      tab.add("Simple", panel);
      buildPanel2();
      tab.add("Compound", panel2);
      buildPanel3();
      tab.add("Continious", panel3);
      frame.add(tab);
      frame.setVisible(true);
   }
   
   private void buildPanel() {
      panel = new JPanel();
      panel.setLayout(new GridLayout(5, 2));
      p = new JLabel("Principle $");
      input = new JTextField(5);
      r = new JLabel("Annual % Rate");
      input2 = new JTextField(5);
      y = new JLabel("Years");
      input3 = new JTextField(5);
      f = new JLabel("Output File");
      input4 = new JTextField(5);
      c = new JButton("Compute Simple Interest");
      c.addActionListener(new buttonListener());
      
      panel.add(p);
      panel.add(input);
      panel.add(r);
      panel.add(input2);
      panel.add(y);
      panel.add(input3);
      panel.add(f);
      panel.add(input4);
      panel.add(c);
   }
   
   private void buildPanel2() {
      panel2 = new JPanel();
      panel2.setLayout(new GridLayout(5, 2));
      p2 = new JLabel("Principle $");
      input5 = new JTextField(5);
      r2 = new JLabel("Annual % Rate");
      input6 = new JTextField(5);
      y2 = new JLabel("Years");
      input7 = new JTextField(5);
      f2 = new JLabel("Output File");
      input8 = new JTextField(5);
      c2 = new JButton("Compute Compounded Monthly Interest");
      c2.addActionListener(new buttonListener());
      
      panel2.add(p2);
      panel2.add(input5);
      panel2.add(r2);
      panel2.add(input6);
      panel2.add(y2);
      panel2.add(input7);
      panel2.add(f2);
      panel2.add(input8);
      panel2.add(c2); 
   }
   
   private void buildPanel3() {
      panel3 = new JPanel();
      panel3.setLayout(new GridLayout(5, 2));
      p3 = new JLabel("Principle $");
      input9 = new JTextField(5);
      r3 = new JLabel("Annual % Rate");
      input10 = new JTextField(5);
      y3 = new JLabel("Years");
      input11 = new JTextField(5);
      f3 = new JLabel("Output File");
      input12 = new JTextField(5);
      c3 = new JButton("Compute Continuous Interest");
      c3.addActionListener(new buttonListener());
      
      panel3.add(p3);
      panel3.add(input9);
      panel3.add(r3);
      panel3.add(input10);
      panel3.add(y3);
      panel3.add(input11);
      panel3.add(f3);
      panel3.add(input12);
      panel3.add(c3); 
   }
   
   private class buttonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) { 
         double prin;
         double rate;
         double year;
         String file;
         String title;
         if (e.getSource() == c) {
            prin = Double.parseDouble(input.getText());
            rate = Double.parseDouble(input2.getText());
            rate = rate/100.0;
            year = Double.parseDouble(input3.getText());
            file = input4.getText();
            title = "Simple Interest";
            fileOutput(title, file, prin, rate, year);
            
         }
         else if (e.getSource() == c2) {
            prin = Double.parseDouble(input5.getText());
            rate = Double.parseDouble(input6.getText());
            rate = rate/100.0;
            year = Double.parseDouble(input7.getText());
            file = input8.getText();
            title = "Interest Compounded Monthly";
            fileOutput(title, file, prin, rate, year);
         
         }
         else if (e.getSource() == c3) {
            prin = Double.parseDouble(input9.getText());
            rate = Double.parseDouble(input10.getText());
            rate = rate/100.0;
            year = Double.parseDouble(input11.getText());
            file = input12.getText();
            title = "Interest Compounded Continuously";
            fileOutput(title, file, prin, rate, year);
         }
      }
      
      public double calculateSimple(double prin, double rate, double year) {
         double a = prin * Math.pow((1 + rate), year);
         return a;
      }
      
      public double calculateCompound(double prin, double rate, double year) {
         double a = prin * Math.pow((1 + (rate/12.0)), (12.0 * year));
         return a;
      }
      
      public double calculateContinuous(double prin, double rate, 
                                                     double year) {
         double a = prin * Math.exp(rate * year);
         return a;
      }
      
      public void fileOutput(String title, String file, double prin, 
                        double rate, double year) {
            try {
            PrintWriter writer = new PrintWriter(new File(file));
            String data = String.format("%s\nPrinciple: %.2f\n" +
                                        "Interest Rate: %.4f\n" +
                                        "Years: %.0f", title, prin, rate, year);
            double a = 0.0;
            for (int i = 0; i < 11; ++i) {
               if (title.equals("Simple Interest")) {
                  a = calculateSimple(prin, rate, i);
                  data += String.format("\n%d $%.2f", i, a);
               }
               
               else if (title.equals("Interest Compounded Monthly")) {
                  a = calculateCompound(prin, rate, i);
                  data += String.format("\n%d $%.2f", i, a);
               }
               
               else if (title.equals("Interest Compounded Continuously")) {
                  a = calculateContinuous(prin, rate, i);
                  data += String.format("\n%d $%.2f", i, a);
               }
            }
            writer.println(data);                      
            writer.close();   
            frame.dispose();                   
         }
         catch (FileNotFoundException error_object)
         {
               System.out.print("");
         }
      }
   }
     
}
