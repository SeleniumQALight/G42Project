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
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize(); //открыли на весь экран
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //добавили время ожидания (до 5 секунд будет выполняться действие)
        webDriver.get("http://v3.test.itpmgroup.com"); //открываем сайт
        webDriver.quit(); //закрывает браузер (close - закрывает вкладку)

    }
}
