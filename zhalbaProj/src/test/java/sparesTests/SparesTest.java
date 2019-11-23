package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {

  private final String spareName = "ZhalbaSpare";

  @Test
  public void addNewSpare() {
    loginPage.fillingLoginFormAndSubmitIt("Student", "909090"); // clicked on vhod button
    homePage.checkIsAvatarDisplayed();
    homePage.clickOnMenuDictionary();
    homePage.clickOnSubMenuSpares();

    sparePage.clickOnAddButton();

    editSparePage.enterSpareNameIntoIput(spareName);
    editSparePage.selectSpareTypeFromDropDown("Датчики");
    editSparePage.clickOnSubmitButton();

    checkExpectedResult("Can't find spare in the list", sparePage.isSpareInList(spareName));
  }
 @After
  public void deleteSpare() {
    sparePage.deleteSpareUntilPresent(spareName);
 }

}
