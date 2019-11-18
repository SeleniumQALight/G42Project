package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithPageObjectTest extends AbstractParentTest {
@Test
    public void validLogin() {
    loginPage.openPage(); // метод openPage открывает нужную урлку
    loginPage.enterLoginInToInputLogin("Student"); // метод enterLoginInToInputLogin вводит значение в поле логин
    loginPage.enterPassInToInputPassword("909090"); // метод enterPassInToInputPassword вводит значение в поле пароля
    loginPage.clickOnButtonVhod(); // метод clickOnButtonVhod нажимает кнопку вход реализация этих методов будет в AbstractParentTest

    checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed()); //checkExpectedResult - название метода
    // ожидаемый результат - на homePage отображается аватарка
}
@Test
        public void notValidLogin1() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin(" ");
    loginPage.enterPassInToInputPassword("909090");
    loginPage.clickOnButtonVhod();

    checkExpectedResult("Avatar is present", !homePage.isAvatarDisplayed()); // ввод значений в готовый метод (реализован в AbstractParentTest) isAvatarDisplayed - метод класса homePage
    }
@Test
    public void notValidLogin2(){
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin("1");
    loginPage.enterPassInToInputPassword("909090");
    loginPage.clickOnButtonVhod();

    checkExpectedResult("The button Vhod not displayed", loginPage.isButtonVhodDisplayed());
}

}
