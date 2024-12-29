//
//package bank.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//
//public class Changepin extends JFrame implements ActionListener {
//    
//    Changepin(String pinchange)
//    {
//        setLayout(null);
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0,0,900,900);
//        add(image);
//        
//        JLabel text = new JLabel("CHANGE YOUR PIN");
//        text.setForeground(Color.WHITE);
//        text.setFont(new Font("System", Font.BOLD,16));
//        text.setBounds(250,280,500,35);
//        image.add(text);
//        
//        
//        JLabel pintext = new JLabel("NEW PIN:");
//        pintext.setForeground(Color.WHITE);
//        pintext.setFont(new Font("System", Font.BOLD,16));
//        pintext.setBounds(165,320,180,25);
//        image.add(pintext);
//        
//        JTextField pin = new JTextField();
//        pin.setFont(new Font("Raleway",Font.BOLD,25));
//        pin.setBounds(330,320,180,25);
//        image.add(pin);
//        
//        JLabel repintext = new JLabel("RE-ENTER NEW PIN:");
//        repintext.setForeground(Color.WHITE);
//        repintext.setFont(new Font("System", Font.BOLD,16));
//        repintext.setBounds(165,360,180,25);
//        image.add(repintext);
//        
//        JTextField repin = new JTextField();
//        repin.setFont(new Font("Raleway",Font.BOLD,25));
//        repin.setBounds(330,360,180,25);
//        image.add(repin);
//        
//        JButton change = new JButton("CHANGE");
//        change.setBounds(355,485,150,30);
//        image.add(change);
//        
//        JButton back = new JButton("BACK");
//        back.setBounds(355,520,150,30);
//        image.add(back);
//        
//        setSize(900, 900);
//        setLocation(300, 0);
//        setUndecorated(true); // Remove default window decorations
//        setVisible(true); // Make the frame visible        
//    }
//    
//    
//    
//    public static void main(String args[])
//    {
//        new Changepin("").setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}


package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Changepin extends JFrame implements ActionListener {
    JTextField pin, repin;
    JButton change, back;
    String pinnumber;

    Changepin(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pin = new JTextField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("RE-ENTER NEW PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        repin = new JTextField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            String newPin = pin.getText();
            String reenteredPin = repin.getText();

            if (newPin.equals("") || reenteredPin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter and re-enter the new PIN");
                return;
            }

            if (!newPin.equals(reenteredPin)) {
                JOptionPane.showMessageDialog(null, "Entered PINs do not match");
                return;
            }

            try {
                Con c = new Con();
                String query1 = "update bank set pin = '" + newPin + "' where pin = '" + pinnumber + "'";
                String query2 = "update login set pin = '" + newPin + "' where pin = '" + pinnumber + "'";
                String query3 = "update signupthree set pin = '" + newPin + "' where pin = '" + pinnumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(newPin).setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Changepin("").setVisible(true);
    }
}
