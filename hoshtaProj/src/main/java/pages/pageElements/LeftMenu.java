package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends CommonActionsWithElements {

    @FindBy(id = "spares")
    private Link sparesSubMenu;

    @FindBy(id = "dictionary")
    private Link dictionaryMenu;

    public void clickDictionaryMeny() {
        actionsWithOurElements.clickElement(dictionaryMenu);
    }

    public void clickSparesSubMeny() {
        actionsWithOurElements.clickElement(sparesSubMenu);
    }
}