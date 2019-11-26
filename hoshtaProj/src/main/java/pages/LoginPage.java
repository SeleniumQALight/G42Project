package pages;

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

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Can not work with browser");
        }
    }

    public void enterLoginIntoInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    public void enterPassIntoInputPassword(String password) {
        actionsWithOurElements.enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonVhod() {
        actionsWithOurElements.clickElement(buttonVhod);
}

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
