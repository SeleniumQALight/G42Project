package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareType;

    @FindBy(name = "add")
    private WebElement createButton;

    @FindBy(name = "delete")
    private WebElement deleteButton;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void addSpareName(String name) {
        actionsWithOurElements.enterTextIntoInput(spareNameInput, name);
    }


    public void selectSpareType(String option) {
        actionsWithOurElements.selectOptionByTextFromDropdown(spareType, option);
    }

    public void clickCreateButton() {
        actionsWithOurElements.clickOnElement(createButton);
    }

    public void clickDeleteButton() {
        actionsWithOurElements.clickOnElement(deleteButton);
    }
}
