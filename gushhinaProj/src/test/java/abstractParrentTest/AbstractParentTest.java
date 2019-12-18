package abstractParrentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.EditSparePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;



    @Before
    public void setUp() throws Exception {
        //two lines down are for to find our chrome for testing
        //  File file = new File("./src/drivers/chromedriver");
        // System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        // webDriver = new ChromeDriver();
        // 3 lines are commented cuz we made driverInit - will check browser automatacly


        webDriver = driverInit ();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //every 0.3sec during 5sec the operation will try to run

        loginPage = new LoginPage(webDriver);

        homePage = new HomePage(webDriver);

        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
    }
        private WebDriver driverInit () throws Exception {
           String browser = System.getProperty("browser");
           if ((browser == null) || ("chrome".equalsIgnoreCase(browser))){
               WebDriverManager.chromedriver().setup();
               return new ChromeDriver();
           }else if ("firefox".equalsIgnoreCase(browser)){
               WebDriverManager.firefoxdriver().setup();
               return new FirefoxDriver();
           }else if ("IE".equalsIgnoreCase(browser)){
               WebDriverManager.iedriver().setup();
               return new InternetExplorerDriver();
           }else {
               throw new Exception("Check browser var ");
           }
    }

    @After
    public void closeChrome(){
        webDriver.quit();
    }

  //  @Step
    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

 //   @Step
    protected void correctLogin(String message, boolean actualResult){
        Assert.assertEquals(message, true, actualResult);
    }
}
