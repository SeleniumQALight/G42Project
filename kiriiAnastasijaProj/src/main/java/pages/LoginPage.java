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
        super(webDriver);
    } // будут содержаться все классы на логин пейдже и все действия

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Cannot work with browser");
        }
    }

    public void enterloginInToInputLogin(String login) {
        //WebElement inputLogin = webDriver.findElement(By.name("_username"));
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed in to Input login");
    }

    public void enterPassInToInputPass(String password) {
       // WebElement inputPass = webDriver.findElement(By.id("password"));
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " was inputed in to Input password");
    }

    public void clickOnButtonVhod() {
        //WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
        buttonVhod.click();
        logger.info("Button was clicked");

    }
}
