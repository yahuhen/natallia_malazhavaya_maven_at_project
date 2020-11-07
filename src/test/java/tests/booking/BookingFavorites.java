package tests.booking;

import driver.ThreadLocaleDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import pages.StaticSwitchForBookingCalendar;
import pages.VoidLoginBooking;

import java.util.concurrent.TimeUnit;

public class BookingFavorites {
    @After

//    @AfterMethod
    public void clean() throws InterruptedException {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@id='js-wishlist-carousel']/ul/li[1]/div/a/*")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//div[@id='js-wishlist-carousel']/ul/li[1]/div/a/*")).click();
        driver.close();
        ThreadLocaleDriver.setWebDriver(null);
    }
    @Test
//    @Test
    public void bookingFavorites() throws InterruptedException {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        VoidLoginBooking.loginBooking();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//input[@id='ss']")).clear();
        driver.findElement(By.xpath("//input[@id='ss']")).sendKeys("Мадрид");
        driver.findElement(By.xpath("//div[@class='xp__dates-inner xp__dates__checkin']/div/div/div[@class='sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon']/span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"))
                .click();
        String dataToday = driver.findElement(By.xpath("//td[@class='bui-calendar__date bui-calendar__date--today']/span"))
                .getAttribute("aria-label");
        String[] today = dataToday.split(" ");
        today[1] = StaticSwitchForBookingCalendar.switchForBookingCalendar(today[1]);
        String dataInMonth1 = today[0]+" "+today[1]+" "+today[2];
        String firstDataForXPath = "//span[@aria-label = "+"'" + dataInMonth1 + "']/..";
        driver.findElement(By.xpath(firstDataForXPath)).click();
        int day = Integer.parseInt(today[0]) + 5;
        String dayIn5Days = "" + day;
        today[0] = dayIn5Days;
        String dataInMonth2 = today[0]+" "+today[1]+" "+today[2];
        String secondDataForXPath = "//span[@aria-label = "+"'" + dataInMonth2 + "']/..";
        driver.findElement(By.xpath(secondDataForXPath)).click();
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();
        driver.findElement(By.xpath("//*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg']")).click();
        driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[last()-1]/div/div/button/*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg']"))
                .click();
        Thread.sleep(4000);
        String colorForFirstHotel = driver.findElement(By.xpath("//*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg']"))
                .getCssValue("fill");
        String colorForSecondHotel = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[last()-1]/div/div/button/*[@class='bk-icon -iconset-heart sr-wl-entry-heart-svg']"))
                .getCssValue("fill");
        Assert.assertEquals("The color of heartbutton of the first hotel is wrong", "rgb(204, 0, 0)", colorForFirstHotel);
        Assert.assertEquals("The color of heartbutton of the second hotel is wrong", "rgb(204, 0, 0)", colorForSecondHotel);
        driver.findElement(By.xpath("//span[@class='header_name user_firstname ge-no-yellow-bg']")).click();
        driver.findElement(By.xpath("//a[@*[contains(., 'menu_wishlist')]]")).click();
        String confirmation = driver.findElement(By.xpath("//div[@class='wl-bui-num-props wl-bui-num-props--overwrite']/*[2]"))
                .getText();
        Assert.assertEquals("The confirmation is wrong", "2 варианта сохранены", confirmation);
    }
}
