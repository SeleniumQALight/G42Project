package sparesTests;

        import abstractParentTest.AbstractParentTest;
        import org.junit.After;
        import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "KapitonSpare";
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmit("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparesPage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();
        checkExpectedResult("Can not find spare in lost", sparesPage.isSpareInList(spareName));
    }
  @After
    public void deleteSpare(){
        sparesPage.deleteSpareUntilPresent(spareName);
  }
}
