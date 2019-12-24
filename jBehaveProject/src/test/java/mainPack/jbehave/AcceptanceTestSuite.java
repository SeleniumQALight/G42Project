package mainPack.jbehave;

import net.thucydides.jbehave.ThucydidesJUnitStories;

public class AcceptanceTestSuite extends ThucydidesJUnitStories {
	public AcceptanceTestSuite() {
		System.setProperty("webdriver.chrome.driver", "..\\drivers\\chromedriver.exe");
		findStoriesCalled("**/*/*.story");
	}
}
