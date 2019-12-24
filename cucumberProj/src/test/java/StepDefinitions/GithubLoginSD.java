package StepDefinitions;

import Selenium.SeleniumFunctions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;

import java.net.MalformedURLException;

public class GithubLoginSD {

    SeleniumFunctions sf = new SeleniumFunctions();

    @Given("^user is on github homepage$")
    public void user_is_on_github_homepage() throws MalformedURLException,
            InterruptedException {
//        sf.createDriver();
        sf.ishomepageDisplayed();
    }

    @Given("^пользователь находится на Домашней странице$")
    public void ru_user_is_on_github_homepage() {
        sf.ishomepageDisplayed();
    }

    @Given("^user Fail is on github homepage$")
    public void user_fail_is_on_github_homepage() throws MalformedURLException,
            InterruptedException {
        Assert.fail("Test fail");
    }

    @When("^user clicks on Sign in button$")
    public void user_clicks_on_Sign_in_button() {
        sf.clickSigninLink();
    }

    @Когда("^пользователь нажимает на кнопку 'Вход'$")
    public void ru_user_clicks_on_Sign_in_button() {
        sf.clickSigninLink();
    }



    @Then("^user is displayed login screen$")
    public void user_is_displayed_login_screen() {
        sf.isloginsectionDisplayed();
        sf.teardown();
    }

    @Тогда("^пользователь видит Логин страницу$")
    public void ru_user_is_displayed_login_screen() {
        sf.isloginsectionDisplayed();

    }


}
