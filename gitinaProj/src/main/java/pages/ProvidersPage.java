package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ProvidersPage extends ParentPage {

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

}
