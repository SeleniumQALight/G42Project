package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LogInPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;


    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/");
        } catch (Exception e) {
            Assert.fail("Cannot work with browser");
        }
    }

    public void enterLoginInToinputlogin(String login) {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed into Input login");
    }

    public void enterPassInToInputPassWord(String password) {
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " was inputed into Input password");

    }

    public void clickOnButtonVhod() {
        buttonVhod.click();
        logger.info("Button was clicked");
    }

    public boolean isButtonVhodDisplayed(){
        try{
            WebElement avatar = webDriver.findElement(By.xpath(".//button"));
            logger.info("Button Vhod is displayed");
            return buttonVhod.isDisplayed();

        }catch (Exception e){
            logger.info("Button Vhod is not displayed");
            return  false;
        }
    }


    public boolean isEmailFieldDisplayed(){
        try{
            WebElement avatar = webDriver.findElement(By.xpath(".//input[@name='_username']"));
            logger.info("Email field is displayed");
            return inputLogin.isDisplayed();

        }catch (Exception e){
            logger.info("Email field  is not displayed");
            return  false;
        }
    }

    public boolean isPasswordFieldDisplayed(){
        try{
            WebElement avatar = webDriver.findElement(By.xpath(".//input[@type='password']"));
            logger.info("Password field is displayed");
            return inputPass.isDisplayed();

        }catch (Exception e){
            logger.info("Password field  is not displayed");
            return  false;
        }
    }


}
