package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import parentPage.ParentPage;

public class SparePage extends ParentPage {
    @FindBy(xpath = ".//div[@class='box-tools']//a[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;
    @FindBy(xpath = ".//input[@id='spares_spareName']")
    private WebElement inputSpareName;
    @FindBy(xpath = ".//select[@id='spares_spareType']")
    private WebElement dropDownList;


    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoInput(inputSpareName, spareName);
    }

//    public void selectSpareTypeFromDropDown(String spareTypeName) {
//        actionsWithOurElements.selectItemFromDropDownList(dropDownList, spareTypeName);
//    }

    public void clickSpareTypeFromDropDownList(String spareTypeFromList) {
        actionsWithOurElements.clickOnElement(dropDownList);
        webDriver.findElement(By.xpath("//*[contains(text(),'"+spareTypeFromList+"')]")).click();
    }
}
