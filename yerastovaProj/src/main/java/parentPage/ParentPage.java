package parentPage;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
        PageFactory.initElements(webDriver, this);
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
