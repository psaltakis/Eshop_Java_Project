
package ui;

import entities.Customer;
import entities.Product;
import entities.User;
import eshop.Eshop;
import eshop.EshopData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Frame extends JFrame {
    JLabel l1 = new JLabel("Username", SwingConstants.CENTER);
    JLabel l2 = new JLabel("Password", SwingConstants.CENTER);
    JTextField t1 = new JTextField(5);
    JTextField t2 = new JTextField(5);
    JButton b1 = new JButton("Register");
    JButton b2 = new JButton("Login");
    JFrame f1 = new JFrame();

    public Frame() throws Exception {

        f1.setLayout(new GridLayout(3, 1));
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f1.setTitle("Login");
        JPanel p2 = new JPanel();
        f1.setSize(300, 300);
        JPanel p1 = new JPanel(new GridLayout(3, 2));
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        b1.addActionListener(new action());
        b2.addActionListener(new action());
        p1.add(t2);
        p1.add(b1);
        p1.add(b2);
        f1.add(p2);
        f1.add(p1);
        f1.setVisible(true);
    }

    private class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if ((e.getSource() == b1)) {
                    RegisterFrame f = new RegisterFrame();
                    f1.dispose();
                } else {
                    String us = t1.getText();
                    String pass = t2.getText();
                    ArrayList<Customer> customers = EshopData.getUsers();
                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i).getUsername().equals(us) && customers.get(i).getPassword().equals(pass)) {
                            ShoppingCart cart=new ShoppingCart(customers.get(i));
                            MainUI f = new MainUI(cart);
                            f1.dispose();
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(new JFrame(), "Not Correct Credentials");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}