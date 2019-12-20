package eOrder.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class eOrderInboxPage {
	public WebDriver driver;

	@FindBy(xpath = "//input[@id='PatientNumber'][1]")
	WebElement shealthCard;

	@FindBy(xpath = "//input[@id='Last_Name'][1]")
	WebElement slastName;

	@FindBy(xpath = "//input[@id='First_Name'][1]")
	WebElement sfirstName;

	@FindBy(xpath = "//tr[@id='ButtonRow1']//input[@value='Search']")
	WebElement searchBtn;

	@FindBy(id = "eOrderButton")
	WebElement eOrderBtn;
	
	@FindBy(id = "SearchButton")
	WebElement searchButton;

	@FindBy(xpath = "//input[@value='newwithphn']")
	WebElement NewPatientHCN;

	@FindBy(xpath = "//input[@value='newwithoutphn']")
	WebElement NewPatientwithoutHCN;

	@FindBy(id = "btneOrderRetrievePatient")
	WebElement Create_eOrderNewPatient;

	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "healthcard":
			shealthCard.sendKeys(text);
			break;
		case "lastname":
			slastName.sendKeys(text);
			break;
		case "firstname":
			sfirstName.sendKeys(text);
			break;
		}
	}

	public void click(String element) {
		switch (element) {
		case "search":
			searchBtn.click();
			break;
		case "searchbutton":
			searchButton.click();
			break;
		case "eorder":
			eOrderBtn.click();
			break;
		case "newpatientwithHCN":
			NewPatientHCN.click();
			break;
		case "newpatientwithoutHCN":
			NewPatientwithoutHCN.click();
			break;
		case "createordernewpatient":
			Create_eOrderNewPatient.click();
			break;
		}
	}

	@FindBy(id = "RolesDropDownList")
	WebElement ddRoles;

	public void selectRole(String roleType) {
		Select RolesType = new Select(ddRoles);
		RolesType.selectByVisibleText(roleType);
	}
	
	public void clear(String element) throws InterruptedException {
		switch (element) {
		case "healthcard":
			shealthCard.clear();
			break;
		case "lastname":
			slastName.clear();
			break;
		case "firstname":
			sfirstName.clear();
			break;
		}
	}

	public int getTotalResults() {
		List<WebElement> rowCount = driver.findElements(By.xpath("//tr[starts-with(@id,'prow_')]"));
		int TotalSearchResults = rowCount.size();
		return TotalSearchResults;
	}

	public eOrderInboxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
