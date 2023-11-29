package _2txt;

public class TransportManager implements TransportControl {
    private Vehicle[] vehicles;
    private int totalVehicles;
    private String managerName;


    public static void addTransport(Vehicle[] vehicles, Vehicle auto) {
        Vehicle[] vehicles1 = new Vehicle[vehicles.length + 1];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles1[i] = vehicles[i];
        }
        vehicles1[vehicles1.length - 1] = auto;
        System.out.println("добавили " +  auto);
    }

    public static void quantity(int totalVehicles){
        System.out.println("На маршруте всего " + totalVehicles);
    }

    @Override
    public void controlSchedule() {

    }

    @Override
    public void controlStateTransport() {

    }
}

