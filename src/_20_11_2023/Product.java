package _20_11_2023;

import java.util.Arrays;
import java.util.Objects;

public class Product {
    String nameProduct;
    int price;
    int numberProducts;



    public void setNameProduct(String nameProduct) {
        if(Objects.equals(nameProduct, "Apple")){
            System.out.println("product in stock");
        }else {
            System.out.println("product is out of stock");
        }
        this.nameProduct = nameProduct;
    }

    public void quantityStock(){
        if(numberProducts > 5){
            System.out.println("same quantity");
        }else if(numberProducts < 5){
            System.out.println("the quantity has become smaller");
        }else{
            System.out.println("without changes");
        }
    }
}

class Customer extends Order{
    String nameCustomer;
    String email;
    String [] historyOrders;

    public void makeOrder(){
        String[] newOrders = new String[historyOrders.length + products.length];
        for (int i = 0; i < historyOrders.length; i++) {
            newOrders[i] = historyOrders[i];
        }
        newOrders[newOrders.length - 1] = Arrays.toString(products);
    }

    public void cancelOrder(){
        historyOrders[2] = null;
    }
}
