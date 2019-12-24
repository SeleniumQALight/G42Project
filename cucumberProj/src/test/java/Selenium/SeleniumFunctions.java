package Selenium;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFunctions {

    public static WebDriver driver = null;
    public static WebDriverWait waitVar = null;

    public static String baseURL = "https://github.com/";

    public WebDriver createDriver() throws MalformedURLException,
            InterruptedException {
        File fileFF = new File(".././drivers/chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(baseURL);

        waitVar = new WebDriverWait(driver, 15);
        return driver;
    }

    public void teardown() {
        driver.quit();
    }

    public void ishomepageDisplayed() {
        waitVar.until(ExpectedConditions.presenceOfElementLocated(By
                .linkText("Sign in")));

        driver.findElement(By.linkText("Sign in")).isDisplayed();
//        driver.findElement(By.className("marketing-section-signup"))
//                .isDisplayed();
    }

    public void clickSigninLink() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void isloginsectionDisplayed() {
        waitVar.until(ExpectedConditions.presenceOfElementLocated(By
                .className("auth-form-body")));
        waitVar.until(ExpectedConditions.presenceOfElementLocated(By
                .name("commit")));
    }

}