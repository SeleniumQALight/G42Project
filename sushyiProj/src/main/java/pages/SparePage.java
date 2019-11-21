package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement buttonAdd;

    private EditSparePage clickOnSparePage;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        //tyt isp Polimorfizm
        return actionsWithOurElements
                .isElementDisplayed(".//*[text()='" + spareName + "']");
    }

    public void deleteSpareUntilPresent(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
        //poka ne stanet False
        while (isSpareInList(spareName)){
            cllickOnSpare(spareName);
            editSparePage.clickOnDeleteButton();
            //чтоб он был не Вечным то сделаем Каунтер
        }

    }

    private void cllickOnSpare(String spareName) {
        actionsWithOurElements
                .clickOnElement(".//*[text()='" + spareName + "']");
    }
}
