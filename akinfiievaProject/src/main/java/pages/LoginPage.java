package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(name = "_password")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-block btn-flat']")
    private WebElement buttonVhod;

    @FindBy(xpath = ".//div[@class='login-box-body']")
    private WebElement loginBox;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/");
        } catch (Exception e) {
            Assert.fail("Can't work with browser");
        }
    }

    public void enterLoginIntoInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }


    public void enterPasswordIntoInputPassword(String password) {
        actionsWithOurElements.enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean isLoginBoxRefreshed() {
        return actionsWithOurElements.isElementDisplayed(loginBox);
    }

    public void fillingLoginFormAndSubmitIt(String login, String password) {
        openPage();
        enterLoginIntoInputLogin(login);
        enterPasswordIntoInputPassword(password);
        clickOnButtonVhod();
    }
}
