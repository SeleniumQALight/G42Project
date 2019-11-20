package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {
    @FindBy (xpath = "//*[@class='btn btn-info btn-sm']")
    private WebElement addSpareButton;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(addSpareButton);
    }
}
