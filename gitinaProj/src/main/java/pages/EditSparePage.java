package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD; //дропдаун в закрытом состоянии
    @FindBy(name = "add")
    private WebElement submitButton;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSparenameIntoInput(String spareName) {
        actionsWithOurElements.enterTextIntoInput(spareNameInput, spareName);
    }

    public void selectSpareTypeFromDropdown(String spareType) {
        actionsWithOurElements.selectVisibleTextinDDbyJava(spareTypeDD, spareType);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
