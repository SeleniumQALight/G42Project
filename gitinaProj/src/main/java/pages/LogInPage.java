package pages;

import org.junit.Assert;
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
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/");
        } catch (Exception e) {
            Assert.fail("Cannot work with browser");
        }
    }

    public void enterLoginInToinputlogin(String login) {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed into Input login");
    }

    public void enterPassInToInputPassWord(String password) {
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " was inputed into Input password");

    }

    public void clickOnButtonVhod() {
        buttonVhod.click();
        logger.info("Button was clicked");
    }


}
