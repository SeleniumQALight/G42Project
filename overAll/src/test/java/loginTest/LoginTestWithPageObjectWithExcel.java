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

        loginPage.openPage();
        loginPage.enterLoginInToInputLogin(dataForValidLogin.get("login"));
        loginPage.enterPassInToInputPassWord(dataForValidLogin.get("pass"));
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present"
                , true
                , homePage.isAvatarDisplayed());
    }



}
