package parentPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    protected WebDriver webdriver; // чтоб создать конструктор на webdriver жмем Alt+Insert, выбираем конструктор, ок. С помощью конструктора можно параметризировать
    protected Logger logger = Logger.getLogger(getClass()); //getClass - сюда вводится назввание класса страницы, можно будет выбирать любую

    public ParentPage(WebDriver webdriver) {
        this.webdriver = webdriver;
        PageFactory.initElements(webdriver, this); //this - будет использоваться та страница, которую используем PageFactory - класс который умеет инициализировать элементы от файнд бай
    }
}
