package bloodMonitoring.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ObjectHelper;

public class BM_HomePage {
	public WebDriver driver;

	@FindBy(xpath = "//div[@id='delegation-list-content']/div/ul/li[2]/a")
	public static WebElement pastDelegation;
	@FindBy(xpath = "//div[@id='delegation-list-content']/div/ul/li[1]/a")
	public static WebElement activeDelegation;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[5]/button")
	public static WebElement delegation;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button")
	public static WebElement notificationsSubscription;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[4]/button")
	public static WebElement alertPreferences;
	@FindBy(xpath = "//div[@id='delegation-list-content']/div[1]/b")
	public static WebElement alertPreferenceList;
	@FindBy(id = "close")
	public static WebElement Close;
	@FindBy(xpath = "//div[@id='notification-subscription-container']/div/div[1]")
	public static WebElement notificationsList;
	@FindBy(id = "firstname-search")
	public static WebElement searchByFirstName;
	@FindBy(id = "patient-search-submit")
	public static WebElement searchButton;
	@FindBy(xpath = "//tr[@id='MainHL7Upload']//a")
	public static WebElement hl7uploadlink;

	@FindBy(id = "FileUpload")
	public static WebElement chooseFile;
	@FindBy(id = "UploadButton")
	public static WebElement uploadFileBtn;
	@FindBy(id = "UploadResults")
	public static WebElement uploadResults;

	@FindBy(id = "Mobile")
	public static WebElement smsMobileNumber;
	@FindBy(id = "saveAlertConfigBtn")
	public static WebElement AlertPrefconfirmButton;
	@FindBy(id = "btnBloodMonitorProgram")
	public static WebElement bloodMonitoringProgram;

	public static By shealthCard = By.id("PatientNumber");
	public static By slastName = By.xpath("//input[@id='Last_Name'][1]");
	public static By sfirstName = By.xpath("//input[@id='First_Name'][1]");
	public static By searchbtn = By.id("SEARCH");
	public static By dateOfbirth = By.id("DateOfBirth");
	public static By patientFoundName = By.xpath("//table[@id='HistSearchResults']/tbody/tr/td/table/tbody/tr/td[3]");

	public BM_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "healthcard":
			ObjectHelper.driver.findElement(shealthCard).sendKeys(text);
			break;
		case "lastname":
			ObjectHelper.driver.findElement(slastName).sendKeys(text);
			break;
		case "firstname":
			ObjectHelper.driver.findElement(sfirstName).sendKeys(text);
			break;
		case "dateOfbirth":
			ObjectHelper.driver.findElement(dateOfbirth).sendKeys(text);
			break;
		}
	}

	public static void searchpatient(String searchby, String phn) throws InterruptedException {
		ObjectHelper.driver.switchTo().frame("ifPatientSearch");

		enterText(searchby, phn);
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) ObjectHelper.driver;
		executor.executeScript("arguments[0].click();", ObjectHelper.driver.findElement(searchbtn));
		ObjectHelper.driver.switchTo().defaultContent();
	}

}
