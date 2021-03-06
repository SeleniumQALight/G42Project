package parentPage;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.pageElements.WebDriverAwareDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithOurElements actionsWithOurElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expectedUrl;

    //создание конструктора что б каждый класс не открывал свой браузер
    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
//        PageFactory.initElements(webDriver, this);
//        PageFactory.initElements(
//                new HtmlElementDecorator(
//                        new HtmlElementLocatorFactory(webDriver))
//                ,this);
        PageFactory.initElements(
                new WebDriverAwareDecorator(
                        new HtmlElementLocatorFactory(webDriver), webDriver), this);
        expectedUrl = baseUrl + partUrl;
    }

    public void checkCurrentUrl(){
        try {
            Assert.assertEquals("URL is unexpected", expectedUrl, webDriver.getCurrentUrl());
        } catch (Exception e) {
            logger.error("Cannot get URL " + e);
            Assert.fail("Cannot get URL " + e);
        }
    }

}
