package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;

public class SparePage extends ParentPage {

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private Button addButton;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text()='" + spareName + "']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        int counter = 0;
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickDeleteButton();
            logger.info(counter + " spare was deleted");
            if (counter>100){
                Assert.fail("There are more then 100 spares");
            }
            counter++;
        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }
}
