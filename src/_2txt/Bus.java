package _2txt;

import java.util.Random;

class Bus extends Vehicle implements Maintenance {
    private boolean accessibility;
    private int busNumber;



    @Override
    void speed() {

    }

    @Override
    void paymentVerification() {

    }

    public static void access(boolean accessibility, int busNumber) {
        if (accessibility) {
            System.out.println("места доступны");
        } else {
            System.out.println("места не доступны");
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
