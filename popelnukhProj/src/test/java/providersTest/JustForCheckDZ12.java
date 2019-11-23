package providersTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class JustForCheckDZ12 extends AbstractParentTest {
    @Test
    public void checkBoxIsSelected(){
        loginPage.fillingLoginFormAndSubmitIt("student", "909090");
        providersPage.openPage();
        providersPage.findBTR80Provider();
        providersEditPage.selectCheckboxPrivatePerson();
        providersEditPage.selectCheckboxIsOurFirm();
        providersEditPage.submitChangeInfoAboutProvider();
    }
    @Test
    public void checkBoxIsNotSelected(){
        loginPage.fillingLoginFormAndSubmitIt("student", "909090");
        providersPage.openPage();
        providersPage.findBTR80Provider();
        providersEditPage.deselectCheckboxPrivatePerson();
        providersEditPage.deselectCheckboxIsOurFirm();
        providersEditPage.submitChangeInfoAboutProvider();

    }
}