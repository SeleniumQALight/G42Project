package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.LeftMenu;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

  @FindBy(xpath = ".//*[@class='pull-left image']")
  private WebElement avatar;
//
//  @FindBy(id = "dictionary")
//  private Link menuDictionary;
//
//  @FindBy (id = "spares")
//  private Link subMenuSpares;

  public LeftMenu leftMenu;

  public HomePage(WebDriver webDriver) {
    super(webDriver, "/");
  }

  @Test
  public boolean isAvatarDisplayed() {

//    try {
//      WebElement avatar = webDriver.findElement(By.xpath(".//*[@class='pull-left image']"));
//      return avatar.isDisplayed();
//    } catch (Exception e) {
//      return false;
//    }
    return actionsWithOurElements.isElementDisplayed(avatar);
  }

  @Test
  public void checkIsAvatarDisplayed() {
    Assert.assertTrue("Avatar is not Displayed", isAvatarDisplayed());
  }

//  public void clickOnMenuDictionary() {
//    actionsWithOurElements.clickOnElement(menuDictionary);
//  }
//
//  public void clickOnSubMenuSpares() {
//    actionsWithOurElements.clickOnElement(subMenuSpares);
//
//  }
}
