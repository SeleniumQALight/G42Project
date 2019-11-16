package LoginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver webdriver;

    @Test
    public void validLogin(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webdriver = new ChromeDriver();                               //создали объект для браузера хром

        webdriver.manage().window().maximize();                                 //сделать окно браузера на весь экран

        webdriver.get("http://v3.test.itpmgroup.com/");                          //ccылка на наш сайт

        webdriver.findElement(By.name("_username")).clear();
        webdriver.findElement(By.name("_username")).sendKeys("Student");

        webdriver.findElement(By.id("password")).clear();
        webdriver.findElement(By.id("password")).sendKeys("909090");

        webdriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not present, BLEAT!!!11", isAvatarPresent());



        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);      //каждые пол секунды по дефолту хром будет пробовать
                                                                                //выполнить каждое
                                                                                //действие на протяжении 5 секунд,
                                                                                //по их истечению будет time timeout

        webdriver.quit();                                                       //закрыть браузер
    }

    private boolean isAvatarPresent() {
        try {
            return webdriver.findElement(By.xpath("//*[@class='pull-left image']")).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
}
