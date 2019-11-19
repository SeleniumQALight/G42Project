package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage {
    @FindBy (xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    @FindBy (xpath = "//a//span[text()= 'Словари']")
    private WebElement menuDictionary;

    @FindBy (xpath= "//a[@href='/dictionary/spares']")
    private WebElement subMenuSpares;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarDisplayed () {
        return actionsWithOurElements.isElementDisplayed(avatar);


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
}
