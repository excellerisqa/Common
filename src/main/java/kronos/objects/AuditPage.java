package kronos.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuditPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div/div/input")
	WebElement category;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Audits']")
	WebElement categoryAudits;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Comments']")
	WebElement categoryComments;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Requests']")
	WebElement categoryRequests;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Overtime Requests']")
	WebElement categoryOvertimeRequests;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Signoff and Approval']")
	WebElement categorySignoffandApproval;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Moved Amounts']")
	WebElement categoryMovedAmounts;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Corrections']")
	WebElement categoryCorrections;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Schedule Audits']")
	WebElement categoryScheduleAudits;
	
	@FindBy(xpath = "//div[@id='categoryLabel']/../div[2]/div/div//span[@title='Day Lock Audits']")
	WebElement categoryDayLockAudits;
	

	public void click(String element) throws InterruptedException {
		element.toLowerCase();
		switch (element) {
		case "category":
			category.click();
			break;
		case "audits":
			categoryAudits.click();
			break;
		case "comments":
			categoryComments.click();
			break;
		case "requests":
			categoryRequests.click();
			break;
		case "overtime requests":
			categoryOvertimeRequests.click();
			break;
		case "signoff and approval":
			categorySignoffandApproval.click();
			break;
		case "moved amounts":
			categoryMovedAmounts.click();
			break;
		case "corrections":
			categoryCorrections.click();
			break;
		case "schedule audits":
			categoryScheduleAudits.click();
			break;
		case "day lock audits":
			categoryDayLockAudits.click();
			break;
		}
	}

	public AuditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}