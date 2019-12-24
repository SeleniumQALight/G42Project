package mainPack.jbehave;

import mainPack.steps.HomePageSteps;
import mainPack.steps.V3UserSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DefinitionStepsForV3 {

    @Steps
    V3UserSteps v3UserSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Given("User is on the V3 login page")
    public void userIsOnTheLoginPage() {
        v3UserSteps.is_the_login_page();
    }

    @When("User enter '$login' to loginInput on Login Page")
    public void userEnterValueToLoginInputOnLoginPage(String login) {
        v3UserSteps.enterValueToLoginInputOnLoginPage(login);
    }

    @When("User enter '$passWord' to passWordInput on Login Page")
    public void userEnterValueToPassInputOnLoginPage(String passWord) {
        v3UserSteps.enterValueToPassInputOnLoginPage(passWord);
    }

    @When("User click button Enter")
    public void userClickButtonEnter() {
        v3UserSteps.clickOnButtonEnter();
    }

    @Then("User sees avatar on Home page")
    public void userSeesAvatarOnHomepage() {
        homePageSteps.isAvatarPresent();
    }

    @Then("User sees loginForm on LoginPage")
    public void userSeesLoginFormOnLoginPage() {
        v3UserSteps.seesLoginFormOnLoginPage();
    }
}
