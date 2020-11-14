package class_work.steps;

import driver.Config;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;


public class FakeBaseSteps {
private static final Logger LOG = Logger.getLogger(FakeBaseSteps.class);
    @Before
    public void doBefore(){
        System.out.println("Init Webdtiver");
        Driver.setConfig(Config.CHROME);
    }

    @After
    public void doAfter() throws MalformedURLException {
        Driver.getWebDriver().close();
        Driver.setWebDriver(null);
    }
}
