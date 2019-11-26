package contractorsTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class ContractorsTest extends AbstractParentTest {
    String login = "Student";
    String password = "909090";

    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmit(login, password);

        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuContractors();

        contractorsPage.clickAddButton();
        contractorsPage.selectCheckBoxPrivatePerson( "true");
        contractorsPage.selectCheckBoxIsOurFirm("false");
    }
}
