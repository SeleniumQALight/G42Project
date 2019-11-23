package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {




    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//input[@id='spares_spareName']")
    private WebElement inputSpareName;

    @FindBy(xpath = ".//select[@id='spares_spareType']")
    private WebElement dropDownList;

    @FindBy (name = "add")
    private WebElement submitButton;

    @FindBy (name = "delete")
    private WebElement buttonDelete;

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextInInput(inputSpareName, spareName);
    }

    public void selectSpareTypeFromDropDown(String itemName) {
        actionsWithOurElements.selectVisibleTextFromDropDownList(dropDownList, itemName);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
