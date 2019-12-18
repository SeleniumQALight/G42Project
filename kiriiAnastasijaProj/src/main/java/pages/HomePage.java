package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.LeftMenu;
import parentPage.ParentPage;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;
//    @FindBy(id = "dictionary")
//    private Link menuDictionary;
//    @FindBy(id = "spares")
//    private Link subMenuSpares;

    public LeftMenu leftMenu;

    @FindBy(xpath = ".//a[@href = '/dictionary/providers']")
    private WebElement menuProviders;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    @Step
    public boolean isAvatarDisplayed() {
//        try {
//            WebElement avatar = webDriver.findElement(By.xpath(".//*[@class='pull-left image']"));
//            return avatar.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
        return actionsWithOurElements.isElementDisplayed(avatar);
    }


    public String currentUrl()
    {return webDriver.getCurrentUrl();
    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not present", isAvatarDisplayed());
    }

//    public void clickOnMenuDictionary() {
//        actionsWithOurElements.clickOnElement(menuDictionary);
//    }

    public void clickOnMenuProviders() {
        actionsWithOurElements.clickOnElement(menuProviders);
    }

   // public void clickOnSubMenuSpares(){
//        actionsWithOurElements.clickOnElement(subMenuSpares);
//    }
}
