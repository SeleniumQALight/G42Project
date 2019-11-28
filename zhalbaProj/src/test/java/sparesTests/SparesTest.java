package sparesTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {

  private final String spareName = "ZhalbaSpare" + Utils.getDateAndTimeFormated();


  @Test
  public void addNewSpare() {
    loginPage.fillingLoginFormAndSubmitIt("Student", "909090"); // clicked on vhod button

    homePage.checkCurrentUrl();
    homePage.checkIsAvatarDisplayed();
    homePage.clickOnMenuDictionary();
    homePage.clickOnSubMenuSpares();

    sparePage.checkCurrentUrl();
    sparePage.deleteSpareUntilPresent(spareName);
    sparePage.clickOnAddButton();

    editSparePage.checkCurrentUrl();
    editSparePage.enterSpareNameIntoIput(spareName);
    editSparePage.selectSpareTypeFromDropDown("Датчики");
    editSparePage.clickOnSubmitButton();

    sparePage.checkCurrentUrl();
    checkExpectedResult("Can't find spare in the list", sparePage.isSpareInList(spareName));
  }

  @After
  public void deleteSpare() {
    sparePage.deleteSpareUntilPresent(spareName);
  }

}
