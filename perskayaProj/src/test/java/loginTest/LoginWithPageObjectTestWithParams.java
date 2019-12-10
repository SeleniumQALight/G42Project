package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class) // говорим джейюниту запусти этот класс несколько раз
public class LoginWithPageObjectTestWithParams extends AbstractParentTest { //alt+insert / constructor / выбираем обе переменные
String login, pass;

    public LoginWithPageObjectTestWithParams(String login, String pass) { // конструктор
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")  //@Parameterized.Parameters; в скобках указываем номер параметров 0  и 1
    public static Collection testData(){
       return Arrays.asList(new Object[][]// Object[][] - двухмерный массив для каждого набора данных
               {{"Student", "906090"},
               {"login", "909090"}
    }
       );
    }

    @Test
    public void unValidLogin() {
    loginPage.openPage(); // метод openPage открывает нужную урлку
    loginPage.enterLoginInToInputLogin(login); // метод enterLoginInToInputLogin вводит значение в поле логин
    loginPage.enterPassInToInputPassword(pass); // метод enterPassInToInputPassword вводит значение в поле пароля
    loginPage.clickOnButtonVhod(); // метод clickOnButtonVhod нажимает кнопку вход реализация этих методов будет в AbstractParentTest

    checkExpectedResult("Avatar should not be present", !homePage.isAvatarDisplayed()); //checkExpectedResult - название метода
    // ожидаемый результат - на homePage отображается аватарка
}

}
