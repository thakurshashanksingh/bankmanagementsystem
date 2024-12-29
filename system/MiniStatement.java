package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // ATM Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);

        // Title
        JLabel title = new JLabel("Mini Statement");
        title.setBounds(200, 50, 400, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("System", Font.BOLD, 20));
        img.add(title);

        // Bank Name
        JLabel bank = new JLabel("Bank Management System");
        bank.setBounds(150, 150, 400, 20);
        bank.setForeground(Color.WHITE);
        bank.setFont(new Font("System", Font.BOLD, 16));
        img.add(bank);

        // Card Number Display
        JLabel card = new JLabel();
        card.setBounds(150, 180, 400, 20);
        card.setForeground(Color.WHITE);
        card.setFont(new Font("System", Font.PLAIN, 14));
        img.add(card);

        // Transaction Details
        JTextArea statement = new JTextArea();
        statement.setBounds(150, 210, 600, 400);
        statement.setFont(new Font("System", Font.PLAIN, 14));
        statement.setEditable(false);
        img.add(statement);

        // Fetching and Displaying Data
        try {
            Con conn = new Con(); // Replace with your DB connection class
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");

            if (rs.next()) {
                String cardNumber = rs.getString("cardno");
                card.setText("Card Number: XXXX-XXXX-XXXX-" + cardNumber.substring(12));
            }

            rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            StringBuilder transactions = new StringBuilder();

            while (rs.next()) {
                transactions.append(rs.getString("date")).append("  ")
                            .append(rs.getString("type")).append("  ")
                            .append(rs.getString("amount")).append("\n");
            }

            statement.setText(transactions.length() == 0 ? "No transactions found" : transactions.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage());
        }

        // Exit Button
        JButton exit = new JButton("Back");
        exit.setBounds(355, 650, 150, 30);
        img.add(exit);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        });

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String args[]) {
        new MiniStatement("").setVisible(true);
    }
}
