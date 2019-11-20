package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {

        super(webDriver);
    }

    @FindBy (name = "_username")
    private WebElement inputLogin;

    @FindBy (id = "password")
    private WebElement inputPass;

    @FindBy (tagName = "button")
    private WebElement buttonVhod;

    public void openPage (){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Can not work with browser");
        }
    }

    public void enterLoginIntoInputLogin(String login) {
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputted into input Login");


    }

    public void enterPassIntoInputPassword(String password) {
//        WebElement inputPass = webDriver.findElement(By.id("password"));
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info("\"" + password + "\""  + " was inputted into input Password");
    }

    public void clickonButtonVhod() {
//        WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
        buttonVhod.click();
        logger.info("Button was clicked");
    }

    public boolean isSubmitButtonPresent () {
        try {
            return buttonVhod.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
