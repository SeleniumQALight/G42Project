package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.EditSparesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparesPage;

import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparePage;
    protected EditSparesPage editSparesPage;

    @Before
    public void setUp() throws Exception {
//        File file = new File("./src/Drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = driverInit();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparesPage(webDriver);
        editSparesPage = new EditSparesPage(webDriver);

    }

    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equalsIgnoreCase(browser))) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        } else
            throw new Exception("Check browser var ");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

}
