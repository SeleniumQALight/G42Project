package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.LeftMenu;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class HomePage extends ParentPage {
    @FindBy (xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

//    @FindBy (xpath = "//a//span[text()= 'Словари']")
//    private Link menuDictionary;
//
//    @FindBy (xpath= "//a[@href='/dictionary/spares']")
//    private Link subMenuSpares;

    public LeftMenu leftMenu;
    @FindBy (id= "prov_cus")
    private WebElement subMenuProviders;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarDisplayed () {
        return actionsWithOurElements.isElementDisplayed(avatar);


    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }
//
//    public void clickOnMenuDictionary() {
//        actionsWithOurElements.clickOnElement(menuDictionary);
//    }
//
//    public void clickOnSubMenuSpares() {
//        actionsWithOurElements.clickOnElement(subMenuSpares);
//    }

    public void clickOnSubMenuProviders() {
        actionsWithOurElements.clickOnElement(subMenuProviders);
    }
}
