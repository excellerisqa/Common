	package oracleApex.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {
	public WebDriver driver;

	@FindBy(linkText = "Reports")
	WebElement reports;
	
	@FindBy(linkText = "Dashboard")
	WebElement dashboard;
	
	@FindBy(linkText = "Overall Satisfaction")
	WebElement overallSatisfaction;
	
	@FindBy(linkText = "Ranked Attributes")
	WebElement rankedAttributes;
	
	@FindBy(linkText = "Comments Report")
	WebElement commentsReport;
	
	@FindBy(linkText = "Response Distribution")
	WebElement responseDistribution;
	
	@FindBy(linkText = "Trending by Survey Scores")
	WebElement surveyScores;
	
	@FindBy(linkText = "Trending by Feedback types")
	WebElement feedbackType;
	
	@FindBy(linkText = "Feedback Types by Location")
	WebElement feedbackTypeByLocation;
	
	@FindBy(linkText = "MedSci Consult Dashboard")
	WebElement medSciConsultDashboard;
	
	@FindBy(linkText = "Surveys")
	WebElement surveys;
	
	@FindBy(xpath = "//img[@title='Popup Calendar: From Date']")
	WebElement fromDate;
	
	@FindBy(xpath = "//img[@title='Popup Calendar: To Date']")
	WebElement toDate;
	
	@FindBy(xpath = "//span[text()='Prev']")
	WebElement prevButton;
	
	@FindBy(xpath = "//a[text()='1']")
	WebElement one;
	
	@FindBy(id = "B45593564547299198")
	WebElement runReport;
	
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "reports":
			reports.click();
			break;
		case "dashboard":
			dashboard.click();
			break;
		case "overallsatisfaction":
			overallSatisfaction.click();
			break;
		case "rankedattributes":
			rankedAttributes.click();
			break;
		case "commentsreport":
			commentsReport.click();
			break;
		case "responsedistribution":
			responseDistribution.click();
			break;
		case "surveyscores":
			surveyScores.click();
			break;
		case "feedbacktype":
			feedbackType.click();
			break;
		case "feedbacktypebylocation":
			feedbackTypeByLocation.click();
			break;
		case "medsciconsultdashboard":
			medSciConsultDashboard.click();
			break;
		case "surveys":
			surveys.click();
			break;
		case "fromdate":
			fromDate.click();
			break;
		case "todate":
			toDate.click();
			break;
		case "prevbutton":
			prevButton.click();
			break;
		case "1":
			one.click();
			break;
		case "runreport":
			runReport.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		/*case "search":
			search.sendKeys(text);
			break;*/
		}
	}

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}