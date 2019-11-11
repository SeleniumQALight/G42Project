package loginTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    @Test
    public void validLogin() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver webDriver = new ChromeDriver(); //создание браузера хром

        webDriver.manage().window().maximize(); //увеличиваем размер окна в хроме
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //увеличиваем время ожидания, чтоб подгрузилась страница, если 5 сек пройдет и действие не выполнится, то тест падает. По дефолту каждые пол сек пробует
        webDriver.get("http://v3.test.itpmgroup.com");
        webDriver.quit(); //метод закрывает и уничтожает браузер, чтоб исчезла сущность
    }
}