package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.ValueExp;
import java.util.List;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;
    private final String CHECK_BOX_SELECTED = "Selected";
    private final String CHECK_BOX_UNSELECTED = "Unselected";

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

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("is element displayed -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("is element displayed ->  false");
            return false;
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
//            webDriverWait_10.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)));
            webElement.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }

    public void selectValueinDDbyJava(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in drop down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }


    public void selectValueInSpareDDXpathByOption(WebElement dropdown, String option) {
        clickOnElement(dropdown);
        clickOnElement("//select[@id='spares_spareType']/option[@value ='" + option + "']");
        logger.info(option + " was selected in drop down");
    }


    public void selectValueInSpareDDXpathByText(WebElement dropdown, String text) {
        clickOnElement(dropdown);
        clickOnElement("//select[@id='spares_spareType']/option[text()='" + text + "']");
        logger.info(text + " was selected in drop down");
    }

    public void selectVisibleTextInDDbyJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in drop down");
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

    public void setStateToCheckBox(WebElement webelement, String expectedState) {
        if ((!(expectedState.equals(CHECK_BOX_SELECTED)) && (!expectedState.equals(CHECK_BOX_UNSELECTED)))) {
            logger.info("Expected State is not correct");
            stopTestAndPrintMessage();
        }
        boolean isSelected = isCheckboxSelected(webelement);
        logger.info("Checkbox is selected: " + isSelected);
        if (isSelected) {
            if ((expectedState.equals(CHECK_BOX_SELECTED))) {
                logger.debug("Nothing to do");
            } else {
                logger.info("Setting checkbox to: " + expectedState);
                clickOnElement(webelement);
            }
        } else {
            if ((expectedState.equals(CHECK_BOX_SELECTED))) {
                logger.info("Setting checkbox to: " + expectedState);
                webelement.click();
            } else {
                logger.debug("Nothing todo");
            }
        }
    }

//made in class


    public void setStatetoCheckboNew(WebElement checkbox, String state) {
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUncheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = checkbox.isSelected();
        if (isStateCheck || isStateUncheck) {

            if ((isStateCheck && isCheckBoxSelected) || (isStateUncheck && !isCheckBoxSelected)) {
                logger.info("Checkbox is already in needed state");
            } else if ((isStateCheck && !isCheckBoxSelected) || (isStateUncheck && isCheckBoxSelected)) {
                clickOnElement(checkbox);
            }
            {
                logger.error("State should be only 'check' on 'uncheck'");
                stopTestAndPrintMessage();
            }
        }

    }

    public boolean isCheckboxSelected(WebElement checkbox) {

        try {
            return checkbox.isSelected();
        } catch (Exception e) {
            logger.info("There is error with checkbox");
            return false;
        }

    }
}
