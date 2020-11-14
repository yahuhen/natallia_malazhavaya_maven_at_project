package tests.booking_cucumber;

import driver.ThreadLocaleDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestData;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import pages.*;

import java.net.MalformedURLException;

public class CreateUser {
    private static final Logger LOGGER = Logger.getLogger(CreateUser.class);

    @Given("I go to booking.com")
    public void getSource() throws MalformedURLException {
        BookingCreateUser.getBooking();
    }

    @When("I create a new user")
    public void createNewBookingUser() throws InterruptedException, MalformedURLException {
        BookingCreateUser.createBookingUserName();
        BookingCreateUser.createBookingPassword("Na123456789");
        BookingCreateUser.confirmBookingPassword("Na123456789");
        BookingCreateUser.createAccountButton();
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//button[@class='modal-mask-closeBtn']")).click();
    }

    @Then("I get confirmation email")
    public void getConfirmationEmail() throws MalformedURLException, InterruptedException {
        //просим письмо для подтверждения почтового ящика
        BookingUserMenu.yourAccountMenuButton();
        BookingUserMenu.myProfileButton();
        BookingMyProfile.registrationConfirmationEmailRequest();
        //проверяем, что письмо пришло
        FindEmail.findSpecificEmail(TestData.USER_MAIL,
                TestData.USER_MAIL_PASSWORD, "booking");
        ThreadLocaleDriver.getWebDriver().close();
        ThreadLocaleDriver.setWebDriver(null);
    }
}
