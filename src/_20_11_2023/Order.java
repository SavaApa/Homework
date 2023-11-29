package _20_11_2023;

public class Order extends Product {
    static String[] products;
    String orderStatus;
    int totalAmount;

    public void addProduct() {
        String[] newProducts = new String[products.length + 3];
        for (int i = 0; i < products.length; i++) {
            newProducts[i] = products[i];
        }
        newProducts[newProducts.length - 1] = nameProduct;
    }

    public static int sumTotal() {
        int priceOneProd = 3;
        return products.length * priceOneProd;
    }
}
