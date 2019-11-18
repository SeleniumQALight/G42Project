package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id ="password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try{
            webDriver.get("http://v3.test.itpmgroup.com/login");
        } catch (Exception e) {
            Assert.fail("Can not work with browser");
        }

    }

    public void enterLoginIToInputLogin(String login) {
        //WebElement inputLogin = webDriver.findElement(By.name("_username"));
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed in to input Login");


    }

    public void enterPassInToPassword(String password) {
       // WebElement inputPass = webDriver.findElement(By.id("password"));
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " was inputed into input PassWord");
    }


    public void clickOnButtonVhod() {
     //   WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
        buttonVhod.click();
        logger.info("Button was clicked");
    }

    public boolean unValidPassW() {
        try {
            WebElement buttonVh = webDriver.findElement(By.name("submit"));
            return buttonVhod.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}















