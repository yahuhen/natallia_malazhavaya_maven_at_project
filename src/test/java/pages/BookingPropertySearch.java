package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class BookingPropertySearch {
    private static final Logger LOGGER = Logger.getLogger(BookingPropertySearch.class);

    public static void enterCity(String city) throws MalformedURLException {
        LOGGER.debug("Enter name of the city in the search field (By.xpath //input[@id='ss'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='ss']")).clear();
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='ss']")).sendKeys(city);
    }

    public static void enterDates(String date1, String date2) throws MalformedURLException {
        LOGGER.debug("Open the calendar (By.xpath //div[@class='xp__dates-inner xp__dates__checkin']/div/div/div[@class='sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon']/span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@class='xp__dates-inner xp__dates__checkin']/div/div/div[@class='sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon']/span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"))
                .click();
        LOGGER.debug("Add the dates to the calendar");
        String firstDataForXPath = "//span[@aria-label = "+"'" + date1 + "']/..";
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath(firstDataForXPath)).click();
        String secondDataForXPath = "//span[@aria-label = "+"'" + date2 + "']/..";
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath(secondDataForXPath)).click();
    }

    public static void checkPriceButton() throws MalformedURLException {
        LOGGER.debug("Click the button 'Check price' (By.xpath //button[@data-sb-id='main'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//button[@data-sb-id='main']")).click();
    }
}
