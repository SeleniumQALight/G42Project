package loginTest;

import abstractParentTest.AbstractParentTest;
import libs.ExcelDriver;
import org.junit.Test;


import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObjectWithExcel extends AbstractParentTest {
    @Test
    public void validLogin() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(configProperties.DATA_FILE(),"validLogOn");

        logInPage.openPage();
        logInPage.enterLoginInToInputlogin(dataForValidLogin.get("login"));
        logInPage.enterPassInToInputPassWord(dataForValidLogin.get("pass"));
        logInPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present"

                , homePage.isAvatarDisplayed());
    }



}
