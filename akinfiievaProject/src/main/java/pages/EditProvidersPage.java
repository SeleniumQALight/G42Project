package pages;

import javafx.scene.Parent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditProvidersPage extends ParentPage {
    @FindBy(id = "prov_cus_proCustName")
    private WebElement enterProCustName;
    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement enterProCustAddress;
    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement enterProCustPhone;
    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement checkIfPrivatePerson;
    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement checkIfIsOurFirm;

    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterProCustName(String proCustName) {
        actionsWithOurElements.enterTextIntoInput(enterProCustName, proCustName);
    }

    public void enterProCustAddress(String proCustAddress) {
        actionsWithOurElements.enterTextIntoInput(enterProCustAddress, proCustAddress);
    }

    public void enterProCustPhone(String proCustPhone) {
        actionsWithOurElements.enterTextIntoInput(enterProCustPhone, proCustPhone);
    }

    public void checkIfPrivatePerson(String isPrivatePerson) {
        actionsWithOurElements.setStateToCheckBox(checkIfPrivatePerson, isPrivatePerson);
    }

    public void checkIfIsOurFirm(String isOurFirm) {
        actionsWithOurElements.setStateToCheckBox(checkIfIsOurFirm, isOurFirm);
    }
}