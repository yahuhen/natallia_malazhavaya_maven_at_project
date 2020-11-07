package tests.training.training_tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

public class Demo {
    public static void main(String[] args) throws IOException {
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingPort(9515)
//                .build();
//        service.start();

//        WebDriver driver = new ChromeDriver();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());
        driver.get("https://tut.by");
        driver.close();
    }
}
