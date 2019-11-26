package parentPage;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    abstract public String getExpectedUrl();

    public boolean checkCurrentUrl() {
        String actualUrl = webDriver.getCurrentUrl();
        if (actualUrl.equals(getExpectedUrl())) {
            return true;
        } else {
            return false;
        }
    }

}