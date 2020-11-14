package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class BookingCarRentalSearch {
    private static final Logger LOGGER = Logger.getLogger(BookingCarRentalSearch.class);
    public static void enterCity(String city) throws MalformedURLException, InterruptedException {
        LOGGER.debug("Enter name of the city in the search field (By.xpath //input[@name='ss_origin'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@name='ss_origin']")).clear();
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@name='ss_origin']")).sendKeys(city);
        Thread.sleep(2000);
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//ul[@class='c-autocomplete__list sb-autocomplete__list -visible']/li")).click();
    }
    public static void enterDates() throws MalformedURLException {
        LOGGER.debug("Enter dates in the search field (By.xpath //*[@class='bk-icon -experiments-calendar_checkin sb-date-picker_icon-svg'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//*[@class='bk-icon -experiments-calendar_checkin sb-date-picker_icon-svg']"))
                .click();
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@data-id='M1606780800000']/table/tbody/tr/td[2]/span")).click();
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//*[@id=\"frm\"]/div[2]/div[3]/div/div[3]/div/div[2]/div/div[2]/div[2]/div[3]/div/div/div[2]/table/tbody/tr[1]/td[6]/span")).click();
    }
    public static void checkPriceButton() throws MalformedURLException {
        LOGGER.debug("Click the button 'Check price' (By.xpath //button[@class='sb-searchbox__button ']");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();
    }
    public static void checkLocationOfTheProvider(String city) throws MalformedURLException {
        LOGGER.debug("Find the number of providers in the specified city(By.xpath(\"//div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing']/div[@class='result result--bcom    all-free-canx']) and " +
                "check if each of these providers has the specified city in their address line(By.xpath(\"//div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing']/div[\"+i+\"]/div/div/p");
        int numberOfProviders = ThreadLocaleDriver.getWebDriver()
                .findElements(By.xpath("//div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing']/div[@class='result result--bcom    all-free-canx']"))
                .size();
        for (int i = 1; i <= numberOfProviders; i++) {
            String fullLocation = ThreadLocaleDriver.getWebDriver().
                    findElement(By.xpath("//div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing']/div["+i+"]/div/div/p"))
                    .getText();
            boolean location = fullLocation.contains(city);
            Assert.assertTrue(location);
        }
    }
    public static void checkLocationOfTheCar(String city) throws MalformedURLException, InterruptedException {
        LOGGER.debug("Find the number of cars in the specified city(By.xpath //div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing stage-map--bcom-wide']/div[@class='bui-panel   carResultDiv']) and " +
                "check if each of these cars has the specified city in their address line(By.xpath //div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing stage-map--bcom-wide']/div[\"+(i+1)+\"]/div[1]/div[2]/div[5]/div/div/p[1]");
        ThreadLocaleDriver.getWebDriver().
                findElement(By.xpath("//div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing']/div[1]/div/div[3]/div[2]/a"))
                .click();
        Thread.sleep(8000);
        int numberOfCars = ThreadLocaleDriver.getWebDriver()
                .findElements(By.xpath("//div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing stage-map--bcom-wide']/div[@class='bui-panel   carResultDiv']"))
                .size();
        for (int i = 1; i <= numberOfCars; i++) {
            String fullLocation = ThreadLocaleDriver.getWebDriver().
                    findElement(By.xpath("//div[@class='stage stage-map--bcom stage-map-horizontal-search stage-bcom stage-map-bui stage-map--alert-spacing stage-map--bcom-wide']/div["+(i+1)+"]/div[1]/div[2]/div[5]/div/div/p[1]"))
                    .getText();
            boolean location = fullLocation.contains(city);
            Assert.assertTrue(location);
        }
    }
}
