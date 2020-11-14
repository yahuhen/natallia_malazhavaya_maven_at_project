package class_work.suites;


import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"class_work.steps"},
        features = {"src/test/resources/features/fake/FakeTwo.feature"}
)
public class FakeRunner2 {

}