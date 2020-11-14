package tests.booking;

import driver.ThreadLocaleDriver;
import pages.TestData;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.*;

import java.net.MalformedURLException;

public class BookingNewUser {
    private static final Logger LOGGER = Logger.getLogger(BookingNewUser.class);

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
    public void createNewBookingUser() throws InterruptedException, MalformedURLException {
        BookingCreateUser.createBookingUserName();
        BookingCreateUser.createBookingPassword("Na123456789");
        BookingCreateUser.confirmBookingPassword("Na123456789");
        BookingCreateUser.createAccountButton();
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//button[@class='modal-mask-closeBtn']")).click();
        //просим письмо для подтверждения почтового ящика
        BookingUserMenu.yourAccountMenuButton();
        BookingUserMenu.myProfileButton();
        BookingMyProfile.registrationConfirmationEmailRequest();
        //проверяем, что письмо пришло
        FindEmail.findSpecificEmail(TestData.USER_MAIL,
                TestData.USER_MAIL_PASSWORD, "booking");
        ThreadLocaleDriver.getWebDriver().close();
    }
}
