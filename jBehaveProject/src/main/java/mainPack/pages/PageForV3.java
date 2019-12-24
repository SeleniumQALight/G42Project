package mainPack.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;

public class PageForV3 extends PageObject {
	public boolean iselementPresent(WebElementFacade elementFacade){
		try {
			return elementFacade.isEnabled();
		}catch (ElementNotFoundException e){
			return false;
		}catch (NoSuchElementException e){
			return false;
		}
	}
}
