package pages;

import driver.ThreadLocaleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class VoidFindEmail {
    public void findSpecificEmail(String mailBox, String password, String sender) {
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get("https://mail.ru/");
        driver.findElement(By.xpath("//input[@id='mailbox:login-input']"))
                .sendKeys(mailBox);
        driver.findElement(By.xpath("//input[@value='Ввести пароль']")).click();
        driver.findElement(By.xpath("//input[@id='mailbox:password-input']"))
                .sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//span[@class='search-panel-button__text']")).click();
        driver.findElement(By.xpath("//input[@class='_1BEp2b6vqOez8I6Rw9SpK6 _3pRLYQt59tmiwn0Ugfy9W5']"))
                .sendKeys(sender);
        driver.findElement(By.xpath("//span[@class='_1Sq-e9MVzbKWUgdGRPfVlE']")).click();
        driver.close();
        ThreadLocaleDriver.setWebDriver(null);
    }
}
