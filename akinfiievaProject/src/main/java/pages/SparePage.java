package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {
    @FindBy(xpath = ".//div[@class='box-tools']//a[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;
    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
