package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "spares_spareName")
    private WebElement enterSpareName;
    @FindBy(id = "spares_spareType")
    private WebElement clickOnSpareTypeDropdown;
    @FindBy (xpath = ".//*[@id='spares_spareType']")
    private WebElement clickOnSelectedDropdownSpareType;

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoInput(enterSpareName, spareName);
    }

    public void selectSpareTypeFromDropDown(String detailType) {
        actionsWithOurElements.clickOnElement(clickOnSpareTypeDropdown);
        actionsWithOurElements.selectOnDropdownElement(clickOnSelectedDropdownSpareType, detailType);

    }

}
