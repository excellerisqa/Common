package kronos.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerGeniesWidget {
	public WebDriver driver;
	
	@FindBy(id = "searchQuery")
	WebElement quickFindSearch;
	
	@FindBy(id = "quickfindsearch_btn")
	WebElement quickFindSearchButton;

	@FindBy(xpath = "//span[text()='Timekeeping']")
	WebElement timeKeeping;

	@FindBy(xpath = "//a[text()='Add Punch']")
	WebElement addPunch;

	@FindBy(xpath = "//a[text()='Delete Punch']")
	WebElement deletePunch;
	
	@FindBy(xpath = "//a[text()='Add Pay Code']")
	WebElement addPayCode;
	
	@FindBy(xpath = "//a[text()='Delete Pay Code']")
	WebElement deletePayCode;
	
	//Add punch elements
	@FindBy(xpath = "//div[@class='dateinput-wrapper']/span/div/input")
	WebElement date;
	
	@FindBy(xpath = "//div[@class='krn-time-wrapp']/input")
	WebElement time;
	
	@FindBy(xpath = "(//div[@data-component='smart-dropdown']/div/input)[2]")
	WebElement addPayCodeAmount;
	
	@FindBy(xpath = "(//div[@data-component='smart-dropdown']/div/input)[2]")
	WebElement deletePayCodeAmount;
	
	@FindBy(xpath = "//span[text()='Cancel']")
	WebElement cancel;

	
	@FindBy(xpath = "//span[text()='Apply']")
	WebElement apply;
	
	@FindBy(xpath = "//button[text()='Apply']")
	WebElement addPayCodeApply;
	
	@FindBy(xpath = "//button[text()='Apply']")
	WebElement deletePayCodeApply;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement addPayCodeCancel;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement deletePayCodeCancel;
	
	@FindBy(xpath = "//div[@class='genieselector']")
	WebElement genieSelector;
	
	@FindBy(xpath = "//li[@title='Mgr Reconcile Timecard']/a")
	WebElement mgrReconcile;
	
	@FindBy(xpath = "//span[text()='Go To']")
	WebElement goTo;
	
	@FindBy(linkText = "People Editor")
	WebElement peopleEditor;


	/*public void Login(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
		okButton.click();
	}*/

	public void click(String element) throws InterruptedException {
		element.toLowerCase();
		switch (element) {
		case "quickfindsearchbutton":
			quickFindSearchButton.click();
			break;
		case "timekeeping":
			timeKeeping.click();
			break;
		case "addpunch":
			addPunch.click();
			break;
		case "deletepunch":
			deletePunch.click();
			break;
		case "addpaycode":
			addPayCode.click();
			break;
		case "deletepaycode":
			deletePayCode.click();
			break;
		case "apply":
			apply.click();
			break;
		case "cancel":
			cancel.click();
			break;
		case "addpaycodeapply":
			addPayCodeApply.click();
			break;
		case "addpaycodecancel":
			addPayCodeCancel.click();
			break;
		case "deletepaycodeapply":
			deletePayCodeApply.click();
			break;
		case "selector":
			genieSelector.click();
			break;
		case "manage reconcile timecard":
			mgrReconcile.click();
			break;
		case "goto":
			goTo.click();
			break;
		case "people editor":
			peopleEditor.click();
			break;
		}
	}
	
	public void clearText(String element){
		element.toLowerCase();
		switch (element) {
		case "quickfindsearch":
			quickFindSearch.clear();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "quickfindsearch":
			quickFindSearch.sendKeys(text);
			break;
		case "date":
			date.sendKeys(text);
			break;
		case "time":
			time.sendKeys(text);
			break;	
		case "addpaycodeamount":
			addPayCodeAmount.sendKeys(text);
			break;
		case "deletepaycodeamount":
			deletePayCodeAmount.sendKeys(text);
			break;
		}
	}

	public ManagerGeniesWidget(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}