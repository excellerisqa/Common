package oracleApex.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FeedBackFormPage {
	public WebDriver driver;

	@FindBy(linkText = "New Feedback Entry")
	WebElement newFeedbackEntry;

	//Page Elements in province radio button
	@FindBy(xpath = "//input[@value='AB' and @name='p_t25']")
	WebElement alberta;
	
	@FindBy(xpath = "//input[@value='BC' and @name='p_t25']")
	WebElement britishColumbia;
	
	@FindBy(xpath = "//input[@value='ON' and @name='p_t25']")
	WebElement ontario;
	
	@FindBy(xpath = "//input[@value='SK' and @name='p_t25']")
	WebElement saskatchewan;
	
	//Page elements in 'Assign to' radio buttons
	@FindBy(xpath = "//input[@value='10005' and @name='p_t26']")
	WebElement brl;
	
	@FindBy(xpath = "//input[@value='10030']")
	WebElement rma;
	
	@FindBy(xpath = "//input[@value='136' and @name='p_t26']")
	WebElement hospitalContract;
	
	@FindBy(xpath = "//input[@value='278' and @name='p_t26']")
	WebElement geneticsLab;
	
	//Page elements in 'Business Unit group' radio buttons
	@FindBy(xpath = "//input[@value='1060']")
	WebElement accounting;
	
	@FindBy(xpath = "//input[@value='1260' and @name='p_t27']")
	WebElement chemistry;
	
	//Page elements in 'Feedback Channel' radio buttons
	@FindBy(xpath = "//input[@value='CEMAIL']")
	WebElement contactUsEmail;
	
	@FindBy(xpath = "//input[@value='EMAIL']")
	WebElement email;
	
	@FindBy(xpath = "//input[@value='CCARD']")
	WebElement commentCard;
	
	@FindBy(xpath = "//input[@value='SMEDIA']")
	WebElement socialMedia;
	
	//Page elements in 'Internal Location' buttons
	@FindBy(xpath = "//label[@for='P2_INTERNAL_LOCATION_NAME']/../..//tr/td[2]/div/button[2]")
	WebElement internalLocation;
	
	//Page elements in 'Customer' radio buttons
	@FindBy(xpath = "//input[@value='2' and @name='p_t31']")
	WebElement patient;
	
	@FindBy(xpath = "//input[@value='3' and @name='p_t31']")
	WebElement other;
	
	@FindBy(xpath = "//input[@value='4' and @name='p_t31']")
	WebElement internal;
	
	//Page elements for Customer details
	@FindBy(xpath = "//input[contains(@id, 'CUSTOMER_NAME')]")
	WebElement customername;
	
	@FindBy(xpath = "//input[contains(@id, 'CUSTOMER_PHONE')]")
	WebElement customerphone;
	
	@FindBy(xpath = "//input[contains(@id, 'CUSTOMER_EMAIL')]")
	WebElement customeremail;
	
	@FindBy(xpath = "//textarea[@id='P2_COMMENTS']")
	WebElement comments;
	
	
	//Page elements for Reason Group
	@FindBy(xpath = "//label[contains(@for,'REASON_GROUP') and text()='Accounts']/../input")
	WebElement accounts;
	
	@FindBy(xpath = "//label[contains(@for,'REASON_GROUP') and text()='Appointments']/../input")
	WebElement appointments;
	
	@FindBy(xpath = "//label[contains(@for,'REASON_GROUP') and text()='Courier Services']/../input")
	WebElement courierServices;
	
	@FindBy(xpath = "//label[contains(@for,'REASON_GROUP') and text()='Miscellaneous']/../input")
	WebElement misc;
	
	
	//Page elements for 'Reason'
	@FindBy(xpath = "//label[contains(@for,'REASON') and text()='Address Change']/../input")
	WebElement addresschange;
	
	@FindBy(xpath = "//label[contains(@for,'REASON') and text()='Availability']/../input")
	WebElement availability;
	
	@FindBy(xpath = "//label[contains(@for,'REASON') and text()='Driving Behaviour']/../input")
	WebElement drivingBehaviour;
	
	@FindBy(xpath = "//label[contains(@for,'REASON') and text()='Client Error']/../input")
	WebElement clientError;
	
	//Page elements for Priority
	@FindBy(xpath = "//label[contains(@for,'PRIORITY') and text()='Normal']/../input")
	WebElement normal;
	
	@FindBy(xpath = "//label[contains(@for,'PRIORITY') and text()='Urgent']/../input")
	WebElement urgent;
	
	//Page elements for Feedback Type and attachment
	@FindBy(xpath = "//label[contains(@for,'FEEDBACK') and text()='Positive']/../input")
	WebElement positive;
	
	@FindBy(xpath = "//label[contains(@for,'FEEDBACK') and text()='Negative']/../input")
	WebElement negative;
	
	@FindBy(xpath = "//label[contains(@for,'FEEDBACK') and text()='Neutral']/../input")
	WebElement neutral;
	
	
	@FindBy(xpath = "//img[@alt='Add Attachment']")
	WebElement chooseFile;
	
	@FindBy(id = "P2_ATTACH_ONE")
	WebElement filePath;
	
	@FindBy(id = "P2_ATTACH_NAME")
	WebElement attachmentName;
	
	@FindBy(id = "SAVE_ATTACH")
	WebElement addAttachment;
	
	//page elements for 'Comment Card patient'
	
	@FindBy(xpath = "//label[text()='0 to 15 min']/../input")
	WebElement waitTime;
	
	@FindBy(xpath = "//label[contains(@for,'QID') and text()='Patient']/../input")
	WebElement areYou;
	
	@FindBy(xpath = "//label[contains(@for,'QID') and text()='10-Very Satisfied']/../input")
	WebElement satisfaction;
	
	@FindBy(xpath = "//label[contains(@for,'QID') and text()='10-Extremely likely']/../input")
	WebElement recommend;
	
	@FindBy(xpath = "//input[@value='3' and @name='p_t67']")
	WebElement waitingRoom;
	
	@FindBy(xpath = "//input[@value='4' and @name='p_t68']")
	WebElement waitTimeExp;
	
	@FindBy(xpath = "//input[@value='2' and @name='p_t69']")
	WebElement EmployeeCourtesy;
	
	@FindBy(xpath = "//input[@value='1' and @name='p_t70']")
	WebElement clinicalProcedure;
	
	@FindBy(xpath = "//input[@value='4' and @name='p_t71']")
	WebElement process;
	
	@FindBy(xpath = "//input[@value='2' and @name='p_t72']")
	WebElement convenience;
	
	@FindBy(xpath = "//b[contains(text(),'Opportunities for improvement')]/../../td[2]/fieldset/textarea")
	WebElement oppForImprovement;
	
	@FindBy(xpath = "//input[@id='P2_S_QID63_0']")
	WebElement receiveEmail;
	
	//Page elements for Status
	@FindBy(xpath = "//input[@value='O' and @id='P2_SURVEY_STATUS_0']")
	WebElement newstatus;
	
	@FindBy(xpath = "//input[@value='P' and @id='P2_SURVEY_STATUS_1']")
	WebElement inProgress;

	
	//Page elements for Status
	@FindBy(xpath = "//fieldset[@id='P2_STATUS_NOTES_fieldset']/textarea")
	WebElement notes;
	
	@FindBy(xpath = "//a[@class='uRegionControl uRegionCollapsed']")
	WebElement copyto;
	
	@FindBy(xpath = "//input[contains(@id,'P2_LOCATION') and @value='I']")
	WebElement user;
	
	@FindBy(xpath = "//input[contains(@id,'P2_LOCATION') and @value='L']")
	WebElement location;
	
	@FindBy(id = "P2_COPYTO_INDIVIDUAL")
	WebElement user_dropdown;
	
	@FindBy(xpath = "//table[@id='P2_LOCATION_NAME_C_holder']/tbody/tr/td[2]/div/button[2]")
	WebElement showvalues;
	
	@FindBy(xpath = "//textarea[@id='P2_COMMENTS_C']")
	WebElement copyToComments;	
	
	@FindBy(linkText = "Submit")
	WebElement submit;
	
	@FindBy(linkText = "Save Changes")
	WebElement saveChanges;
	
	@FindBy(linkText = "Cancel")
	WebElement cancel;

	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "newfeedback":
			newFeedbackEntry.click();
			break;
		case "alberta":
			alberta.click();
			break;
		case "britishcolumbia":
			britishColumbia.click();
			break;
		case "ontario":
			ontario.click();
			break;
		case "saskatchewan":
			saskatchewan.click();
			break;
		case "rma":
			rma.click();
			break;
		case "brl":
			brl.click();
			break;
		case "hospitalContract":
			hospitalContract.click();
			break;
		case "geneticslab":
			geneticsLab.click();
			break;
		case "accounting":
			accounting.click();
			break;
		case "chemistry":
			chemistry.click();
			break;
		case "contactusemail":
			contactUsEmail.click();
			break;
		case "email":
			email.click();
			break;
		case "commentcard":
			commentCard.click();
			break;
		case "socialmedia":
			socialMedia.click();
			break;
		case "internallocation":
			internalLocation.click();
			break;
		case "patient":
			patient.click();
			break;
		case "other":
			other.click();
			break;
		case "internal":
			internal.click();
			break;
		case "accounts":
			accounts.click();
			break;
		case "appointments":
			appointments.click();
			break;			
		case "courierservices":
			courierServices.click();
			break;
		case "misc":
			misc.click();
			break;
		case "availability":
			availability.click();
			break;
		case "drivingbehaviour":
			drivingBehaviour.click();
			break;
		case "clienterror":
			clientError.click();
			break;
		case "normal":
			normal.click();
			break;
		case "urgent":
			urgent.click();
			break;
		case "positive":
			positive.click();
			break;
		case "negative":
			negative.click();
			break;
		case "neutral":
			neutral.click();
			break;
		case "choosefile":
			chooseFile.click();
			break;
		case "addattachment":
			addAttachment.click();
			break;
		case "filepath":
			filePath.click();
			break;
		case "waittime":
			waitTime.click();
			break;
		case "areyou":
			areYou.click();
			break;
		case "satisfaction":
			satisfaction.click();
			break;
		case "recommend":
			recommend.click();
			break;
		case "waitingroom":
			waitingRoom.click();
			break;
		case "waittimeexp":
			waitTimeExp.click();
			break;		
		case "exployeecourtesy":
			EmployeeCourtesy.click();
			break;
		case "clinicalprocedure":
			clinicalProcedure.click();
			break;
		case "process":
			process.click();
			break;
		case "convenience":
			convenience.click();
			break;
		case "new":
			newstatus.click();
			break;
		case "inprogress":
			inProgress.click();
			break;
		case "copyto":
			copyto.click();
			break;
		case "location":
			location.click();
			break;
		case "user":
			user.click();
			break;
		case "showvalues":
			showvalues.click();
			break;
		case "submit":
			submit.click();
			break;	
		case "savechanges":
			saveChanges.click();
			break;
		case "cancel":
			cancel.click();
			break;
		case "addresschange":
			addresschange.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "customername":
			customername.sendKeys(text);
			break;
		case "customerphone":
			customerphone.sendKeys(text);
			break;
		case "customeremail":
			customeremail.sendKeys(text);
			break;
		case "comments":
			comments.sendKeys(text);
			break;
		case "notes":
			notes.sendKeys(text);
			break;
		case "opportunities":
			oppForImprovement.sendKeys(text);
			break;
		case "receiveemail":
			receiveEmail.sendKeys(text);
			break;
		case "copytocomments":
			copyToComments.sendKeys(text);
			break;
		case "attachmentname":
			attachmentName.sendKeys(text);
			break;
		}
	}
	
	public void select_dropdown(String user) {
		Select userDropdown = new Select(user_dropdown);
		userDropdown.selectByValue(user);
	}

	public FeedBackFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}