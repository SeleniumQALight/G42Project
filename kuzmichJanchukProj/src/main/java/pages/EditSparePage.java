package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class EditSparePage extends ParentPage {

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(name = "add")
    private WebElement submitButton;

    @FindBy(name = "delete")
    private WebElement deleteButton;

    public EditSparePage(WebDriver driver) {
        super(driver, "/dictionary/spares/edit");
    }

    public void enterSpareNameIntoInput(String spareName) {
        commonActions.enterTextIntoInput(spareNameInput, spareName);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        commonActions.selectVisibleTextInDDByJava(spareTypeDD, spareType);
    }

    public void clickOnSubmitButton() {
        commonActions.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        commonActions.clickOnElement(deleteButton);
    }
}
