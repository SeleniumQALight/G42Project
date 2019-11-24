package sparestest;

import abstractparenttest.AbstractParentTest;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {

    @Test
    public void addNewSpare() {
        loginPage.fillLoginFormAndSubmit("Student", "909090");

        homePage.isAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.clickOnAddButton();
        sparePage.openDropDown();
        sparePage.fillInSpareName("G42Project_Kuzmych-Ianchuk");
        sparePage.selectFromDropDownOptions("Датчики");
        sparePage.clickOnCreateButton();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
