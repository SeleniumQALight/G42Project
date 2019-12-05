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
//    String baseUrl = "http://v3.test.itpmgroup.com";
    String baseUrl;
    String expectedUrl;

    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
//        PageFactory.initElements(webDriver, this);
//        PageFactory.initElements(
//                new HtmlElementDecorator(
//                        new HtmlElementLocatorFactory(webDriver))
//                ,this);
        PageFactory.initElements(new WebDriverAwareDecorator(new HtmlElementLocatorFactory(webDriver), webDriver), this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedUrl = baseUrl + partUrl;
    }

//    abstract public String getExpectedUrl();

//    public boolean checkCurrentUrl() {
//        String actualUrl = webDriver.getCurrentUrl();
//        if (actualUrl.equals(getExpectedUrl())) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void checkCurrentUrl(){
        try{
            Assert.assertEquals("URL is not expected", expectedUrl, webDriver.getCurrentUrl());
        } catch (Exception e){
            logger.error("Can not get URL " + e);
            Assert.fail("Can not get URL " + e);
        }
    }

}