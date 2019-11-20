package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class DictionarySparePage extends ParentPage {
    @FindBy (xpath = ".//table[@class= 'table table-hover']//tr[.//td[contains(text(),'Test Spare Name')]]")
    private WebElement newSpareForTest;
    @FindBy (xpath = ".//h1[contains( text ( ),'Запчасти')]")
    private WebElement headerSparesOnDictionaryPage;

    public DictionarySparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkNewSpare() {
        actionsWithOurElements.isElementDisplayed(newSpareForTest);
    }

    public void checkDictionaryPageisDisplayed() {
        actionsWithOurElements.isElementDisplayed(headerSparesOnDictionaryPage);
    }
}
