package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement vhodButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Can not work with browser");
        }
    }

    public void enterLoginIntoInputLogin(String login) {
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));
//        inputLogin.clear();
//        inputLogin.sendKeys(login);
//        logger.info(login + " was inputed into input Login");
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    public void enterPasswordIntoInputPassword(String password) {
//        WebElement inputPassword = webDriver.findElement(By.id("password"));
//        inputPassword.clear();
//        inputPassword.sendKeys(password);
//        logger.info(password + " was inputed into input Password");
        actionsWithOurElements.enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonVhod() {
//        WebElement vhodButton = webDriver.findElement(By.tagName("button"));
//        vhodButton.click();
//        logger.info(" Button Vhod was clicked");
        actionsWithOurElements.clickOnElement(vhodButton);
    }

    public boolean isLoginFieldDisplayed() {
        try {
            return inputLogin.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void fillingLoginFormAndSubmit(String login, String password) {
        openPage();
        enterLoginIntoInputLogin(login);
        enterPasswordIntoInputPassword(password);
        clickOnButtonVhod();
    }
}
