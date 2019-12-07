package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
  @FindBy(id = "spares_spareName")

  private WebElement spareNameInput;

  @FindBy(id = "spares_spareType")

  private WebElement spareTypeDD;

  @FindBy ()
  private WebElement checkbox;

  @FindBy(name = "add")
  private WebElement submitButton;

  @FindBy(name = "delete")
  private WebElement deleteButton;

  public EditSparePage(WebDriver webDriver) {
    super(webDriver, "/dictionary/spares/edit");
  }

  public void enterSpareNameIntoIput(String spareName) {
    actionsWithOurElements.enterTextIntToInput(spareNameInput, spareName);
  }

  public void selectSpareTypeFromDropDown(String spareType) {
    actionsWithOurElements.selectVisibleTextInDDByJava(spareTypeDD, spareType);
  }

  public void clickOnSubmitButton() {
    actionsWithOurElements.clickOnElement(submitButton);
  }

  public void clickOnDeleteButton() {
    actionsWithOurElements.clickOnElement(deleteButton);
  }

  public void setCheckbox(String expectedState) {
    actionsWithOurElements.setSateToCheckBox(checkbox, expectedState);
  }
}


