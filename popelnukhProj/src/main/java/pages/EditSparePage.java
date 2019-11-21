package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;
    @FindBy(id="spares_spareType")
    private WebElement dropDown;
    @FindBy(name = "add")
    private WebElement submitButton;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSpareNameIntoInput(String spareName) {
        actionsWithOurElements.enterTextIntoInput(spareNameInput, spareName);
    }

    public void selectFromDropDownTypeOfSpare(String spareType) {
        actionsWithOurElements.selectVisibleText(dropDown, spareType);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}