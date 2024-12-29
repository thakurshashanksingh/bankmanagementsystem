package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton log,sup,clear;
    JTextField tf;
    JPasswordField tf2;
    Login(){
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10 , 100, 100);
        add(label);
        
        JLabel text =  new JLabel("Welcome to ATM");
        add(text);
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Railway",Font.BOLD, 38));
        getContentPane().setBackground(Color.WHITE);
        
        JLabel cardno =  new JLabel("CARD NO:");
        add(cardno);
        cardno.setBounds(120,150,400,40);
        cardno.setFont(new Font("railway",Font.BOLD, 28));
        getContentPane().setBackground(Color.WHITE);
        
        tf = new JTextField();
        tf.setBounds(300,150,230,40);
        tf.setFont(new Font("Arial",Font.BOLD,14));
        add(tf);
        
        JLabel pin =  new JLabel("ENTER PIN:");
        add(pin);
        pin.setBounds(120,220,400,40);
        pin.setFont(new Font("Osward",Font.BOLD, 28));
        getContentPane().setBackground(Color.WHITE);
        
        tf2 = new JPasswordField();
        tf2.setBounds(300,220,230,40);
        tf2.setFont(new Font("Arial",Font.BOLD,14));

        add(tf2);
        
        setSize(800,480);//define length and breadth 
        setVisible(true);//frame visibleto user by true
        setLocation(350,200);
        
        log = new JButton("SIGN IN");
        log.setBounds(300,300,100,30);
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);   
        log.addActionListener(this);
        add(log);
        
         clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE); 
        clear.addActionListener(this);
        add(clear);
        
         sup = new JButton("SIGN UP");
        sup.setBounds(300,350,230,30);
        sup.setBackground(Color.BLACK);
        sup.setForeground(Color.WHITE);   
        sup.addActionListener(this);
        add(sup);
        
        
    }
    
   
    public static void main(String args[])
    {
        new Login();        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
           tf.setText("");
           tf2.setText("");
        }
        else if(e.getSource()==log){
            Con c = new Con();
            String cardnumber = tf.getText();
            String pinnumber = tf2.getText();
            
            String query = "SELECT * FROM login WHERE cardNumber = '" + cardnumber + "' AND pin = '" + pinnumber + "'";
            try{
                
               ResultSet rs = c.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                   tf.setText("");
                   tf2.setText("");
               }
            }
            catch (SQLException ae)
            {
                System.out.println(ae);
            }
            
        }
        else if(e.getSource()==sup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        
        
       
    }
}
