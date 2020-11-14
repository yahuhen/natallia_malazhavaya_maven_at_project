package pages;

import driver.ThreadLocaleDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CreateNewTrashMailBox {
    private static final Logger LOGGER = Logger.getLogger(CreateNewTrashMailBox.class);

    public static String getNewTrashMail(String userTrashMail, String passwordTrashMail) throws InterruptedException, MalformedURLException {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        LOGGER.debug("Go to trashmail.com");
        driver.get("https://trashmail.com/");
        LOGGER.debug("Enter the username (By.xpath //div[@id='tm-header-text']/form/input[@name='fe-login-user'])");
        driver.findElement(By.xpath("//div[@id='tm-header-text']/form/input[@name='fe-login-user']"))
                .sendKeys(userTrashMail);
        LOGGER.debug("Enter the password (By.xpath //div[@id='tm-header-text']/form/input[@name='fe-login-pass'])");
        driver.findElement(By.xpath("//div[@id='tm-header-text']/form/input[@name='fe-login-pass']"))
                .sendKeys(passwordTrashMail);
        LOGGER.debug("Click on the button 'Submit' (By.xpath //div[@id='tm-header-text']/form/input[@name='create_submit'])");
        driver.findElement(By.xpath("//div[@id='tm-header-text']/form/input[@name='create_submit']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        LOGGER.debug("Add a new email (By.xpath //span[@id='fe-add-btnEl'])");
        driver.findElement(By.xpath("//span[@id='fe-add-btnEl']")).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//td[@class='x-grid-cell x-grid-td x-grid-cell-fe-col-destination x-grid-dirty-cell x-unselectable']/div")).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        LOGGER.debug("Get the name of email (By.xpath //td[@class='x-grid-cell x-grid-td x-grid-cell-fe-col-disposable-name x-grid-dirty-cell x-unselectable']/div)");
        WebElement emaill = driver.findElement(By.xpath("//td[@class='x-grid-cell x-grid-td x-grid-cell-fe-col-disposable-name x-grid-dirty-cell x-unselectable']/div"));
        String firstPartEmail = emaill.getText();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        LOGGER.debug("Get the name of domain (By.xpath //td[@class='x-grid-cell x-grid-td x-grid-cell-fe-col-disposable-domain x-grid-dirty-cell x-unselectable']/div)");
        WebElement domain = driver.findElement(By.xpath("//td[@class='x-grid-cell x-grid-td x-grid-cell-fe-col-disposable-domain x-grid-dirty-cell x-unselectable']/div"));
        String secondPartEmail = domain.getText();
        LOGGER.debug("Save changes (By.xpath //span[@id='fe-save-btnWrap'])");
        driver.findElement(By.xpath("//span[@id='fe-save-btnWrap']")).click();
        String email = firstPartEmail+secondPartEmail;
//        driver.close();
        return email;
    }
}
