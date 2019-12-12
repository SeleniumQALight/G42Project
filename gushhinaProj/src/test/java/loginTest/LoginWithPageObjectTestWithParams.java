package loginTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//!!!! This class is a hardcod for the class LoginWithPageObjectTest (change code)

@RunWith(Parameterized.class)  //our class will run with diff params
public class LoginWithPageObjectTestWithParams extends AbstractParentTest {
    String login, pass;

    public LoginWithPageObjectTestWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }


    //    @Test
//    public void validLogin(){
//        loginPage.openPage();
//        loginPage.enterLoginInToInputLogin("Student");
//        loginPage.enterPassInToInputPassword("909090");
//        loginPage.clickOnButtonVhod();
//
//        //if isAvatarDisplayed is false, the message will be shown
//        checkExpectedResult("Avatar is not present.", homePage.isAvatarDisplayed());
//
//    }
    //block down will give us params
    @Parameterized.Parameters (name = "Parameters are {0} and {1}") //it's for understanding in Run tab (under left) what means
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "909096"},
                {"Studentishka", "909090"}

                }
        );
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin(login);
        loginPage.enterPassInToInputPassword(pass);
        loginPage.clickOnButtonVhod();

        correctLogin("Home page is not opened!", !homePage.isLogginSuccess());
    }



}
