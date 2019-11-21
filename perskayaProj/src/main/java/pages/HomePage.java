package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parentPage.ParentPage;

public class HomePage extends ParentPage { // наследует все от родителя
    public HomePage(WebDriver webdriver) { // наследует конструктор от родителя
        super(webdriver);
    }
    public boolean isAvatarDisplayed() { // метод для отображения аватарки,
        // параметры в скобках не нужны, страница внутри себя должна знать как найти аватарку и как у нее спросить есть она или нет
        try {
            WebElement avatar = webdriver.findElement(By.xpath(".//*[@class='pull-left image']")); //поиск аватарки
            return avatar.isDisplayed(); // возвращаем значение, показана ли аватарка в браузере, а не в доме. Это случай отображения
        } catch (Exception e) {
            return false; // здесь аватарка не отобразилась в браузере
        }
    }
}
