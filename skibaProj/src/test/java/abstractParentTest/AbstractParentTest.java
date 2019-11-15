package abstractParentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();                               //создали объект для браузера хром
        webDriver.manage().window().maximize();                                 //сделать окно браузера на весь экран
        webDriver.get("http://v3.test.itpmgroup.com/");                          //ccылка на наш сайт
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);      //каждые пол секунды по дефолту хром будет пробовать выполнить каждое действие на протяжении 5 секунд, по их истечению будет time timeout
        loginPage = new LoginPage(webDriver);
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}
