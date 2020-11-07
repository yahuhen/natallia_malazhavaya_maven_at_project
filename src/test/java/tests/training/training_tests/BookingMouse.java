package tests.training.training_tests;


import driver.ThreadLocaleDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BookingMouse {
    @Test
    public void bookingMouse() throws InterruptedException {
////        WebDriver driver = Driver.getWebDriver();
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.navigate().to("https://www.booking.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@*[contains(., 'Выберите валюту')]]/.."));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        Thread.sleep(1000);
        String byn = driver.findElement(By.xpath("//div[@class[contains(., 'content')] and contains(., 'Выберите валюту')]")).getText();
        driver.close();
//        Driver.setWebDriver(null);
        ThreadLocaleDriver.setWebDriver(null);
        Assert.assertEquals("Выберите валюту", byn);
    }
}
