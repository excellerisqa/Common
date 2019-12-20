package kronos.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageTimeCardWidget {
	public WebDriver driver;

	@FindBy(xpath = "//span[text()='Approve Timecard']")
	WebElement approveTimecardDropdown;

	@FindBy(xpath = "//a[text()='Approve Timecard']")
	WebElement approveTimecard;

	@FindBy(xpath = "//a[text()='Remove Timecard Approval']")
	WebElement removeTimecard;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement Save;
	
	@FindBy(xpath = "//span[text()='Apply']")
	WebElement apply;
	
	@FindBy(xpath = "//i[@class='icon-k-calendar']")
	WebElement calendarFilter;
	
	@FindBy(xpath = "//div[@class='timeframeDateSelect']/span/div/div/div/span/div/input")
	WebElement filterStartDate;
	
	@FindBy(linkText = "Cancel")
	WebElement commentCancel;
	
	@FindBy(linkText = "OK")
	WebElement commentOk;

	public void click(String element) throws InterruptedException {
		element.toLowerCase();
		switch (element) {
		case "approvetimecarddropdown":
			approveTimecardDropdown.click();
			break;
		case "approvetimecard":
			approveTimecard.click();
			break;
		case "removetimecard":
			removeTimecard.click();
			break;
		case "save":
			Save.click();
			break;
		case "apply":
			apply.click();
			break;
		case "calendar":
			calendarFilter.click();
			break;
		case "commentcancel":
			commentCancel.click();
			break;
		case "commentok":
			commentOk.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "startdate":
			filterStartDate.sendKeys(text);
			break;
		}
	}

	public ManageTimeCardWidget(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}