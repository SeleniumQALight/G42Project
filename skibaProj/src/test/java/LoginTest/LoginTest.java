package LoginTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    @Test
    public void validLogin(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver webdriver = new ChromeDriver();                               //создали объект для браузера хром

        webdriver.manage().window().maximize();                                 //сделать окно браузера на весь экран
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);      //каждые пол секунды по дефолту хром будет пробовать
                                                                                //выполнить каждое
                                                                                //действие на протяжении 5 секунд,
                                                                                //по их истечению будет time timeout

        webdriver.get("http://v3.test.itpmgroup.com");                          //ccылка на наш сайт
        webdriver.quit();                                                       //закрыть браузер
    }
}
