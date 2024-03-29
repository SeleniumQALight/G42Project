package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;


    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;

        webDriverWait_10 = new WebDriverWait(webDriver,10);
        webDriverWait_15 = new WebDriverWait(webDriver,15);
    }
    public void enterTextInToInput(WebElement webElement, String text) {
        try{
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into input");

    } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement (WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));

 //        webDriverWait_10.until (
 //                ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement));
 //         Это метод для  подождать пока эллемент не исчезнет

            webElement.click();
            logger.info("Element was clicked" + getElementName(webElement));

        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private String getElementName(WebElement webElement) {
        String elementName = "";
        if (webElement instanceof TypifiedElement) {
            elementName = "'" + ((TypifiedElement) webElement).getName() + "'";
        }
        return elementName;
    }

    public boolean isElementDisplayed (WebElement webElement) {
        try {
           boolean state = webElement.isDisplayed();
           logger.info("Is element displayed -> " + state);
           return state;

        } catch (Exception e) {
            logger.info("Is element displayed -> false");
            return  false;

        }
    }


    private void stopTestAndPrintMessage() {
        logger.error(" Cannot work with element ");
        Assert.fail("Cannot work with element");
    }

    public void selectValueInDDByJava(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown) ;
            select.selectByValue(value);
            logger.info(value + " was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void selectVisibleTextInDDByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown) ;
            select.selectByVisibleText(text);
            logger.info(text + " was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e){
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try {
           clickOnElement(webDriver.findElement(By.xpath(xpath)));
        } catch (Exception e){
            stopTestAndPrintMessage();
        }
    }
/*   this is my own method from homework

    public void setStateToCheckBox(WebElement webelement, String expectedState) {
        if ("check".equals(expectedState) || "uncheck".equals(expectedState)) {
            try {
                if (webelement.isSelected() && "check".equals(expectedState)) {
                    logger.info("Already check");
                } else if (!webelement.isSelected() && "check".equals(expectedState)) {
                    webelement.click();
                    logger.info("check box checked");
                } else if (webelement.isSelected() && "uncheck".equals(expectedState)) {
                    webelement.click();
                    logger.info("check box deselected");

                } else if (!webelement.isSelected() && "uncheck".equals(expectedState)) {
                    logger.info("checkbox is already unchecked");
                }

            } catch (Exception e) {
                stopTestAndPrintMessage();
            }

        } else {
            logger.error("State should be 'check' or 'uncheck'");
            Assert.fail("State should be 'check' or 'uncheck'");
        }
    }
*/

     public void setStateToCheckBox (WebElement checkBox, String state) {
         boolean isStateCheck = state.toLowerCase().equals("check");
         boolean isStateUncheck = state.toLowerCase().equals("uncheck");
         boolean isCheckBoxSelected = checkBox.isSelected();

         if (isStateCheck || isStateUncheck) {
             if ((isStateCheck && isCheckBoxSelected) || (isStateUncheck && !isCheckBoxSelected)) {
                 logger.info ("CheckBox is already in needed state");
             } else  if ((isStateCheck && !isCheckBoxSelected) || (isStateUncheck && isCheckBoxSelected)) {
                 clickOnElement(checkBox);
             }

         } else {
             logger.error("State should be only 'check' or 'uncheck'");
             stopTestAndPrintMessage();
         }
     }
}
