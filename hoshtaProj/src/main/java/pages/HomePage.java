package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parrentPage.ParentPage;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    @FindBy(id = "spares")
    private WebElement sparesSubMenu;

    @FindBy(id = "dictionary")
    private WebElement dictionaryMenu;

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    public boolean isAvatarDisplayed() {
        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void checkIfAvatarIsPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

    public void clickOnDictionaryMenu() {
        actionsWithOurElements.clickElement(dictionaryMenu);

    }

    public void clickOnSparesSubMenu() {
        actionsWithOurElements.clickElement(sparesSubMenu);
    }
}
