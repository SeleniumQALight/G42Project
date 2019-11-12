package parentPage;

import org.openqa.selenium.WebDriver;

public class ParentPage {
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebDriver webDriver;
}
