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
        super(driver, "/login");
    }

    public void openPage() {
        try {
            driver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Browser has failed!");
        }
    }

    public void enterLoginIntoLoginField(String login) {
        commonActions.enterTextIntoInput(inputLogin, login);
    }

    public void enterPasswordIntoPasswordField(String password) {
        commonActions.enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonEnter() {
        commonActions.clickOnElement(enterButton);
    }

    public void fillLoginFormAndSubmit(String login, String password) {
        openPage();
        enterLoginIntoLoginField(login);
        enterPasswordIntoPasswordField(password);
        clickOnButtonEnter();
    }
}
