package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoInput(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputed into input");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info(" Element was clicked");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean staate = element.isDisplayed();
            logger.info("Is element displayed -> " + staate);
            return staate;
        } catch (Exception e){
            logger.info("Is element displayed ->  false");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with athe element ");
        Assert.fail("Can not work with the element ");
    }

}
