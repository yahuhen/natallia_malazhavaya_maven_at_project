package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BookingLogin {
    private static final Logger LOGGER = Logger.getLogger(BookingLogin.class);

    public static void loginBooking(String username, String password) throws MalformedURLException, InterruptedException {
        BookingCreateUser.getBooking();
        ThreadLocaleDriver.getWebDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(2000);
        LOGGER.debug("Click on the button 'Log in' (By.xpath //span[contains(., 'Войти в аккаунт')])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//span[contains(., 'Войти в аккаунт')]")).click();
        LOGGER.debug("Enter the username (By.xpath //input[@id='username']");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        LOGGER.debug("Click on the button 'Next' (By.xpath //button[@class='bui-button bui-button--large bui-button--wide']/span[@class='bui-button__text'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']/span[@class='bui-button__text']")).click();
        LOGGER.debug("Enter the password (By.xpath //input[@id='password']");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        LOGGER.debug("Click on the button 'Next' (By.xpath //button[@class='bui-button bui-button--large bui-button--wide']/span[@class='bui-button__text'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//button[@class='bui-button bui-button--large bui-button--wide']/span[@class='bui-button__text']")).click();
    }
}
