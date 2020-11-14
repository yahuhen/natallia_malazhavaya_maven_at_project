package tests.training.training_tests;

import driver.ThreadLocaleDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;

public class SelectDemoqa {
    @Test
    public void select() throws InterruptedException, MalformedURLException {
//        WebDriver driver = Driver.getWebDriver();
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.navigate().to("https://demoqa.com/select-menu");
        WebElement element
                = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(element);
//        select.selectByValue("6");
        select.selectByVisibleText("White");
        Thread.sleep(3000);
        driver.close();
//        Driver.setWebDriver(null);
        ThreadLocaleDriver.setWebDriver(null);

    }
}
