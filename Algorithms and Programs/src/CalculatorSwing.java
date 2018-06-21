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
import static java.lang.Double.parseDouble;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculatorSwing extends JFrame implements ActionListener {

    JButton []b=new JButton[4];
    JTextField t1,t2;
    GridLayout gd;
    JLabel l1,l3,l4;
     int num1,num2;
     double result;
    CalculatorSwing()
    {
         super("Calculate");
        setSize(300,200);   //equivalent to    this.setSize(300,200);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gd=new GridLayout(0,2,50,50);
        t1=new JTextField();
        t2=new JTextField();
        l3= new JLabel("Number 1:");
        l4=new JLabel("Number 2:");
        String arr[] = {"Add","Subtract","Divide","Multiply"};
        for(int i=0;i<arr.length;i++)
        {
            b[i]=new JButton(arr[i]);
            
        }
         l1=new JLabel();  
         b[0].addActionListener(this);
         b[1].addActionListener(this);
         b[2].addActionListener(this);
         b[3].addActionListener(this);
         
        setLayout(new GridLayout(0,2,15,10));
        add(l3);add(t1);
        add(l4);add(t2);
        add(b[0]);add(b[1]);add(b[2]);add(b[3]);
        add(l1);
        setResizable(false);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object a=e.getSource();
        JButton b = (JButton)a;
        String op=b.getText();
       Double x,y;
        if(op.equals("Add"))
        {
            try{x= parseDouble(t1.getText());y=parseDouble(t2.getText());
                result=x+y; 
            l1.setText(""+result);}
            catch(NumberFormatException e1){
                l1.setText("Enter valid input");
            }
         
        }
        if(op.equals("Subtract"))
        {
         try{x= parseDouble(t1.getText());y=parseDouble(t2.getText());
             result=x-y;
         l1.setText(""+result);} 
          catch(NumberFormatException e1){
                l1.setText("Enter valid input");
            }
          
        }
        if(op.equals("Multiply"))
        {
            try{
                x= parseDouble(t1.getText());y=parseDouble(t2.getText());
                result=x*y;
            l1.setText(""+result);}
             catch(NumberFormatException e1){
                l1.setText("Enter valid input");
            }
            
        }
        if(op.equals("Divide"))
        {
            if(parseDouble(t2.getText())==0)
            {
                l1.setText("Division not possible");
            }
            else
            {
                try{x= parseDouble(t1.getText());y=parseDouble(t2.getText());
                    result=x/y;
                l1.setText(""+result);}
                 catch(NumberFormatException e1){
                l1.setText("Enter valid input");
            }
                
            }
            
        }
        
        
    }
    public static void main(String[] args) {
        new CalculatorSwing();
    }
    
}
