package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class FindEmail {
    private static final Logger LOGGER = Logger.getLogger(FindEmail.class);

    public static void findSpecificEmail(String mailBox, String password, String sender) throws MalformedURLException {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LOGGER.debug("Go to mail.ru");
        driver.get("https://mail.ru/");
        LOGGER.debug("Enter your email address (By.xpath //input[@id='mailbox:login-input'])");
        driver.findElement(By.xpath("//input[@id='mailbox:login-input']"))
                .sendKeys(mailBox);
        LOGGER.debug("Click on the button 'Enter the password' (By.xpath //input[@value='Ввести пароль'])");
        driver.findElement(By.xpath("//input[@value='Ввести пароль']")).click();
        LOGGER.debug("Enter your password (By.xpath //input[@id='mailbox:password-input)");
        driver.findElement(By.xpath("//input[@id='mailbox:password-input']"))
                .sendKeys(password);
        LOGGER.debug("Click on the button 'Submit' (By.xpath //input[@type='submit'])");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        LOGGER.debug("Open the search panel (By.xpath //span[@class='search-panel-button__text'])");
        driver.findElement(By.xpath("//span[@class='search-panel-button__text']")).click();
        LOGGER.debug("Enter information that you are looking for (By.xpath //input[@class='_1BEp2b6vqOez8I6Rw9SpK6 _3pRLYQt59tmiwn0Ugfy9W5'])");
        driver.findElement(By.xpath("//input[@class='_1BEp2b6vqOez8I6Rw9SpK6 _3pRLYQt59tmiwn0Ugfy9W5']"))
                .sendKeys(sender);
        LOGGER.debug("Start searching (By.xpath //span[@class='_1Sq-e9MVzbKWUgdGRPfVlE'])");
        driver.findElement(By.xpath("//span[@class='_1Sq-e9MVzbKWUgdGRPfVlE']")).click();
    }
}
