package parentPage;

import org.openqa.selenium.WebDriver;

public class ParentPage {
   protected WebDriver webDriver;

    //создание конструктора что б каждый класс не открывал свой браузер
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

}
