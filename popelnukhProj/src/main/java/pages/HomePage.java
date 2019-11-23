package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage{
    @FindBy(id="dictionary")
    private WebElement menuDictionary;
    @FindBy(id="spares")
    private WebElement subMenuSpares;
    @FindBy(id = "prov_cus")
    private WebElement subMenuProviders;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;
    public boolean isAvatarDisplayed(){
        return actionsWithOurElements.isElementDisplayed(avatar);
//        try{
//            WebElement avatar = webDriver.findElement(By.xpath(".//*[@class='pull-left image']"));
//            return avatar.isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
    }



    public boolean isButtonVhodDisplayed() {
        try{
            WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
            return buttonVhod.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }

    public void clickOnSubMenuProviders() {
        actionsWithOurElements.clickOnElement(subMenuProviders);
    }
}