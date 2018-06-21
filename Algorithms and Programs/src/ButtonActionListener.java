/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ButtonActionListener extends JFrame implements ActionListener
{
    JButton blue;
    JButton cyan;
    JButton lblue;
    JButton magenta;
    JButton pink;
    JButton red ;
    JButton reset;
    ButtonActionListener()
    {
        super("BACKGROUND COLOR PALLATE");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        blue = new JButton("BLUE");
        lblue = new JButton("LIGHT BLUE");
        cyan = new JButton("CYAN");
        red = new JButton("RED");
        pink = new JButton("PINK");
        magenta = new JButton("MAGENTA");
        reset = new JButton("RESET");
        getContentPane().setBackground(Color.DARK_GRAY);
 
        Font f;
        f = new Font("Comic Sans MS", 0, 14);
        
        setResizable(false);
        
        setLayout(new FlowLayout());
        blue.addActionListener(this); 
        blue.setFont(f);
        add(blue);
        lblue.addActionListener(this);
        lblue.setFont(f);
        add(lblue);
        cyan.addActionListener(this);
        cyan.setFont(f);
        add(cyan);
        red.addActionListener(this);
        red.setFont(f);
        add(red);
        pink.addActionListener(this);
        pink.setFont(f);
        add(pink);
        magenta.addActionListener(this);
        magenta.setFont(f);
        add(magenta);
        reset.addActionListener(this);
        reset.setFont(f);
        add(reset);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        JButton b=(JButton)ae.getSource();
        if(b==blue)
        {
        getContentPane().setBackground(Color.BLUE);
        blue.setEnabled(false);            
        }
        else if(b==lblue)
        {
        getContentPane().setBackground(new Color(135,206,250));
        lblue.setEnabled(false);            
        }
        else if(b==pink)
        {
        getContentPane().setBackground(Color.PINK);
        pink.setEnabled(false);            
        }
        else if(b==red)
        {
        getContentPane().setBackground(Color.RED);
        red.setEnabled(false);            
        }
        else if(b==cyan)
        {
        getContentPane().setBackground(Color.CYAN);
        cyan.setEnabled(false);            
        }
        else if(b==magenta)
        {
            getContentPane().setBackground(Color.MAGENTA);
            magenta.setEnabled(false);
        }
        else if(b==reset)
        {
            getContentPane().setBackground(Color.DARK_GRAY);
            lblue.setEnabled(true);
            blue.setEnabled(true);
            red.setEnabled(true);
            cyan.setEnabled(true);
            magenta.setEnabled(true);
            pink.setEnabled(true);
        }
        else{}
    }
    public static void main(String... args)
    {
        new ButtonActionListener();
    }
}
