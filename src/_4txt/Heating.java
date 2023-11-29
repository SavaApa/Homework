package _4txt;

public class Heating extends Device implements ControlInterface {
    private double currentTemperature;
    private double targetTemperature;

    @Override
    void versionUpdate() {

    }

    public static void temperature(double currentTemperature, double targetTemperature) {
        if (currentTemperature > targetTemperature ) {
            targetTemperature = currentTemperature;
            System.out.println(targetTemperature);
        }else if(currentTemperature < targetTemperature){
            System.out.println(targetTemperature);
        }else{
            System.out.println(targetTemperature);
        }

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

