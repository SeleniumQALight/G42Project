package loginTest;


import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

  WebDriver webDriver;

  @Test
  public void validLoin() {
    File file = new File("./src/drivers/chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize(); // окно на весь экран
    webDriver.manage().timeouts().implicitlyWait(5,
        TimeUnit.SECONDS); // 5 сек ждет(пытается выполнить операцию каждые пол. сек) для любой операции в пределах жизни драйвера
    webDriver.get("http://v3.test.itpmgroup.com");

    webDriver.findElement(By.name("_username")).clear();
    webDriver.findElement(By.name("_username")).sendKeys("Student");

    webDriver.findElement(By.id("password")).clear();
    webDriver.findElement(By.id("password")).sendKeys("9090905");

    webDriver.findElement(By.tagName("button")).click();

    Assert.assertTrue("Avatar is not present", isAvatarPresent());

    webDriver.quit();

  }


  private boolean isAvatarPresent() {
    try {
      return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
    } catch (Exception e) {
      return false;
    }

  }

}
