package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parentPage.ParentPage;

/**
 * Created by Андрей Гугля on 14.11.2019.
 */
public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public boolean isAvatarDisplayed(){
        try {
            WebElement avatar = webDriver.findElement(By.xpath(""));
            return isAvatarDisplayed();
        }catch (Exception e) {
            return false;
        }
    }
}
