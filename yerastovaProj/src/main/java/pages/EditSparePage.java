package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {


    @FindBy (xpath = "//input[@id='spares_spareName']")
    private WebElement inputSpareName;

    @FindBy (xpath = "//select[@id='spares_spareType']")
    private WebElement drillDownSpareType;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoInput(inputSpareName, spareName);

    }

    private WebElement spareTypeListValue(String spareType) {
        return webDriver.findElement(By.xpath(String.format("//select[@id='spares_spareType']/option[text()='%s']", spareType)));

    }


    public void selectSpareTypeFromDropDown(String spareType) {
        actionsWithOurElements.clickOnElement(drillDownSpareType);
       
        actionsWithOurElements.clickOnElement(spareTypeListValue(spareType));
    }

}

