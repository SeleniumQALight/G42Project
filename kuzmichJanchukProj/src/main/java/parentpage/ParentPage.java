package parentpage;

import libs.CommonActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    protected WebDriver driver;
    protected Logger log = Logger.getLogger(getClass());
    protected CommonActions commonActions;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        commonActions = new CommonActions(driver);
    }
}
