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

public class LocationOfTheCar {
    private static final Logger LOGGER = Logger.getLogger(LocationOfTheCar.class);

    @Given("I logged in")
    public void login() throws MalformedURLException, InterruptedException {
        ThreadLocaleDriver.getWebDriver().close();
        ThreadLocaleDriver.setWebDriver(null);
        BookingLogin.loginBooking(TestData.USER_BOOKING, TestData.USER_BOOKING_PASSWORD);
    }
    @When("I search for a car by location {string}")
    public void searchOfTheCar(String string) throws MalformedURLException, InterruptedException {
        BookingOffers.chooseCarRental();
        BookingCarRentalSearch.enterCity(string);
        BookingCarRentalSearch.enterDates();
        BookingCarRentalSearch.checkPriceButton();
        Thread.sleep(8000);
    }
    @Then("I get only those cars that are located at the specified {string}")
    public void checkAddressTitle(String string) throws MalformedURLException, InterruptedException {
        BookingCarRentalSearch.checkLocationOfTheCar(string);
        ThreadLocaleDriver.getWebDriver().close();
        ThreadLocaleDriver.setWebDriver(null);
    }
}
