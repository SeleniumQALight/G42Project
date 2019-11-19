package abstractparenttest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    protected  void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    };

    protected void expectElementNotPresent(String message, boolean actualResult) {
        Assert.assertEquals(message, false, actualResult);
    }
}
