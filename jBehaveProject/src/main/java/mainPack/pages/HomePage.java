package mainPack.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DefaultUrl("http://v3.test.itpmgroup.com/")
public class HomePage extends PageForV3 {

    @FindBy(xpath = ".//a//img[@src='/bundles/ap/adminlte/dist/img/avatar.png']")
    private WebElementFacade avatar;

    public void isAvatarPresent() {
        assertThat(iselementPresent(avatar), is(true));
    }

}