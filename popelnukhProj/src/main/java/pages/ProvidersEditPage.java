package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ProvidersEditPage extends ParentPage {
    @FindBy(id = "prov_cus_proCustName")
    private WebElement proCustName;
    @FindBy(id="prov_cus_proCustAddress")
    private WebElement proCustAdress;
    @FindBy(id="prov_cus_proCustPhone")
    private WebElement proCustPhone;
    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement privatePerson;
    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement isOurFirm;
    @FindBy(name="add")
    private WebElement submitButton;
    @FindBy(name = "save")
    private WebElement saveButton;

    public ProvidersEditPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/dictionary/providers/edit");
        }catch (Exception e){
            Assert.fail("Can't work with browser");
        }
    }

    public void enterProCustName(String provName) {
        actionsWithOurElements.enterTextIntoInput(proCustName, provName);
    }

    public void enterProCustAdress() {
        actionsWithOurElements.enterTextIntoInput(proCustAdress, "79VDV");
    }

    public void enterProCustPhone() {
        actionsWithOurElements.enterTextIntoInput(proCustPhone, "0500168806");
    }

    public void selectCheckboxPrivatePerson() {
        if(!privatePerson.isSelected()){
            privatePerson.click();
        }
    }

    public void selectCheckboxIsOurFirm() {
        if(!isOurFirm.isSelected()){
            isOurFirm.click();
        }
    }

    public void submitNewProvider() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void submitChangeInfoAboutProvider() {
        actionsWithOurElements.clickOnElement(saveButton);
    }

    public void deselectCheckboxPrivatePerson() {
        if(privatePerson.isSelected()){
            privatePerson.click();
        }
    }

    public void deselectCheckboxIsOurFirm() {
        if(isOurFirm.isSelected()){
            isOurFirm.click();
        }
    }
}