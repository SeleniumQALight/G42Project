package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.channels.ScatteringByteChannel;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;
    @Test //обозначаем, что дальше идет тесткейс
    public void validLogin() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver(); //версия хрома должна быть последней

        webDriver.manage().window().maximize(); //открыли на весь экран
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //добавили время ожидания (до 5 секунд будет выполняться действие)
        webDriver.get("http://v3.test.itpmgroup.com"); //открываем наш сайт
        //чистим поле логин
        webDriver.findElement(By.name("_username")).clear();
        //вводим данные в поле логин
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");
        //кликаем по кнопке вход
        webDriver.findElement(By.tagName("button")).click(); //клик - клик именно мышкой
        //проверяем или отображается аватарка
        Assert.assertTrue("Avatar is not present", isAvatarPresent());


        webDriver.quit(); //закрывает браузер (close - закрывает вкладку)


    }

    private boolean isAvatarPresent() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
