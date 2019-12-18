package parentPage;

import libs.ActionWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {
    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
  //      PageFactory.initElements(webDriver, this);
        //above one commented cuz we added yandex library = block down
        PageFactory.initElements(
                new HtmlElementDecorator(
                        new HtmlElementLocatorFactory(webDriver)),
                this
        );

        actionWithOurElements = new ActionWithOurElements(webDriver);
        expectedUrl = baseUrl + partUrl;
    }

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithOurElements actionWithOurElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expectedUrl;


    public void checkCurrentUrl (){
        try {
            Assert.assertEquals("URL is not expected.", expectedUrl,  webDriver.getCurrentUrl());

        }catch (Exception e){
            logger.error("Can't get URL " + e);
            Assert.fail("Can't get URL " + e);
        }
    }




}
