package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;
    protected ContractorsPage contractorsPage;
    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    protected Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() throws Exception {
//        File file = new File("./src/drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        webDriver = new ChromeDriver();
        webDriver = driverInit();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
        contractorsPage = new ContractorsPage(webDriver);
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
        } else if ("remote".equals(browser)) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.WINDOWS);
            cap.setVersion("79");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(cap);
            webDriver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    chromeOptions);
            return webDriver;
        } else {
            throw new Exception("Check browser variable");
        }
    }

    @After
    public void tearDown() {
//        webDriver.quit();
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }

        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }

        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

}
