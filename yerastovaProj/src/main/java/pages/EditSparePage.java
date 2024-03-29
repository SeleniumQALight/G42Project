package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {

//
    @FindBy (xpath = "//input[@id='spares_spareName']")
    private WebElement inputSpareName;

    @FindBy (xpath = "//select[@id='spares_spareType']")
    private WebElement drillDownSpareType;

    @FindBy (id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(name = "add")
    private WebElement submitButton;

    @FindBy (name = "delete")
    private WebElement deleteButton;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }


    public void enterSpareNameIntoInput(String spareName) {
        actionsWithOurElements.enterTextIntoInput(inputSpareName, spareName);

    }

    private WebElement spareTypeListValue(String spareType) {
        return webDriver.findElement(By.xpath(String.format("//select[@id='spares_spareType']/option[text()='%s']", spareType)));

    }


//    public void selectSpareTypeFromDropDown(String spareType) {
//        actionsWithOurElements.clickOnElement(drillDownSpareType);
//
//        actionsWithOurElements.clickOnElement(spareTypeListValue(spareType));
//    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectVisibleTextInDDByJava(spareTypeDD, spareType);

        actionsWithOurElements.clickOnElement(spareTypeListValue(spareType));
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(deleteButton);
    }
}

