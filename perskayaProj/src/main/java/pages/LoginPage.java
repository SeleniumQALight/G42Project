package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

// тут будет описание всех элементов этой страницы и все действия.
public class LoginPage extends ParentPage { // когда введем слово extends строка подчеркнется красным - нужно создать конструктор
    @FindBy(name = "_username")
    private WebElement inputLogin;
    @FindBy(id = "password")
    private WebElement inputPass;
    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public LoginPage(WebDriver webdriver) {
        super(webdriver);
    }

    public void openPage() {
        try {
            webdriver.get ("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Can't work with brouser.");   // если асерт красный то в файле пуум удалить строку <scope>test</scope>, так как мы сейчас наодимся в меине а не в тесте, потом альт + ентер импорт класс орг джейюнит
        }
    }

    public void enterLoginInToInputLogin(String login) { // login - название переменной
        //WebElement inputLogin = webdriver.findElement(By.name("_username")); уже не нужно, так как написали сверху файнд бай
        inputLogin.clear();
        inputLogin.sendKeys(login);
        logger.info(login + " was inputed in to input Login");
    }

    public void enterPassInToInputPassword(String password) {
        //WebElement inputPass = webdriver.findElement(By.id("password"));
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + " was inputed into input PassWord");
    }

    public void clickOnButtonVhod() {
        //WebElement buttonVhod = webdriver.findElement(By.tagName("button"));
        buttonVhod.click();
        logger.info("Button was clicked");
    }
}
