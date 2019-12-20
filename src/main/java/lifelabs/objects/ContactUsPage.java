package lifelabs.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	public WebDriver driver;

	@FindBy(xpath = "//nav[@class='left-tabs-nav']/ul/li/a")
	WebElement contactUs;
	
	@FindBy(xpath = "//nav[@class='left-tabs-nav']/ul/li[2]/a")
	WebElement requestMedicalConsult;
	
	@FindBy(xpath = "//nav[@class='left-tabs-nav']/ul/li[3]/a")
	WebElement businessPartnership;
	
	@FindBy(xpath = "//nav[@class='left-tabs-nav']/ul/li[4]/a")
	WebElement community;
	
	@FindBy(xpath = "//nav[@class='left-tabs-nav']/ul/li[5]/a")
	WebElement officesAndMainLab;
	
	@FindBy(xpath = "//nav[@class='left-tabs-nav']/ul/li[6]/a")
	WebElement media;
	
	@FindBy(xpath = "(//div[@class='bgtwo-button']/a)[1]")
	WebElement patientFaq;
	
	@FindBy(xpath = "(//div[@class='bgtwo-button']/a)[2]")
	WebElement hcpFaq;
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "ContactUs":
			contactUs.click();
			break;
		case "RequestMedicalConsult":
			requestMedicalConsult.click();
			break;
		case "BusinessPartnership":
			businessPartnership.click();
			break;
		case "Community":
			community.click();
			break;
		case "OfficesAndMainLab":
			officesAndMainLab.click();
			break;
		case "Media":
			media.click();
			break;
		case "PatientFaq":
			patientFaq.click();
			break;
		case "HcpFaq":
			hcpFaq.click();
			break;
		}
	}


	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
