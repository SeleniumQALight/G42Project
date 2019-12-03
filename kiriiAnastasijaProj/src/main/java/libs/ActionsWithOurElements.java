package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            logger.info(text + " was inputed into input");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
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
            logger.info("Is element displayed -> " + false);
            return false;
        }
    }

    public void selectInDropdownElement(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " element was selected");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Cannot work with element ");
        Assert.fail("Cannot work with element ");
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
//        boolean isChecked = webElement.isSelected();
//        try {
//            if (expectedState == "check") {
//                if (isChecked == false) {
//                    webElement.click();
//                    logger.info("Check element ");
//                } else {
//                    logger.info("Element is already checked " + isChecked);
//                }
//            }
//            if (expectedState == "uncheck") {
//                if (isChecked == true) {
//                    webElement.click();
//                    logger.info("Uncheck element ");
//                } else {
//                    logger.info("Element is already unchecked" + isChecked);
//                }
//            }
//        } catch (Exception e) {
//            logger.info("Wrong status ");
//        }
        boolean isStateCheck = expectedState.toLowerCase().equals("check");
        boolean isStateUnCheck = expectedState.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = checkbox.isSelected();

        if(isStateCheck || isStateUnCheck) {
            if ((isStateCheck && isCheckBoxSelected) || (isStateUnCheck && !isCheckBoxSelected)){
                logger.info("Checkbox is already needed state");
            }else if ((isStateCheck && !isCheckBoxSelected) || (isStateUnCheck && isCheckBoxSelected)){
                clickOnElement(checkbox);
            }
        }else{
    logger.info("State should be equal only 'check' or 'uncheck'");
            stopTestAndPrintMessage();
            }
    }
}