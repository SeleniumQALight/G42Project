package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ProvidersPage extends ParentPage {
    @FindBy(xpath ="//div//a[@data-original-title='Add']")
    private WebElement addButton;
    public ProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }
}
