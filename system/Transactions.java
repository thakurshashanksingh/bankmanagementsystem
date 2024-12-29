package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdraw, fastcash, miniStatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    Transactions(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        
        add(img);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        img.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        img.add(deposit);
        
        
        // Button 2: Withdraw
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 415, 150, 30);
        withdraw.addActionListener(this);
        img.add(withdraw);

        // Button 3: Transfer
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        img.add(fastcash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        img.add(miniStatement);

        pinchange = new JButton("Pin Chnage");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        img.add(pinchange);

        // Button 6: Pay Bills
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);       
        img.add(balanceenquiry);

        

        // Button 8: Exit
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);        
        img.add(exit);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public static void main(String args[]){
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit)
        {
            System.exit(0);
        }
        else if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(e.getSource()==withdraw){
            setVisible(false);
            new Withdraw1(pinnumber).setVisible(true);
        }
        else if(e.getSource()==pinchange){
            setVisible(false);
            new Changepin(pinnumber).setVisible(true);
        }
        else if (e.getSource() == balanceenquiry) {
            setVisible(false);
            new Balanceenquiry(pinnumber).setVisible(true); // Pass the correct parameter
        }
        else if (e.getSource() == miniStatement) {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true); // Pass the correct parameter
        }
        
        
        
    }

    
}