package sparesTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

/**
 * Created by Андрей Гугля on 19.11.2019.
 */
public class SparesTest extends AbstractParentTest {
    private final String spareName = "guglyaSpare" + Utils.getDateAndTimeFormated();


    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
//        homePage.clickOnMenuDictionary();
//        homePage.clickOnSubMenuSpares();
        homePage.leftMenu.clickOnMenuDictionary();
        homePage.leftMenu.clickOnSubMenuSpare();

        sparePage.checkCurrentUrl();


        sparePage.deleteSpareUntilPresent(spareName);

        sparePage.clickOnAddButton();

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();

        sparePage.checkCurrentUrl();
        checkExpextedResult("Can not find spare in list", sparePage.isSpareInList(spareName));



    }
    @After
    public void deleteSpare(){
        sparePage.deleteSpareUntilPresent(spareName);
    }
}
