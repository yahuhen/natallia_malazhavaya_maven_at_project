package runners;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"tests.booking_cucumber"},
        features = {"src/test/resources/features/check_headers/CheckHeaders.feature",
                "src/test/resources/features/create_new_user/CreateUser.feature",
                "src/test/resources/features/check_favorites/CheckFavorites.feature"}
)
public class RunnerForBookingPropertyCucumber {
}
