package loginTest;

import abstractParentTest.AbstractParentTest;
import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithPageObject extends AbstractParentTest{
    @Test
    public void validLogin(){
        loginPage.openPage();



    }



}
