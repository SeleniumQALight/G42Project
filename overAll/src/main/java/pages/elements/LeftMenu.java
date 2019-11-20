package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']")
public class LeftMenu extends CommonActionWithElements {


    @FindBy(id = "dictionary")
    private Link dictionary;

    @FindBy(xpath = ".//*[@id='workers']/a")
    private WebElement workersSubMenu;

    @FindBy(id = "spares")
    private Link sparesSubMenu;

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(dictionary);
    }
}
