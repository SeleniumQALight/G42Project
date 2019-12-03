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
        webDriverWait_10 = new WebDriverWait(webDriver,10);
        webDriverWait_15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextIntoInput(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into field");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked " + getElementName(webElement));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private String getElementName(WebElement webElement) {
        String elementName = "";
        if (webElement instanceof TypifiedElement) {
            elementName = "'" + ((TypifiedElement) webElement).getName() + "'";
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

    public void selectItemFromDropDownList(WebElement webElement, String itemName) {
        Select dropDownValue = new Select(webElement);
        try {
            dropDownValue.selectByVisibleText(itemName);
            logger.info(itemName + " was selected in dropdown");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can't work with element.");
        Assert.fail("Can't work with element.");
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String locator) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void setStateToCheckBoxHomeOption(WebElement checkBox, String expectedState) {
        try {
            if (expectedState == "true") {
                if (checkBox.isSelected()) {
                    logger.info("State true was setted");
                } else {
                    checkBox.click();
                    logger.info("State true was setted");
                }
            } else if (expectedState == "false") {
                if (checkBox.isSelected()) {
                    checkBox.click();
                    logger.info("State false was setted");
                } else {
                    logger.info("State false was setted");
                }
            } else {
                logger.info("Can't detect the state");
            }
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void setStateToCheckBoxClassOption(WebElement checkBox, String state) {
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUnCheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = checkBox.isSelected();

        if (isStateCheck || isStateUnCheck) {
            if ((isStateCheck && isCheckBoxSelected) || (isStateUnCheck && !isCheckBoxSelected)) {
                logger.info("Checkbox is already in needed state");
            } else if((isStateCheck && !isCheckBoxSelected) || (isStateUnCheck && isCheckBoxSelected)) {
                checkBox.click();
                logger.info("Checkbox now is in needed state");
            }
        } else {
            logger.error("State should be only check or uncheck");
            stopTestAndPrintMessage();
        }
    }
}