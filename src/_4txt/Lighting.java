package _4txt;

import java.util.Random;
import java.util.Scanner;

public class Lighting extends Device implements ControlInterface {
    private int brightnessLevel;
    private String colorTemperature;

    @Override
    void versionUpdate() {

    }

    public static int light(int brightnessLevel) {
        Random rnd = new Random();
        int lighting = rnd.nextInt(1, 5);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Изменить температуру?");
        String person = scanner.nextLine();
        if (person.equalsIgnoreCase("сделать больше")) {
            lighting++;
        } else if (person.equalsIgnoreCase("сделать меньше")) {
            lighting--;
        }
        return lighting;
    }

    public static String color(int brightnessLevel){
        String colorTemperature;
        if(brightnessLevel <= 2){
            colorTemperature = "Синий";
        }else{
            colorTemperature = "Красный";
        }
        return colorTemperature;
    }

    @Override
    public void tornOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void getStatus() {

    }
}


