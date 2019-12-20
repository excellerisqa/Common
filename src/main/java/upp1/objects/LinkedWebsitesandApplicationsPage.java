package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LinkedWebsitesandApplicationsPage {
	WebDriver driver;

	public LinkedWebsitesandApplicationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
