package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {

  private final String spareName ="GitinaSpare";
    @Test
    public void adNewSpare() {
        logInPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.clickOnAddButton();
        editSparePage.enterSparenameIntoInput(spareName);
editSparePage.selectSpareTypeFromDropdown("Датчики");
editSparePage.clickOnSubmitButton();
checkExpectedResult("Cannot find spare in List", sparePage.isSpareInList(spareName));
    }
    @After
    public void deleteSpare(){
     sparePage.deleteSpareUntilPresent(spareName);
    }
}
