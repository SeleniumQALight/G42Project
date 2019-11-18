package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement enterButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        try {
            driver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Browser has failed!");
        }
    }

    public void enterLoginIntoLoginField(String login) {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        log.info(login + " was input as login.");
    }

    public void enterPasswordIntoPasswordField(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        log.info(password + " was input as password");
    }

    public void clickOnButtonEnter() {
        enterButton.click();
        log.info("Button Enter was clicked.");
    }
}
