package parentpage;

import libs.CommonActions;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {
    protected WebDriver driver;
    protected Logger log = Logger.getLogger(getClass());
    protected CommonActions commonActions;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expectedUrl;

    public ParentPage(WebDriver driver, String partialUrl) {
        this.driver = driver;
        baseUrl = configProperties.base_url();
        PageFactory.initElements(driver, this);
        commonActions = new CommonActions(driver);
        expectedUrl = baseUrl + partialUrl;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Found unexpected URL!", expectedUrl, driver.getCurrentUrl());
        } catch (Exception e) {
            log.error("Cannot get URL " + e);
            Assert.fail("Cannot get URL " + e);
        }
    }
}
