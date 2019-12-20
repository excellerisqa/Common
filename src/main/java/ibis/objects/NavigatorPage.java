package ibis.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigatorPage {
	public WebDriver driver;

	@FindBy(linkText = "CA Receivables Manager")
	WebElement receivablesManager;

	@FindBy(linkText = "Standard")
	WebElement customerStandard;

	public void click(String element) throws InterruptedException {
		switch (element) {
		case "receivablesmanager":
			receivablesManager.click();
			break;
		case "customerstandard":
			customerStandard.click();
			break;
		}
	}

	public NavigatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}