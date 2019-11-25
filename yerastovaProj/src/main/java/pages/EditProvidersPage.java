package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditProvidersPage extends ParentPage {

    @FindBy (xpath = "//input[@id = 'prov_cus_proCustIsFl']")
    private WebElement checkboxPrivatePerson;

    @FindBy (xpath = "//input[@id = 'prov_cus_isOurFirm']")
    private WebElement checkboxIsOurFirm;

    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setStateToCheckboxPrivatePerson(String expectedState) {
        actionsWithOurElements.setStateToCheckBox(checkboxPrivatePerson, expectedState);
    }

    public void setStateToCheckboxIsOurFirm(String expectedState) {
        actionsWithOurElements.setStateToCheckBox(checkboxIsOurFirm, expectedState);
    }
}
