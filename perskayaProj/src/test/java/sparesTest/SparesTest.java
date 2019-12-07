package sparesTest;

import Libs.Utils;
import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "PerskayaSpare" + Utils.getDateAndTimeFormated(); // final - объявление константы, будет создавать запчасть PerskayaSpare и её же искать
   // к фамилии доклеиваем дату и время с помощью класса Utils и метода getDateAndTimeFormated
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090"); // залогиниться
        homePage.checkCurrentUrl(); // проверка попали ли мы на homePage
        homePage.checkIsAvatarPresent();
//        homePage.clickOnMenuDictionary();
//        homePage.clickOnSubMenuSpares();
        homePage.leftMenu.clickOnMenuDictionary();
        homePage.leftMenu.clickOnSubMenuSpare();

        sparePage.checkCurrentUrl(); // проверка попали ли мы на sparePage
        sparePage.deleteSpareUntilPresent(spareName); // удалить запчасть, если такая уже есть до теста

        sparePage.clickOnAddButton ();

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareNameIntoInput(spareName); // ввести имя запчасти в инпут
        editSparePage.selectSpareTypeFromDropDown("Датчики"); // выбрать запчасть из дропдауна
        editSparePage.clickOnSubmitButton(); // клик на кнопку

        sparePage.checkCurrentUrl();
        checkExpectedResult("Can not find spare in list,", sparePage.isSpareInList(spareName)); // проверка, о том что добавлена запчасть
        }
    @After
    public void deleteSpare(){ //удаление запчасти
        sparePage.deleteSpareUntilPresent(spareName); // deleteSpareUntilPresent - м-д удаляет запчасти пока их находит

    }
}
