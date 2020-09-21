package ui;

import entities.Customer;
import entities.Product;
import entities.ProductInOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShoppingCart extends JFrame {
    JFrame f1=new JFrame();
    JScrollPane scroll=new JScrollPane();
    JButton b1=new JButton("Proceed Order");
    JButton b2=new JButton("Remove All");
    JPanel p1=new JPanel();
    ArrayList<ProductInOrder> productInOrders=new ArrayList<>();
    Customer customer;
    ShoppingCart(Customer c){
        customer=c;
        f1.setTitle("Shopping Cart");;
        f1.setSize(400,200);
        p1.setSize(100,1000);
        p1.setLayout(new GridLayout(7,1));
        scroll.getViewport().add(p1);
        b1.addActionListener(new action());
        b2.addActionListener(new action());
        f1.add(scroll, BorderLayout.CENTER);
        JPanel p2=new JPanel(new FlowLayout());
        p2.add(b1);
        p2.add(b2);
        f1.add(p2,BorderLayout.SOUTH);
        f1.setVisible(false);
    }

    public JFrame getF1() {
        return f1;
    }

    public void setF1(JFrame f1) {
        this.f1 = f1;
    }

    public void addProductToShoppingCart(Product p){
        ProductInOrder pi=new ProductInOrder(p,1);
        ProductInOrderPanel pp=new ProductInOrderPanel(pi);
        productInOrders.add(pi);
        p1.add(pp);
        p1.revalidate();
    }
    public void removeProductFromShoppingCart(ProductInOrderPanel p){
        productInOrders.remove(p.product);
        p1.remove(p);
        p1.revalidate();
    }
    public void removeQuantity(Product p){

    }
    private class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           if(e.getSource()==b2){
               p1.removeAll();
               p1.revalidate();
           }
           if(e.getSource()==b1){
               SelectPaymentOption pr=new SelectPaymentOption(productInOrders,customer);
               f1.dispose();
           }
        }
    }

}
