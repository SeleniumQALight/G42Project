package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {
    @FindBy(xpath = "//div//a[@data-original-title='Add']")
    private WebElement buttonAdd; // кнопка добавления аппаратов

    public SparePage(WebDriver webdriver) {
        super(webdriver);
    }

    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }
}
