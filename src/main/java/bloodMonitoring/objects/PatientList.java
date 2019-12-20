package bloodMonitoring.objects;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;


public class PatientList {
	public WebDriver driver;

	@FindBy(id = "patientListIndex_info")
	public static WebElement patientIndex;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[3]/div/div[2]/button[2]")
	public static WebElement enterTestResults;
	@FindBy(xpath = "//div[@id='testResultsContent']/div[1]/div/div[1]/h4")
	public static WebElement TestResultsTitle;
	@FindBy(id = "PatientTestResult_CollectionDate")
	public static WebElement TestResultsDate;
	@FindBy(id = "PatientTestResult_AccessionNo")
	public static WebElement TestResultsAccessinNo;
	@FindBy(id = "PatientTestResult_Source")
	public static WebElement TestResultsSource;
	@FindBy(id = "ManualEntrySave")
	public static WebElement TestResultsSaveButton;
	@FindBy(id = "ManualEntryCancel")
	public static WebElement TestResultsCancelButton;
	@FindBy(id = "ManualEntryX")
	public static WebElement TestResultsCloseButton;
	@FindBy(id = "graphOrTable-Table")
	public static WebElement ResultstableView;
	@FindBy(xpath = "//div[@id='resultsNotesTable']/table/tbody/tr[1]/td/b")
	public static WebElement ResultsDate;
	@FindBy(id = "ManualEntryStatusBox")
	public static WebElement ResultstableStatus;

	public final static Logger logger = Logger.getLogger("Delegation");

	public PatientList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void OpeningBloodMonitorApplication() throws Exception {
		Thread.sleep(5000);
		// InfusionHistory.iframe(driver);
		ObjectHelper.driver.switchTo().frame("ifInbox");
		// clicking on Blood monitor Tab
		CommonFunctions.waitandClick(By.id("btnBloodMonitor"), 3);
		CommonFunctions.waitForVisiblity(By.xpath("//table[@id='patientListIndex']/tbody/tr[1]/td[2]"), 30);
	}

	public boolean patientStatus(String Patient, String Status) throws Exception {
		boolean finalResult = false;
		OpeningBloodMonitorApplication();
		// getting the patients count in the list
		List<WebElement> patientsize = ObjectHelper.driver
				.findElements(By.cssSelector("#patientListIndex > tbody > tr > td.sorting_1"));
		System.out.println("patientList size =" + patientsize.size());
		// loop to iterate and select the patient from list
		for (int i = 1; i <= patientsize.size(); i++) {
			WebElement patientName = ObjectHelper.driver
					.findElement(By.xpath("//table[@id='patientListIndex']/tbody/tr[" + i + "]/td[3]"));
			if (patientName.getText().equals(Patient)) {
				WebElement status = ObjectHelper.driver
						.findElement(By.xpath("//table[@id='patientListIndex']/tbody/tr[" + i + "]/td[11]"));
				if (status.getText().equals(Status)) {
					finalResult = true;
					break;
				} else {
					finalResult = false;
					break;
				}
				// Assert.assertTrue(status.getText().equals(Status));
			}
		}
		return finalResult;
	}

	public void commonFunctionForEnteringResults() throws Exception {
		String[] TestResults = XLHandler.readexcel("Sheet1", 13, "Test.xlsx");
		List<String> TestResult = Arrays.asList(TestResults[1], TestResults[2], TestResults[3], TestResults[4],
				TestResults[5], TestResults[6], TestResults[7], TestResults[8], TestResults[9], TestResults[10],
				TestResults[11], TestResults[12], TestResults[13], TestResults[14], TestResults[15], TestResults[16]);
		CommonFunctions.waitForVisiblity(TestResultsTitle, 5);
		logger.info("TestResultsTitle.getText()" + TestResultsTitle.getText() + TestResult.get(1));
		Assert.assertTrue(TestResultsTitle.getText().contains(TestResult.get(1)));
		TestResultsAccessinNo.click();
		TestResultsAccessinNo.sendKeys(TestResult.get(2));
		TestResultsSource.click();
		TestResultsSource.sendKeys(TestResult.get(3));
		for (int i = 1; i <= 4; i++) {
			WebElement results = ObjectHelper.driver.findElement(By.xpath(
					"//div[@id='testResultsContent']/div[1]/div/div[2]/div[5]/table/tbody/tr[" + i + "]/td[2]/input"));
			WebElement minValue = ObjectHelper.driver.findElement(By.xpath(
					"//div[@id='testResultsContent']/div[1]/div/div[2]/div[5]/table/tbody/tr[" + i + "]/td[4]/input"));
			WebElement maxValue = ObjectHelper.driver.findElement(By.xpath(
					"//div[@id='testResultsContent']/div[1]/div/div[2]/div[5]/table/tbody/tr[" + i + "]/td[5]/input"));
			WebElement checkbox = ObjectHelper.driver.findElement(By.xpath(
					"//div[@id='testResultsContent']/div[1]/div/div[2]/div[5]/table/tbody/tr[" + i + "]/td[6]/input"));
			results.click();
			results.sendKeys(TestResult.get(i + 3));
			minValue.click();
			minValue.sendKeys(TestResult.get(i + 7));
			maxValue.click();
			maxValue.sendKeys(TestResult.get(i + 10));
			checkbox.click();
		}
	}

}
