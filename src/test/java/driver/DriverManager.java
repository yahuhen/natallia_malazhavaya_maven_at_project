package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public static WebDriver getDriver(Config config) throws MalformedURLException {

        switch (config != null ? config : Config.CHROME) {
            case OPERA -> {return getOperaDriver();}
            case SAFARI -> {return getSafariDriver();}
            case FIREFOX -> {return getFireFoxDriver();}
            case IE11 -> {return  getIE11Driver();}
            case REMOTE -> {return getRemoteDriver();}
            default -> {return getChromeDriver();}
        }
    }
    private static WebDriver getOperaDriver() {
        return new OperaDriver();
    }
    private static WebDriver getSafariDriver() {
        return new SafariDriver();
    }
    private static WebDriver getFireFoxDriver() {
        return new FirefoxDriver();
    }
    private static WebDriver getIE11Driver() {return new InternetExplorerDriver();}
    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        return new ChromeDriver(caps);
    }
    private static WebDriver getRemoteDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver webDriver =
                new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        return webDriver;
    }

}
