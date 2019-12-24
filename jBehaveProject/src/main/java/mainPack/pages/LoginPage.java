package mainPack.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

@DefaultUrl("http://v3.qalight.com.ua/login")
public class LoginPage extends PageForV3 {

    @FindBy(name = "_username")
    private WebElementFacade loginInput;

    @FindBy(name = "_password")
    private WebElementFacade passwordInput;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElementFacade submitButton;

    @FindBy(xpath = ".//*[@class='login-box-body']")
    private WebElementFacade loginForm;

    public void enter_login(String login) {
        loginInput.type(login);
    }

    public void enter_pasword(String passWord) {
        passwordInput.type(passWord);
    }

    public void clickOnButtonEnter() {
        submitButton.click();
    }

    public void loginFormPresent() {
        assertThat(iselementPresent(loginForm), is(true));
    }

}