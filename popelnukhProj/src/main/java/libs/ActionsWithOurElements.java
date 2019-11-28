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

    public void enterTextIntoInput(WebElement webElement
            , String text) {
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
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed ->" + state);
            return state;
        } catch (Exception e) {
            logger.info("Is element displayed -> False");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can't work with element ");
        Assert.fail("Can't work with element ");
    }

    public void selectValueInDDByJava(WebElement dropDawn, String value) {
        try {
            Select select = new Select(dropDawn);
            select.selectByValue(value);
            logger.info(value + " was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }
    public void selectVisibleText(WebElement dropDawn, String text) {
        try {
            Select select = new Select(dropDawn);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(String locator) {
        try{
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        }catch (Exception e){
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try{
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }
    public void setStateToCheckBox(WebElement checkBox, String state) {
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUncheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = checkBox.isSelected();
        if (isStateCheck || isStateUncheck) {
            if ((isStateCheck && isCheckBoxSelected) || (isStateUncheck && !isCheckBoxSelected)) {
                logger.info("CheckBox is already needed state");
            } else if ((isStateCheck && !isCheckBoxSelected) || (isStateUncheck && isCheckBoxSelected)) {
                clickOnElement(checkBox);
            } else {
                logger.error("State should be only 'check' or 'uncheck'");
                stopTestAndPrintMessage();

            }
        }
    }
}