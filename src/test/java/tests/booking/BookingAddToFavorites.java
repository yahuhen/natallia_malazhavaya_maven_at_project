package tests.booking;

import driver.ThreadLocaleDriver;
import pages.TestData;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.BookingLogin;
import pages.BookingPropertySearch;

import java.net.MalformedURLException;

public class BookingAddToFavorites {
    private static final Logger LOGGER = Logger.getLogger(BookingAddToFavorites.class);

    @Before
    public void start() {
        LOGGER.info("Test started!");
    }
    @After

//    @AfterMethod
    public void clean() throws InterruptedException, MalformedURLException {
        LOGGER.info("Test is over!");
        Thread.sleep(4000);
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@id='js-wishlist-carousel']/ul/li[1]/div/a/*")).click();
        Thread.sleep(10000);
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@id='js-wishlist-carousel']/ul/li[1]/div/a/*")).click();
        Thread.sleep(4000);
        ThreadLocaleDriver.getWebDriver().close();
    }
    @Test
//    @Test
    public void bookingFavorites() throws InterruptedException, MalformedURLException {
        BookingLogin.loginBooking(TestData.USER_BOOKING, TestData.USER_BOOKING_PASSWORD);
        BookingPropertySearch.enterCity("Мадрид");
        BookingPropertySearch.enterDates("30 Ноябрь 2020", "16 Декабрь 2020");
        BookingPropertySearch.checkPriceButton();
        pages.BookingFavorites.clickHeart();
        Assert.assertEquals("The color of heartbutton of the first hotel is wrong", "rgb(204, 0, 0)", pages.BookingFavorites.getColorOfFirstHeartButton());
        Assert.assertEquals("The color of heartbutton of the second hotel is wrong", "rgb(204, 0, 0)", pages.BookingFavorites.getColorOfSecondHeartButton());
        Assert.assertEquals("The confirmation is wrong", "2 варианта сохранены", pages.BookingFavorites.getConfirmationOfFavorites());
    }
}
