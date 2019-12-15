package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {

        super(webDriver, "/login");
    }

    @FindBy (name = "_username")
    private WebElement inputLogin;

    @FindBy (id = "password")
    private WebElement inputPass;

    @FindBy (tagName = "button")
    private WebElement buttonVhod;

    @Step
    public void openPage (){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Can not work with browser");
        }
    }

    @Step
    public void enterLoginIntoInputLogin(String login) {
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));
//        inputLogin.clear();
//        inputLogin.sendKeys(login);
//        logger.info(login + " was inputted into input Login");
        actionsWithOurElements.enterTextIntoInput (inputLogin, login);
    }

    @Step
    public void enterPassIntoInputPassword(String password) {
        actionsWithOurElements.enterTextIntoInput(inputPass, password);
    }

    @Step
    public void clickOnButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean isSubmitButtonPresent () {
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    @Step
    public void fillingLoginFormAndSubmitIt(String login, String password) {
        openPage();
        enterLoginIntoInputLogin(login);
        enterPassIntoInputPassword(password);
        clickOnButtonVhod();
    }
}
