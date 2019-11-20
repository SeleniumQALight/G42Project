package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {
    @FindBy(xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement addSpareButton;
    @FindBy(xpath = ".//h1[contains( text ( ),'Запчасти')]")
    private WebElement headerSparesOnDictionaryPage;
    @FindBy (xpath = ".//table[@class= 'table table-hover']//tr[.//td[contains(text(),'DubynaSpare')]]")
    private WebElement spareName;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(addSpareButton);
    }


    public void checkNewSpare() {
        actionsWithOurElements.isElementDisplayed(spareName);
    }

    public void checkDictionaryPageisDisplayed() {
        actionsWithOurElements.isElementDisplayed(headerSparesOnDictionaryPage);
    }
}
