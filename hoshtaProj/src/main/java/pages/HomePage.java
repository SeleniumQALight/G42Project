package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.LeftMenu;
import parrentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Image;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }
//    @FindBy(id = "spares")
//    private Link sparesSubMenu;
//
//    @FindBy(id = "dictionary")
//    private Link dictionaryMenu;

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private Image avatar;

    public boolean isAvatarDisplayed() {
        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void checkIfAvatarIsPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

    public LeftMenu leftMenu;

//    public void clickOnDictionaryMenu() {
//        actionsWithOurElements.clickElement(dictionaryMenu);
//
//    }
//
//    public void clickOnSparesSubMenu() {
//        actionsWithOurElements.clickElement(sparesSubMenu);
//    }
}
