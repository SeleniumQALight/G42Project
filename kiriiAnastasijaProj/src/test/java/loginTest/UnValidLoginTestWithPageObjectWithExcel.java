package loginTest;

import abstractParentTest.AbstractParentTest;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;


@RunWith(Parameterized.class)
public class UnValidLoginTestWithPageObjectWithExcel extends AbstractParentTest {
    private String login, pass;

    public UnValidLoginTestWithPageObjectWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()
                    +"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void unvalidLogin() {
        loginPage.fillLoginFormAndSubmitIt(login, pass);

        checkExpectedResult("Avatar should not be present",
                !homePage.isAvatarDisplayed());
    }
}
