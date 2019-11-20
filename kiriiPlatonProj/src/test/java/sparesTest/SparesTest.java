package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    String login = "Student";
    String password = "909090";

    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmit(login, password);

        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.clickAddButton();
    }
}
