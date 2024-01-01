package _20_12_2023;

import java.util.List;

import static _20_12_2023.Team.play;

public class Handler extends Generator {


    public Handler(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
        play(generator(Adult.class));
    }
}

