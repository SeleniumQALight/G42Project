package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @Test
    public void validLogin(){
        File file = new File("./src/Drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("http://v3.test.itpmgroup.com/login");
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("906090");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue("Avatar is not present", isAvatarPresent());
        Assert.assertEquals("http://v3.test.itpmgroup.com/", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    private boolean isAvatarPresent() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
