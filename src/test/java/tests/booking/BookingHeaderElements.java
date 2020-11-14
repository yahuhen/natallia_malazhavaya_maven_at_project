package tests.booking;

import driver.Config;
import driver.DriverManager;
import driver.ThreadLocaleDriver;
import pages.TestData;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BookingHeaders;
import pages.BookingLogin;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BookingHeaderElements {
    private static final Logger LOGGER = Logger.getLogger(BookingHeaderElements.class);

    @Before
    public void start() {
        LOGGER.info("Test started!");
    }
    @After
    public void end() {
        LOGGER.info("Test is over!");
    }

    @Test
//    @Test
    public void findHeaderElements() throws InterruptedException, MalformedURLException {
        BookingLogin.loginBooking(TestData.USER_BOOKING, TestData.USER_BOOKING_PASSWORD);
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
//        WebDriver driver = DriverManager.getDriver(Config.REMOTE);
//        driver.navigate().to("https://www.booking.com/");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//span[contains(., 'Войти в аккаунт')]")).click();
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestData.USER_BOOKING);
//        driver.findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']/span[@class='bui-button__text']")).click();
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestData.USER_BOOKING_PASSWORD);
//        driver.findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']/span[@class='bui-button__text']")).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(driver.findElement(By.id(BookingHeaders.LOGO_ID)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(BookingHeaders.CHOOSE_CURRENCY_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(BookingHeaders.CHOOSE_LANGUAGE_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(BookingHeaders.PROFILE_NOTIFICATION_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(BookingHeaders.PROFILE_QUESTIONS_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(BookingHeaders.ADD_PROPERTY_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(BookingHeaders.AVATAR_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(BookingHeaders.USER_BLOCK_XPATH)).isDisplayed());
        driver.close();
    }
}
