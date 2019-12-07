package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

    @FindBy(xpath = ".//*[@class='sidebar-menu']")
    public class LeftMenu extends CommonActionWithElements {
    @FindBy(id = "dictionary")
    private Link menuDictionary;

    @FindBy(id = "spares")
    private Link subMenuSpares;

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }
}
