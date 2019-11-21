package Libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.EditSparePage;

public class ActionsWithOurElements {
    WebDriver webDriver; //обявляем переменную webDriver
    Logger logger = Logger.getLogger(getClass());
    public ActionsWithOurElements(WebDriver webDriver) { // на пустом месте правая кн. клавиатуры / Generate / Constructor чтоб вручную его не создавать
        this.webDriver = webDriver;
    }

    public void enterTextInToInput (WebElement webElement, String text ) { // webElement - это элемент куда хотим ввести текст, text - это сам текст
        try {
            webElement.clear(); // очищаем поле
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to input");
        } catch (Exception e) {
            stopTestAndPrintMassage ();
        }
    }

    public void clickOnElement(WebElement webElement) { // метод который кликает на элемент
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e){
           stopTestAndPrintMassage();
        }
    }

    public boolean isElementDisplayed (WebElement webElement) { // метод, который проверяет отображение элемента
        try {
            boolean state = webElement.isDisplayed(); // запись во временную переменную состояния = отображается / не отображается
            logger.info("Is element displayed -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("Is element displayed -> " + false); // когда нет элемента
            return false;
        }
    }

    private void stopTestAndPrintMassage() {
        logger.error("Can not work with element"); // будет писать сообщение в лог
        Assert.fail("Can not work with element"); // будет писать сообщение в отчет
    }

    public void selectVisibleTextInDDByJava(WebElement dropDown, String text) { // РЕАЛИЗОВАТЬ!!!!!!!!
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + "selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMassage();
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
            stopTestAndPrintMassage();
        }
    }
}
