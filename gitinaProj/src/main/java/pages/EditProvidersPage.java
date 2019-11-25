package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditProvidersPage extends ParentPage {
    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement privatePersonCheckbox;

    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement isOUrFirmCheckbox;

    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }



    public void clickOnPrivatePersonCheckbox() {
        actionsWithOurElements.clickOnElement(privatePersonCheckbox);
    }

    public void clickOnIsOurFirmCheckbox() {
        actionsWithOurElements.clickOnElement(isOUrFirmCheckbox);
    }


    public boolean isPrivatePersonCheckboxSelected(){
            boolean isPrivatePersonCheckboxSelected = actionsWithOurElements.isCheckboxSelected(privatePersonCheckbox);
            logger.info("Private Person Checkbox is selected: "+ isPrivatePersonCheckboxSelected);
        return isPrivatePersonCheckboxSelected;
    }

    public boolean IsOUrFirmCheckboxSelected(){
        boolean isOurFirmCheckboxSelected = actionsWithOurElements.isCheckboxSelected(isOUrFirmCheckbox);
        logger.info("Is Our Firm Check Box is selected: "+ isOurFirmCheckboxSelected);
        return isOurFirmCheckboxSelected;
    }

}
