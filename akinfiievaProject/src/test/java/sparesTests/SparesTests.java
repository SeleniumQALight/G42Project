package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SparesTests extends AbstractParentTest {
    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmitIt("Student","909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();

        sparePage.clickOnButtonAdd();
        final String spareName = "AkinfiievaSpare";
        sparePage.enterSpareName(spareName);
        sparePage.selectSpareTypeFromDropDown("Датчики");

    }
}
