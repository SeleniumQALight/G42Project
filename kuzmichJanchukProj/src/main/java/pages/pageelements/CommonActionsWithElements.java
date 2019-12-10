package pages.pageelements;

import libs.CommonActions;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class CommonActionsWithElements extends HtmlElement implements WebDriverAware {

    protected WebDriver driver;
    protected CommonActions commonActions;

    @Override
    public void setWebDriver(WebDriver driver) {
        this.driver= driver;
        commonActions = new CommonActions(driver);
    }
}
