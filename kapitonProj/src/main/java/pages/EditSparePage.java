package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
   @FindBy (id = "spares_spareName")
    private WebElement spareNameInput;
   @FindBy (id = "spares_spareType")
   private WebElement spareTypeDD;
    @FindBy (name = "add")
   private WebElement submitButton;
    @FindBy(name = "delete")
    private WebElement buttonDelete;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareNameInToInput(String spareName) {
        actionWithOurElements.enterTextInToInput(spareNameInput, spareName);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionWithOurElements.selectVisibleTextInDDByJava(spareTypeDD, spareType);
    }

    public void clickOnSubmitButton() {
        actionWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionWithOurElements.clickOnElement(buttonDelete);
    }
}
