package StepDefinitions;


import Selenium.SeleniumFunctions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {
    SeleniumFunctions sf = new SeleniumFunctions();
    WebDriver webDriver;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        System.out.println( "--------- Scenario "  + scenario.getName() + " started -------- \n ");

            webDriver = sf.createDriver();

    }

    @After
    public void embedScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            scenario.embed(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        sf.teardown();
        System.out.println( "--------- Scenario "  + scenario.getName() + " finished -------- \n ");

    }

}
