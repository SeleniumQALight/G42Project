package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
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
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
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

    public void setStateToCheckBox(WebElement checkbox, String expectedState) {
        try {
            if (expectedState == "check") {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    logger.info("Checkbox was checked");
                } else {
                    logger.info("Checkbox is already checked");
                }
            } else if (expectedState == "uncheck") {
                if (checkbox.isSelected()) {
                    checkbox.click();
                    logger.info("Checkbox was unchecked");
                } else {
                    logger.info("Checkbox is already unchecked");
                }
            } else {
                logger.error("Incorrect expected state: state should be check or uncheck");
            }
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }
}


//правая кнопка, дженерейт, конструктор