package Bridge;

public class SmartRemote extends BasicRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl() {
        if (device instanceof SmartTv) {
            System.out.println("Smart Remote: Voice control activated");
            ((SmartTv) device).browseInternet();
        } else {
            System.out.println("Smart Remote: Voice control disable");
        }
    }
}
