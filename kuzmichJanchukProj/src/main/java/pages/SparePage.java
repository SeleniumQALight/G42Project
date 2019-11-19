package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

public class SparePage extends ParentPage {

    @FindBy(xpath = "//*[@class = 'fa fa-plus']")
    WebElement buttonAdd;

    public SparePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddButton() {
        commonActions.clickOnElement(buttonAdd);
    }
}
