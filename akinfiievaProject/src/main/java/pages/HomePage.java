package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parentPage.ParentPage;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarDisplayed() {
        try {
            WebElement avatar = webDriver.findElement(By.xpath(".//*[@class='pull-left image']"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isLoginBoxRefreshed() {

        try {
            WebElement loginLogo = webDriver.findElement(By.xpath(".//div[@class='login-box-body']"));

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
