package ui;

import entities.Product;
import entities.ProductInOrder;
import entities.Order;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductInOrderPanel extends JPanel {
    JLabel l1=new JLabel();
    JLabel l2=new JLabel();
    JLabel l3=new JLabel();
    JLabel l4=new JLabel();
    JButton b1=new JButton("+1");
    JButton b2=new JButton("-1");
    JButton b3=new JButton("Remove");
    Product product;
    ProductInOrderPanel(ProductInOrder p){
        this.setLayout(new GridLayout(1,7));
        product=p.getProduct();
        l1.setText(p.getProduct().getTitle());
        l2.setText(Double.toString(p.getProduct().getPrice()));
        l3.setText(Integer.toString(p.getQuantity()));
        l4.setText(Double.toString(p.getTotalPrice()));
        add(l1);
        add(l2);
        b1.addActionListener(new action());
        b2.addActionListener(new action());
        b3.addActionListener(new action());
        add(l3);
        add(l4);
        add(b1);
        add(b2);
        add(b3);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);
    }
    private class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b1){
                    l3.setText(Integer.toString(Integer.parseInt(l3.getText())+1));
                }
                if(e.getSource()==b2){
                    if(l3.getText()=="0"){
                        return;
                    }
                    l3.setText(Integer.toString(Integer.parseInt(l3.getText())-1));
                }
                else if(e.getSource()==b3){
                    MainUI.cart.removeProductFromShoppingCart(ProductInOrderPanel.this);
                }
        }
    }

}
