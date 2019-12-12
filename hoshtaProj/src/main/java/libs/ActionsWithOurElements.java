package libs;

import org.aeonbits.owner.ConfigFactory;
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
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
        this.webDriverWait_10 = new WebDriverWait(webDriver, configProperties.TIME_FOR_DFFAULT_WAIT());
        this.webDriverWait_15 = new WebDriverWait(webDriver, configProperties.TIME_FOR_EXPLICIT_WAIT_LOW());
    }

    public void enterTextIntoInput(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered into input.");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            //webDriverWait_10.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)));
            webElement.click();
            logger.info("Element " + getElementName(webElement) + "was clicked");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private String getElementName(WebElement webElement) {
        return (webElement instanceof TypifiedElement) ? "'" + ((TypifiedElement) webElement).getName() + "'" + " " : "";
    }

    public boolean isElementDisplayed(WebElement webElement) {
        String element = (webElement instanceof TypifiedElement) ? " '" + ((TypifiedElement) webElement).getName() + "'" : "";
        String elementIsNotDisplayedMessage = String.format("Element%s is not displayed", element);
        try {
            boolean state = webElement.isDisplayed();
            String message = state ? String.format("Element%s is displayed", element) : elementIsNotDisplayedMessage;
            logger.info(message);
            return state;
        } catch (Exception e) {
            logger.info(elementIsNotDisplayedMessage);
            return false;
        }
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        String errorText = "Can not work with element ";
        logger.error(errorText);
        Assert.fail(errorText);
    }

    public int getNumberOfElements(By by) {
        logger.info("Get number of elements");
        return webDriver.findElements(by).size();
    }

    public String getText(WebElement webElement) {
        logger.info("Get text of the element");
        return webElement.getText();
    }

    public void selectValueInDDByJava(WebElement dropDoown, String value) {
        try {
            Select select = new Select(dropDoown);
            select.selectByValue(value);
            logger.info(value + " value was selected in dropdown");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void selectVisibleTextInDDByJava(WebElement dropDoown, String text) {
        try {
            Select select = new Select(dropDoown);
            select.selectByVisibleText(text);
            logger.info(text + " value was selected in dropdown");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }


    public void clickElement(String locator) {
        try {
            webDriver.findElement(By.xpath(locator)).click();
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void setSateToCheckBox(WebElement webelement, String expectedState) {
        try {
            String actualState = webelement.isSelected() ? "checked" : "unchecked";
            if (!actualState.equals(expectedState)) {
                webelement.click();
                logger.info("State of checkbox was changed to " + expectedState);
            } else {
                logger.info("State of checkbox is already " + expectedState);
            }
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }
}
