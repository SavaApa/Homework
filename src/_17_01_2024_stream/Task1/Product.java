package _17_01_2024_stream.Task1;

import lombok.Getter;

@Getter
public class Product {
    private final String name;

    public Product(String category, String name) {
        this.name = name;
    }

}
