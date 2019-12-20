package eOrder.objects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GlobalAdminHomePage {

	public WebDriver driver;

	// Site Administrator User Maintenance elements
	
	@FindBy(xpath = "//input[@name='sUserID']")
	WebElement UserId;

	@FindBy(xpath = "//input[@name='sLastname']")
	WebElement LastName;

	@FindBy(xpath = "//input[@name='sFirstname']")
	WebElement FirstName;

	@FindBy(id = "sSearchUserStatus")
	WebElement Status;

	@FindBy(id = "sOrganization")
	WebElement Organizations;
	
	//Navigate section elements

	@FindBy(linkText = "User Entry")
	WebElement UserEntry;

	@FindBy(linkText = "Physician Entry")
	WebElement PhysicianEntry;

	@FindBy(linkText = "Location Entry")
	WebElement LocationEntry;

	@FindBy(linkText = "Test Catalogue Entry")
	WebElement TestCatalogueEntry;

	@FindBy(linkText = "Standardized Test Catalog")
	WebElement StandardizedTestCatalog;

	@FindBy(linkText = "Audit Review")
	WebElement AuditReview;

	@FindBy(linkText = "Exception Management")
	WebElement ExceptionManagement;

	@FindBy(linkText = "MyEHealth Patient Mapping")
	WebElement MyEHealthPatientMapping;

	@FindBy(linkText = "HL7 Upload")
	WebElement HL7Upload;

	@FindBy(linkText = "Status Update")
	WebElement StatusUpdate;
	
	@FindBy(linkText = "Hardcopy Reprint")
	WebElement HardcopyReprint;
	
	//other options in the page
	@FindBy(xpath = "//input[@id='btnSearch']")
	WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@id='btnReport']")
	WebElement ReportBtn;
	
	@FindBy(xpath = "//input[@id='btnNew']")
	WebElement NewBtn;

	@FindBy(xpath = "//input[@value='LOG-OFF']")
	WebElement LogOff;

	// common error message for invalid value
	@FindBy(xpath = "//div[@class='error error-spacing']//strong")
	WebElement ErrorMessage;


	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "userid":
			UserId.sendKeys(text);;
			break;
		case "lastname":
			LastName.sendKeys(text);
			break;
		case "firstname":
			FirstName.sendKeys(text);
			break;
		}
	}

	public void click(String element) {
		element.toLowerCase();
		switch (element) {
		case "userentry":
			UserEntry.click();
			break;
		case "physicianentry":
			PhysicianEntry.click();
			break;
		case "locationentry":
			LocationEntry.click();
			break;
		case "testcatalogueentry":
			TestCatalogueEntry.click();
			break;
		case "standardizedtestcatalog":
			StandardizedTestCatalog.click();
			break;
		case "auditreview":
			AuditReview.click();
			break;
		case "exceptionmanagement":
			ExceptionManagement.click();
			break;
		case "myeHealthpatientmapping":
			MyEHealthPatientMapping.click();
			break;
		case "hl7upload":
			HL7Upload.click();
			break;
		case "statusupdate":
			StatusUpdate.click();
			break;
		case "hardcopyreprint":
			HardcopyReprint.click();
			break;
		case "search":
			SearchBtn.click();
			break;
		case "new":
			NewBtn.click();
			break;
		case "report":
			ReportBtn.click();
			break;
		case "logoff":
			LogOff.click();
			break;
		}
	}
	
	public void selectStatus(String status) {
		Select sts = new Select(Status);
		status.toLowerCase();
		switch (status) {
		case "active":
			sts.selectByVisibleText("Active");
			break;
		case "deleted":
			sts.selectByVisibleText("Deleted");
			break;
		}
	}
	
	public void selectOrg(String organization) {
		Select org = new Select(Status);
		organization.toLowerCase();
		switch (organization) {
		case "brantford general hospital":
			org.selectByVisibleText("Brantford General Hospital");
			break;
		case "cambridge memorial hospital":
			org.selectByVisibleText("Deleted");
			break;
		}
	}
			
	public GlobalAdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
}
