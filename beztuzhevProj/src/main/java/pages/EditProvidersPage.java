package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditProvidersPage extends ParentPage {
    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@id = 'prov_cus_proCustIsFl']")
    private WebElement privatePersonCheckbox;

    public void privatePersonCheckbox(String expectedState) {
        actionsWithOurElements.setStateToCheckBox(privatePersonCheckbox, expectedState);
    }
}