package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }
    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;


    //method po rabote s avatarom
    public boolean isAvatarDisplayed (){
        try{
            WebElement avatar = webDriver.findElement(By.xpath(".//*[@class='pull-left image']"));
            return avatar.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed" , isAvatarDisplayed());
    }
    public boolean isLogginSuccess(){
        try{
            WebElement successLoggin = webDriver.findElement(By.xpath("//*/li[text()='Главная']"));
            return successLoggin.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnMenuDictionary() {
        actionWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionWithOurElements.clickOnElement(subMenuSpares);
    }
}
