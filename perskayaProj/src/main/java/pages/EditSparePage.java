package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(name = "add")
    private WebElement submitButton;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    @FindBy(id = "spares_spareType")
    private WebElement dropDownSpareType;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareNameIntoInput(String spareName) { // ввод имени запчасти
        actionsWithOurElements.enterTextInToInput(spareNameInput, spareName); // на spareNameInput альт+ентер / криейт филд
    }

        public void selectSpareTypeFromDropDown(String spareType) { // м-д выбора типа запчасти из дроп дауна
        actionsWithOurElements.clickOnElement(dropDownSpareType); // клик на дроп даун
        actionsWithOurElements.clickOnElement(spareTypeListValue(spareType));
    }

    private WebElement spareTypeListValue(String spareType) { // м-д который находит тип запчасти из вариантов в дропдауне
        return webdriver.findElement(By.xpath(String.format("//select[@id='spares_spareType']/option[text()='%s']", spareType)));
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton); // submitButton - переменная, жмем альт+ентер, криейт филд
    }

    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}