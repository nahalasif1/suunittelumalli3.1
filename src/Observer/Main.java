package Observer;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        WeatherStation weatherStation = new WeatherStation(new Random().nextInt(30));


        WeatherObserver observer1 = new WeatherObserver("Observer 1");
        WeatherObserver observer2 = new WeatherObserver("Observer 2");
        WeatherObserver observer3 = new WeatherObserver("Observer 3");
        WeatherObserver observer4 = new WeatherObserver("Observer 4");


        weatherStation.subscribe(observer1);
        weatherStation.subscribe(observer2);
        weatherStation.subscribe(observer3);
        weatherStation.subscribe(observer4);


        weatherStation.start();


        Thread.sleep(10000);


        System.out.println("Unsubscribing Observer 3...");
        weatherStation.unsubscribe(observer3);


        Thread.sleep(10000);


        weatherStation.stopWeatherStation();
        weatherStation.join();
    }
}
