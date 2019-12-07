package pages.pageElements;

import java.lang.reflect.Field;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.pagefactory.CustomElementLocatorFactory;

public class WebDriverAwareDecorator extends HtmlElementDecorator{
  private WebDriver driver;

  public WebDriverAwareDecorator(CustomElementLocatorFactory factory, WebDriver driver) {
    super(factory);

    this.driver = driver;
  }

  @Override
  protected <T extends HtmlElement> T decorateHtmlElement(ClassLoader loader, Field field) {
    T element = super.decorateHtmlElement(loader, field);

    if (element instanceof pages.pageElements.WebDriverAware) {
      ((pages.pageElements.WebDriverAware)element).setWebDriver(driver);
    }

    return element;
  }

}
