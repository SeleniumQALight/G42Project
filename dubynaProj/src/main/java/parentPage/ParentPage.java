package parentPage;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithOurElements actionsWithOurElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class); //создание всех переменных из класса
    String baseUrl; //v3.test.itpmgroup.com/ envirnoment
    String expectedURL;


    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url(); //вытягивам переменную из файлика
       // PageFactory.initElements(webDriver, this);
        PageFactory.initElements(
                new HtmlElementDecorator(
                        new HtmlElementLocatorFactory(webDriver))
                ,this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        expectedURL = baseUrl + partUrl;

    }
    public void  checkCurrentUrl(){
        try {
            Assert.assertEquals(
                    "URL is not expected",
                    expectedURL,
                    webDriver.getCurrentUrl()
            );
        } catch (Exception e){
            logger.error("Can not get url " + e);
            Assert.fail("Can not get url " + e);
        }


    }

}
