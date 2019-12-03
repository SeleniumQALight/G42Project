package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

/**
 * Created by Андрей Гугля on 21.11.2019.
 */
public class EditSparePage extends ParentPage{
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropD;

    @FindBy(name = "add")
    private WebElement submitButton;

    @FindBy(name ="delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareNameInToInput(String spareName) {
        actionsWithOurElements.enterTextInToInput(spareNameInput, spareName);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectVisibleTextInDropDByJava(spareTypeDropD, spareType);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
