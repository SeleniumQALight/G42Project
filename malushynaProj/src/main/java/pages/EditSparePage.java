package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {

    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropdownList;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoInput(inputSpareName, spareName);
    }

    public void selectSpareTypeFromDropDown(String text) {
        actionsWithOurElements.selectItemFromDropdownList(spareTypeDropdownList, text);
    }
}
