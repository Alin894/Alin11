package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefinition", "hooks"},
        features = "src/test/resources/features",
        tags = "@Run",
        plugin = {"pretty", "html:target/HtmlReport.htm"})
public class TestRunner  {
}
