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
            boolean state = element.isDisplayed();
            logger.info("Is element displayed -> " + state);
            return state;
        } catch (Exception e){
            logger.info("Is element displayed ->  false");
            return false;
        }
    }

    public void selectOptionByTextFromDropdown(WebElement dropdown, String text) {
        try {
            Select select = new Select(dropdown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected from dropdown");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }

    }

    public void selectOptionByValueFromDropdown(WebElement dropdown, String value) {
        try {
            Select select = new Select(dropdown);
            select.selectByValue(value);
            logger.info(value + " was selected from dropdown");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }

    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with athe element ");
        Assert.fail("Can not work with the element ");
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e){
            return false;
        }
    }

    public void clickOnElement(String xpath) {
           try  {
               clickOnElement(webDriver.findElement(By.xpath(xpath)));
           } catch (Exception e){
               stopTestAndPrintMessage();
           }
    }
}
