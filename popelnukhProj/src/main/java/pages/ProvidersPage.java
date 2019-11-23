package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ProvidersPage extends ParentPage {
    @FindBy(xpath = ".//*[@id='device_list']//tbody//tr[.//td[contains(text(),'BTR-80')]]")
    private WebElement btr80;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void findBTR80Provider() {
        actionsWithOurElements.clickOnElement(btr80);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/dictionary/providers");
        } catch (Exception e) {
            Assert.fail("Can't work with browser");
        }
    }

    public boolean isProviderInList(String providerName) {
        try {
            return actionsWithOurElements.isElementDisplayed(".//*[text()='" + providerName + "']");
        } catch (Exception e) {
            return false;
        }
    }
}