package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparesPage extends ParentPage {
    @FindBy(xpath = "//*[@class = 'fa fa-plus']")
    private WebElement buttonAdd;


    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnAddButton() {
        actionWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionWithOurElements.isElementDisplayed(".//*[text()='" + spareName + "']"); //параматризированый локатор
    }

    public void deleteSpareUntilPresent(String spareName) {
        int counter = 0;
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickOnDeleteButton();
            logger.info(counter + " spare was deleted");
            if (counter > 100) {
                Assert.fail("There are more then 100 spares.");
            }
            counter ++;
        }
    }

    private void clickOnSpare(String spareName) {
        actionWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }
}
