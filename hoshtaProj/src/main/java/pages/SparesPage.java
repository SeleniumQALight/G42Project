package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parrentPage.ParentPage;

public class SparesPage extends ParentPage {
    public SparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//i[@class='fa fa-plus']")
    private WebElement addButton;


    public void checkIfAddButtonIsDisplayed(){
        Assert.assertTrue("\"Add\" button is not displayed", isAddButtonDisplayed());
    }

    private boolean isAddButtonDisplayed() {
        return actionsWithOurElements.isElementDisplayed(addButton);
    }

    public void clickAddButton() {
        actionsWithOurElements.clickElement(addButton);
    }
}
