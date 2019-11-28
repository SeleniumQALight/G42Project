package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

/**
 * Created by Андрей Гугля on 12.11.2019.
 */
public class LoginPage extends ParentPage{
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public void openPage() {
        try{
            webDriver.get("http://v3.test.itpmgroup.com/login");
        }catch (Exception e){
            Assert.fail("Can not work with browser");
        }
    }

    public void enterLoginInToInputLogin(String login) {
  //      WebElement inputLogin = webDriver.findElement(By.name("_username")); за коментировали по причине find by
  //      inputLogin.clear();
 //       inputLogin.sendKeys(login);
  //      logger.info(login + " was iputed in to input Login"); заменили эти строки в парент падже акшеном с нашими елементами
        actionsWithOurElements.enterTextInToInput(inputLogin,login);

    }

    public void enterPassInToInputPassword(String password) {
  //      WebElement inputPass = webDriver.findElement(By.id("password"));   findby
 //       inputLogin.clear();
  //      inputLogin.sendKeys(password);
 //       logger.info(password + " was inputed in to PassWord");
        actionsWithOurElements.enterTextInToInput(inputPassword, password );
    }

    public void clickOnButtonVhod() {
  //      WebElement buttonVhod = webDriver.findElement(By.tagName("button"));  findby
    //    buttonVhod.click();
  //      logger.info("Button was clicked");
        actionsWithOurElements.clickOnElement(buttonVhod);

    }

    public boolean stayOnLoginPageChek() {
        try {
            WebElement buttonVhod = webDriver.findElement(By.name("submit"));
            return buttonVhod.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void fillingLoginFormAndSubmitIt(String login, String pass) {
        openPage();
        enterLoginInToInputLogin(login);
        enterPassInToInputPassword(pass);
        clickOnButtonVhod();
    }
}
