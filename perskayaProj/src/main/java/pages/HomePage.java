package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage { // наследует все от родителя
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    public HomePage(WebDriver webdriver) { // наследует конструктор от родителя
        super(webdriver);
    }

    public boolean isAvatarDisplayed() { // метод для отображения аватарки,
        // параметры в скобках не нужны, страница внутри себя должна знать как найти аватарку и как у нее спросить есть она или нет

//        try {
//            WebElement avatar = webdriver.findElement(By.xpath(".//*[@class='pull-left image']")); //поиск аватарки
//            return avatar.isDisplayed(); // возвращаем значение, показана ли аватарка в браузере, а не в доме. Это случай отображения
//        } catch (Exception e) {
//            return false; // здесь аватарка не отобразилась в браузере
//        }
    return actionsWithOurElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary); // на menuDictionary нажать аль+ентер и выбрать создать филд
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }
}
