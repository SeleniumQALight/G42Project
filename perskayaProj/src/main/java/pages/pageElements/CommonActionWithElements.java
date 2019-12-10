package pages.pageElements;

import Libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class CommonActionWithElements extends HtmlElement implements WebDriverAware {
    protected WebDriver webDriver;
    protected ActionsWithOurElements actionsWithOurElements;

    @Override
    public void setWebDriver(WebDriver driver) {
       this.webDriver = driver; // появился драйвер который можем использовать в елементах
       actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}
