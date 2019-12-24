package StepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"json:target/cucumber-report/cucumber.json", "html:target/site/cucumber-pretty"},
//        features = "D:\\workSpace\\G22Project\\cucumberProj\\src\\test\\java\\feature\\github_login.feature",
//        glue = "StepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber"

        }

)
public class RunCukeTest {
}