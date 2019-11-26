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

    public void selectValueInDDByJava(WebElement dropDown, String value) { // Value - из html структуры, по Value метод работает быстрей чем по text
        try {
            Select select = new Select(dropDown); // Select - выбираем орг опен кю ей селениум саппорт; объявили переменную select типа Select - этот класс работает
            // только с дроп даунами с селектами и опшионсами; Select(dropDown) - передаем в селект дропдаун; мы обратились к дропдауну и получили все чо у него есть
            select.selectByValue(value);
            logger.info(value + "was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMassage();
        }
    }
    public void selectVisibleTextInDDByJava(WebElement dropDown, String text) { // text -  из html структуры
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + "was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMassage();
        }
    }
    public boolean isElementDisplayed(String locator) { // м-д который находит что запчасть отображается
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator))); // здесь isElementDisplayed - м-д, который принимает вебелемент, умеет спрашивать
            //у элемента есть он или нет. Это пример полиморфизма, когда есть одинаково названные методы, которые работают с вебелементом или стрингой
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

//    public void setSateToCheckBox(WebElement webelement, String expectedState){ //м-д устанавливает чек бокс если он пустой
////        webelement.findElement(By.xpath(".//*/li[@id='spares']")); // найти чек бокс
//        String expectedState = webelement.findElement(By.xpath(".//*/li[@id='spares']"));;
//        if (expectedState == webelement.getAttribute(class("''")));  // если чек бокс активен - ничего не делать
//        {)
//
//        }else {
//
//        }
//        String state = webelement.isDisplayed(); // запись во временную переменную состояния = отображается / не отображается
//            logger.info("Is element displayed -> " + state);
//локатор, когда чек бокс активен       .//*/li[@class='active' and @id='spares']
// локатор, когда чек бокс не активен   .//*/li[@class='' and @id='spares']
//    }
}
