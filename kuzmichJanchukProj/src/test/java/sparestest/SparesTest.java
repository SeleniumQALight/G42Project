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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
