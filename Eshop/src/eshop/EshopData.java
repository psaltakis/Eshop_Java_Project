package eshop;

import entities.Customer;
import entities.Product;
import entities.User;

import java.util.ArrayList;

public class EshopData {
    private static ArrayList<Customer> customers=new ArrayList<Customer>();
    private static ArrayList<Product> products=new ArrayList<Product>();

    public static ArrayList<Customer> getUsers() {
        return customers;
    }

    public static void setUsers(ArrayList<Customer> users) {
        EshopData.customers = users;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        EshopData.products = products;
    }
}
