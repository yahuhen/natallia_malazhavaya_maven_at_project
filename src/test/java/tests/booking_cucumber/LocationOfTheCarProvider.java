package tests.booking_cucumber;

import driver.ThreadLocaleDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestData;
import org.apache.log4j.Logger;
import pages.BookingCarRentalSearch;
import pages.BookingOffers;
import pages.BookingLogin;

import java.net.MalformedURLException;

public class LocationOfTheCarProvider {
    private static final Logger LOGGER = Logger.getLogger(LocationOfTheCarProvider.class);

    @Given("I logged in as a booking user")
    public void login() throws MalformedURLException, InterruptedException {
        ThreadLocaleDriver.getWebDriver().close();
        ThreadLocaleDriver.setWebDriver(null);
        BookingLogin.loginBooking(TestData.USER_BOOKING, TestData.USER_BOOKING_PASSWORD);
    }
    @When("I search for car providers by location {string}")
    public void searchOfTheCar(String string) throws MalformedURLException, InterruptedException {
        BookingOffers.chooseCarRental();
        BookingCarRentalSearch.enterCity(string);
        BookingCarRentalSearch.enterDates();
        BookingCarRentalSearch.checkPriceButton();
        Thread.sleep(8000);
    }
    @Then("I get only those car providers that are located at the specified {string}")
    public void checkAddressTitle(String string) throws MalformedURLException, InterruptedException {
        BookingCarRentalSearch.checkLocationOfTheProvider(string);
        ThreadLocaleDriver.getWebDriver().close();
        ThreadLocaleDriver.setWebDriver(null);
    }
}
