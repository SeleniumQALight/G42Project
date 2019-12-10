package sparesTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest{
    //Ykazat tut Nomer testa!? желательно в если  АПИ исп метод Удаляющий сущности
    private  final String spareName = "TC1002-RasulenkoSpare" + Utils.getDateAndTimeFormated();
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
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();

        sparePage.checkCurrentUrl();
        checkExpectedResult("Can not find spare in list"
        , sparePage.isSpareInList(spareName));

    }
// za soboi ydalaem
    @After
    public void deleteSpare(){
        sparePage.deleteSpareUntilPresent(spareName);
    }
}
