package LoginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;
import pages.LoginPage;

@Epic("Allure examples") // описывает класс
@Feature("Junit 4 support")
public class LoginWithPageObjectTest extends AbstractParentTest {
    @Description("Some detailed test description") // описание
    @Story("Base support for bdd annotations") // это стори фич копиурется из джиры
//    @Link("https://example.org") // любой линк можно вставить
//    @Link(name = "allure", type = "mylink") // название линка
//    @Issue("123") // 123 - номер бага
//    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void validLogin() {
    loginPage.openPage(); // метод openPage открывает нужную урлку
    loginPage.enterLoginInToInputLogin("Student"); // метод enterLoginInToInputLogin вводит значение в поле логин
    loginPage.enterPassInToInputPassword("9090909"); // метод enterPassInToInputPassword вводит значение в поле пароля
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
