package tests.booking_cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

public class LoggerBeforeAfter {
    private static final Logger LOGGER = Logger.getLogger(LoggerBeforeAfter.class);
    @Before
    public void start() {
        LOGGER.info("Test started!");
    }
    @After
    public void end() {
       LOGGER.info("Test is over!");
    }
}
