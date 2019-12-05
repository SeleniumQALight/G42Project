package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
        webDriverWait_15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextIntoInput(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into input");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
//            webDriverWait_10.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement))); ---- просто пример
            webElement.click();
            logger.info("Element was clicked " + getElementName(webElement));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private String getElementName(WebElement webElement) {
        String elementName = "";
        if (webElement instanceof TypifiedElement){
            elementName = "'" + ((TypifiedElement)webElement).getName() + "'";
        }
        return elementName;
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("Is element displayed -> false");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }

    public void selectValueFromDropdownList(WebElement dropDown, String value) {
        try {
            dropDown.click();
            clickOnElement(".//option[text() = '" + value + "']");
            logger.info(value + " was selected from dropdown list");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void selectValueFromDropdownListWithJava(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(value);
            logger.info(value + " was selected from dropdown list");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

//    public void setStateToCheckBox(WebElement checkbox, String expectedState) {
//        try {
//            if (expectedState == "check") {
//                if (!checkbox.isSelected()) {
//                    checkbox.click();
//                    logger.info("Checkbox was checked");
//                } else {
//                    logger.info("Checkbox is already checked");
//                }
//            } else if (expectedState == "uncheck") {
//                if (checkbox.isSelected()) {
//                    checkbox.click();
//                    logger.info("Checkbox was unchecked");
//                } else {
//                    logger.info("Checkbox is already unchecked");
//                }
//            } else {
//                logger.error("Incorrect expected state: state should be check or uncheck");
//            }
//        } catch (Exception e) {
//            stopTestAndPrintMessage();
//        }
//    }

    public void setStateToCheckBox(WebElement checkBox, String state){
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUnCheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = checkBox.isSelected();

        if (isStateCheck || isStateUnCheck){
            if ((isStateCheck && isCheckBoxSelected) || (isStateUnCheck && !isCheckBoxSelected)){
                logger.info("Checkbox ia already in needed state");
            } else if ((isStateCheck && !isCheckBoxSelected)||(isStateUnCheck && isCheckBoxSelected)){
                clickOnElement(checkBox);
            }
        } else{
            logger.error("State shoula be only check or uncheck");
            stopTestAndPrintMessage();
        }
    }
}


//правая кнопка, дженерейт, конструктор