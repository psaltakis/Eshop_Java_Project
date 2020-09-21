package entities;

public class Product {
    private double price;
    private double tax;
    private String title;
    private String category;
    private String description;

    public Product(double price, double tax, String title, String category, String description) {
        this.price = price;
        this.tax = tax;
        this.title = title;
        this.category = category;
        this.description = description;
    }

    public double getPrice() {
        return price+tax;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
