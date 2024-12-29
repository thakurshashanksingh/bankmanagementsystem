package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.SQLException;
public class SignupOne extends JFrame implements ActionListener{

    long rand;
    JTextField nameField, fnameField, emailField, addressField, cityField, stateField, pincodeField;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried;
    ButtonGroup genderGroup, maritalStatusGroup;
    JButton nextButton;
    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        rand = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel form = new JLabel("APPLICATION FORM NO. " + rand);
        form.setFont(new Font("Raleway", Font.BOLD, 38));
        form.setBounds(140, 20, 600, 40);
        add(form);

        JLabel details = new JLabel("PAGE 1: PERSONAL DETAILS");
        details.setFont(new Font("Raleway", Font.BOLD, 22));
        details.setBounds(240, 80, 400, 30);
        add(details);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalStatus.setBounds(100, 390, 200, 30);
        add(maritalStatus);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.PLAIN, 14));
        nameField.setBounds(300, 140, 400, 30);
        add(nameField);

        fnameField = new JTextField();
        fnameField.setFont(new Font("Raleway", Font.PLAIN, 14));
        fnameField.setBounds(300, 190, 400, 30);
        add(fnameField);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.PLAIN, 14));
        male.setBackground(Color.WHITE);
        male.setBounds(300, 290, 100, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.PLAIN, 14));
        female.setBackground(Color.WHITE);
        female.setBounds(400, 290, 100, 30);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.PLAIN, 14));
        emailField.setBounds(300, 340, 400, 30);
        add(emailField);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.PLAIN, 14));
        married.setBackground(Color.WHITE);
        married.setBounds(300, 390, 100, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.PLAIN, 14));
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(400, 390, 120, 30);
        add(unmarried);

        maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarried);

        addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.PLAIN, 14));
        addressField.setBounds(300, 440, 400, 30);
        add(addressField);

        cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.PLAIN, 14));
        cityField.setBounds(300, 490, 400, 30);
        add(cityField);

        stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.PLAIN, 14));
        stateField.setBounds(300, 540, 400, 30);
        add(stateField);

        pincodeField = new JTextField();
        pincodeField.setFont(new Font("Raleway", Font.PLAIN, 14));
        pincodeField.setBounds(300, 590, 400, 30);
        add(pincodeField);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Raleway", Font.BOLD, 16));
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(620, 650, 80, 30);
        nextButton.addActionListener(this);
        add(nextButton);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String args[]) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno =""+ rand; //long
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailField.getText();
        String maritalStatus = null;
        if (married.isSelected()) {
            maritalStatus = "Married";
        } else if (unmarried.isSelected()) {
            maritalStatus = "Unmarried";
        }
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pincode = pincodeField.getText();
        
        try{
             if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name is required");
            return; // Stop further execution
        }
          
        if (fname.equals("")) {
            JOptionPane.showMessageDialog(null, "Father's Name is required");
            return;
        }
        if (dob.equals("")) {
            JOptionPane.showMessageDialog(null, "Date of Birth is required");
            return;
        }
        if (gender == null) {
            JOptionPane.showMessageDialog(null, "Gender is required");
            return;
        }
        if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email is required");
            return;
        }
        if (maritalStatus == null) {
            JOptionPane.showMessageDialog(null, "Marital Status is required");
            return;
        }
        if (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Address is required");
            return;
        }
        if (city.equals("")) {
            JOptionPane.showMessageDialog(null, "City is required");
            return;
        }
        if (state.equals("")) {
            JOptionPane.showMessageDialog(null, "State is required");
            return;
        }
        if (pincode.equals("")) {
            JOptionPane.showMessageDialog(null, "Pincode is required");
            
        }
        
        else{
                 Con c = new Con();
                 String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + maritalStatus + "', '" + address + "', '" + city + "', '" + state + "', '" + pincode + "')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignupTwo(formno).setVisible(true);
             }
               
        }
        catch(HeadlessException | SQLException ex){
            System.out.println(ex);
        }
        
        
    }
}
