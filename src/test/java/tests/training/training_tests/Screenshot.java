package tests.training.training_tests;

import driver.ThreadLocaleDriver;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Screenshot {
    @Test
    public void getScreenshot() throws IOException {
//        WebDriver driver = Driver.getWebDriver();
        WebDriver driver = ThreadLocaleDriver.getWebDriver();
        driver.navigate().to("https://www.google.com/");
        new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        Files.copy(new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)),
                Paths.get("C:\\JAVA\\CoursesYS\\screenshot.png"), StandardCopyOption.REPLACE_EXISTING);
        driver.close();
//        Driver.setWebDriver(null);
        ThreadLocaleDriver.setWebDriver(null);
    }
}
