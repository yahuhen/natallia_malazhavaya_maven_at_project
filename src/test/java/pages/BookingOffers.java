package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class BookingOffers {
    private static final Logger LOGGER = Logger.getLogger(BookingOffers.class);

    public static void chooseCarRental() throws MalformedURLException, InterruptedException {
        LOGGER.debug("Go to page 'Car Rental' (By.xpath //span[contains(., 'Аренда машин')])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//span[contains(., 'Аренда машин')]")).click();
    }
}
