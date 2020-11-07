package pages;

import driver.ThreadLocaleDriver;
import objects.TestData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CreateNewTrashMailBox {

    public static String getNewTrashMail() throws InterruptedException {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get("https://trashmail.com/");
        driver.findElement(By.xpath("//div[@id='tm-header-text']/form/input[@name='fe-login-user']"))
                .sendKeys(TestData.USER_TRASH_NAME);
        driver.findElement(By.xpath("//div[@id='tm-header-text']/form/input[@name='fe-login-pass']"))
                .sendKeys(TestData.USER_TRASH_PASSWORD);
        driver.findElement(By.xpath("//div[@id='tm-header-text']/form/input[@name='create_submit']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@id='fe-add-btnEl']")).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//td[@class='x-grid-cell x-grid-td x-grid-cell-fe-col-destination x-grid-dirty-cell x-unselectable']/div")).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        WebElement emaill = driver.findElement(By.xpath("//td[@class='x-grid-cell x-grid-td x-grid-cell-fe-col-disposable-name x-grid-dirty-cell x-unselectable']/div"));
        String firstPartEmail = emaill.getText();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        WebElement domain = driver.findElement(By.xpath("//td[@class='x-grid-cell x-grid-td x-grid-cell-fe-col-disposable-domain x-grid-dirty-cell x-unselectable']/div"));
        String secondPartEmail = domain.getText();
        driver.findElement(By.xpath("//span[@id='fe-save-btnWrap']")).click();
        String email = firstPartEmail+secondPartEmail;
//        driver.close();
        return email;
    }
}
