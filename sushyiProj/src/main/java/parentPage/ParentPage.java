package parentPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        // sozdaem tut Logger


    }

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());


}
