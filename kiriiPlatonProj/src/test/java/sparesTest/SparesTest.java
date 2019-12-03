package sparesTest;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    String login = "Student";
    String password = "909090";
    final String spareName = "PlatonSpare" + Utils.getDateAndTimeFormated();

    @After
    public void deleteSpareFromList(){
        sparePage.deleteSpareUntilPresent(spareName);
    }

    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmit(login, password);

        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);
        sparePage.clickAddButton();

        editSparePage.checkCurrentUrl();
        editSparePage.addSpareName(spareName);
        editSparePage.selectSpareType("Датчики");
        editSparePage.clickCreateButton();

        sparePage.checkCurrentUrl();
        checkExpectedResult("Cannot find spare in the list", sparePage.isSpareInList(spareName));

    }
}
