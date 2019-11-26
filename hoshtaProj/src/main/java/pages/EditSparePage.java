package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parrentPage.ParentPage;

public class EditSparePage extends ParentPage {
    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    @FindBy(name = "delete")
    private WebElement deleteButton;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropdown;

    @FindBy(id = "spares_spareName")
    private WebElement spareName;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement createButton;

    private WebElement getDropdownValueElement(String value){
        return webDriver.findElement(By.xpath(String.format("//option[text()='%s']", value)));
    }

    private boolean isCreateButtonDisplayed() {
        return actionsWithOurElements.isElementDisplayed(createButton);
    }

    public void checkIfCreateButtonIsDisplayed() {
        Assert.assertTrue("\"Create\" button is not displayed", isCreateButtonDisplayed());
    }

    public void inputSpareName(String text){
        actionsWithOurElements.enterTextIntoInput(spareName, text);
    }

    public void expandSpareTypeDropdownAndSelectValue(String value) {
        actionsWithOurElements.clickElement(spareTypeDropdown);
        actionsWithOurElements.clickElement(getDropdownValueElement(value));
    }

    public void clickCreateButton() {
        actionsWithOurElements.clickElement(createButton);
    }

    public void clickDeleteButton() {
        actionsWithOurElements.clickElement(deleteButton);
    }

    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.selectVisibleTextInDDByJava(spareTypeDropdown, spareType);
    }
}
