package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = "tests.booking",
        features = "src/test/resources/Heasder.feature",
        strict = true
)
public class CucumberRunnerTest {
}
