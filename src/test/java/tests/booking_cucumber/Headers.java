package tests.booking_cucumber;

import driver.ThreadLocaleDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.TestData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BookingHeaders;
import pages.BookingLogin;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Headers {
    private static final Logger LOGGER = Logger.getLogger(Headers.class);

    @Given("I logged in as user")
    public void login() throws MalformedURLException, InterruptedException {
        BookingLogin.loginBooking(TestData.USER_BOOKING, TestData.USER_BOOKING_PASSWORD);
    }
    @When("I check if all headers are displayed")
    public void findHeaderElements() throws InterruptedException, MalformedURLException {
        ThreadLocaleDriver.getWebDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(ThreadLocaleDriver.getWebDriver().findElement(By.id(BookingHeaders.LOGO_ID)).isDisplayed());
        Assert.assertTrue(ThreadLocaleDriver.getWebDriver().findElement(By.xpath(BookingHeaders.CHOOSE_CURRENCY_XPATH)).isDisplayed());
        Assert.assertTrue(ThreadLocaleDriver.getWebDriver().findElement(By.xpath(BookingHeaders.CHOOSE_LANGUAGE_XPATH)).isDisplayed());
        Assert.assertTrue(ThreadLocaleDriver.getWebDriver().findElement(By.xpath(BookingHeaders.PROFILE_NOTIFICATION_XPATH)).isDisplayed());
        Assert.assertTrue(ThreadLocaleDriver.getWebDriver().findElement(By.xpath(BookingHeaders.PROFILE_QUESTIONS_XPATH)).isDisplayed());
        Assert.assertTrue(ThreadLocaleDriver.getWebDriver().findElement(By.xpath(BookingHeaders.ADD_PROPERTY_XPATH)).isDisplayed());
        Assert.assertTrue(ThreadLocaleDriver.getWebDriver().findElement(By.xpath(BookingHeaders.AVATAR_XPATH)).isDisplayed());
        Assert.assertTrue(ThreadLocaleDriver.getWebDriver().findElement(By.xpath(BookingHeaders.USER_BLOCK_XPATH)).isDisplayed());
        ThreadLocaleDriver.getWebDriver().close();
        ThreadLocaleDriver.setWebDriver(null);
    }
}
