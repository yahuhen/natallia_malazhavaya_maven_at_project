package runners;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests.booking_cucumber"},
        features = {"src/test/resources/features/car_rental_address/CheckLocationOfTheCar.feature",
                "src/test/resources/features/car_rental_address/CheckLocationOfTheCarProvider.feature"}
)
public class RunnerForCarRentalAddressCucumber {
}
