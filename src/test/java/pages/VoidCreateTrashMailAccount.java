package pages;

import driver.ThreadLocaleDriver;
import objects.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class VoidCreateTrashMailAccount {
    public void createTrashMailAccount(String username, String password, String realEmailAddress, String realEmailPassword) throws InterruptedException {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get("https://trashmail.com/");
        driver.findElement(By.xpath("//div[@class='form-group']/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[1]/input"))
                .sendKeys(username);
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[2]/input"))
                .sendKeys(password);
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[3]/input"))
                .sendKeys(password);
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[4]/input"))
                .sendKeys(realEmailAddress);
        driver.findElement(By.xpath("//div[@id='tab-register']/form/div[6]/button")).click();
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath("//input[@id='mailbox:login-input']"))
                .sendKeys(realEmailAddress);
        driver.findElement(By.xpath("//input[@value='Ввести пароль']")).click();
        driver.findElement(By.xpath("//input[@id='mailbox:password-input']"))
                .sendKeys(realEmailPassword);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='dataset__items']/a[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[contains(., 'Welcome at TrashMail.com,')]/a[1]")).click();
        driver.close();
    }


}
