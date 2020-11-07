package runners;

import tests.training.training_tests.*;

public class RunnerParallel {
    public static void main(String[] args) {
//        Driver.setConfig(Config.CHROME);

        Thread thread1 = new Thread(() -> {
            try {
                new Refresh().refresh();
                } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                new Weather().weather();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            try {
                new SelectDemoqa().select();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread3.start();

        Thread thread4 = new Thread(() -> {
            try {
                new W3schools().w3school();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread4.start();

        Thread thread5 = new Thread(() -> {
            try {
                new BookingScrollMoskow().bookingScrollMoskow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread5.start();

        Thread thread6 = new Thread(() -> {
            try {
                new BookingMouse().bookingMouse();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread6.start();

        Thread thread7 = new Thread(() -> {
            try {
                new Screenshot().getScreenshot();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread7.start();

        Thread thread8 = new Thread(() -> {
            try {
                new BookingParis().bookingParis();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread8.start();
    }
    }

