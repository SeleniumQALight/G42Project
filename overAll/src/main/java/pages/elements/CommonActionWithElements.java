package pages.elements;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


public class CommonActionWithElements extends HtmlElement implements WebDriverAware {
    private WebDriver driver = null;
    ActionsWithOurElements actionsWithOurElements ;

    @Override
    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
        actionsWithOurElements = new ActionsWithOurElements(driver);
    }
}
