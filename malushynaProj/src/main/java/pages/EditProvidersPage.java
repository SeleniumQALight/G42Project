package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditProvidersPage extends ParentPage {

    @Override
    public String getExpectedUrl() {
        return "http://v3.test.itpmgroup.com/dictionary/providers/edit";
    }

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement privatePersonCheckbox;

    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement isOurFirmCheckbox;

    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setStateToPrivatePersonCheckbox(String expectedState) {
        actionsWithOurElements.setStateToCheckBox(privatePersonCheckbox, expectedState);
    }

    public void setStateToIsOurFirmCheckbox(String expectedState) {
        actionsWithOurElements.setStateToCheckBox(isOurFirmCheckbox, expectedState);
    }
}