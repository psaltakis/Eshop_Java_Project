package ui;

import entities.Product;
import eshop.Eshop;
import eshop.EshopData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchBar extends JFrame {
    JLabel l1=new JLabel();
    JTextField t1=new JTextField(20);
    JButton b1=new JButton("Search");
    JButton b2=new JButton("Clear");
    ArrayList<Product> products=new ArrayList<Product>();
    DefaultTableModel dm;
    String[][] a=new String[27][3];
    ;
    public SearchBar(){
        setSize(600,600);
        JPanel p1=new JPanel(new FlowLayout());
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);
        p1.add(b2);
        add(p1,BorderLayout.NORTH);
        b2.addActionListener(new action());
        products= EshopData.getProducts();
        for(int i=0;i<products.size();i++){
            String[] b=new String[3];
            String ID=Integer.toString(i+1);
            String Label=products.get(i).getTitle();
            String Price=Double.toString(products.get(i).getPrice());
            b[0]=ID;
            b[1]=Label;
            b[2]=Price;
            a[i]=b;
        }
        b1.addActionListener(new action());
        String[] columnNames = { "ID", "Label", "Price"};
        JTable j = new JTable();
        dm=(DefaultTableModel)j.getModel();
        dm.addColumn(columnNames[0]);
        dm.addColumn(columnNames[1]);
        dm.addColumn(columnNames[2]);
        populate(a);
        JScrollPane sp = new JScrollPane(j);
        add(sp,BorderLayout.CENTER);
        setVisible(true);
    }
    public void populate(String[][] a){
        for(int i=0;i<a.length;i++){
            dm.addRow(a[i]);
        }
    }
    public void populate(){
        for(int i=0;i<a.length;i++){
            dm.addRow(a[i]);
        }
    }
    public void removeallrows(){
        dm.setRowCount(0);
    }
    public void searchrow(){
       for(int i=0;i<a.length;i++){
           if(a[i][1].toLowerCase().contains(t1.getText().toLowerCase())){
               dm.addRow(a[i]);
           }
       }
    }
    private class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b2){
                removeallrows();
                populate();
            }
            else if(e.getSource()==b1){
                removeallrows();
                searchrow();
            }
        }
    }


}
