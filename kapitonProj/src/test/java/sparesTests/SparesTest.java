package sparesTests;

        import abstractParentTest.AbstractParentTest;
        import libs.Utils;
        import org.junit.After;
        import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "KapitonSpare " + Utils.getDateAndTimeFormated() ;
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmit("Student", "909090");

        homePage.checkCurrentUrl();//проверка попали ли мы на правильную страницу

        homePage.checkIsAvatarPresent();
//        homePage.clickOnMenuDictionary();
//        homePage.clickOnSubMenuSpares();

        homePage.leftMenu.clickOnMenuDictionary();
        homePage.leftMenu.clickOnSubMenuSpare();

        sparesPage.checkCurrentUrl();//проверка попали ли мы на правильную страницу

        sparesPage.deleteSpareUntilPresent(spareName);
        sparesPage.clickOnAddButton();

        editSparePage.checkCurrentUrl(); //проверка попали ли мы на правильную страницу
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();

        sparesPage.checkCurrentUrl(); //проверка попали ли мы на правильную страницу
        checkExpectedResult("Can not find spare in lost", sparesPage.isSpareInList(spareName));
    }
  @After
    public void deleteSpare(){
        sparesPage.deleteSpareUntilPresent(spareName);
  }
}
