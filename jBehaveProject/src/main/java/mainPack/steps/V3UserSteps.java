package mainPack.steps;

import mainPack.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class V3UserSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step
    public void is_the_login_page() {
        loginPage.open();
    }

    @Step
    public void enterValueToLoginInputOnLoginPage(String login) {
        loginPage.enter_login(login);
    }

    @Step
    public void enterValueToPassInputOnLoginPage(String passWord) {
        loginPage.enter_pasword(passWord);
    }

    @Step
    public void clickOnButtonEnter() {
        loginPage.clickOnButtonEnter();
    }

    @Step
    public void seesLoginFormOnLoginPage() {
        loginPage.loginFormPresent();
    }
}