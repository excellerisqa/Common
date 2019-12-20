package bloodMonitoring.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctions;

public class BM_PatientDetails {
	public WebDriver driver;

	@FindBy(id = "patient_details_tab")
	public WebElement PatientDetailsLink;
	@FindBy(xpath = "//div[@id='mainForm']/div[1]/div[3]/div/div[2]/span/a")
	public WebElement edit;
	@FindBy(xpath = "//div[@id='mainForm']/div[1]/div[3]/div/div[2]")
	public static WebElement editButton;
	@FindBy(xpath = "//select[@id='SelectedLanguage']/option[1]")
	public WebElement EnglishLanguage;
	@FindBy(xpath = "//select[@id='SelectedLanguage']/option[2]")
	public WebElement frenchLanguage;
	@FindBy(xpath = "//div[@id='mainForm']/div[2]/div[2]/div/label")
	public WebElement alertLanguage;
	@FindBy(id = "SelectedRegistrationStatus")
	public static WebElement PatientStatusDropDown;
	@FindBy(xpath = "//select[@id='SelectedRegistrationStatus']/option[2]")
	public static WebElement SuspendedOption;
	@FindBy(xpath = "//select[@id='SelectedRegistrationStatus']/option[3]")
	public static WebElement UnenrolledOption;
	@FindBy(xpath = "//select[@id='SelectedRegistrationStatus']/option[1]")
	public static WebElement ActiveOption;
	@FindBy(id = "Reason")
	public static WebElement PatientStatusReason;
	@FindBy(id = "UnenrolledOn")
	public static WebElement PatientUnenrolledOn;
	@FindBy(id = "SuspendedUntil")
	public static WebElement PatientSuspendedUntil;

	@FindBy(xpath = "//div[@id='healthcareteam-modal-container']/div/div[3]/input[1]")
	public static WebElement addTeamMember;
	@FindBy(xpath = "//div[@id='healthcareteam-modal-container']/div/div[3]/input[2]")
	public static WebElement addTeamMembercancel;

	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button")
	public static WebElement closeButton;
	@FindBy(xpath = "//div[@id='mainForm']/div[2]/div[1]/div/label")
	public static WebElement lemtradaId;
	@FindBy(xpath = "//div[@id='mainForm']/div[2]/div[18]/div/h4")
	public static WebElement infusionDatesHeader;

	public BM_PatientDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void LanguagePreference(String patient) throws Exception {
		BM_ProgramMonitoring.selectingPatientFromList(patient);
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
