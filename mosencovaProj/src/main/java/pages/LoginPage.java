package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try{
            webDriver.get("http://v3.test.itpmgroup.com/login");

        }catch(Exception e) {
            Assert.fail("Can not work with browther");
        }
        }
    }

