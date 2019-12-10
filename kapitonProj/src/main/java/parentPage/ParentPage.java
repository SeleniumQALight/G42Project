package parentPage;

import libs.ActionWithOurElements;
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
    protected ActionWithOurElements actionWithOurElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);//создали переменную  которую хотим получить все из класса
   // String baseUrl = "http://v3.test.itpmgroup.com";
    String baseUrl;
    String expectedUrl;



    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
       // PageFactory.initElements(webDriver, this);
//        PageFactory.initElements(
//                new HtmlElementDecorator(
//                        new HtmlElementLocatorFactory(webDriver))
//                ,this);
        PageFactory.initElements(new WebDriverAwareDecorator(new HtmlElementLocatorFactory(webDriver), webDriver), this);

        actionWithOurElements = new ActionWithOurElements(webDriver);
        expectedUrl = baseUrl + partUrl;


    }public void checkCurrentUrl(){
        try {
            Assert.assertEquals("URL is not expected ", expectedUrl, webDriver.getCurrentUrl());

        }catch (Exception e){
            logger.error("Can not get url " + e);
            Assert.fail("Can not get url " + e);
        }


    }


}
