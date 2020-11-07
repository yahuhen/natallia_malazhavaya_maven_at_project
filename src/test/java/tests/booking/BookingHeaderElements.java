package tests.booking;

import driver.ThreadLocaleDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.VoidLoginBooking;

import java.util.concurrent.TimeUnit;

public class BookingHeaderElements {
    @Test
//    @Test
    public void findHeaderElements() throws InterruptedException {
        VoidLoginBooking.loginBooking();
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(driver.findElement(By.id("logo_no_globe_new_logo")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-id='currency_selector']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-id='language_selector']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='bk-icon -sprite-profile_notification bui__profile_notification']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='bk-icon -streamline-question_mark_circle']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='sign_in_wrapper sign_in_wrapper-add-property']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='user_avatar user_avatar--circle user_avatar--normalised user_avatar--initial ge-no-yellow-img_border ']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='user_name_block']")).isDisplayed());
        driver.close();
        ThreadLocaleDriver.setWebDriver(null);
    }
}
