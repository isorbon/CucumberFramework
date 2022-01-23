package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            // features we use to provider the path of all the feature files
            features = "src/test/resources/features/",
            // glue is where we find implementations for gherkin steps
            // we provide the path of package where we defined all the steps
            glue = "steps",

            // if we set it to true, it will quickly scan all gherkin steps whether they are implemented or not
            // if it set to true, it stops actual execution
            // to execute script, it should be set to false
            dryRun = false,

            // only relevant information gives
            // Monochrome true will remove irrelevant info from console
            monochrome = true,

            // tags will identify the scenario based on the tag we provide to the feature file
            tags = "@modify",

            plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
    )

    public class Smoke {
    }
