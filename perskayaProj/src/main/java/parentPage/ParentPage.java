package parentPage;

import Libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    protected WebDriver webdriver; // чтоб создать конструктор на webdriver жмем Alt+Insert, выбираем конструктор, ок. С помощью конструктора можно параметризировать
    protected Logger logger = Logger.getLogger(getClass()); //getClass - сюда вводится назввание класса страницы, в которой будет выполняться вызов
    // можно будет выбирать любую
//Logger - тип переменной, имя класса; говорим дай нам объект, который будет писать лог страницы
    protected ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webdriver) { // конструктор ParentPage всегда называется как класс, не имеет типа возвращаемой переменной
        this.webdriver = webdriver; // this - это обращение к этому классу, переменная объявленная в этом классе будет равна тому, что прийдет из вне
        PageFactory.initElements(webdriver, this); //PageFactory - класс который умеет инициализировать элементы от файнд бай
        // webdriver - говорим в каком браузере будем инициализировать, this - элементы какой страницы инициализируем, т.е. той с которой происходит обращение

        actionsWithOurElements = new ActionsWithOurElements(webdriver);
    }
}
