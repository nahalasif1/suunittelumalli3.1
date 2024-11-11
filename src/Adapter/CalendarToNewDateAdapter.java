package Adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    private Calendar calendar;

    public CalendarToNewDateAdapter() {
        this.calendar = Calendar.getInstance();
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        // Subtracting 1 because Calendar months are zero-based (January is 0).
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        // Adding 1 because Calendar months are zero-based (January is 0).
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
