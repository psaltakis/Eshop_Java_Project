package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import entities.Product;
import eshop.EshopData;

public class MainUI extends JFrame {
   
  private static final long serialVersionUID = 1L;
	JButton Button=new JButton("Search");
    JPanel p2=new JPanel(new GridLayout(3,3));
    JButton sc=new JButton("Shopping Cart");
    JRadioButton r1=new JRadioButton("Smart Phones");
    JRadioButton r2=new JRadioButton("Laptops");
    JRadioButton r3=new JRadioButton("TV");
    JFrame f1=new JFrame();
    JPanel p1=new JPanel(new GridLayout(5,1));
    static ShoppingCart cart;
	private Scanner input;
    MainUI(ShoppingCart car) throws Exception{
        cart=car;
		input = new Scanner(new File("products.txt"));
        while (input.hasNextLine()) {
            String[] one=input.nextLine().split("  ");
            Product p=new Product(Double.parseDouble(one[3].trim()),Double.parseDouble(one[4].trim()),one[0],one[2],one[1]);
            EshopData.getProducts().add(p);
        }
        ButtonGroup b1=new ButtonGroup();
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);
        f1.setSize(600,400);
        f1.setTitle("Eshop");
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Button.addActionListener(new action());
        p1.add(Button);
        p1.add(r1);
        p1.add(r2);
        sc.addActionListener(new action());
        p1.add(r3);
        r1.addActionListener(new action());
        r2.addActionListener(new action());
        r3.addActionListener(new action());
        p1.add(sc);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        p1.setBorder(blackline);
        p2.setBorder(blackline);
        f1.add(p1,BorderLayout.WEST);
        f1.add(p2,BorderLayout.CENTER);
        f1.setVisible(true);
    }
    public void generateViewWithProducts(ArrayList<Product> products){
        p2.removeAll();
        for(final Product p:products){
            JPanel pa=new JPanel();
            Border blackline = BorderFactory.createLineBorder(Color.black);
            pa.setBorder(blackline);
            JLabel l1=new JLabel(p.getTitle());
            JLabel l2=new JLabel(Double.toString(p.getPrice()));
            pa.add(l1);
            pa.add(l2);
            pa.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int n=JOptionPane.showConfirmDialog(null,"Add Product to Cart?","Add Product",JOptionPane.YES_NO_OPTION);
                    if(n==JOptionPane.YES_OPTION){
                        System.out.println(p);
                            cart.addProductToShoppingCart(p);
                    }
                }
            });
            p2.add(pa);
            p2.validate();
        }

    }
    public void generateViewForSmartPhones(){
        ArrayList<Product> pr=new ArrayList<>();

        for(Product p: EshopData.getProducts()){
            if(p.getCategory().equalsIgnoreCase("Smartphone")){
                pr.add(p);
            }
        }
        generateViewWithProducts(pr);
    }
    public void generateViewForLaptops(){
        ArrayList<Product> pr=new ArrayList<>();

        for(Product p: EshopData.getProducts()){
            if(p.getCategory().equalsIgnoreCase("Laptop")){
                pr.add(p);
            }
        }
        generateViewWithProducts(pr);
    }
    public void generateViewForTV(){
        ArrayList<Product> pr=new ArrayList<>();

        for(Product p: EshopData.getProducts()){
            if(p.getCategory().equalsIgnoreCase("TV")){
                pr.add(p);
            }
        }
        generateViewWithProducts(pr);
    }
    private class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(r1.isSelected()){
                generateViewForSmartPhones();
            }
            else if(r2.isSelected()){
                generateViewForLaptops();
            }
            else if(r3.isSelected()){
                generateViewForTV();
            }
            if(e.getSource()==sc){
                cart.f1.setVisible(true);
            }
            if(e.getSource()==Button){
                SearchBar s=new SearchBar();
            }
        }
    }
}
