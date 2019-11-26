package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ProvidersPage extends ParentPage {

    @Override
    public String getExpectedUrl() {
        return "http://v3.test.itpmgroup.com/dictionary/providers";
    }

    @FindBy(xpath = ".//a[@class = 'btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton(){
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
