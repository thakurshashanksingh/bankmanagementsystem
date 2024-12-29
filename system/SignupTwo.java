package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SignupTwo extends JFrame implements ActionListener {
    long rand;
    JTextField panField, adharField;
    JComboBox<String> religionCombo, categoryCombo, incomeCombo, educationCombo, occupationCombo;
    JRadioButton seniorCitizenYes, seniorCitizenNo, existingAccountYes, existingAccountNo;
    ButtonGroup seniorCitizenGroup, existingAccountGroup;
    JButton nextButton;
    String formno;
    SignupTwo(String formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel details = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        details.setFont(new Font("Raleway", Font.BOLD, 22));
        details.setBounds(240, 80, 400, 30);
        add(details);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 200, 30);
        add(religion);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        JLabel education = new JLabel("Educational");
        JLabel qualification = new JLabel("Qualification:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30); // Adjusted y position
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30); // Adjusted y position
        add(education);
        add(qualification);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        JLabel adhar = new JLabel("Aadhar Number:");
        adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhar.setBounds(100, 490, 200, 30);
        add(adhar);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);

        String[] religions = {"Select Religion", "Hindu", "Muslim", "Christian", "Other"};
        religionCombo = new JComboBox<>(religions);
        religionCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        religionCombo.setBounds(300, 140, 400, 30);
        add(religionCombo);

        String[] categories = {"Select Category", "General", "OBC", "SC", "ST"};
        categoryCombo = new JComboBox<>(categories);
        categoryCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        categoryCombo.setBounds(300, 190, 400, 30);
        add(categoryCombo);

        String[] incomes = {"Select Income", "None", "Below 1 Lakh", "1 Lakh - 5 Lakh", "Above 5 Lakh"};
        incomeCombo = new JComboBox<>(incomes);
        incomeCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        incomeCombo.setBounds(300, 240, 400, 30);
        add(incomeCombo);

        String[] ed = {"Select Education", "Non-Graduation", "Graduation", "Post-Graduation"};
        educationCombo = new JComboBox<>(ed);
        educationCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        educationCombo.setBounds(300, 315, 400, 30);
        add(educationCombo);

        String[] occupations = {"Select Occupation", "Salaried", "Self-Employed", "Business", "Other"};
        occupationCombo = new JComboBox<>(occupations);
        occupationCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        occupationCombo.setBounds(300, 390, 400, 30);
        add(occupationCombo);

        religionCombo.setBackground(Color.WHITE);
        categoryCombo.setBackground(Color.WHITE);
        incomeCombo.setBackground(Color.WHITE);
        //qualification.setBackground(Color.WHITE);
        occupationCombo.setBackground(Color.WHITE);


        
        panField = new JTextField();
        panField.setFont(new Font("Raleway", Font.PLAIN, 14));
        panField.setBounds(300, 440, 400, 30);
        add(panField);

        adharField = new JTextField();
        adharField.setFont(new Font("Raleway", Font.PLAIN, 14));
        adharField.setBounds(300, 490, 400, 30);
        add(adharField);

        seniorCitizenYes = new JRadioButton("Yes");
        seniorCitizenYes.setFont(new Font("Raleway", Font.PLAIN, 14));
        seniorCitizenYes.setBackground(Color.WHITE);
        seniorCitizenYes.setBounds(300, 540, 100, 30);
        add(seniorCitizenYes);

        seniorCitizenNo = new JRadioButton("No");
        seniorCitizenNo.setFont(new Font("Raleway", Font.PLAIN, 14));
        seniorCitizenNo.setBackground(Color.WHITE);
        seniorCitizenNo.setBounds(400, 540, 100, 30);
        add(seniorCitizenNo);

        seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorCitizenYes);
        seniorCitizenGroup.add(seniorCitizenNo);

        existingAccountYes = new JRadioButton("Yes");
        existingAccountYes.setFont(new Font("Raleway", Font.PLAIN, 14));
        existingAccountYes.setBackground(Color.WHITE);
        existingAccountYes.setBounds(300, 590, 100, 30);
        add(existingAccountYes);

        existingAccountNo = new JRadioButton("No");
        existingAccountNo.setFont(new Font("Raleway", Font.PLAIN, 14));
        existingAccountNo.setBackground(Color.WHITE);
        existingAccountNo.setBounds(400, 590, 100, 30);
        add(existingAccountNo);

        existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingAccountYes);
        existingAccountGroup.add(existingAccountNo);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Raleway", Font.BOLD, 16));
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(590, 640, 80, 30);
        nextButton.addActionListener(this);
        add(nextButton);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String args[]) {
        new SignupTwo(""); // pass form number
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+rand; // form number (you can pass it dynamically)
        String religion = (String) religionCombo.getSelectedItem();
        String category = (String) categoryCombo.getSelectedItem();
        String income = (String) incomeCombo.getSelectedItem();
        String education = (String) educationCombo.getSelectedItem();
        String occupation = (String) occupationCombo.getSelectedItem();
        String pan = panField.getText();
        String adhar = adharField.getText();
        String seniorCitizen = null;
        if (seniorCitizenYes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (seniorCitizenNo.isSelected()) {
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if (existingAccountYes.isSelected()) {
            existingAccount = "Yes";
        } else if (existingAccountNo.isSelected()) {
            existingAccount = "No";
        }

        try {
            if (religion.equals("Select Religion") || category.equals("Select Category") || income.equals("Select Income")
                || education.equals("Select Education") || occupation.equals("Select Occupation") || pan.equals("")
                || adhar.equals("") || seniorCitizen == null || existingAccount == null) {
                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }
            else{
            Con c = new Con();
            String query = "insert into signuptwo values('" + formno + "', '" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + pan + "', '" + adhar + "', '" + seniorCitizen + "', '" + existingAccount + "')";
            c.s.executeUpdate(query);
            //SIGNUP3 OBJECT
            setVisible(false);            
            
        } 
        new SignupThree(formno).setVisible(true);

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
