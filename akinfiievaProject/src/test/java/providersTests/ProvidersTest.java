package providersTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class ProvidersTest extends AbstractParentTest {

    @Test
    public void addNewProviders() {
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuProviders();
        providersPage.clickOnButtonAdd();
        editProvidersPage.enterProCustName("test2411");
        editProvidersPage.enterProCustAddress("testaddress2411");
        editProvidersPage.enterProCustPhone("24112411");
        editProvidersPage.checkIfPrivatePerson("true");
        editProvidersPage.checkIfIsOurFirm("check");
    }
}