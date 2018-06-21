/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.regex.*;
public class VowelChecker extends JFrame implements KeyListener{
  JLabel l;
  JTextField tf;
  JFrame j;
    VowelChecker()
    {
      j = new JFrame("Vowel Checker");
     tf = new JTextField();
    l = new JLabel("you need to enter a character");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    j.setVisible(true);
    j.setResizable(true);
    j.setBounds(50, 50, 500, 500);
    j.add(tf);
    j.add(l);
    tf.addKeyListener(this);
    tf.setBounds(20, 20,500,50);
}

  @Override
  public void keyReleased(KeyEvent e){
     try
     {
      Object t=e.getSource();
    JTextField f=(JTextField)t;
    String s = f.getText();
    Character c= s.charAt(s.length()-1);
    if(Pattern.matches("[aeiouAEIOU]",c.toString()))
    l.setText("You entered a vowel");
    else l.setText("You have not Entered a Vowel");
    }
    catch(Exception e1)
    {System.out.print("");
    }
    }

public static void main(String[] args){
      VowelChecker vc = new VowelChecker();
}

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}




