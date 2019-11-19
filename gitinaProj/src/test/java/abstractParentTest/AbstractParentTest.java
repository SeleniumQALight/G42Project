package abstractParentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LogInPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LogInPage logInPage;
    protected HomePage homePage;
    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        logInPage = new LogInPage(webDriver);
        homePage = new HomePage(webDriver);
    }


    @After
    public void tearDown(){
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

}
