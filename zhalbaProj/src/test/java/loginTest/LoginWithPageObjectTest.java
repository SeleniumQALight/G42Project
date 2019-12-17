package loginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.Test;

@Epic("Allure examples")
@Feature("Junit 4 support")
public class LoginWithPageObjectTest extends AbstractParentTest {

  @Description("Some detailed test description")
  @Story("Base support for bdd annotations")
  @Link("https://example.org")
  @Link(name = "allure", type = "mylink")
  @Issue("123")
  @Issue("432")
  @Severity(SeverityLevel.CRITICAL)

  @Test
  public void validLogin() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin("Student");
    loginPage.enterPassInToInputPassword("909090");
    loginPage.clickOnButtonVhod();

    checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
  }

  @Test
  public void invalidLogin() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin("Student");
    loginPage.enterPassInToInputPassword("909091");
    loginPage.clickOnButtonVhod();

    checkExpectedResult("Avatar is not present", !homePage.isAvatarDisplayed());
    checkExpectedResult("Button is not displayed", loginPage.isVhodButtonDispalyed());
  }
}
