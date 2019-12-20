package oracleApex.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedBackPage {
	public WebDriver driver;
	
	@FindBy(linkText = "Feedback")
	WebElement feedback;

	@FindBy(linkText = "New Feedback Entry")
	WebElement newFeedbackEntry;
	
	@FindBy(xpath = "//a[@id='apexir_SEARCHDROPROOT']")
	WebElement searchDropDown;
	
	@FindBy(xpath = "//a[@id='ID']")
	WebElement idSearch;
	
	@FindBy(xpath = "//button[@value='Go']")
	WebElement go;
	
	@FindBy(xpath = "//a[contains(text(),'ID')]/../../td[4]/a/img")
	WebElement removeIdFilter;
	
	@FindBy(linkText = "New")
	WebElement newStatus;
	
	@FindBy(linkText = "In Progress")
	WebElement inProgress;
	
	@FindBy(linkText = "Closed")
	WebElement closed;
	
	@FindBy(xpath = "//input[@title='Search Report']")
	WebElement search;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "feedback":
			feedback.click();
			break;
		case "newfeedback":
			newFeedbackEntry.click();
			break;
		case "searchdropdown":
			searchDropDown.click();
			break;
		case "idsearch":
			idSearch.click();
			break;
		case "go":
			go.click();
			break;
		case "removeidfilter":
			removeIdFilter.click();
			break;
		case "new":
			newStatus.click();
			break;
		case "inprogress":
			inProgress.click();
			break;
		case "closed":
			closed.click();
			break;
		case "logout":
			logout.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "search":
			search.sendKeys(text);
			break;
		}
	}

	public FeedBackPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}