package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {
    @FindBy(xpath = "//div//a[@data-original-title='Add']")
    private WebElement buttonAdd; // кнопка добавления аппаратов

    public SparePage(WebDriver webdriver) {
        super(webdriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) { // метод, который проверяет что запчасть добавилась
        return actionsWithOurElements.isElementDisplayed(".//*[text() = '" + spareName + "']"); // проверка есть ли эта запчасть, это параметризированный локато
        // в одинарных кавычках - наш текст; создаем метод
    }

    public void deleteSpareUntilPresent(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webdriver); // создаем екземпляр EditSparePage
        while (isSpareInList(spareName)){            // выполняет цикл пока выполняется условие (пока запчасть есть в цикле)
        clickOnSpare(spareName);
        editSparePage.clickOnDeleteButton();

        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements
                .clickOnElement(".//*[text()='" + spareName + "']"); // создать метод с икспасом
    }
}
