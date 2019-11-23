package providersTest;

import LoginTest.LoginWithPageObjectTest;
import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class AddNewProviderTest extends AbstractParentTest {
    String providerName = "NovayaDetal";
    @Test
    public void addNewProvider(){
        loginPage.fillingLoginFormAndSubmitIt("student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.addNewProvider();
        providersEditPage.enterProCustName(providerName);
        providersEditPage.enterProCustAdress();
        providersEditPage.enterProCustPhone();
        providersEditPage.selectCheckboxPrivatePerson();
        providersEditPage.selectCheckboxIsOurFirm();
//        providersEditPage.submitNewProvider();
//        checkExpectedResult("Can't find spare"
//                , providersPage.isProviderInList(providerName));

    }
}