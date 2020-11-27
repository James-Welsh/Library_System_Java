public class ElectronicDevice {

    private String deviceId;
    private String deviceLocation;
    private String deviceType;
    private boolean isAvailable;
    
    public ElectronicDevice(String deviceId, String deviceLocation, String deviceType) {
        
        this.deviceId = deviceId;
        this.deviceLocation = deviceLocation;
        this.deviceType = deviceType;
        this.isAvailable = true;
    }
}
