package pages;

import driver.ThreadLocaleDriver;
import objects.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class VoidLoginBooking {
    public static void loginBooking() {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.navigate().to("https://www.booking.com/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//li[@id='current_account']/a/div/span")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestData.USER_BOOKING);
        driver.findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']/span[@class='bui-button__text']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestData.USER_BOOKING_PASSWORD);
        driver.findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']/span[@class='bui-button__text']")).click();
    }
}
