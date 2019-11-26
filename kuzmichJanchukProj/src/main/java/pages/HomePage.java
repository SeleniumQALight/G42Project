package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class = 'pull-left image']")
    private WebElement avatar;

    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    public HomePage(WebDriver driver) {
        super(driver, "/");
    }

    public boolean isAvatarDisplayed() {
        return  commonActions.isElementDisplayed(avatar);
    }

    public void isAvatarPresent() {
        Assert.assertTrue("Avatar is not present!", isAvatarDisplayed());
    }

    public void clickOnMenuDictionary() {
        commonActions.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        commonActions.clickOnElement(subMenuSpares);
    }
}
