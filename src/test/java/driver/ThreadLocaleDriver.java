package driver;

import org.openqa.selenium.WebDriver;

public class ThreadLocaleDriver {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            webDriver.set(DriverManager.getDriver(Config.CHROME));
        }
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver webDriver) {
        ThreadLocaleDriver.webDriver.set(webDriver);
    }
}

