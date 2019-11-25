package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoInput (WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into input");
        }catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement (WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");

        }catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }

    public boolean isElementDisplayed (WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed -> " + state);
            return state;
        }catch (Exception e){
            logger.info("Is element displayed -> false");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.debug("Can not work with element ");
        Assert.fail("Can not work with element ");
    }

    public void selectValueInDDByJava(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in DropDown");

        }catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void selectVisibleTextInDDByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DropDown");

        }catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(String locator) {

        try{
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));

        }catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(xpath)));

        }catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void setStateToCheckBox(WebElement webelement, String expectedState){
        try {
           boolean checkBox = webelement.isSelected();
            if (checkBox==true & expectedState.equals("N")){
                clickOnElement(webelement);
                logger.info("checkbox change state into " + expectedState);
            }else if (checkBox==false & expectedState.equals("Y")) {
                clickOnElement(webelement);
                logger.info("checkbox change state into " + expectedState);
            }else if (!expectedState.equals("Y")& !expectedState.equals("N")) {
                logger.error("Something went wrong");
                stopTestAndPrintMessage();
            }
        }catch (Exception e){
            stopTestAndPrintMessage();
        }


    }
}
