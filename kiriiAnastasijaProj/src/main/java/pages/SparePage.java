package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {

    @FindBy(xpath = ".//*[@class = 'fa fa-plus']")
    private WebElement addSpareButton;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(addSpareButton);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text() ='" + spareName + "']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickDeleteButton();

        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(".//*[text() = '" + spareName + "']");
    }
}
