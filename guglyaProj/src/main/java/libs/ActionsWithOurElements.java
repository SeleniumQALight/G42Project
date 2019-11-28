package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void selectValueInDropDByJava(WebElement dropDown, String value) {
       try{
           Select select = new Select(dropDown);
           select.selectByValue(value);
           logger.info(value + " was selected in Drop Down");
    }catch (Exception e){
           stopTestAndPrintMessage();
       }
    }
    public void selectVisibleTextInDropDByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
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
        try {
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        }catch(Exception e){
            stopTestAndPrintMessage();
        }
    }

    public void setStateToChekBox(WebElement chekBox, String state){
        boolean isStateChek = state.toLowerCase().equals("check");
        boolean isStateUnCheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = chekBox.isSelected();

        if(isStateChek || isStateUnCheck){
            if((isStateChek && isCheckBoxSelected ) || (isStateUnCheck && !isCheckBoxSelected)){
                logger.info("Checkbox is alredy in ineededstate");
            }else if((isStateChek && !isCheckBoxSelected) ||(isStateUnCheck && isCheckBoxSelected)){
                clickOnElement(chekBox);
            }
        }else {
            logger.error("State shold be only 'check' or 'uncheck'");
            stopTestAndPrintMessage();
        }
    }
}