package _17_01_2024_stream.Task2;

import java.util.List;

public class Product {
    private final String category;
    private final double price;

    public Product(String category, double price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
class Order{
    private final String customerName;
    private final List<Product> products;

    public Order(String customerName, List<Product> products) {
        this.customerName = customerName;
        this.products = products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Product> getProducts() {
        return products;
    }
}
