package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

import java.lang.ref.SoftReference;

public class LoginPage extends ParentPage {

    @Override
    public String getExpectedUrl() {
        return "http://v3.test.itpmgroup.com/login";
    }

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
        }catch (Exception e){
            Assert.fail("Can not work with browser");
        }
    }

    public void enterLoginIntoInputLogin(String login) {
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    public void enterPassIntoInputPassword(String password) {
//        WebElement inputPass= webDriver.findElement(By.id("password"));
//        inputPass.clear();
//        inputPass.sendKeys(password);
//        logger.info(password + " was inputted into input Password");
        actionsWithOurElements.enterTextIntoInput(inputPass,password);
    }

    public void clickOnButtonVhod() {
//        WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
//        buttonVhod.click();
//        logger.info("Button was clicked");
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean isButtonVhodDisplayed(){
//        try{
//            return buttonVhod.isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    public void fillingLoginFormAndSubmitIt(String login, String pass) {
        openPage();
        enterLoginIntoInputLogin(login);
        enterPassIntoInputPassword(pass);
        clickOnButtonVhod();
    }
}
