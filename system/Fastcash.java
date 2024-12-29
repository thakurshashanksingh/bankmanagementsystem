//package bank.management.system;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class Fastcash extends JFrame implements ActionListener{
//    
//    JButton deposit, withdraw, fastcash, miniStatement, pinchange, balanceenquiry, exit;
//    String pinnumber;
//    Fastcash(String pinnumber)
//    {
//        this.pinnumber=pinnumber;
//        setLayout(null);
//        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel img = new JLabel(i3);
//        img.setBounds(0,0,900,900);
//        
//        add(img);
//        
//        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
//        text.setBounds(215,300,700,35);
//        text.setForeground(Color.WHITE);
//        text.setFont(new Font("System",Font.BOLD,16));
//        img.add(text);
//        
//        deposit = new JButton("RS 100");
//        deposit.setBounds(170,415,150,30);
//        deposit.addActionListener(this);
//        img.add(deposit);
//        
//        
//        // Button 2: Withdraw
//        withdraw = new JButton("RS 500");
//        withdraw.setBounds(355, 415, 150, 30);
//        withdraw.addActionListener(this);
//        img.add(withdraw);
//
//        // Button 3: Transfer
//        fastcash = new JButton("RS 1000");
//        fastcash.setBounds(170, 450, 150, 30);
//        fastcash.addActionListener(this);
//        img.add(fastcash);
//
//        miniStatement = new JButton("RS 2000");
//        miniStatement.setBounds(355, 450, 150, 30);
//        miniStatement.addActionListener(this);
//        img.add(miniStatement);
//
//        pinchange = new JButton("RS 5000");
//        pinchange.setBounds(170, 485, 150, 30);
//        pinchange.addActionListener(this);
//        img.add(pinchange);
//
//        // Button 6: Pay Bills
//        balanceenquiry = new JButton("RS 10000");
//        balanceenquiry.setBounds(355, 485, 150, 30);
//        balanceenquiry.addActionListener(this);       
//        img.add(balanceenquiry);
//
//        
//
//        // Button 8: Exit
//        exit = new JButton("BACK");
//        exit.setBounds(355, 520, 150, 30);
//        exit.addActionListener(this);        
//        img.add(exit);
//        
//        
//        
//        setSize(900,900);
//        setLocation(300,0);
//        setUndecorated(true);
//        setVisible(true);
//        
//    }
//    
//    public static void main(String args[]){
//        new Fastcash("");
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==exit)
//        {
//            setVisible(false);
//            new Transactions(pinnumber).setVisible(true);
//        }
//        else {
//            String amount = ((JButton)e.getSource()).getText().substring(3);
//            Con c = new Con();
//            try{
//                
//                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
//                int balance = 0;
//                if (rs.next()) {
//                    balance = rs.getInt("balance");
//                }
//
//                
//                int withdrawAmount = Integer.parseInt(amount);
//                if (withdrawAmount > balance) {
//                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
//                    return;
//                }
//                
//            }
//            catch{
//                
//            }
//        }
//        
//    }
//
//    
//}




package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Fastcash extends JFrame implements ActionListener {

    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back;
    String pinnumber;

    Fastcash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);

        add(img);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        img.add(text);

        rs100 = new JButton("RS 100");
        rs100.setBounds(170, 415, 150, 30);
        rs100.addActionListener(this);
        img.add(rs100);

        rs500 = new JButton("RS 500");
        rs500.setBounds(355, 415, 150, 30);
        rs500.addActionListener(this);
        img.add(rs500);

        rs1000 = new JButton("RS 1000");
        rs1000.setBounds(170, 450, 150, 30);
        rs1000.addActionListener(this);
        img.add(rs1000);

        rs2000 = new JButton("RS 2000");
        rs2000.setBounds(355, 450, 150, 30);
        rs2000.addActionListener(this);
        img.add(rs2000);

        rs5000 = new JButton("RS 5000");
        rs5000.setBounds(170, 485, 150, 30);
        rs5000.addActionListener(this);
        img.add(rs5000);

        rs10000 = new JButton("RS 10000");
        rs10000.setBounds(355, 485, 150, 30);
        rs10000.addActionListener(this);
        img.add(rs10000);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        img.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3); // Extract amount from button text
            Con c = new Con();
            try {
                // Get current balance
                ResultSet rs = c.s.executeQuery("SELECT SUM(amount) AS balance FROM bank WHERE pin = '" + pinnumber + "'");
                int balance = 0;
                if (rs.next()) {
                    balance = rs.getInt("balance");
                }

                int withdrawAmount = Integer.parseInt(amount);
                if (withdrawAmount > balance) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Perform withdrawal
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber + "', CURRENT_TIMESTAMP, 'Withdrawal', '-" + withdrawAmount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Fastcash("");
    }
}
