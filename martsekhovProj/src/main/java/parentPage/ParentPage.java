package parentPage;

import libs.ActionWithOurElements;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithOurElements actionWithOurElements;

    public ParentPage(WebDriver webDriver, String s) {
        this.webDriver = webDriver;
       // PageFactory.initElements(webDriver, this);
        PageFactory.initElements(
                new HtmlElementDecorator(
                        new HtmlElementLocatorFactory(webDriver))
                ,this);
        actionWithOurElements = new ActionWithOurElements(webDriver);
    }

}