package abstractParrentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.HomePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    private WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Before
    public void setUp(){
        File file = new File("./src/Drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }
}
