package parentPage;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithOurElements actionsWithOurElements;
    String baseURL = "http://v3.test.itpmgroup.com";
    String expectedURL;

    public ParentPage(WebDriver webDriver, String partURL) {

        this.webDriver = webDriver;
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
