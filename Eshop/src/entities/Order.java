package entities;


import java.util.ArrayList;

public class Order {
    private Payment payment;
    private Customer customer;

    private ArrayList<ProductInOrder> products;

    public Order(Payment payment, Customer customer, ArrayList<ProductInOrder> products) {
        this.payment = payment;
        this.customer = customer;
        this.products = products;
    }

    public Order(Customer customer, ArrayList<ProductInOrder> products) {
        this.customer = customer;
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public ArrayList<ProductInOrder> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductInOrder> products) {
        this.products = products;
    }
    public double getTotalPrice(){
        double price=0;
        for(int i=0;i<products.size();i++){
            price=price+products.get(i).getTotalPrice();
        }
        return price;
    }
}
