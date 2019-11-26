package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDDClosed; //дропдаун в закрытом состоянии

    @FindBy(name = "add")
    private WebElement submitButton;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareNameIntoInput(String spareName) {
        actionsWithOurElements.enterTextIntoInput(spareNameInput, spareName);
    }

    public void selectSpareTypeFromDropdown(String spareType) {
        actionsWithOurElements.selectVisibleTextInDDbyJava(spareTypeDDClosed, spareType);
    }

    public void selectSpareTypeFromDropDownValue(String value) {
        try {
            actionsWithOurElements.selectValueInSpareDDXpathByOption(spareTypeDDClosed, value);
        } catch (Exception e) {
            logger.info("No such option in DropDown");
        }
    }

    public void selectSpareTypeFromDropDownText(String text) {
        try {
            actionsWithOurElements.selectValueInSpareDDXpathByText(spareTypeDDClosed, text);
        } catch (Exception e) {
            logger.info("No such option in DropDown");
        }
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
