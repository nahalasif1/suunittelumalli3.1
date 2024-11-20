package Bridge;

public class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Basic Remote: Power off");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Basic Remote: Volume down");
        device.setVolume(Math.max(device.getVolume() - 10, 0));
    }

    @Override
    public void volumeUp() {
        System.out.println("Basic Remote: Volume up");
        device.setVolume(Math.min(device.getVolume() + 10, 100));
    }

    @Override
    public void channelDown() {
        System.out.println("Basic Remote: Channel down");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Basic Remote: Channel up");
        device.setChannel(device.getChannel() + 1);
    }
}
