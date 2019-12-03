package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;


public class SparePage extends ParentPage {

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;


    public SparePage(WebDriver webDriver) {

        super(webDriver, "/dictionary/spares");
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }


    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text() ='" + spareName + "']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        int counter = 0;
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)){                                       //удаляет ранее добавленный пункт (запчасть), пока он не перестанет находиться в списке
            clickOnSpare (spareName);
            editSparePage.clickOnDeleteButton();
            logger.info(counter + " spare was deleted");
            if (counter > 100) {
                Assert.fail("There are more then 100 spares.");  //останавливаем тест, если после 100 удалений запчасть все еще есть в списке
            }
            counter ++;   // к каждому удалению добавляем 1, пока не будет 100 попыток
        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }
}

