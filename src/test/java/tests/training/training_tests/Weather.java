package tests.training.training_tests;

import driver.ThreadLocaleDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Weather {
    @Test
    public void weather() throws InterruptedException, MalformedURLException {
//        WebDriver driver = Driver.getWebDriver();
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("погода Минск");
        WebElement firstResult = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(., 'завтра')]")));
        firstResult.click();
//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//        driver.findElement(By.xpath("//span[contains(., 'завтра')]")).click();
//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//a[contains(@href, 'gismeteo')]")).click();
//        driver.findElement(By.xpath("//a[contains(@title, 'Погода в Минске на завтра')]")).click();
//        WebElement element = driver.findElement(By.xpath("//div[@class='chart chart__temperature']/div/div[5]/span[1]"));
//        System.out.println(element.getText());//можно использовать getAttribute() чтобы вытащить содержание атрибута
//        //getText() вытаскивает то, что между <> <>
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.close();
//        Driver.setWebDriver(null);
        ThreadLocaleDriver.setWebDriver(null);
    }
}