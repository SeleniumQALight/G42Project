package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparesPage extends ParentPage {
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    public SparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpereInList(String spareName) {
        return actionsWithOurElements.IsElementDisplayed(".//*[text()='" + spareName + "']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        EditSparesPage editSparesPage = new EditSparesPage(webDriver);
        while (isSpereInList(spareName)) {
            clickOnSpare(spareName);
            editSparesPage.clickOnDeleteButton();
        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }
}
