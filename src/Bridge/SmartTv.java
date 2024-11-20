package Bridge;

public class SmartTv extends Tv {

    public void browseInternet() {
        System.out.println("Smart TV: Conecting to the internet...");
    }

    @Override
    public void printStatus() {
        super.printStatus();
        System.out.println("Additional feature: Internet browsing available");
    }
}

