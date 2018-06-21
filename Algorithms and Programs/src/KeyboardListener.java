/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.System.exit;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class KeyboardListener implements KeyListener {
    JFrame f;
    JLabel j;
    JTextField f1;
    String expr=" ";
    KeyboardListener()
    {
          f=new JFrame();
         f.setSize(400,400);
         f.setLayout(null);
       
        j=new JLabel();
        j.setBounds(50,50,150,20);
        f1=new JTextField();
        f1.setBounds(50,100,150,20);
        f.add(f1);
        f.add(j);
        f1.addKeyListener(this);
        //f1=new JTextField();
        f.setResizable(false);
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
       new KeyboardListener();
    }
    
    public void keyPressed(KeyEvent e)
    {
       char keychar=e.getKeyChar();
            //int i=e.getKeyCode();
            //System.out.println(i);
            
         // System.out.println("1"+keychar);
           // System.out.println("exites");
        
        
        expr=expr+keychar;
        j.setText(" "+expr);
      // String b="10";
       // int l=expr.length();
        if(f1.getText().equals("quit"))
        {
     
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
            {
                exit(0);
            }
            
           
        }
        
    }
    public void keyTyped(KeyEvent e)
    {
        System.out.println("key typed is:"+e.getKeyChar());
    }
    
    public void keyReleased(KeyEvent e)
    {
        System.out.println("key released:"+e.getKeyChar());
    }
}
