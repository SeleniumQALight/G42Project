package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parrentPage.ParentPage;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "_username")
    private WebElement inputLogin;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Can not work with browser");
        }
    }

    public void enterLoginIntoInputLogin(String login) {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was entered into the input login");
    }

    public void enterPassIntoInputPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        logger.info(password + " was entered into the input password");
    }

    public void clickOnButtonVhod() {
        buttonVhod.click();
        logger.info("Vhod button was clicked");
    }

    public boolean isVhodButtonVisible() {
        return buttonVhod.isDisplayed();
    }
}
