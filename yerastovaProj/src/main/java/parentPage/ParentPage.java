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
    String baseURL;
    String expectedURL;

    public ParentPage(WebDriver webDriver, String partURL) {

        this.webDriver = webDriver;
        baseURL = configProperties.base_url();
//        PageFactory.initElements(webDriver, this); //without yandex HTML elements
//        PageFactory.initElements(  //with yandex HTML elements
//                new HtmlElementDecorator(
//                        new HtmlElementLocatorFactory(webDriver))
//                ,this);
        PageFactory.initElements(new WebDriverAwareDecorator(new HtmlElementLocatorFactory(webDriver), webDriver), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedURL = baseURL + partURL;
    }

    public  void  checkCurrentUrl () {
        try {
            Assert.assertEquals("Url is not expected"
                    , expectedURL
                    , webDriver.getCurrentUrl());
        }catch (Exception e) {
            logger.error("Can not get URL " + e);
            Assert.fail("Can not get URL " + e);
        }
    }



}
