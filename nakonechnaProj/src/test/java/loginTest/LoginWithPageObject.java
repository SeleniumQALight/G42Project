package loginTest;

import abstractPackageTest.AbstractParentClass;
import org.junit.Test;

public class LoginWithPageObject extends AbstractParentClass {
    @Test
    public void ValidLogin() {
        loginPage.openPage();
    }
}
