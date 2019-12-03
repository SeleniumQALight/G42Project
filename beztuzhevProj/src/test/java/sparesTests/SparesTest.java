package sparesTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class
SparesTest extends AbstractParentTest {

    private final String spareName = "BeztuzhevSpare" + Utils.getDateAndTimeFormated();   //добавляет системное время

    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName); //удалить запчасть, перед внесением ее имени, если она уже есть в списке
        sparePage.clickOnAddButton();

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();

        checkExpectedResult("Can not find spare in list", sparePage.isSpareInList(spareName));
    }

    @After
    public void deleteSpare() {
        sparePage.deleteSpareUntilPresent(spareName);

    }

}
