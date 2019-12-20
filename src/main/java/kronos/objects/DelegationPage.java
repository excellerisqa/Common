package kronos.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DelegationPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Mgr_Delegation")
	WebElement mgrDelegation;
	
	@FindBy(id = "rb_createDelegation")
	WebElement createNewDelegation;
	
	@FindBy(id = "rb_deleteDelegation")
	WebElement removeDelegation;
	
	@FindBy(xpath = "//input[@value='Next']")
	WebElement nextBtn;
	
	@FindBy(id = "elStartDate")
	WebElement delegationStartDate;
	
	@FindBy(id = "elEndDate")
	WebElement delegationEndDate;
	
	@FindBy(xpath = "//input[@name='save_button']")
	WebElement delegationSave;
	
	@FindBy(xpath = "//input[@name='cancel_button']")
	WebElement delegationCancel;
	
	@FindBy(id = "rb_accept")
	WebElement acceptDelegation;
	
	@FindBy(id = "rb_reject")
	WebElement declineDelegation;

	/*public void Login(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
		okButton.click();
	}*/

	public void click(String element) throws InterruptedException {
		element.toLowerCase();
		switch (element) {
		case "mgrdelegation":
			mgrDelegation.click();
			break;
		case "delegationsave":
			delegationSave.click();
			break;
		case "delegationcancel":
			delegationCancel.click();
			break;
		case "createnewdelegation":
			createNewDelegation.click();
			break;
		case "removedelegation":
			removeDelegation.click();
			break;
		case "nextbutton":
			nextBtn.click();
			break;
		case "acceptdelegation":
			acceptDelegation.click();
			break;
		case "declinedelegation":
			declineDelegation.click();
			break;
		}
	}
	
	/*
	public void clearText(String element){
		element.toLowerCase();
		switch (element) {
		case "quickfindsearch":
			quickFindSearch.clear();
			break;
		}
	}*/
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "delegationstartdate":
			delegationStartDate.sendKeys(text);
			break;
		case "delegationenddate":
			delegationEndDate.sendKeys(text);
			break;
		}
	}

	public DelegationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}