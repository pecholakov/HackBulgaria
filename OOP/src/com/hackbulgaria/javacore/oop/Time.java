package com.hackbulgaria.javacore.oop;

import java.util.Calendar;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;
    private int day;
    private int month;
    private int year;

    public Time(int hours, int minutes, int seconds, int day, int month, int year) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Time now() {
        Calendar c = Calendar.getInstance();
        c.getTime();
        return new Time(c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND),
                c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %02d.%02d.%04d", this.hours, this.minutes, this.seconds, this.day,
                this.month, this.year);
    }
}
