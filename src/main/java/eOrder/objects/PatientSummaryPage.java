package eOrder.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientSummaryPage {
	public WebDriver driver;

	// Patient details
	@FindBy(id = "idPHN")
	WebElement healthNumber;

	@FindBy(id = "idName")
	WebElement name;

	@FindBy(id = "idDOB")
	WebElement Birthdate;

	@FindBy(id = "idPhone")
	WebElement Phone;

	@FindBy(xpath = "//td[@id='RecordTabs4']//a")
	WebElement eOrdersCount;

	// Links on the page

	@FindBy(id = "btnLabRequisitionCreate")
	WebElement Create_eOrderBtn;

	@FindBy(id = "SearchButton")
	WebElement Search;

	@FindBy(id = "InboxButton")
	WebElement Inbox;
	
	@FindBy(xpath = "//table[@class='fullW MainContextBar']/tbody/tr/td")
	WebElement patientSummaryInbox;
	
	@FindBy(xpath = "//td[@class='fullW MainContextBar']/table/tbody/tr/td")
	WebElement patientSummaryInboxOne;

	@FindBy(xpath = "//input[@value='LOG-OFF']")
	WebElement LogOff;

	// Methods to access these webelements

	public String getText(String element) {
		element.toLowerCase();
		switch (element) {
		case "healthnumber":
			return healthNumber.getText();
		case "name":
			return name.getText();
		case "birthdate":
			return Birthdate.getText();
		case "phone":
			return Phone.getText();
		case "eorderscount":
			return eOrdersCount.getText();
		}
		return null;
	}

	public void click(String element) {
		element.toLowerCase();
		switch (element) {
		case "createeOrder":
			Create_eOrderBtn.click();
			break;
		case "search":
			Search.click();
			break;
		case "inbox":
			Inbox.click();
			break;
		case "patientsummaryinbox":
			patientSummaryInbox.click();
			break;
		case "patientsummaryinboxone":
			patientSummaryInboxOne.click();
			break;
		case "logoff":
			LogOff.click();
			break;
		}
	}



	public PatientSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
