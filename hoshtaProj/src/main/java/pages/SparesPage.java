package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parrentPage.ParentPage;

public class SparesPage extends ParentPage {
    public SparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//tbody/tr[last()]/td[1]")
    private WebElement lastSpareName;

    @FindBy(xpath = "//tbody/tr[last()]/td[2]")
    private WebElement lastSpareType;

    @FindBy(xpath = "//i[@class='fa fa-plus']")
    private WebElement addButton;

    public void checkIfAddButtonIsDisplayed() {
        Assert.assertTrue("\"Add\" button is not displayed", isAddButtonDisplayed());
    }

    private boolean isAddButtonDisplayed() {
        return actionsWithOurElements.isElementDisplayed(addButton);
    }

    public void clickAddButton() {
        actionsWithOurElements.clickElement(addButton);
    }

    public String getLastSpareName() {
        return actionsWithOurElements.getText(lastSpareName);
    }

    public String getLastSpareType() {
        return actionsWithOurElements.getText(lastSpareType);
    }

    public void clickRow(String spareName) {
        By tableRow = By.xpath(String.format("//tr[./td[1][text()='%s']]", spareName));
        actionsWithOurElements.clickElement(webDriver.findElement(tableRow));
    }
}