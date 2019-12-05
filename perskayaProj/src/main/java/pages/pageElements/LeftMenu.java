package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']") // локатор левого меню
public class LeftMenu extends HtmlElement { // описывает конкретные элемент - левое меню
    @FindBy(id = "dictionary")
    private Link menuDictionary;

    @FindBy(id = "spares")
    private Link subMenuSpares;

    public void clickOnMenuDictionary(){
        menuDictionary.click();
    }
    public void clickOnSubMenuSpare(){
        subMenuSpares.click();
    }
}
