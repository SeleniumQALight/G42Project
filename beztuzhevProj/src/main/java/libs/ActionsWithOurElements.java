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

    public void enterTextInInput(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to input");

        } catch (Exception e) {
            stopTestAndPrintMessage();

        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Can not work with element ");
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
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }

    public void selectValueFromDropDownList(WebElement dropDown, String itemValue) {


        try {
            Select dropDownValue = new Select(dropDown);
            dropDownValue.selectByValue(itemValue);
            logger.info(itemValue + " was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void selectVisibleTextFromDropDownList(WebElement dropDown, String text) {

        try {
            Select dropDownValue = new Select(dropDown);
            dropDownValue.selectByVisibleText(text);
            logger.info(text + " was selected in Drop Down");
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

    public void setStateToCheckBox(WebElement webElement, String expectedState) {
        boolean isChecked = webElement.isSelected();
        try {
            if (expectedState == "check") {
                if (isChecked == false) {
                    webElement.click();
                    logger.info("Check element ");
                } else {
                    logger.info("Element is already checked " + isChecked);
                }
            }
            if (expectedState == "uncheck") {
                if (isChecked == true) {
                    webElement.click();
                    logger.info("Uncheck element ");
                } else {
                    logger.info("Element is already unchecked" + isChecked);
                }
            }
        } catch (Exception e) {
            logger.info("Wrong status ");
        }
    }
}

