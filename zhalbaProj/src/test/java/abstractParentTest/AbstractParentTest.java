package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.EditSparePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

public class AbstractParentTest {

  private WebDriver webDriver;
  protected LoginPage loginPage;
  protected HomePage homePage;
  protected SparePage sparePage;
  protected EditSparePage editSparePage;

  @Before
  public void setUp() throws Exception {
//    File file = new File("./src/drivers/chromedriver.exe");
////    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
////    webDriver = new ChromeDriver();
    webDriver = driverInit();
    webDriver.manage().window().maximize(); // окно на весь экран
    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    loginPage = new LoginPage(webDriver);
    homePage = new HomePage(webDriver);
    sparePage = new SparePage(webDriver);
    editSparePage = new EditSparePage(webDriver);

  }

  private WebDriver driverInit() throws Exception {
    String browser = System.getProperty("browser");
    if ((browser == null) || ("chrome".equals(browser))) {
      WebDriverManager.chromedriver().setup();
      return new ChromeDriver();
    } else if ("firefox".equalsIgnoreCase(browser)) {
      WebDriverManager.firefoxdriver().setup();
      return new FirefoxDriver();
    } else if ("ie".equalsIgnoreCase(browser)) {
      WebDriverManager.iedriver().arch32().setup();
      return new InternetExplorerDriver();
    } else if ("edge".equalsIgnoreCase(browser)) {
      WebDriverManager.edgedriver().setup();
      return new EdgeDriver();
    } else {
      throw new Exception("Check browser var ");
    }
  }

  @After
  public void tearDown() {
    webDriver.quit();

  }

  protected void checkExpectedResult(String message, boolean actualResult) {
    Assert.assertEquals(message, true, actualResult);
  }

}
