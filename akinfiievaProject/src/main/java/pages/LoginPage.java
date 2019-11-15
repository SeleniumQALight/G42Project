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

@FindBy (name = "_password")
private WebElement inputPassword;

@FindBy (xpath = ".//button[@class='btn btn-primary btn-block btn-flat']")
private WebElement buttonVhod;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/");
        } catch (Exception e) {
            Assert.fail("Can't work with browser");
        }
    }


    public void enterLoginIntoInputLogin(String login) {
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed into input login");
    }


    public void enterPasswordIntoInputPassword(String password) {
//        WebElement inputPassword = webDriver.findElement(By.name("_password"));
        inputPassword.clear();
        inputPassword.sendKeys(password);
        logger.info(password + " was inputed into input login");
    }

    public void clickOnButtonVhod() {
//        WebElement clickButton = webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-block btn-flat']"));
        buttonVhod.click();
        logger.info("button Vhod was clicked");
    }
}