package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

//в этом классе будут все действия для страницы логин
public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public String Url = "http://v3.test.itpmgroup.com/login";


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
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed into input login");
    }

    public void enterPassIntoInputPassword(String password) {
//        WebElement inputPass= webDriver.findElement(By.id("password"));
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " was inputed into input Password");
    }

    public void clickOnButtonVhod() {
//        WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
        buttonVhod.click();
        logger.info("Button was clicked");
    }

    public boolean isButtonVhodDisplayed(){
        try{
            return buttonVhod.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
