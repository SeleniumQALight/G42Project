package pages.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy (xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends CommonActionsWithElements {
    @FindBy(id="dictionary")
    private Link menuDictionary;
    @FindBy(id="spares")
    private Link subMenuSpares;
    @FindBy(id = "prov_cus")
    private WebElement subMenuProviders;


    public  void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }
}