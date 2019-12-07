package pages.pageElements;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends HtmlElement {
    @FindBy (id = "dictionary")
    private Link menuDictionary;

    @Name(" Submenu Spares")//присваиваем другое имя для логгера
    @FindBy (id = "spares")
    private Link subMenuSpares;

    public void clickOnMenuDictionary(){
        menuDictionary.click();
    }

    public void clickOnSubmenuSpares() {
        menuDictionary.click();
    }
}
