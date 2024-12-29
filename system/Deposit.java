
package bank.management.system;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField t1;
    JButton deposit, back;
    JLabel amount;
    String pinnumber;

    Deposit(String pin) {
        this.pinnumber = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 900);
        add(img);

        amount = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        deposit = new JButton("DEPOSIT");
        back = new JButton("BACK");

        amount.setBounds(170, 300, 400, 20);
        img.add(amount);

        t1.setBounds(170, 350, 320, 25);
        img.add(t1);

        deposit.setBounds(355, 485, 150, 30);
        img.add(deposit);

        back.setBounds(355, 520, 150, 30);
        img.add(back);

        deposit.addActionListener(this);
        back.addActionListener(this);

        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = t1.getText(); // Amount entered by the user
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(date); // Format the date as a string

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    Con c1 = new Con(); // Assuming Con is your database connection class
                    String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber + "', '" + formattedDate + "', 'Deposit', '" + number + "')";
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true); // Assuming Transactions is another class
                } catch (HeadlessException | SQLException e) {
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
