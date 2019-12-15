package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy (xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends CommonActionsWithElements {
    @FindBy (xpath = "//a//span[text()= 'Словари']")
    private Link menuDictionary;

    @FindBy (xpath= "//a[@href='/dictionary/spares']")
    private Link subMenuSpares;

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }
}
