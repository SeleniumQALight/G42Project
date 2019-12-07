package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

//    @FindBy(xpath = "//*[@class='btn btn-info btn-sm']")
//    private WebElement addSpareButton;
//    @FindBy(xpath = ".//h1[contains( text ( ),'Запчасти')]")
//    private WebElement headerSparesOnDictionaryPage;
//    @FindBy (xpath = ".//table[@class= 'table table-hover']//tr[.//td[contains(text(),'MoiseyenkoSpare')]]")
//    private WebElement spareName;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

//    public void checkNewSpare() {
//        actionsWithOurElements.isElementDisplayed(spareName);
//    }

//    public void checkDictionaryPageisDisplayed() {
//        actionsWithOurElements.isElementDisplayed(headerSparesOnDictionaryPage);
//    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text() = '" + spareName + "']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        int counter = 0;
        EditSparePage editSparePage = new EditSparePage( webDriver);
        while (isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickOnDeleteButton();
            logger.info(counter +  "spare was deleted");
            if (counter > 100) {
                Assert.fail("There are more than 100 spares");
            }
            counter ++;
        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(".//*[text()= '" + spareName + "']");
    }
}
