package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActions {
    WebDriver driver;
    Logger log = Logger.getLogger(getClass());

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTextIntoInput(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            log.info(text + " was input to the inputField");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            log.info("Element was clicked");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            log.info("Is element displayed -> " + state);
            return state;
        } catch (Exception e) {
            log.info("Is element displayed -> false");
            return  false;
        }
    }

    private void stopTestAndPrintMessage() {
        log.error("Can't work with element ");
        Assert.fail("Can't work with element ");
    }

}
