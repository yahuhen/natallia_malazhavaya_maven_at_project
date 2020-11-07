package tests.booking;

import driver.ThreadLocaleDriver;
import objects.TestData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CreateNewTrashMailBox;
import pages.VoidFindEmail;

import java.util.concurrent.TimeUnit;

public class BookingNewUser {

    @Test
//    @Test
    public void createNewBookingUser() throws InterruptedException {
        //получили новый почтовый адрес на trashmail
        String mail = CreateNewTrashMailBox.getNewTrashMail();
        //создаем аккаунт
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.navigate().to("https://www.booking.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='current_account_create']/a")).click();
        driver.findElement(By.xpath("//input[@id='login_name_register']")).
                sendKeys(mail);
        driver.findElement(By.xpath("//span[contains(.,'Начать работу')]")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Na123456789");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='confirmed_password']")).sendKeys("Na123456789");
        driver.findElement(By.xpath("//span[contains(.,'Создать аккаунт')]")).click();
        driver.findElement(By.xpath("//button[@class='modal-mask-closeBtn']")).click();
        //просим письмо для подтверждения почтового ящика
        driver.findElement(By.xpath("//span[@class='header_name user_firstname ge-no-yellow-bg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='profile-menu__item profile_menu__item--mydashboard']/a")).click();
        driver.findElement(By.xpath("//span[@class='email-confirm-banner__button-text email-confirm-banner__button-text--resend b_button__text']")).click();
        Thread.sleep(2000);
        //проверяем, что письмо пришло
        new VoidFindEmail().findSpecificEmail(TestData.USER_MAIL,
                TestData.USER_MAIL_PASSWORD, "booking");
    }
}
