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

public class PaypalUI extends JFrame {
    JLabel l1=new JLabel("Enter Paypal Account Details",SwingConstants.CENTER);
    JLabel l2=new JLabel("Enter Account",SwingConstants.CENTER);
    JTextField t=new JTextField(20);
    JButton b=new JButton("Order!");
    ArrayList<ProductInOrder> pro;
    Customer co;
    PaypalUI(ArrayList<ProductInOrder> p, Customer c){
        setSize(300,300);
        JPanel p1=new JPanel(new FlowLayout());
        add(l1,BorderLayout.NORTH);
        p1.add(l2);
        b.addActionListener(new action());
        p1.add(t);
        add(p1,BorderLayout.CENTER);
        add(b,BorderLayout.SOUTH);
        setVisible(true);
    }
    private class action implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            PaypalPayment p=new PaypalPayment(t.getText());
            Order or=new Order(p,co,pro);
            JOptionPane.showMessageDialog(new JFrame(),"Successfully Ordered!");
            dispose();

        }
    }
}
