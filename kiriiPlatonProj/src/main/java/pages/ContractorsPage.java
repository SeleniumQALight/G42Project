package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ContractorsPage extends ParentPage {
    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private WebElement addButton;

    @FindBy(xpath = ".//*[text()='Private person']/input")
    private WebElement checkBoxPrivatePerson;

    @FindBy(xpath = ".//*[text()='Is our firm']/input")
    private WebElement checkBoxIsOurFirm;

    public ContractorsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }


    public void selectCheckBoxPrivatePerson(String state) {
        actionsWithOurElements.selectCheckbox(checkBoxPrivatePerson, state);
    }

    public void selectCheckBoxIsOurFirm(String state) {
        actionsWithOurElements.selectCheckbox(checkBoxIsOurFirm, state);
    }

}
