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
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("http://v3.test.itpmgroup.com");
        //ochistim dla perestrachovki nochnih testov
        webDriver.findElement(By.name("_username")).clear();
        //vvedem
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.id("password")).clear();

        //Fail
        webDriver.findElement(By.id("password")).sendKeys("9088890");
        //true
        //webDriver.findElement(By.id("password")).sendKeys("909090");

        webDriver.findElement(By.tagName("button")).click();

        // Proverka
        Assert.assertTrue("Avatar is not present", isAvaterPresent());



        webDriver.quit();
    }

    private boolean isAvaterPresent() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        } catch (Exception e) {
           return false;
        }

    }

}
