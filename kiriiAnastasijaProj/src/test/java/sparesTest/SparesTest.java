package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;


public class SparesTest extends AbstractParentTest {
    @Test
    public void addNewSpare() {
        loginPage.fillLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.clickOnAddButton();
        editSparePage.enterSpareName("RadulenkoSpare");
        editSparePage.selectSpareTypeFromDropDown("Датчики");



    }
}
