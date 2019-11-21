package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {

    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement addButton;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }
}