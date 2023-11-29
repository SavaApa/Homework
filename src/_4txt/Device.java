package _4txt;

import java.time.LocalDateTime;

public abstract class Device {
    private String deviceId;
    private String location;
    private boolean isOn;
    private LocalDateTime lastChecked;

    abstract void versionUpdate();

}
