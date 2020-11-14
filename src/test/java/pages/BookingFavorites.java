package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class BookingFavorites {
    private static final Logger LOGGER = Logger.getLogger(BookingFavorites.class);

    public static void clickHeart() throws MalformedURLException, InterruptedException {
        LOGGER.debug("Click on the icon of heart (By.xpath //*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg']")).click();
        LOGGER.debug("Click on the icon of heart (By.xpath //div[@id='hotellist_inner']/div[last()-1]/div/div/button/*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@id='hotellist_inner']/div[last()-1]/div/div/button/*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg']"))
                .click();
        Thread.sleep(4000);
    }

    public static String getColorOfFirstHeartButton() throws MalformedURLException {
        LOGGER.debug("Get the color of heart's icon of the first hotel (By.xpath //*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg'])");
        String colorForFirstHotel = ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg']"))
                .getCssValue("fill");
        return colorForFirstHotel;
    }
    public static String getColorOfSecondHeartButton() throws MalformedURLException {
        LOGGER.debug("Get the color of heart's icon of the last hotel (By.xpath //div[@id='hotellist_inner']/div[last()-1]/div/div/button/*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg'])");
        String colorForLastHotel = ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@id='hotellist_inner']/div[last()-1]/div/div/button/*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg']"))
                .getCssValue("fill");
        return colorForLastHotel;
    }

    public static String getConfirmationOfFavorites() throws MalformedURLException, InterruptedException {
        LOGGER.debug("Click on the user's menu (By.xpath //span[@class='header_name user_firstname ge-no-yellow-bg'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//span[@class='header_name user_firstname ge-no-yellow-bg']")).click();
        Thread.sleep(2000);
        LOGGER.debug("Click on the wishlist in the user's menu (By.xpath //a[@*[contains(., 'menu_wishlist')]])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//a[@*[contains(., 'menu_wishlist')]]")).click();
        Thread.sleep(2000);
        LOGGER.debug("Get the confirmation message (By.xpath //div[@class='wl-bui-num-props wl-bui-num-props--overwrite']/*[2])");
        String confirmation = ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@class='wl-bui-num-props wl-bui-num-props--overwrite']/*[2]"))
                .getText();
        return confirmation;
    }
}
