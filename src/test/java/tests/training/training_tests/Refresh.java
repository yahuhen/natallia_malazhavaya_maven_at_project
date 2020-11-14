package tests.training.training_tests;

import driver.ThreadLocaleDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Refresh {
    @Test
    public void refresh() throws MalformedURLException {
//        WebDriver driver = Driver.getWebDriver();
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
//        driver.navigate().to("https://www.tut.by/");
//        driver.manage().window().getSize();
//        driver.switchTo().window("https://selenium.dev");
//        driver.get("https://selenium.dev");
//        System.out.println(driver.getCurrentUrl());
//        driver.close(); //закрывает только это окно
        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.ya.ru/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
//        driver.quit(); //закрывает все окна
        driver.close();
//        Driver.setWebDriver(null);
        ThreadLocaleDriver.setWebDriver(null);
    }
}
