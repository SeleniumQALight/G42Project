package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']") // локатор левого меню
public class LeftMenu extends CommonActionWithElements { // описывает конкретные элемент - левое меню, 05.12 изменили наследование на комон
    @FindBy(id = "dictionary")
    private Link menuDictionary;

    @FindBy(id = "spares")
    private Link subMenuSpares;

    public void clickOnMenuDictionary(){

        actionsWithOurElements.clickOnElement(menuDictionary);
//        menuDictionary.click();
    }
    public void clickOnSubMenuSpare(){

        actionsWithOurElements.clickOnElement(subMenuSpares);
//        subMenuSpares.click();
    }
}
