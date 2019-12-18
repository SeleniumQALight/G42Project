package pages;

import io.qameta.allure.Step;
import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LogInPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;


    public LogInPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/");
        } catch (Exception e) {
            Assert.fail("Cannot work with browser");
        }
    }

    @Step
    public void enterLoginInToInputlogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    @Step
    public void enterPassInToInputPassWord(String password) {
        actionsWithOurElements.enterTextIntoInput(inputPass, password);
    }

    @Step
    public void clickOnButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    @Step
    public boolean isButtonVhodDisplayed() {
        try {
            logger.info("Button Vhod is displayed");
            return buttonVhod.isDisplayed();

        } catch (Exception e) {
            logger.info("Button Vhod is not displayed");
            return false;
        }
    }

    @Step
    public boolean isEmailFieldDisplayed() {
        try {
            logger.info("Email field is displayed");
            return inputLogin.isDisplayed();

        } catch (Exception e) {
            logger.info("Email field  is not displayed");
            return false;
        }
    }
    @Step
    public boolean isPasswordFieldDisplayed() {
        try {
            logger.info("Password field is displayed");
            return inputPass.isDisplayed();

        } catch (Exception e) {
            logger.info("Password field  is not displayed");
            return false;
        }
    }
    @Step
    public void fillingLoginFormAndSubmitIt(String login, String pass) {
        openPage();
        enterLoginInToInputlogin(login);
        enterPassInToInputPassWord(pass);
        clickOnButtonVhod();

    }
}
