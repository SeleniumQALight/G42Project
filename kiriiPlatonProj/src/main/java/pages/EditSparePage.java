package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {

    @FindBy(id = "spares_spareName")
    private WebElement spareName;

    @FindBy(id = "spares_spareType")
    private WebElement spareType;

    @FindBy(name = "add")
    private WebElement createButton;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addSpareName(String text) {
        actionsWithOurElements.enterTextIntoInput(spareName,text);
    }


    public void selectSpareType(String option) {
        actionsWithOurElements.selectOptionFromDropdown(spareType, option);
    }

    public void clickCreateButton() {
        actionsWithOurElements.clickOnElement(createButton);
    }
}
