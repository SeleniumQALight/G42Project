package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparesPage extends ParentPage {
    @FindBy(xpath = "//*[@class = 'fa fa-plus']")
    private WebElement buttonAdd;


    public SparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
        actionWithOurElements.clickOnElement(buttonAdd);
    }
}
