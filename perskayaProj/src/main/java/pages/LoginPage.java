package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

// тут будет описание всех элементов этой страницы и все действия и методы
public class LoginPage extends ParentPage { // когда введем слово extends строка подчеркнется красным - нужно создать конструктор
    //описываем все элементы класса LoginPage
    @FindBy(name = "_username") // указываем по какому признаку, а именно _username, мы ищем элемент
    private WebElement inputLogin; // объявление переменной куда будет записан найденный элемент

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
        //WebElement inputLogin = webdriver.findElement(By.name("_username")); - мы просим вебдрайвер найти элемент по этому локатору и
        // его записать в эту переменную inputLogin// уже не нужно, так как написали сверху файнд бай

        actionsWithOurElements.enterTextInToInput (inputLogin, login); // добавлено вместо 3х строк ниже

//        inputLogin.clear(); // находим элемент, который сохранен в переменной inputLogin и очищаем это поле
//        inputLogin.sendKeys(login); // ввести в инпут login из метода
//        logger.info(login + " was inputed in to input Login"); // подключаем логирования, это будет информирование о введенном логине
    }

    public void enterPassInToInputPassword(String password) {
        //WebElement inputPass = webdriver.findElement(By.id("password")); уже не нужно, так как написали сверху файнд бай

        actionsWithOurElements.enterTextInToInput(inputPass, password); // добавлено вместо 3х строк ниже

//        inputPass.clear();
//        inputPass.sendKeys(password);
//        logger.info(password + " was inputed into input PassWord");
    }

    public void clickOnButtonVhod() { // параметр в методе не нужен, это просто клик поэтому () пустые
        //WebElement buttonVhod = webdriver.findElement(By.tagName("button")); уже не нужно, так как написали сверху файнд бай

        // если элемент грузится больше 5 секунд, нужно добавить логику в это место
        actionsWithOurElements.clickOnElement(buttonVhod);

//        buttonVhod.click();
//        logger.info("Button was clicked");
    }

    public boolean isButtonVhodDisplayed() {
        try {
            WebElement buttonVhod = webdriver.findElement(By.tagName("button")); //поиск кнопки
            return buttonVhod.isDisplayed(); // возвращаем значение, показана ли аватарка в браузере, а не в доме. Это случай отображения
        } catch (Exception e) {
            return false; // здесь кнопка не отобразилась в браузере
        }
    }

    public void fillingLoginFormAndSubmitIt(String login, String password) { // авторизация в кабинет
        openPage();
        enterLoginInToInputLogin(login);
        enterPassInToInputPassword(password);
        clickOnButtonVhod();
    }
}
