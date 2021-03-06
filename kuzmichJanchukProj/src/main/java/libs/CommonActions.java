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

public class CommonActions {
    private WebDriver driver;
    private Logger log = Logger.getLogger(getClass());
    private WebDriverWait webDriverWait_10, webDriverWait_15;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        webDriverWait_10 = new WebDriverWait(driver, 10);
        webDriverWait_15 = new WebDriverWait(driver, 15);
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
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(element));
            //webDriverWait_10.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
            element.click();
            log.info("Element was clicked" + getElementName(element));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private String getElementName(WebElement element) {
        String elementName = "";
        if(element instanceof TypifiedElement)  {
            elementName = " '" + ((TypifiedElement)element).getName() + "'";
        }
        return elementName;
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

    public void selectValueInDDByJava(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            log.info(value + " was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void selectVisibleTextInDDByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            log.info(text + " was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(driver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try {
            clickOnElement(driver.findElement(By.xpath(xpath)));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

//    public void toggleCheckbox(WebElement checkboxLocator, String action) {
//        switch (action) {
//            case "check":
//                try {
//                    if (!checkboxLocator.isSelected()) {
//                        checkboxLocator.click();
//                    } else {
//                        log.info("Checkbox is already checked!");
//                    }
//                } catch (Exception e) {
//                    stopTestAndPrintMessage();
//                }
//                break;
//            case "uncheck":
//                try {
//                    if (checkboxLocator.isSelected()) {
//                        checkboxLocator.click();
//                    } else {
//                        log.info("Checkbox is already unchecked!");
//                    }
//                } catch (Exception e) {
//                    stopTestAndPrintMessage();
//                }
//                break;
//            default:
//                log.error("Wrong action parameter! Use <check> or <uncheck> only.");
//                break;
//        }
//}
    public void setStateToCheckbox(WebElement checkBox, String state) {
        boolean isStateChecked = state.toLowerCase().equals("check");
        boolean isStateUnchecked = state.toLowerCase().equals("uncheck");
        boolean isCheckboxSelected = checkBox.isSelected();

        if(isStateChecked || isStateUnchecked) {
            if((isStateChecked && isCheckboxSelected) || (isStateUnchecked && !isCheckboxSelected)) {
                log.info("Checkbox is already in desired state.");
            } else if ((isStateChecked && !isCheckboxSelected) || (isStateUnchecked && isCheckboxSelected)) {
                clickOnElement(checkBox);
            }
        } else {
            log.error("State should be only 'check' or 'uncheck'");
            stopTestAndPrintMessage();
        }
    }
}

