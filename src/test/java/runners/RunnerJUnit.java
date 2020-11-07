package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.training.training_tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
//        BookingParis.class,
//        Refresh.class,
//        Weather.class,
//        SelectDemoqa.class,
//        W3schools.class,
//        BookingScrollMoskow.class,
//        Screenshot.class,
//        BookingMouse.class
        Common.class

})

public class RunnerJUnit {
//static {
//    globalBefore();
//}
//public static void globalBefore() {
//    ThreadLocaleDriver.getWebDriver().get("https://www.booking.com/");
//}
}
