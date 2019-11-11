package LoginTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Андрей Гугля on 07.11.2019.
 */
public class LoginTest {
  //  WebDriver webDriver = new ChromeDriver();

    @Test
    public void validLogin(){
        File file = new File("./src/old_drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("http://v3.test.itpmgroup.com/login");


        webDriver.quit();

    }
}
