package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CreateTrashMailAccount {
    private static final Logger LOGGER = Logger.getLogger(CreateTrashMailAccount.class);

    public void createTrashMailAccount(String username, String password, String realEmailAddress, String realEmailPassword) throws InterruptedException, MalformedURLException {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get("https://trashmail.com/");
        LOGGER.debug("Click on the button 'Create email address' (By.xpath //div[@class='form-group']/ul/li[3]/a)");
        driver.findElement(By.xpath("//div[@class='form-group']/ul/li[3]/a")).click();
        LOGGER.debug("Enter the username (By.xpath //div[@id='tab-register']/form/div[1]/input)");
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[1]/input"))
                .sendKeys(username);
        LOGGER.debug("Enter the password (By.xpath //div[@id='tab-register']/form/div[2]/input)");
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[2]/input"))
                .sendKeys(password);
        LOGGER.debug("Enter the password (By.xpath //div[@id='tab-register']/form/div[3]/input)");
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[3]/input"))
                .sendKeys(password);
        LOGGER.debug("Enter the real email (By.xpath //div[@id='tab-register']/form/div[4]/input)");
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[4]/input"))
                .sendKeys(realEmailAddress);
        LOGGER.debug("Click on the registration button (By.xpath //div[@id='tab-register']/form/div[6]/button)");
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[6]/button")).click();
        LOGGER.debug("Go to mail.ru");
        driver.get("https://mail.ru/");
        LOGGER.debug("Enter your email address (By.xpath //input[@id='mailbox:login-input'])");
        driver.findElement(By.xpath("//input[@id='mailbox:login-input']"))
                .sendKeys(realEmailAddress);
        LOGGER.debug("Click on the button 'Enter the password' (By.xpath //input[@value='Ввести пароль'])");
        driver.findElement(By.xpath("//input[@value='Ввести пароль']")).click();
        LOGGER.debug("Enter your password (By.xpath //input[@id='mailbox:password-input)");
        driver.findElement(By.xpath("//input[@id='mailbox:password-input']"))
                .sendKeys(realEmailPassword);
        LOGGER.debug("Click on the button 'Submit' (By.xpath //input[@type='submit'])");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        LOGGER.debug("Go to the last email sent (By.xpath //div[@class='dataset__items']/a[1])");
        driver.findElement(By.xpath("//div[@class='dataset__items']/a[1]")).click();
        Thread.sleep(4000);
        LOGGER.debug("Go to confirmation link (By.xpath //*[contains(., 'Welcome at TrashMail.com,')]/a[1])");
        driver.findElement(By.xpath("//*[contains(., 'Welcome at TrashMail.com,')]/a[1]")).click();
        driver.close();
    }


}
