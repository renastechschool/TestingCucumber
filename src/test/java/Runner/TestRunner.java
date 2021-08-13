package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/Resources",
        glue = "stepDefinitions",
        tags = "@AssertionExample",
        dryRun = false,
        plugin = {"pretty","html:report.html"}
)

public class TestRunner {
}