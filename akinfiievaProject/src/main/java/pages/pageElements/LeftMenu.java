package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends HtmlElement {
    @FindBy(xpath = ".//li[@id='dictionary']")
    public Link menuDictionary;
    @FindBy(xpath = ".//li[@id='dictionary']//ul[@class='treeview-menu menu-open']//li[@id='spares']")
    private Link submenuSpares;

    public void clickOnMenuDictionary() {
        menuDictionary.click();
    }

    public void clickOnSubmenuSpares() {
        submenuSpares.click();
    }
}
