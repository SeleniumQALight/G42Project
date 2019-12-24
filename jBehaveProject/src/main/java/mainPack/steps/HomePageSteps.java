package mainPack.steps;

import mainPack.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void isAvatarPresent() {
        homePage.isAvatarPresent();
    }
}