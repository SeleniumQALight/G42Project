package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class = 'pull-left image']")
    WebElement avatar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAvatarDisplayed() {
        try {
            return avatar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
