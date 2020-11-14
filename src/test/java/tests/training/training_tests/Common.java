package tests.training.training_tests;

import driver.ThreadLocaleDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class Common {
    @Before
    public void initDriver() throws MalformedURLException {
        ThreadLocaleDriver.getWebDriver().get("https://www.booking.com/");
    }

    @After
    public void closeDriver() throws MalformedURLException {
        ThreadLocaleDriver.getWebDriver().close();
        ThreadLocaleDriver.setWebDriver(null);
    }

    @Test
    public void bookingMouse() throws InterruptedException, MalformedURLException {
        Thread.sleep(2000);
        WebElement element = ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//*[@*[contains(., 'Выберите валюту')]]/.."));
        Actions actions = new Actions(ThreadLocaleDriver.getWebDriver());
        actions.moveToElement(element);
        actions.perform();
        Thread.sleep(1000);
        String byn = ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@class[contains(., 'content')] and contains(., 'Выберите валюту')]")).getText();
        Assert.assertEquals("Выберите валюту", byn);
    }
        @Test
        public void bookingScrollMoskow() throws MalformedURLException {
            ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='ss']")).click();
            ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='ss']")).sendKeys("Москва");
            Actions make = new Actions(ThreadLocaleDriver.getWebDriver());
            make
                    .sendKeys(Keys.ENTER)
                    .build()
                    .perform();
            WebElement element2 = new WebDriverWait(ThreadLocaleDriver.getWebDriver(), 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hotellist_inner']/div[10]")));
            element2 = ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//div[@id='hotellist_inner']/div[10]"));
            ((JavascriptExecutor) ThreadLocaleDriver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element2);
            ((JavascriptExecutor)ThreadLocaleDriver.getWebDriver()).executeScript("arguments[0].style.backgroundColor='green'", element2);
            ((JavascriptExecutor)ThreadLocaleDriver.getWebDriver()).executeScript("arguments[0].style.color='red'", element2);
            ((JavascriptExecutor)ThreadLocaleDriver.getWebDriver()).executeScript("arguments[0].click()", element2);
    }
}
