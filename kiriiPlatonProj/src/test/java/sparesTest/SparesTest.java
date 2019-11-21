package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    String login = "Student";
    String password = "909090";
    final String spareName = "PlatonSpare";

    @After
    public void deleteSpareFromList(){
        sparePage.deleteSpareUntilPresent(spareName);
    }

    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmit(login, password);

        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.clickAddButton();

        editSparePage.addSpareName(spareName);
        editSparePage.selectSpareType("Датчики");
        editSparePage.clickCreateButton();

        checkExpectedResult("Cannot find spare in the list", sparePage.isSpareInList(spareName));

    }
}
