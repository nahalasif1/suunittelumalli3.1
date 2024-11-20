package Bridge;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testDevice(new SmartTv());
    }

    private static void testDevice(Device device) {
        System.out.println("Testing with Basic Remote");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Testing with Advanced Remote");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

        if (device instanceof SmartTv) {
            System.out.println("Testing with Smart Remote");
            SmartRemote smartRemote = new SmartRemote(device);
            smartRemote.power();
            smartRemote.voiceControl();
            device.printStatus();
        }
    }
}
