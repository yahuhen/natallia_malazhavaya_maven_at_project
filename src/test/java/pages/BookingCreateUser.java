package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BookingCreateUser {
    private static final Logger LOGGER = Logger.getLogger(BookingCreateUser.class);
    public static void getBooking() throws MalformedURLException {
        LOGGER.debug("Open booking.com");
        ThreadLocaleDriver.getWebDriver().navigate().to("https://www.booking.com/");
    }
    public static void createBookingUserName() throws MalformedURLException, InterruptedException {
        String mail = CreateNewTrashMailBox.getNewTrashMail(TestData.USER_TRASH_NAME, TestData.USER_TRASH_PASSWORD);
        ThreadLocaleDriver.getWebDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        getBooking();
        Thread.sleep(2000);
        LOGGER.debug("Choose option 'Create account' (By.xpath //li[@id='current_account_create']/a)");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//li[@id='current_account_create']/a")).click();
        LOGGER.debug("Enter the name of new user (By.xpath //input[@id='login_name_register'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='login_name_register']")).
                sendKeys(mail);
        LOGGER.debug("Click the button 'Start' (By.xpath //span[contains(.,'Начать работу')])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//span[contains(.,'Начать работу')]")).click();
    }

    public static void createBookingPassword(String password) throws MalformedURLException, InterruptedException {
        ThreadLocaleDriver.getWebDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LOGGER.debug("Enter the password (By.xpath //input[@id='password'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        Thread.sleep(2000);
    }

    public static void confirmBookingPassword(String password) throws MalformedURLException, InterruptedException {
        ThreadLocaleDriver.getWebDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LOGGER.debug("Confirm the password (By.xpath //input[@id='confirmed_password'])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//input[@id='confirmed_password']")).sendKeys("Na123456789");
    }

    public static void createAccountButton() throws MalformedURLException, InterruptedException {
        LOGGER.debug("Click the button 'Create account' (By.xpath //span[contains(.,'Создать аккаунт')])");
        ThreadLocaleDriver.getWebDriver().findElement(By.xpath("//span[contains(.,'Создать аккаунт')]")).click();
    }
}
