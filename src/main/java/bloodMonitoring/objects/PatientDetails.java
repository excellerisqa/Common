package bloodMonitoring.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctions;


public class PatientDetails {
	public WebDriver driver;

	@FindBy(id = "patient_details_tab")
	public WebElement PatientDetailsLink;
	@FindBy(xpath = "//div[@id='mainForm']/div[1]/div[3]/div/div[2]/span/a")
	public WebElement edit;
	@FindBy(xpath = "//select[@id='SelectedLanguage']/option[1]")
	public WebElement EnglishLanguage;
	@FindBy(xpath = "//select[@id='SelectedLanguage']/option[2]")
	public WebElement frenchLanguage;
	@FindBy(xpath = "//div[@id='mainForm']/div[2]/div[2]/div/label")
	public WebElement alertLanguage;

	public PatientDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void LanguagePreference(String patient) throws Exception {
		ProgramMonitoring.selectingPatientFromList(patient);
		CommonFunctions.waitForVisiblity(PatientDetailsLink, 5);
		PatientDetailsLink.click();
		CommonFunctions.waitForVisiblity(edit, 5);
		edit.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", alertLanguage);
		Thread.sleep(10000);
		CommonFunctions.waitandClick(By.id("SelectedLanguage"), 5);
		Assert.assertTrue(EnglishLanguage.getText().equals("EN"));
		Assert.assertTrue(frenchLanguage.getText().equals("FR"));
	}

}
