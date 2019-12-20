package lifelabs.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	@FindBy(xpath = "//a/span[text()='Book an Appointment']")
	WebElement bookAnAppointment;
	
	@FindBy(xpath = "//a[text()='Patients ']")
	WebElement patientFeedback;
	
	@FindBy(xpath = "//a[text()='HCP ']")
	WebElement healthCareProviderFeedback;
	
	@FindBy(xpath = "//div[@class='mh-top-menu']/ul/li[2]/a")
	WebElement headerContactUs;
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "BookAnAppointment":
			bookAnAppointment.click();
			break;
		case "PatientFeedback":
			patientFeedback.click();
			break;
		case "HealthCareProviderFeedback":
			healthCareProviderFeedback.click();
			break;
		case "HeaderContactUs":
			headerContactUs.click();
			break;
		}
	}
	
	/*public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "search":
			search.sendKeys(text);
			break;
		}
	}*/

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}