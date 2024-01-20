package _17_01_2024.Task1;

import java.util.ArrayList;
import java.util.List;

class Order {
    private final String customerName;
    private final List<Item> items;

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


