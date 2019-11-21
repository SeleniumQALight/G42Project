package parentPage;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    protected WebDriver webDriver;
protected ActionsWithOurElements actionsWithOurElements;
    public ParentPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

   protected Logger logger = Logger.getLogger(getClass());










}
