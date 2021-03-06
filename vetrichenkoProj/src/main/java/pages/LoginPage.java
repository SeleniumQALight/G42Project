package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    @Step //аннотация что-бы были "степы" в алюр репорте
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
        } catch (Exception e) {
            Assert.fail("Can`t work with browser");
        }
    }

    @Step
    public void enterLoginIntoLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));
//        inputLogin.clear();
//        inputLogin.sendKeys(login);
//        logger.info(login + " was inputed into  in Login");
    }

    @Step
    public void enterPassIntoPass(String password) {
        actionsWithOurElements.enterTextIntoInput(inputPass, password);
//        WebElement inputPass = webDriver.findElement(By.id("password"));
//        inputPass.clear();
//        inputPass.sendKeys(password);
//        logger.info(password + " was inputed into  in Password");
    }

    @Step
    public void clickOnButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
//        WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
//        buttonVhod.click();
//        logger.info("Button was clicked");
    }

    @Step
    public void fillingLoginFormAndSubmitIt(String Login, String Password) {
        openPage();
        enterLoginIntoLogin(Login);
        enterPassIntoPass(Password);
        clickOnButtonVhod();
    }
}
