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

public class BookingParis {
    @Test
    public void bookingParis() throws InterruptedException, TestException, MalformedURLException {
//        WebDriver driver = Driver.getWebDriver();
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.navigate().to("https://www.booking.com/");
        driver.findElement(By.xpath("//input[@id='ss']")).click();
        driver.findElement(By.xpath("//input[@id='ss']")).sendKeys("Париж");
        driver.findElement(By.xpath("//div[@class='xp__dates-inner xp__dates__checkin']/div/div/div[@class='sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon']/span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"))
                .click();
        driver.findElement(By.xpath("//span[@aria-label='30 Ноябрь 2020']")).click();
        driver.findElement(By.xpath("//span[@aria-label='7 Декабрь 2020']")).click();
        driver.findElement(By.xpath("//span[text()='2 взрослых']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']/span[1]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Взрослых: увеличить количество']/span[1]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Номера: увеличить количество']/span[1]")).click();
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();
        WebElement maxPriceHotels = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-id='pri-5']")));
        maxPriceHotels.click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        WebElement maxPriceHotelsFromCheapest = driver.findElement(By.xpath("//a[@data-category='price']"));
        maxPriceHotelsFromCheapest.click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);
        WebElement theCheapestHotel = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div/div[2]/div[2]/div/div/div/div[2]/div/div"));
        String cheapestPrice = theCheapestHotel.getText();
        System.out.println(cheapestPrice);
        String cheapestPriceNumbers = cheapestPrice.replaceAll("[^0-9]", "");
        int cheapestPriceInt = Integer.parseInt(cheapestPriceNumbers);
        if (cheapestPriceInt/7>=1220) {
            System.out.println("OK");
        } else {
            throw new TestException();
        }
        driver.close();
//        Driver.setWebDriver(null);
        ThreadLocaleDriver.setWebDriver(null);
}
}
