package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;
//    @FindBy(id ="spares_spareType")
//    private WebElement spareTypeField;
//    @FindBy(xpath = ".//*[@class='form-control']/*[text()='Датчики']")
//    private WebElement spareTypeName;
    @FindBy (name = "add")
    private WebElement submitButton;
    @FindBy (id = "spares_spareType")
    private WebElement spareTypeDD;
    @FindBy (name = "delete")
    private WebElement buttonDelete;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareNameInToInput(String spareName) {
        actionsWithOurElements.enterTextInToInput(inputSpareName, spareName);
    }

//    public void selectSpareTypeFromDropDown() {
//        actionsWithOurElements.clickOnElement(spareTypeField);
//        actionsWithOurElements.clickOnElement(spareTypeName);

    public void selectSpareTypeFromDropDown (String spareType){
        actionsWithOurElements.selectVisibleTextInDDByJava (spareTypeDD, spareType);
    }
    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
