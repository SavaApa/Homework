package _2txt;

import java.util.Random;

public class Tram extends Vehicle implements Maintenance {
    private int trackWidth;
    private boolean electric;
    @Override
    void speed() {

    }

    @Override
    void paymentVerification() {

    }

    public static void type(int trackWidth, boolean electric){
        if(electric){
            System.out.println("трамвай электрический");
        }else{
            System.out.println("такого трамвая нету");
        }

        if (trackWidth > 10){
            System.out.println("трамвай большой");
        }else {
            System.out.println("трамвай маленький");
        }
    }

    @Override
    public void repair() {
        Random rnd = new Random();
        boolean isRepairBus = rnd.nextBoolean();
        if(isRepairBus){
            System.out.println("автобус отремонтирован");
        }else{
            System.out.println("автобус ремонтируют");
        }
    }

    @Override
    public void cleaning() {
        Random rnd = new Random();
        boolean isCleaning = rnd.nextBoolean();
        if(isCleaning){
            System.out.println("автобус чистый");
        }else{
            System.out.println("автобус моют");
        }
    }
}
