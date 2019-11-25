package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import parentPage.ParentPage;


public class SparePage extends ParentPage {
    @FindBy(xpath = ".//div[@class='box-tools']//a[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareAddedToDictionary(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text()='" + spareName + "']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareAddedToDictionary(spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickButtonDelete();

        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }
}
