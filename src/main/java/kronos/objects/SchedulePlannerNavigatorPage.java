package kronos.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePlannerNavigatorPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//i[@class='icon-k-tabular-view']")
	WebElement tabularView;
	
	@FindBy(xpath = "//i[@class='icon-k-new-gantt-view']")
	WebElement ganttView;
	
	@FindBy(xpath = "//div[@id='schedule-hyperfind-selector component-hyperfind']/div/input")
	WebElement location;
	
	@FindBy(xpath = "//div[@ng-if='model.isAmount']/div/input")
	WebElement addPayCodeAmount;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement AddPayCodeCancel;
	
	@FindBy(xpath = "//button[text()='Apply']")
	WebElement AddPayCodeApply;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement Save;
	
	@FindBy(xpath = "//span[text()='Refresh']")
	WebElement Refresh;
	
	@FindBy(xpath = "//button[text()='Apply']")
	WebElement AddShiftApply;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement EditShiftCancel;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement AvailabilityOk;
	
	@FindBy(xpath = "//span[text()='Yes']")
	WebElement DeleteAvailabilityYes;

	/*public void Login(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
		okButton.click();
	}*/

	public void click(String element) throws InterruptedException {
		element.toLowerCase();
		switch (element) {
		case "tabularview":
			tabularView.click();
			break;
		case "ganttview":
			ganttView.click();
			break;
		case "location":
			location.click();
			break;
		case "addpaycodeapply":
			AddPayCodeApply.click();
			break;
		case "addpaycodecancel":
			AddPayCodeCancel.click();
			break;
		case "addshiftapply":
			AddShiftApply.click();
			break;
		case "editshiftcancel":
			EditShiftCancel.click();
			break;
		case "save":
			Save.click();
			break;
		case "refresh":
			Refresh.click();
			break;
		case "availabilityok":
			AvailabilityOk.click();
			break;
		case "deleteavailabilityyes":
			DeleteAvailabilityYes.click();
			break;
			
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "addpaycodeamount":
			addPayCodeAmount.sendKeys(text);
			break;
		/*case "deletepaycodeamount":
			deletePayCodeAmount.sendKeys(text);
			break;*/
		}
	}
	public SchedulePlannerNavigatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}