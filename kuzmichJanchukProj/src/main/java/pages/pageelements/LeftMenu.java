package pages.pageelements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends CommonActionsWithElements {

    @FindBy(id = "dictionary")
    private Link menuDictionary;

    @FindBy(id = "spares")
    private Link subMenuSpares;

    public void clickOnMenuDictionary() {
        menuDictionary.click();
    }

    public void clickOnSubmenuSpares() {
        subMenuSpares.click();
    }
}
