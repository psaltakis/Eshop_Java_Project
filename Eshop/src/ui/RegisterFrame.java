package ui;

import entities.Customer;
import eshop.EshopData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RegisterFrame extends JFrame {
    JTextField nameText = new JTextField();
    JTextField emailText = new JTextField();
    JTextField usernameText = new JTextField();
    JTextField passwordText = new JTextField();
    JTextField birthdateText = new JTextField();
    JTextField adressText = new JTextField();
    JTextField telephoneText = new JTextField();
    JLabel l1 = new JLabel("Name", SwingConstants.CENTER);
    JLabel l2 = new JLabel("Email", SwingConstants.CENTER);
    JLabel l3 = new JLabel("Username", SwingConstants.CENTER);
    JLabel l4 = new JLabel("Password", SwingConstants.CENTER);
    JLabel l5 = new JLabel("Birthdte", SwingConstants.CENTER);
    JLabel l6 = new JLabel("Adress", SwingConstants.CENTER);
    JLabel l7 = new JLabel("Telephone", SwingConstants.CENTER);
    JButton b1 = new JButton("Register");
    JCheckBox c1 = new JCheckBox("Newsletter Update");
    JFrame f1 = new JFrame();

    RegisterFrame() throws Exception {
        f1.setSize(600, 600);
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setTitle("RegisterFrame");
        JPanel p1 = new JPanel(new GridLayout(8, 2));
        p1.add(l1);
        p1.add(nameText);
        p1.add(l2);
        p1.add(emailText);
        p1.add(l3);
        p1.add(usernameText);
        p1.add(l4);
        p1.add(passwordText);
        p1.add(l5);
        p1.add(birthdateText);
        p1.add(l6);
        p1.add(adressText);
        b1.addActionListener(new action());
        p1.add(l7);
        p1.add(telephoneText);
        p1.add(c1);
        p1.add(b1);
        f1.add(p1, BorderLayout.CENTER);
        f1.setVisible(true);
    }

    private class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                boolean as = false;
                if (c1.isSelected()) {
                    as = true;
                } else {
                    as = false;
                }
                Customer c = new Customer(adressText.getText(), adressText.getText(), new Date(), as, nameText.getText(), usernameText.getText(), telephoneText.getText(), emailText.getText(), passwordText.getText(), new Date());
                EshopData.getUsers().add(c);
                Frame f = new Frame();
                f1.dispose();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}