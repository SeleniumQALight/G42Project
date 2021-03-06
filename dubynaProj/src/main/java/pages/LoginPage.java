package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    public void fillingLoginFormAndSubmit(String login, String pass){
        openPage();
        enterLoginIntoInputLogin(login);
        enterPassIntoInputPassword(pass);
        clickOnButtonVhod();
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/");
        } catch (Exception e) {
            Assert.fail("Can not work with browser");
        }

    }

    public void enterLoginIntoInputLogin(String login) {
        //WebElement inputLogin = webDriver.findElement(By.name("_username"));

        //inputLogin.clear();
        //inputLogin.sendKeys(login);
        //logger.info(login + " was inputed into input login");
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);

    }

    public void enterPassIntoInputPassword(String password) {
        // WebElement inputPass = webDriver.findElement(By.id("password"));
        actionsWithOurElements.enterTextIntoInput(inputPass, password);
    }

    public void clickOnButtonVhod() {
        // WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean buttonVhodIsDisplayed() {
        try {
            WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
            return buttonVhod.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

}
