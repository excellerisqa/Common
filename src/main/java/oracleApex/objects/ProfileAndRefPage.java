	package oracleApex.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileAndRefPage {
	public WebDriver driver;

	@FindBy(linkText = "Profile")
	WebElement profile;
	
	@FindBy(linkText = "References")
	WebElement references;
	
	@FindBy(id = "P170_DATE_FROM")
	WebElement dateFrom;
	
	@FindBy(id = "P170_DATE_TO")
	WebElement dateTo;
	
	@FindBy(xpath = "//button[@title='Show Values']")
	WebElement delegateValues;
	
	@FindBy(id = "SAVE_BUTTON")
	WebElement save;
	
	public void click(String element) throws InterruptedException {
		switch (element) {
		case "profile":
			profile.click();
			break;
		case "references":
			references.click();
			break;
		case "delegatevalues":
			delegateValues.click();
			break;
		case "save":
			save.click();
			break;
		}
	}
	
	public void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "datefrom":
			dateFrom.sendKeys(text);
			break;
		case "dateto":
			dateTo.sendKeys(text);
			break;
		}
	}
	
	/*public void clear(String element) throws InterruptedException {
		switch (element) {
		case "geneticsclientcity":
			geneticsClientCity.clear();
			break;
		}
	}*/

	public ProfileAndRefPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}