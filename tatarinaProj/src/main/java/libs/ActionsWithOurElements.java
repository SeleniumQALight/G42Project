package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public void enterTextInToInput(WebElement webElement, String text) {
        try {
           webElement.clear ();
           webElement.sendKeys(text);
           logger.info(text + " was inputted  in to input");

        } catch (Exception e) {
            stopTestAndPrintMessage ();
        }

    }
    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until (
                    ExpectedConditions.elementToBeClickable (webElement));
//            webDriverWait_10.until (
//                    ExpectedConditions.not(
//                            ExpectedConditions.not(
//                                    ExpectedConditions.elementToBeClickable(webElement)
//                            )

//            );

            webElement.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            stopTestAndPrintMessage();
        }

    }
    public boolean isElementDisplayed (WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info( "Is element displayed -> " + state);
            return state;
        }catch (Exception e) {
            logger.info ("Is element displayed -> false");
            return false;
        }

    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element");
        Assert.fail("can not work with element");
    }
}