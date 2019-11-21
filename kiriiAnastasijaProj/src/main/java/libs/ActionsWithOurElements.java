package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
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
            logger.info(text + "was inputed into input");
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
            logger.info("Is element displayed -> " + false);
            return false;
        }
    }

    public void selectOnDropdownElement(WebElement webElement, String detailType) {
        try{
            Select dropdown = new Select(webElement);
            dropdown.selectByVisibleText(detailType);
            logger.info("Element was selected");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Cannot work with element ");
        Assert.fail("Cannot work with element ");
    }


}
