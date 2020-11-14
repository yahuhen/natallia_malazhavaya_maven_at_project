package runners.training_runners;

import driver.Config;
import driver.Driver;
import tests.training.training_tests.*;

import java.io.IOException;

public class RunnerForTrainingTests {
    public static void main(String[] args) throws InterruptedException, IOException, TestException {
        Driver.setConfig(Config.CHROME);
        new BookingParis().bookingParis();
        new Refresh().refresh();
        new Weather().weather();
        new SelectDemoqa().select();
        new W3schools().w3school();
        new BookingScrollMoskow().bookingScrollMoskow();
        new Screenshot().getScreenshot();
    }
}
