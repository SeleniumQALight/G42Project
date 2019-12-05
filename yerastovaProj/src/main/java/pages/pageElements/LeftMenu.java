package pages.pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy (xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends HtmlElement {
    @FindBy (xpath = "//a//span[text()= 'Словари']")
    private Link menuDictionary;

    @FindBy (xpath= "//a[@href='/dictionary/spares']")
    private Link subMenuSpares;

    public void clickOnMenuDictionary(){
        menuDictionary.click();
    }

    public void clickOnSubMenuSpare() {
        subMenuSpares.click();
    }
}
