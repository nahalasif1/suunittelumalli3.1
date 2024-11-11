package Adapter;

public class Main {
    public static void main(String[] args) {

        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();


        dateAdapter.setYear(2024);
        dateAdapter.setMonth(11); // November
        dateAdapter.setDay(1);

        System.out.println("Original Date: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        dateAdapter.advanceDays(10);

        System.out.println("New Date after advancing 10 days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());
    }
}
