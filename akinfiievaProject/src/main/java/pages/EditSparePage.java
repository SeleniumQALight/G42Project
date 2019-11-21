package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(xpath = ".//input[@id='spares_spareName']")
    private WebElement inputSpareName;
    @FindBy(xpath = ".//select[@id='spares_spareType']")
    private WebElement dropDownList;
    @FindBy(xpath = ".//button[@class='btn btn-info']")
    private WebElement createSpareButton;
    @FindBy(xpath = ".//button[@class='btn btn-danger pull-right']")
    private WebElement buttonDelete;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoInput(inputSpareName, spareName);
    }

    public void selectSpareTypeFromDropDown(String spareTypeName) {
        actionsWithOurElements.selectItemFromDropDownList(dropDownList, spareTypeName);
    }

    public void clickSpareTypeFromDropDownList(String spareTypeFromList) {
        actionsWithOurElements.clickOnElement(dropDownList);
        webDriver.findElement(By.xpath(".//*[contains(text(),'" + spareTypeFromList + "')]")).click();
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(createSpareButton);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
