package lifelabs.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAnAppointmentPage {
	public WebDriver driver;

	@FindBy(xpath = "(//a[text()='Ontario '])[1]")
	WebElement ontario;
	
	@FindBy(linkText = "British Columbia ")
	WebElement britishColumbia;
	
	@FindBy(linkText = "Saskatchewan ")
	WebElement saskatchewan;
	
	@FindBy(xpath = "//a/span[text()='Register ']")
	WebElement register;
	
	@FindBy(xpath = "//a/span[text()='Book an appointment']")
	WebElement bookAnAppointment;
	
	@FindBy(xpath = "//a[contains(text(),'Learn More')]")
	WebElement bookMyVisit;
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "Ontario":
			ontario.click();
			break;
		case "BritishColumbia":
			britishColumbia.click();
			break;
		case "Saskatchewan":
			saskatchewan.click();
			break;
		case "Register":
			register.click();
			break;
		case "BookAnAppointment":
			bookAnAppointment.click();
			break;
		case "BookMyVisit":
			bookMyVisit.click();
			break;
		}
	}


	public BookAnAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
