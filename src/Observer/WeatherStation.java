package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private final List<Observer> observers;
    private int currentTemperature;
    private final Random rand = new Random();

    private static final int MIN_TEMPERATURE = 0;
    private static final int MAX_TEMPERATURE = 30;

    private boolean running = true;

    public WeatherStation(int initialTemperature) {
        this.currentTemperature = initialTemperature;
        this.observers = new ArrayList<>();
    }


    public synchronized void subscribe(Observer observer) {
        observers.add(observer);
    }


    public synchronized void unsubscribe(Observer observer) {
        observers.remove(observer);
    }


    private synchronized void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentTemperature);
        }
    }


    private void simpleWeatherSimulation() {
        if (rand.nextBoolean()) {
            currentTemperature++;
            if (currentTemperature >= MAX_TEMPERATURE) {
                currentTemperature = MAX_TEMPERATURE;
            }
        } else {
            currentTemperature--;
            if (currentTemperature <= MIN_TEMPERATURE) {
                currentTemperature = MIN_TEMPERATURE;
            }
        }
        System.out.println("Temperature updated to: " + currentTemperature);
        notifyObservers();

        int randomDelay = rand.nextInt(10) + 1;
        try {
            System.out.println("Sleeping for " + randomDelay + " seconds.");
            Thread.sleep(randomDelay * 0,5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    @Override
    public void run() {
        while (running) {
            simpleWeatherSimulation();
        }
    }


    public void stopWeatherStation() {
        running = false;
        System.out.println("Weather station stopped.");
    }
}
