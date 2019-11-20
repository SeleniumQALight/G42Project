package libs;



import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;



public class ActionsWithOurElements {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    private WebDriverWait webDriverWait;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 5);

    }

    public void enterTextInToInput(WebElement webElement
            , String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to input " + getElementNameIfNameExist(webElement));
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement webElement){
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
            logger.info("Element was clicked " + getElementNameIfNameExist(webElement));
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement webElement){
        try {
           boolean state = webElement.isDisplayed();
           logger.info("Is element displayed -> " + state);
           return state;
        }catch (Exception e){
           logger.info("Is element displayed -> false");
           return false;
        }
    }

    private String getElementNameIfNameExist(WebElement webElement){
        String messageText = "";
        if (webElement instanceof TypifiedElement) { messageText = "'" + ((TypifiedElement) webElement).getName() + "'";}
        return messageText;
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }
}
