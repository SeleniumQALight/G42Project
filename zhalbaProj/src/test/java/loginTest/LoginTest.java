package loginTest;


import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {


  @Test
  public void validLoin() {
    File file = new File("./src/drivers/chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    webDriver.get("http://v3.test.itpmgroup.com");

    webDriver.quit();

  }

}
