package abstractParrentTest;

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
        //two lines down are for to find our chrome for testing
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //every 0.3sec during 5sec the operation will try to run

        loginPage = new LoginPage(webDriver);
    }
    @After
    public void closeChrome(){
        webDriver.quit();
    }
}
