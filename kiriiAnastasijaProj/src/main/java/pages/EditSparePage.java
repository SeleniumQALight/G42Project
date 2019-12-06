package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(name = "add")
    private WebElement submitButton;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    @FindBy(id = "spares_spareName")
    private WebElement enterSpareName;
    @FindBy(id = "spares_spareType")
    private WebElement clickOnSpareTypeDropdown;
//    @FindBy (xpath = ".//*[@id='spares_spareType']")
//    private WebElement clickOnSpareTypeDropdown;


    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoInput(enterSpareName, spareName);
    }

    public void selectSpareTypeFromDropDown(String value) {
//        actionsWithOurElements.clickOnElement(clickOnSpareTypeDropdown);

        actionsWithOurElements.selectInDropdownElement(clickOnSpareTypeDropdown, value);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
