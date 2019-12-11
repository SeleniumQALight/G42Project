package pages.pageElements;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class CommonActionsWithElements extends HtmlElement implements WebDriverAware {
    protected WebDriver webDriver;
    protected ActionsWithOurElements actionsWithOurElements;

    @Override
    public void setWebDriver(WebDriver driver) {
        this.webDriver = driver;
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}