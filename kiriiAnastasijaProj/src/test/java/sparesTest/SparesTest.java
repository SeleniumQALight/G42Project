package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "TestSpare";

    @Test
    public void addNewSpare() {
        loginPage.fillLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.clickOnAddButton();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("4");
        editSparePage.clickOnSubmitButton();

        checkExpectedResult("Can not find spare in list",
                sparePage.isSpareInList(spareName));
    }
    @After
    public void deleteSpare(){
        sparePage.deleteSpareUntilPresent(spareName);
    }

}
