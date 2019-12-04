package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends HtmlElement {
    @FindBy(id = "dictionary")
    private Link menuDictionary;

    @FindBy(id = "spares")
    private Link subMenuSpares;
    public void clickOnMenuDictionary(){
        //тут исп яндекс методы уже
        menuDictionary.click();
    }

    public void clckOnSubMenuSpare() {
        subMenuSpares.click();
    }
}
