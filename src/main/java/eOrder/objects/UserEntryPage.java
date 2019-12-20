package eOrder.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserEntryPage {
	
	public WebDriver driver;

	// Site Administrator User Entry elements
	
	@FindBy(xpath = "//input[@id='btnPassword']")
	WebElement PasswordBtn;
	
	@FindBy(xpath = "//input[@id='btnCancel']")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//input[@id='btnDelete']")
	WebElement DeleteBtn;

	@FindBy(linkText = "Manage Attributes")
	WebElement ManageAttributes;

	@FindBy(linkText = "Manage Profiles")
	WebElement ManageProfiles;

	@FindBy(xpath = "//a[text()='Manage Delegation']")
	WebElement ManageDelegation;



	public void click(String element) {
		element.toLowerCase();
		switch (element) {
		case "password":
			PasswordBtn.click();
			break;
		case "cancel":
			CancelBtn.click();
			break;
		case "save":
			SaveBtn.click();
			break;
		case "delete":
			DeleteBtn.click();
			break;
		case "manageattributes":
			ManageAttributes.click();
			break;
		case "manageprofiles":
			ManageProfiles.click();
			break;
		case "managedelegation":
			ManageDelegation.click();
			break;
		}
	}

			
	public UserEntryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



}
