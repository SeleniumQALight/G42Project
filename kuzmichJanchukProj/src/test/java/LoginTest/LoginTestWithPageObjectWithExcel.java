package LoginTest;

import abstractparenttest.AbstractParentTest;
import libs.ExcelDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObjectWithExcel extends AbstractParentTest {

    @Test
    public void validLogin() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(configProperties.DATA_FILE(),"validLogOn");

        loginPage.openPage();
        loginPage.enterLoginIntoLoginField(dataForValidLogin.get("login"));
        loginPage.enterPasswordIntoPasswordField(dataForValidLogin.get("pass"));
        loginPage.clickOnButtonEnter();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
}
