package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends HtmlElement {

    @FindBy(id = "spares")
    private Link sparesSubMenu;

    @FindBy(id = "dictionary")
    private Link dictionaryMenu;

    public void clickDictionaryMeny() {
        dictionaryMenu.click();
    }

    public void clickSparesSubMeny() {
        sparesSubMenu.click();
    }
}
