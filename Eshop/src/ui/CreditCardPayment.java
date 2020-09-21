package ui;

import entities.Customer;
import entities.Order;
import entities.PaypalPayment;
import entities.ProductInOrder;
import eshop.Eshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreditCardPayment extends JFrame {
    JLabel l1=new JLabel("Enter CreditCard Details",SwingConstants.CENTER);
    JLabel l2=new JLabel("Enter Card Number",SwingConstants.CENTER);
    JTextField t1=new JTextField(20);
    JLabel l3=new JLabel("Enter Holder Name",SwingConstants.CENTER);
    JTextField t2=new JTextField(20);
    JLabel l4=new JLabel("Enter Security Code",SwingConstants.CENTER);
    JTextField t3=new JTextField(20);
    JButton b=new JButton("Order!");
    ArrayList<ProductInOrder> pro;
    Customer co;
    CreditCardPayment(ArrayList<ProductInOrder> p, Customer c){
        setSize(300,300);
        JPanel p1=new JPanel(new GridLayout(3,3));
        add(l1,BorderLayout.NORTH);
        p1.add(l2);
        b.addActionListener(new action());
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        add(p1,BorderLayout.CENTER);
        add(b,BorderLayout.SOUTH);
        setVisible(true);
    }
    private class action implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            entities.CreditCardPayment c=new entities.CreditCardPayment(Integer.parseInt(t1.getText()),t2.getText(),Integer.parseInt(t3.getText()));
            Order or=new Order(c,co,pro);
            JOptionPane.showMessageDialog(new JFrame(),"Successfully Ordered!");
            dispose();

        }
    }
}
