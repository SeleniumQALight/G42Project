package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.LeftMenu;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Image;
import ru.yandex.qatools.htmlelements.element.Link;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private Image avatar;

    @FindBy(id = "dictionary")
    private Link menuDictionary;

    @FindBy(id = "spares")
    private Link subMenuSpares;

    public LeftMenu leftMenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarDisplayed(){
//        try{
//            WebElement avatar = webDriver.findElement(By.xpath(""));
//            return avatar.isDisplayed();
//        } catch (Exception e){
//            return false;
//        }
        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed" , isAvatarDisplayed());
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }
}
