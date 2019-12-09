package pages.pageElements;

import libs.ActionWithOurElements;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class CommonActionWithElements extends HtmlElement implements WebDriverAware {
    protected WebDriver webDriver;
    protected ActionWithOurElements actionWithOurElements;
    @Override
    public void setWebDriver(WebDriver driver) {
        this.webDriver = driver;
        actionWithOurElements = new ActionWithOurElements(webDriver);
    }
}
