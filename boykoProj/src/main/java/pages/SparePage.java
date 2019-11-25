package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {

    @FindBy (xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonAdd;
    @FindBy(xpath = ".//tr[.//td[text()='Датчики']]//td[text()='BoykoZhannaSpare1']")
    private WebElement spareName;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
                actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareDisplayed () {
        return actionsWithOurElements.isElementDisplayed(spareName);
    };
}
