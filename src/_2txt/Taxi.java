package _2txt;

import java.util.Random;

public class Taxi  extends Vehicle implements Maintenance {
    private String licensePlate;
    private boolean available;
    @Override
    void speed() {

    }

    @Override
    void paymentVerification() {

    }

    public static void freeTaxi(String licensePlate, boolean available){
        if(available){
            System.out.println("такси свободное");
        }else{
            System.out.println("такси занятое");
        }
    }

    @Override
    public void repair() {
        Random rnd = new Random();
        boolean isRepairBus = rnd.nextBoolean();
        if(isRepairBus){
            System.out.println("такси отремонтирован");
        }else{
            System.out.println("такси ремонтируют");
        }
    }

    @Override
    public void cleaning() {
        Random rnd = new Random();
        boolean isCleaning = rnd.nextBoolean();
        if(isCleaning){
            System.out.println("такси чистый");
        }else{
            System.out.println("такси моют");
        }
    }
}
