package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parrentPage.ParentPage;

public class DictionaryPage extends ParentPage {
    public DictionaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "spares_spareName")
    private WebElement spareName;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement createButton;

    public void checkIfCreateButtonIsDisplayed() {
        Assert.assertTrue("\"Create\" button is not displayed", isCreateButtonDisplayed());
    }

    private boolean isCreateButtonDisplayed() {
        return actionsWithOurElements.isElementDisplayed(createButton);
    }

    public void inputSpareName(String text){
        actionsWithOurElements.enterTextIntoInput(spareName, text);
    }
}
