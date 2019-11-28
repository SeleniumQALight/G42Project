package parentPage;

import Libs.ActionsWithOurElements;
import Libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.EditSparePage;

public class ParentPage {
    protected WebDriver webdriver; // чтоб создать конструктор на webdriver жмем Alt+Insert, выбираем конструктор, ок. С помощью конструктора можно параметризировать
    protected Logger logger = Logger.getLogger(getClass()); //getClass - сюда вводится назввание класса страницы, в которой будет выполняться вызов
    // можно будет выбирать любую
//Logger - тип переменной, имя класса; говорим дай нам объект, который будет писать лог страницы
    protected ActionsWithOurElements actionsWithOurElements;

    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class); // создали переменную с которой получаем значения с ConfigProperties
    // файла
    String baseUrl; // переменная базовая урл
    String expectedUrl; //

    public ParentPage(WebDriver webdriver, String partUrl) { // конструктор ParentPage всегда называется как класс, не имеет типа возвращаемой переменной, partUrl - уникальная часть урд
        this.webdriver = webdriver; // this - это обращение к этому классу, переменная объявленная в этом классе будет равна тому, что прийдет из вне

        baseUrl = configProperties.base_url();

        PageFactory.initElements(webdriver, this); //PageFactory - класс который умеет инициализировать элементы от файнд бай
        // webdriver - говорим в каком браузере будем инициализировать, this - элементы какой страницы инициализируем, т.е. той с которой происходит обращение
        actionsWithOurElements = new ActionsWithOurElements(webdriver);

        expectedUrl = baseUrl + partUrl;
    }
    public void checkCurrentUrl(){
        try {
            Assert.assertEquals("URL is not expected",expectedUrl, webdriver.getCurrentUrl());

                }catch (Exception e){
            logger.error("Can not get url " + e);
            Assert.fail("Can not get url " + e);
        }
    }
}
