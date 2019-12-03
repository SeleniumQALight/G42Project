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

  String baseUrl;
  String expectedUrl;

  public ParentPage(WebDriver webDriver, String partUrl) {
    this.webDriver = webDriver;
    baseUrl = configProperties.base_url();
    PageFactory.initElements(webDriver, this);
    actionsWithOurElements = new ActionsWithOurElements(webDriver);
    expectedUrl = baseUrl + partUrl;
  }

  public void checkCurrentUrl() {
    try {
Assert.assertEquals("not expected URL", expectedUrl, webDriver.getCurrentUrl());
    } catch (Exception e){
      logger.error("Can't get URL " + e);
      Assert.fail("Can't get URL " + e);
    }
  }
}

