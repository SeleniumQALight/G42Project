package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pageElements.LeftMenu;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by Андрей Гугля on 14.11.2019.
 */
public class HomePage extends ParentPage {
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

//    @FindBy(id = "dictionary")
//    private Link menuDictionary;
//
//    @FindBy(id = "spares")
//    private Link subMenuSpares;

    public LeftMenu leftMenu ;

    public HomePage(WebDriver webDriver) {
        super(webDriver,"/") ;
    }


    @Step
    public boolean isAvatarDisplayed() {
        //   try {
        //     WebElement avatar = webDriver.findElement(By.xpath(""));
        //    return isAvatarDisplayed();
        //   }catch (Exception e) {
        //  return false;
        //}


        return actionsWithOurElements.isElementDisplayed(avatar);
    }

    @Step
    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

//    public void clickOnMenuDictionary() {
//        actionsWithOurElements.clickOnElement(menuDictionary);
//    }
//
//    public void clickOnSubMenuSpares() {
//        actionsWithOurElements.clickOnElement(subMenuSpares);
//    }
}
