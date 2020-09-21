package ui;

import entities.*;
import eshop.Eshop;
import entities.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class BankTransferUI extends JFrame {
    JLabel l1=new JLabel("Enter CreditCard Details",SwingConstants.CENTER);
    JLabel l2=new JLabel("Enter Bank Name",SwingConstants.CENTER);
    JTextField t1=new JTextField(20);
    JLabel l3=new JLabel("Enter Account Number",SwingConstants.CENTER);
    JTextField t2=new JTextField(20);
    JLabel l4=new JLabel("Enter Beneficiary Name",SwingConstants.CENTER);
    JTextField t3=new JTextField(20);
    JLabel l5=new JLabel("Enter IBAN",SwingConstants.CENTER);
    JTextField t4=new JTextField(20);
    JButton b=new JButton("Order!");
    ArrayList<ProductInOrder> pro;
    Customer co;
    BankTransferUI(ArrayList<ProductInOrder> p, Customer c){
        setSize(300,300);
        JPanel p1=new JPanel(new GridLayout(4,4));
        add(l1,BorderLayout.NORTH);
        p1.add(l2);
        b.addActionListener(new action());
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        p1.add(l5);
        p1.add(t4);
        add(p1,BorderLayout.CENTER);
        add(b,BorderLayout.SOUTH);
        setVisible(true);
    }
    private class action implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            BankTransferPayment b=new BankTransferPayment(t1.getText(),Integer.parseInt(t2.getText()),t3.getText(),Integer.parseInt(t4.getText()));
            Order or=new Order(b,co,pro);
            JOptionPane.showMessageDialog(new JFrame(),"Successfully Ordered!");
            dispose();

        }
    }
}
