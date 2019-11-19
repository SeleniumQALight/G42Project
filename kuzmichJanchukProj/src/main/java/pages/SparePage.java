package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentpage.ParentPage;

import java.util.List;
import java.util.Objects;
//import java.util.stream.Collectors;

public class SparePage extends ParentPage {

    @FindBy(xpath = "//*[@class = 'fa fa-plus']")
    WebElement buttonAdd;

    @FindBy(id = "spares_spareName")
    WebElement spareNameInput;

    @FindBy(xpath = ".//select[@id = 'spares_spareType']")
    WebElement sparesDropDown;

    @FindBy(xpath = ".//select/option")
    List<WebElement> spareTypes;

    @FindBy(xpath = ".//button[@type='submit' and @name='add']")
    WebElement createSpareButton;

    public SparePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddButton() {
        commonActions.clickOnElement(buttonAdd);
    }

    public void fillInSpareName(String userSpareName) {
        commonActions.enterTextIntoInput(spareNameInput, userSpareName);
    }
    public void openDropDown() {
        commonActions.clickOnElement(sparesDropDown);
    }

    public void selectFromDropDownOptions(String option) {
        for (WebElement element : spareTypes) {
            if (Objects.equals(element.getText(), option)) {
                commonActions.clickOnElement(element);
                break;
            }
        }
    }

    public void clickOnCreateButton() {
        commonActions.clickOnElement(createSpareButton);
    }

//    public void selectFromDropDownOptions (String option) {
//        commonActions.clickOnElement(spareTypes
//                .stream()
//                .filter(element -> option.equals(element::getText))
//                .collect(Collectors.toList()).get(0)
//        );
//    }
}
