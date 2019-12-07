package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.LeftMenu;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

public class HomePage extends ParentPage {
    @FindBy (xpath = ".//*[@class='pull-left image']" )
    private WebElement avatar;
    @FindBy (id = "dictionary")
    private Link menuDictionary;

    @Name(" Submenu Spares")//присваиваем другое имя для логгера
    @FindBy (id = "spares")
    private Link subMenuSpares;

    public LeftMenu leftmenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed() );
    }

    public boolean isAvatarDisplayed() {
//        try {
//            WebElement avatar = webDriver.findElement(By.xpath(".//*[@class='pull-left image']"));
//            return avatar.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
        return actionsWithOurElements.isElementDisplayed(avatar);
        }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubmenuSpares() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }
}

