package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.LeftMenu;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

//    @FindBy(id = "dictionary")
//    private Link menuDictionary;
//
//    @FindBy(id = "spares")
//    private Link subMenuSpares;

    @FindBy(id = "prov_cus")
    private Link subMenuContractors;

    public LeftMenu leftMenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarDisplayed() {
//        try {
//
//            return avatar.isDisplayed();
//        } catch (Exception e){
//            return false;
//        }

        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not present", isAvatarDisplayed());
    }

//    public void clickOnMenuDictionary() {
//        actionsWithOurElements.clickOnElement(menuDictionary);
//    }
//
//    public void clickOnSubMenuSpares() {
//        actionsWithOurElements.clickOnElement(subMenuSpares);
//    }

    public void clickOnSubMenuContractors() {
        actionsWithOurElements.clickOnElement(subMenuContractors);
    }
}
