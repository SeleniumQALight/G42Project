package parentPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    protected WebDriver webDriver;

    public ParentPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

   protected Logger logger = Logger.getLogger(getClass());










}
