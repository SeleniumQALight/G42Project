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

  public void enterTextIntToInput(WebElement webElement, String text) {
    try {
      webElement.clear();
      webElement.sendKeys(text);
      logger.info(text + " has been added to input");
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
      logger.info("Is element displayed -> false");
      return false;
    }
  }

  private void stopTestAndPrintMessage() {
    logger.error("Can't work with the element");
    Assert.fail("Can't work with the element");
  }

  public void selectValueInDDByJava(WebElement dropDown, String value) {
    try {
      Select select = new Select(dropDown);
      select.selectByValue(value);
      logger.info(value + " was selected in dropdown");
    } catch (Exception e) {
      stopTestAndPrintMessage();
    }
  }

  public void selectVisibleTextInDDByJava(WebElement dropDown, String text) {
    try {
      Select select = new Select(dropDown);
      select.selectByVisibleText(text);
      logger.info(text + " was selected in dropdown");
    } catch (Exception e) {
      stopTestAndPrintMessage();
    }
  }

  public boolean isElementDisplayed(String locator) {
    try {
      return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
    } catch (Exception e) {
      return false;
    }
  }

  public void clickOnElement(String xpath) {
    try {
      clickOnElement(webDriver.findElement(By.xpath(xpath)));
    } catch (Exception e) {
      stopTestAndPrintMessage();
    }
  }

  public void setSateToCheckBox2(WebElement checkBox, String expectedState) {
    try {
      WebElement checkbox = webDriver.findElement(By.xpath(expectedState));
      checkBox.click();
      logger.info(checkBox.isSelected());
    } catch (Exception e) {
      stopTestAndPrintMessage();
    }
  }

  public void setSateToCheckBox(WebElement checkBox, String expectedState) {
    boolean isStateCheck = expectedState.toLowerCase().equals("check");
    boolean isStateUnCheck = expectedState.toLowerCase().equals("uncheck");
    boolean isCheckboxSelected = checkBox.isSelected();

    if (isStateCheck || isStateUnCheck) {
      if ((isStateCheck && isCheckboxSelected) || (isStateUnCheck && !isCheckboxSelected)) {
        logger.info("Checkbox is already needed state");
      } else if ((isStateCheck && !isCheckboxSelected) || (isStateUnCheck && isCheckboxSelected)) {
        clickOnElement(checkBox);
      }
    } else {
      logger.error("State should be only check or uncheck");
    }
    stopTestAndPrintMessage();
  }
}
