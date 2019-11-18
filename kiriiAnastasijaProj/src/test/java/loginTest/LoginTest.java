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
    public void validLogin() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver(); //создание браузера хром

        webDriver.manage().window().maximize(); //увеличиваем размер окна в хроме
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //увеличиваем время ожидания, чтоб подгрузилась страница, если 5 сек пройдет и действие не выполнится, то тест падает. По дефолту каждые пол сек пробует
        webDriver.get("http://v3.test.itpmgroup.com");
        webDriver.findElement(By.name("_username")).clear(); // найди элемент и почисти
        webDriver.findElement(By.name("_username")).sendKeys("Student");// введи с клавиатуры слово
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click(); //это клик мышкой
        Assert.assertTrue("Avatar is not present",
                isAvatarPresent())
        ;// если то что передаем внутри тру - тест зеленый, если фол  - красным


        webDriver.quit(); //метод закрывает и уничтожает браузер, чтоб исчезла сущность
    }

    private boolean isAvatarPresent() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}