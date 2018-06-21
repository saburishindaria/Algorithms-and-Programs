/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SwingJList extends JFrame{
    
    

    SwingJList(String Title){
        super(Title);
    }
    public static void main(String[] args) {
        SwingJList frame=new SwingJList("Select Continent");
        frame.setSize(500, 500);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0,1,50,50));  
        
        JButton submit=new JButton("SUBMIT");
        
        submit.setSize(100,50);
        
        JTextField display = new JTextField();
//        display.setVisible(true);
        display.setSize(400,100);
        
        final DefaultListModel<String> countryName=new DefaultListModel<>();
        countryName.addElement("Asia");
        countryName.addElement("Europe");
        countryName.addElement("Australia");
        countryName.addElement("Africa");
        countryName.addElement("Antartica");
        final JList<String> countryList = new JList<>(countryName);
        countryList.setSize(200,150);
        
        Action act = new Action();
        act.passTextField(display);

        submit.addActionListener(act);
        countryList.addListSelectionListener(act);
        
        frame.add(display);
        frame.add(countryList);
        frame.add(submit);
        frame.setVisible(true);
        
    }
    
    
}

class Action implements ActionListener,ListSelectionListener{
    ArrayList<String> Selected=new ArrayList<>();
    JTextField toSet;
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Inside Action Listener");
        try{
            FileWriter wr = new FileWriter(new File("File.txt"));
            BufferedWriter br = new BufferedWriter(wr);
            
            br.write("The Names of Countries you Selected :\n");
            
            for(String str : Selected)
                br.write(str+"\n");
                
            for(String s:Selected)
                System.out.println(s);                
                        
            br.close();
            wr.close();           
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found");
            ex.printStackTrace();            
        }
        catch(IOException ex){
            System.out.println("IO Exception");
            ex.printStackTrace();            
        }
              
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        String text="";
        if(e.getValueIsAdjusting() == true){
            System.out.println("Inside List Listener");
            Object ob = e.getSource();
            JList<String> list =(JList<String>)(ob);
            Selected.add(list.getSelectedValue());
            for(String s:Selected){
                System.out.println(s);
                text+=s+", ";
            }
            toSet.setText(text);
        }
    }
    
    void passTextField(JTextField f){
        toSet=f;
    }
}


