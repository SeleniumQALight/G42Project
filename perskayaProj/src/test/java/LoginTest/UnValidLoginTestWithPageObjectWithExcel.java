package LoginTest;

import abstractParentTest.AbstractParentTest;
import Libs.ConfigProperties;
import Libs.SpreadsheetData;
import org.aeonbits.owner.ConfigFactory;
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
        InputStream spreadsheet // создаем инпутстрим
                = new FileInputStream(configProperties.DATA_FILE_PATH() // берем путь к папке и приклеиавем лист
                    +"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData(); // getData - получение наборов данных, тест запускается столько раз сколько у нас строк
    }

    @Test
    public void unvalidLogin() {
        loginPage.fillingLoginFormAndSubmitIt(login, pass);

        checkExpectedResult("Avatar should not be present"
                , false
                , homePage.isAvatarDisplayed());
    }


}
