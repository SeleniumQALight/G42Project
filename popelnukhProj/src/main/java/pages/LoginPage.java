package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(name = "_username")
    private WebElement inputLogin;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public void openPage() {
        try{
            webDriver.get("http://v3.test.itpmgroup.com/");
        }catch (Exception e){
            Assert.fail("Can't work with browser");
        }
    }

    public void enterLoginInToInputLogin(String login) {
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed into input Login");



    }

    public void enterPassInToInputPassword(String password) {
//        WebElement inputPassword = webDriver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys(password);
        logger.info(password + " was inputed into input Password");
    }

    public void clickOnButtonVhod() {
        WebElement clickOnButtonVhod = webDriver.findElement(By.tagName("button"));
        clickOnButtonVhod.click();
        logger.info("Click was success");
    }
}