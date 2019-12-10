package loginTest;

import abstractparenttest.AbstractParentTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        driver.get("http://v3.test.itpmgroup.com");
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.name("_username")).sendKeys("Student");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("909090");
        driver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not present", isAvatarPresent());
        driver.quit();
    }

    private boolean isAvatarPresent() {
        try {
            return driver.findElement(By.xpath(".//*[@class = 'pull-left image']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
