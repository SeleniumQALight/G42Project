package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parrentPage.ParentPage;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @FindBy(name = "_username")
    private WebElement inputLogin;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public void fillingLoginFormAndSubmitIt(String login, String password) {
        openPage();
        enterLoginIntoInputLogin(login);
        enterPassIntoInputPassword(password);
        clickOnButtonVhod();
    }

    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Can not work with browser");
        }
    }

    @Step
    public void enterLoginIntoInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    @Step
    public void enterPassIntoInputPassword(String password) {
        actionsWithOurElements.enterTextIntoInput(inputPassword, password);
    }

    @Step
    public void clickOnButtonVhod() {
        actionsWithOurElements.clickElement(buttonVhod);
    }

    @Step
    public boolean isVhodButtonVisible() {
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    public void tryToLoginAsStudentWithPassword(String password){
        openPage();
        enterLoginIntoInputLogin("Student");
        enterPassIntoInputPassword(password);
        clickOnButtonVhod();
    }
}
