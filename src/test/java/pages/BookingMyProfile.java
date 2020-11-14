package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class BookingMyProfile {
    private static final Logger LOGGER = Logger.getLogger(BookingMyProfile.class);

    public static void registrationConfirmationEmailRequest() throws MalformedURLException, InterruptedException {
        LOGGER.debug("Ask the confirmation email (By.xpath //span[@class='email-confirm-banner__button-text email-confirm-banner__button-text--resend b_button__text'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//span[@class='email-confirm-banner__button-text email-confirm-banner__button-text--resend b_button__text']")).click();
        Thread.sleep(2000);
    }
}
