package oracleApex.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedBackExistingFormPage {
	public WebDriver driver;

	//Page elements for update status
	@FindBy(xpath = "//input[@value='O' and @id='P2_SURVEY_STATUS_0']")
	WebElement newStatus;
	
	@FindBy(xpath = "//input[@value='P' and @id='P2_SURVEY_STATUS_1']")
	WebElement inProgress;
	
	@FindBy(xpath = "//input[@value='C' and @id='P2_SURVEY_STATUS_2']")
	WebElement closed;
	
	@FindBy(xpath = "//input[@id='P2_CAUSE_GROUP_ID_0']")
	WebElement causeGroup;
	
	@FindBy(xpath = "//input[@id='P2_CAUSE_ID_0']")
	WebElement cause;
	
	@FindBy(xpath = "//fieldset[@id='P2_STATUS_NOTES_fieldset']/textarea")
	WebElement notes;
	
	@FindBy(linkText = "Save Changes")
	WebElement saveChanges;
	
	@FindBy(id = "CANCEL_FEEDBACK")
	WebElement cancel;
	
	@FindBy(id = "DELETE_FEEDBACK")
	WebElement deleteFeedback;
	
	@FindBy(id = "open_nce_bt")
	WebElement openNce;
	
	//Page elements for redelegate
	@FindBy(xpath = "//section[@id='R6150612988980532']/div/h1/a/img")
	WebElement redelegate;
	
	@FindBy(xpath = "//table[@id='P2_LOCATION_NAME_R_holder']/tbody/tr/td[2]/div/button[2]")
	WebElement redelegateShowValues;
	
	@FindBy(xpath = "//textarea[@id='P2_COMMENTS_R']")
	WebElement reDelegationComments;
	
	//Page elements for copyTo
	@FindBy(xpath = "//section[@id='REGIONCOPYTO']/div/h1/a/img")
	WebElement copyTo;
	
	@FindBy(xpath = "//table[@id='P2_LOCATION_NAME_C_holder']/tbody/tr/td[2]/div/button[2]")
	WebElement copyToShowValues;
	
	@FindBy(xpath = "//textarea[@id='P2_COMMENTS_C']")
	WebElement copyToComments;
	
	//Page element for Delete Alert
	@FindBy(id = "alertify-ok")
	WebElement deleteYes;
	
	
	//Page elements for Notes
	@FindBy(xpath = "//img[@alt='Add Note']")
	WebElement addNotes;
	
	@FindBy(id = "P2_NOTES")
	WebElement notesDescription;
	
	@FindBy(id = "ADD_NOTE")
	WebElement confirmNotes;
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "new":
			newStatus.click();
			break;
		case "inprogress":
			inProgress.click();
			break;
		case "closed":
			closed.click();
			break;
		case "causegroup":
			causeGroup.click();
			break;
		case "cause":
			cause.click();
			break;
		case "savechanges":
			saveChanges.click();
			break;
		case "cancel":
			cancel.click();
			break;
		case "deletefeedback":
			deleteFeedback.click();
			break;
		case "opennce":
			openNce.click();
			break;
		case "redelegate":
			redelegate.click();
			break;
		case "redelegateshowvalue":
			redelegateShowValues.click();
			break;
		case "copyto":
			copyTo.click();
			break;
		case "copytoshowvalues":
			copyToShowValues.click();
			break;
		case "deleteyes":
			deleteYes.click();
			break;
		case "addnotes":
			addNotes.click();
			break;
		case "confirmnotes":
			confirmNotes.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "notes":
			notes.sendKeys(text);
			break;
		case "redelegationcomments":
			reDelegationComments.sendKeys(text);
			break;
		case "copytocomments":
			copyToComments.sendKeys(text);
			break;
		case "notesdescription":
			notesDescription.sendKeys(text);
			break;
		}
	}
	
	/*public void select_dropdown(String user) {
		Select userDropdown = new Select(user_dropdown);
		userDropdown.selectByValue(user);
	}*/

	public FeedBackExistingFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}