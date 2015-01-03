package fr.unice.polytech.si4.complexite;

/**
 * Created by Hugo on 03/01/2015.
 */
public abstract class Chronometer {
    private static long begin, end;

    public static void start() {
        begin = System.currentTimeMillis();
    }

    public static void stop() {
        end = System.currentTimeMillis();
    }

    public static long getTime() {
        return end - begin;
    }

    public static long getMilliseconds() {
        return end - begin;
    }

    public static double getSeconds() {
        return (end - begin) / 1000.0;
    }

    public static double getMinutes() {
        return (end - begin) / 60000.0;
    }

    public static double getHours() {
        return (end - begin) / 3600000.0;
    }
}
