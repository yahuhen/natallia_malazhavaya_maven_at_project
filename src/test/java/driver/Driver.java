package driver;

import org.openqa.selenium.WebDriver;


public class Driver {

    private static WebDriver webDriver;
    private static  Config config;

    public static void setConfig(Config config) {
        Driver.config = config;
    }

    private Driver() {}

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(config);
        }
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        Driver.webDriver = webDriver;
    }
}
