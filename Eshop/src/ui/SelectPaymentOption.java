package ui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entities.CashOnDeliveryPayment;
import entities.Customer;
import entities.Order;
import entities.ProductInOrder;

public class SelectPaymentOption extends JFrame {
    JButton b1=new JButton("Paypal");
    JButton b2=new JButton("Payment on Delivery");
    JButton b3=new JButton("Credit Card");
    JButton b4=new JButton("Bank Transfer Payment");
    JLabel l1=new JLabel("Select Payment Option",SwingConstants.CENTER);
    ArrayList<ProductInOrder> products;
    Customer customer;
    SelectPaymentOption(ArrayList<ProductInOrder> p,Customer c) {
        products=p;
        customer=c;
        JPanel p1=new JPanel(new GridLayout(2,2));
        setSize(600,400);
        add(l1,BorderLayout.NORTH);
        p1.add(b1);
        b1.addActionListener(new action());
        b2.addActionListener(new action());
        b3.addActionListener(new action());
        b4.addActionListener(new action());
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        add(p1,BorderLayout.CENTER);
        setVisible(true);
    }
    private class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
                PaypalUI p=new PaypalUI(products,customer);
                dispose();
            }
            else if(e.getSource()==b3){
                CreditCardPayment c=new CreditCardPayment(products,customer);
                dispose();
            }
            else if(e.getSource()==b4){
                BankTransferUI a=new BankTransferUI(products,customer);
                dispose();
            }
            else if(e.getSource()==b2){
                CashOnDeliveryPayment c=new CashOnDeliveryPayment(1230);
                Order or=new Order(c,customer,products);
                JOptionPane.showMessageDialog(new JFrame(),"Successfully Ordered!");
                dispose();
            }
        }
    }
}

