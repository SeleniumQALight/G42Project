package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "PerskayaSpare"; // final - объявление константы, будет создавать запчасть PerskayaSpare и её же искать
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090"); // залогиниться
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.clickOnAddButton ();

        editSparePage.enterSpareNameIntoInput(spareName); // ввести имя запчасти в инпут
        editSparePage.selectSpareTypeFromDropDown("Датчики"); // выбрать запчасть из дропдауна
        editSparePage.clickOnSubmitButton(); // клик на кнопку
        checkExpectedResult("Can not find spare in list,", sparePage.isSpareInList(spareName)); // проверка, о том что добавлена запчасть

    }
    @After
    public void deleteSpare(){ //удаление запчасти
        sparePage.deleteSpareUntilPresent(spareName); // deleteSpareUntilPresent - м-д удаляет запчасти пока их находит

    }
}
