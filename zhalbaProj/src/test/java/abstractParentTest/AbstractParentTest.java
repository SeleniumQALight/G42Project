package abstractParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class AbstractParentTest {

  WebDriver webDriver;
  protected LoginPage loginPage;

  @Before
  public void setUp() {
    File file = new File("./src/drivers/chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    WebDriver webDriver = new ChromeDriver();

    webDriver.manage().window().maximize(); // окно на весь экран
    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    loginPage = new LoginPage(webDriver);

  }

  @After
  public void tearDown() {
    webDriver.quit();

  }
}
