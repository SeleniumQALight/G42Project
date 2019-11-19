package abstractParentTest;

import jdk.internal.org.objectweb.asm.Handle;
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
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver(); //версия хрома должна быть последней

        webDriver.manage().window().maximize(); //открыли на весь экран
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //добавили время ожидания (до 5 секунд будет выполняться действие)

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

    protected boolean checkCurrentUrl(String expectedUrl) {
        String actualUrl = webDriver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            return true;
        } else {
            return false;
        }
    }

}



