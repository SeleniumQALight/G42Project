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
    private WebElement inputPass;
    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Can't work with browser!");

        }
    }

    public void enterLoginInToInputLogin(String login) {
     //   WebElement inputLogin = webDriver.findElement(By.name("_username")); We dont need it anymore cuz we tags @ it above
       /* inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was imputed in to input Login"); */
       actionWithOurElements.enterTextInToInput(inputLogin, login);
    }

    public void enterPassInToInputPassword(String password) {
      //  WebElement inputPass = webDriver.findElement(By.id("password"));  We dont need it anymore cuz we tags @ it above
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " was imputed in to input Password");
    }

    public void clickOnButtonVhod() {
      //  WebElement buttonVhod  = webDriver.findElement(By.tagName("button"));  We dont need it anymore cuz we tags @ it above
        buttonVhod.click();
        logger.info("Button was clicked.");
    }
    public void fillingLoginFormAndSubmitIt(String login, String pass) {
        openPage();
        enterLoginInToInputLogin(login);
        enterPassInToInputPassword(pass);
        clickOnButtonVhod();
    }
}