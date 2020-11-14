package tests.booking_cucumber;

import driver.ThreadLocaleDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BookingLogin;
import pages.BookingPropertySearch;

import java.net.MalformedURLException;

public class FavoriteHotels {
    private static final Logger LOGGER = Logger.getLogger(FavoriteHotels.class);

    @Given("I did the sorting of hotels")
    public void sortingOfHotels() throws MalformedURLException, InterruptedException {
        BookingLogin.loginBooking(TestData.USER_BOOKING, TestData.USER_BOOKING_PASSWORD);
        BookingPropertySearch.enterCity("Мадрид");
        BookingPropertySearch.enterDates("30 Ноябрь 2020", "16 Декабрь 2020");
        BookingPropertySearch.checkPriceButton();
    }
    @When("I added the first and the last hotels to my favorite list")
    public void bookingFavorites() throws MalformedURLException, InterruptedException {
        pages.BookingFavorites.clickHeart();
    }
    @Then("I check these hotels are in my favorite list")
    public void checkFavoriteList() throws InterruptedException, MalformedURLException {
        Assert.assertEquals("The color of heartbutton of the first hotel is wrong", "rgb(204, 0, 0)", pages.BookingFavorites.getColorOfFirstHeartButton());
        Assert.assertEquals("The color of heartbutton of the second hotel is wrong", "rgb(204, 0, 0)", pages.BookingFavorites.getColorOfSecondHeartButton());
        Assert.assertEquals("The confirmation is wrong", "2 варианта сохранены", pages.BookingFavorites.getConfirmationOfFavorites());
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@id='js-wishlist-carousel']/ul/li[1]/div/a/*")).click();
        Thread.sleep(10000);
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@id='js-wishlist-carousel']/ul/li[1]/div/a/*")).click();
        Thread.sleep(4000);
        ThreadLocaleDriver.getWebDriver().close();
        ThreadLocaleDriver.setWebDriver(null);
    }
}
