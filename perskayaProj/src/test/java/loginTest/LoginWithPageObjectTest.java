package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

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
        public void notValidPassword1() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin("Student");
    loginPage.enterPassInToInputPassword("9");
    loginPage.clickOnButtonVhod();

    checkExpectedResult("Avatar is present", !homePage.isAvatarDisplayed()); // ввод значений в готовый метод (реализован в AbstractParentTest) isAvatarDisplayed - метод класса homePage
    }
@Test
    public void notValidPassword2(){
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin("Student");
    loginPage.enterPassInToInputPassword(" ");
    loginPage.clickOnButtonVhod();

    checkExpectedResult("The button Vhod not displayed", loginPage.isButtonVhodDisplayed());
}
}
