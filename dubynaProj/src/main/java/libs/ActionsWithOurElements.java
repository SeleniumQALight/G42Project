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
    WebDriverWait webDriverWait_10, webDriverWait_15 ;


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
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement)); //visibilityOf;
          //  webDriverWait_10.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement))); Когда нужна инверсия метода
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("is element displayed -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("is element displayed -> false");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }


    public void selectValueInDDByJava(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in drop down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void selectVisibleTextInDDByJava(WebElement dropDown, String text) {
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

    public void setSateToCheckBox(WebElement checkbox, String state) {
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUncheck = state.toLowerCase().equals("uncheck");
        boolean isCheckboxSelected = checkbox.isSelected();
        if (isStateCheck || isStateUncheck) {
            if((isStateCheck && isCheckboxSelected)||(isStateUncheck && !isCheckboxSelected)){
                logger.info("checkbox is already in needed state");}

            else if ((isStateCheck && !isCheckboxSelected) || (isStateUncheck && isCheckboxSelected)){
                clickOnElement(checkbox);

            }}

         else {
            logger.error("State should be only check or uncheck");
            stopTestAndPrintMessage();
        }
    }



}
