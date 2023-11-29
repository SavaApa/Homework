package _4txt;

import java.time.LocalDateTime;

public class SmartHome {
    private String homeName;
    private Device[] devices;
    private boolean isAwayMode;
    LocalDateTime lastUpdate;

    public static void homeControl(String homeName, Device[] devices,LocalDateTime lastUpdate){
        int dev = devices.length;
        System.out.println("Номер дома " + homeName);
        System.out.println("Количество девайсов " + dev);
        System.out.println("Последние объявление было " + lastUpdate);
    }
}
