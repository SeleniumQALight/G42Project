package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTestWithParams extends AbstractParentTest { //alt+insert / constructor / выбираем обе переменные
String login, pass;

    public LoginWithPageObjectTestWithParams(String login, String pass) { // конструктор
        this.login = login;
        this.pass = pass;
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
