package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
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
    WebDriver webdriver; //объявили переменную
    protected LoginPage loginPage; // обявили переменную loginPage, protected - позволяет видеть эту переменную в наследниках; доступен во всех наследниках и всех пекеджах
    protected HomePage homePage; // обявили переменную homePage
    protected SparePage sparePage;
    protected EditSparePage editSparePage;

    @Before // секция бефор будет выполняться перед каждым тестом
    public void setUp() throws Exception {
//        File file = new File("./src/drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        webdriver = new ChromeDriver(); //создали объект для браузера хром

        webdriver = driverInit(); // создаем метод для инициализации драйвера, аль+ентер добавить эксепшн в метод

        webdriver.manage().window().maximize();//сделать окно браузера на весь экран
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//каждые пол секунды по дефолту хром будет пробовать выполнить действие каждые пол
        //секунды на протяжении 5 секунд, по их истечению будет time timeout, implicitlyWait - не явное ожидание

        loginPage = new LoginPage(webdriver); // создали объект страницы LoginPage
        homePage = new HomePage(webdriver); // инициализировали переменную homePage
        sparePage = new SparePage(webdriver);
        editSparePage = new EditSparePage(webdriver);

    }

    private WebDriver driverInit() throws Exception { // throws Exception - заявили что этот метод может выбросить эксепшн
        String browser = System.getProperty("browser"); // управляющая переменная browser - ключ для запуска тестов
        if ((browser == null) || // когда хотим запустить тест не передавая ничего, по умолчанию будет хром или если передаем хром, то будет хром
        ("chrome".equalsIgnoreCase(browser))){ // equalsIgnoreCase - не важно что нам передадут, оно будет сравнено, в любом регистре
            WebDriverManager.chromedriver().setup(); // настрой хром
            return new ChromeDriver(); // верни новый обект хром драйвер
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup(); // setup - подтягивает настройки
            return new FirefoxDriver(); // на пк должен быть фаерфокс иначе тест не запустится
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().setup(); //arch32().
            return new InternetExplorerDriver();
        } else {
            throw  new Exception("Check browser var"); // аль+ентер выбрать первое add exception to method; это создание эксепшена для этого метода
        }
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
