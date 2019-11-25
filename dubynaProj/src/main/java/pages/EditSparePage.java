package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(xpath = "//*[@name='add']")
    private WebElement createSpareButton;
    @FindBy(id = "spares_spareName")
    private WebElement spareNameField;
    //@FindBy(id = "spares_spareType")
//private WebElement spareTypeField;
    @FindBy(id = "spares_spareType")
    private WebElement spareTypeList;
    @FindBy(xpath = "//option[@value = '4']")
    private WebElement spareTypeDatchiki;
    @FindBy (id = "spares_spareType")
    private WebElement spareTypeDD;
    @FindBy (name = "delete")
    private WebElement buttonDelete;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean buttonCreateIsDisplayed() {
        try {
            WebElement createSpareButton = webDriver.findElement(By.xpath("//*[@name='add']"));
            return createSpareButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnCreateSpareButton() {
        actionsWithOurElements.clickOnElement(createSpareButton);
    }


    public void inputSpareNameIntoSpareNameField(String spareName) {


        actionsWithOurElements.enterTextIntoInput(spareNameField, spareName);
    }

    public void selectSpareTypeFromDropDown() {
        actionsWithOurElements.clickOnElement(spareTypeList);
        actionsWithOurElements.clickOnElement(spareTypeDatchiki);
    }

    public void selectSpareTypeFromDropDownMethodJava(String spareType) {
        actionsWithOurElements.selectVisibleTextInDDByJava(spareTypeDD, spareType);
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}


