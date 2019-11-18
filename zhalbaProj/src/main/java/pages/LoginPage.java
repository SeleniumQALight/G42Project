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

  @FindBy(id="password")
  private  WebElement inputPass;

  @FindBy (tagName = "Button")
  private  WebElement buttonVhod;

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

  public void enterLoginInToInputLogin(String login) {
    inputLogin.clear();
    inputLogin.sendKeys(login);
    logger.info(login + " was imported in to input Login");
  }

  public void enterPassInToInputPassword(String password) {
    inputPass.clear();
    inputPass.sendKeys(password);
    logger.info(password + " was imported in to input Password");
  }

  public void clickonButtonVhod() {
    buttonVhod.click();
    logger.info("Button was clicked");
  }

  public boolean isVhodButtonDispalyed() {
    try {
      WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
      return buttonVhod.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
