package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class BookingUserMenu {
    private static final Logger LOGGER = Logger.getLogger(BookingUserMenu.class);

    public static void yourAccountMenuButton() throws MalformedURLException, InterruptedException {
        LOGGER.debug("Click on account menu button (By.xpath //span[@class='header_name user_firstname ge-no-yellow-bg'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//span[@class='header_name user_firstname ge-no-yellow-bg']")).click();
        Thread.sleep(2000);
    }

    public static void myProfileButton() throws MalformedURLException, InterruptedException {
        LOGGER.debug("Click on my profile button (By.xpath //div[@class='profile-menu__item profile_menu__item--mydashboard']/a)");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@class='profile-menu__item profile_menu__item--mydashboard']/a")).click();
        Thread.sleep(2000);
    }
}
