package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

import java.util.concurrent.TimeUnit;

public class ProvidersPage extends ParentPage {
    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    @FindBy(xpath = ".//*[@class = 'fa fa-plus']")
    private WebElement addProviders;

    public void clickOnAddProviderButton() {
        actionsWithOurElements.clickOnElement(addProviders);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
