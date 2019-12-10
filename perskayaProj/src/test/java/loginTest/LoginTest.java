package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webdriver; //обявили в классе, чтоб webdriver можно было использовать во всех методах этого класса

    @Test //аннотация джейюнита, которая обозначает, что дальше будет идти тест кейс, который можно запускать без класса меин
    public void validLogin(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webdriver = new ChromeDriver(); //создали объект для браузера хром
        webdriver.manage().window().maximize();//сделать окно браузера на весь экран
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//каждые пол секунды по дефолту хром будет пробовать выполнить действие каждые пол
        //секунды на протяжении 5 секунд, по их истечению будет time timeout, implicitlyWait - не явное ожидание

        webdriver.get("http://v3.test.itpmgroup.com"); //ccылка на наш сайт


        webdriver.findElement(By.name("_username")).clear(); //найти этот элемент и очистить поле от возможных значний
        webdriver.findElement(By.name("_username")).sendKeys("Student"); //найти элемент по тегу name значение "_username" или написать by.xpath и в середине
        // кавычек полных xpath. sendKeys - метод, который вводит буквы/цифры с клавиатуры, но не ентер/пробел и т.д.
        webdriver.findElement(By.id("password")).clear();
        webdriver.findElement(By.id("password")).sendKeys("906090");
        webdriver.findElement(By.tagName("button")).click(); //click - метод клика мышки
        // Пример изначального асерта:
        // Assert.assertTrue("Avatar is not present", webdriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());
        // Assert - это объект, который будет делать проверки, у него есть разные методы, например assertTrue - он на вход ждет тру, если мы ему передадим
        // в скобках тру, то тест зеленый. Если мы в скобках передаем фолс, то тест будет красный и выведется сообщение из кавычек.
        // webdriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()) - метод который проверяет отображение аватарки
        Assert.assertTrue("Avatar is not present", isAssertPresent ());


                webdriver.quit();//закрыть браузер
    }

    private boolean isAssertPresent() {
        try {  //как работает: попробуй выполнить то, что написано в этих скобках, если возникнет ексепнш перехвати его и выполни то, что в catch написано
        return webdriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();
        } catch (Exception e) {
        return false;
        }
    }


}
