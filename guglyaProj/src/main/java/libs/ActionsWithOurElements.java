package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Андрей Гугля on 19.11.2019.
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void enterTextInToInput(WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed in to input");
        }catch (Exception e){
            stopTestAndPrintMessage();

        }

    }

    public void clickOnElement(WebElement webElement){
        try{
            webElement.click();
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement webElement){
        try{
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed -> " + state);
            return webElement.isDisplayed();
        }catch (Exception e){
            logger.info("Is element displayed -> " + false);
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");

    }
}
