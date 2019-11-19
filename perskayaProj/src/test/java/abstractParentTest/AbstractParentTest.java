package abstractParentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webdriver; //объявили переменную
    protected LoginPage loginPage; // обявили переменную loginPage, protected - позволяет видеть эту переменную в наследниках; доступен во всех наследниках и всех пекеджах
    protected HomePage homePage; // обявили переменную homePage
    protected SparePage sparePage;

    @Before // секция бефор будет выполняться перед каждым тестом
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webdriver = new ChromeDriver(); //создали объект для браузера хром

        webdriver.manage().window().maximize();//сделать окно браузера на весь экран
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//каждые пол секунды по дефолту хром будет пробовать выполнить действие каждые пол
        //секунды на протяжении 5 секунд, по их истечению будет time timeout, implicitlyWait - не явное ожидание

        loginPage = new LoginPage(webdriver); // создали объект страницы LoginPage
        homePage = new HomePage(webdriver); // инициализировали переменную homePage
        sparePage = new SparePage(webdriver);
    }


    @After //закрытие браузера после каждого теста. можно еще предусмотреть если webdriver = null, то не закрывать
    public void clouseBrouser() {
        webdriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult); // Assert - org junit обязательно, true - expected result, он может быть и фолс, но в нашем случае он тру
    }

    protected void checkExpectedResult(String message, boolean expectedResult, boolean actualResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }
}
