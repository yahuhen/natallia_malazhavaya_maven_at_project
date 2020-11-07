package tests.training.training_tests;

import driver.ThreadLocaleDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class W3schools {
    @Test
    public void w3school() throws InterruptedException {
//        WebDriver driver = Driver.getWebDriver();
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.navigate().to("https://www.w3schools.com/java/");
        WebElement elementTutorial
                = driver.findElement(By.xpath("//span[@class='color_h1']"));
        Actions make = new Actions(driver);
        make
                .doubleClick(elementTutorial)
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        driver.navigate().to("https://www.google.com/");
        WebElement searchField
                = driver.findElement(By.name("q"));
                searchField.sendKeys(Keys.CONTROL, "v");
        Actions make2 = new Actions(driver);
        make2
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        Thread.sleep(5000);
        int resultsAmount = driver.findElements(By.xpath("//div[@class='g' and contains(., 'tutorial')]")).size();
        Assert.assertEquals(10, resultsAmount);
        driver.close();
//        Driver.setWebDriver(null);
        ThreadLocaleDriver.setWebDriver(null);
    }
}
