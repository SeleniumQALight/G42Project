package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {

//    @Override
//    public String getExpectedUrl() {
//        return "http://v3.test.itpmgroup.com/dictionary/spares/edit";
//    }

    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropdownList;

    @FindBy(name = "add")
    private WebElement submitButton;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareNameIntoInput(String spareName) {
        actionsWithOurElements.enterTextIntoInput(inputSpareName, spareName);
    }

    public void selectSpareTypeFromDropDown(String value) {
        actionsWithOurElements.selectValueFromDropdownList(spareTypeDropdownList, value);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
