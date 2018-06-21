/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Swingcheckbox {
static int count;
int flag=0;
 public static JCheckBox checkbox1 = new JCheckBox("Painting");
 public static JCheckBox checkbox2 = new JCheckBox("Skating");
 public static JCheckBox checkbox3 = new JCheckBox("Reading");     
 public static JCheckBox checkbox4 = new JCheckBox("Sketching");
    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkbox with event listener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0,1,50,50));
        JTextField j=new JTextField(20);
        panel1.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(checkbox1);
           panel1.add(checkbox2);
           panel1.add(checkbox3);
           panel1.add(checkbox4);
           panel1.add(j);
    
           
           checkbox1.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
              if (e.getStateChange() == 1) {
              count++;
              System.out.println(count);
              j.setText("No of hobbies selected "+count);
              
            } else {
                  count--;
                  System.out.println(count);
                  j.setText("No of hobbies selected "+count);
	      }
            }
         });
           checkbox2.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
              if (e.getStateChange() == 1) {
              count++;
              System.out.println(count);
              j.setText("No of hobbies selected "+count);
            } else {
                  count--;
                  System.out.println(count);
                  j.setText("No of hobbies selected "+count);
	      }
              
            }
         });
           checkbox3.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
              if (e.getStateChange() == 1) {
              count++;
              System.out.println(count);
              j.setText("No of hobbies selected "+count);
            } else {
                  count--;
                  System.out.println(count);
                  j.setText("No of hobbies selected "+count);
	      }
            }
         });
           checkbox4.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
              if (e.getStateChange() == 1) {
              count++;
              System.out.println(count);
              j.setText("No of hobbies selected "+count);
            } else {
                  count--;
                  System.out.println(count);
                  j.setText("No of hobbies selected "+count);
	      }
            }
         });
                       frame.setSize(1000,1000);
            frame.add(panel1);
	 frame.pack();
	 frame.setVisible(true);

    }
}