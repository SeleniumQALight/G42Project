package LoginTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    @Test
    public void validLogin() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgfoup.com");
        driver.quit();
    }
}
