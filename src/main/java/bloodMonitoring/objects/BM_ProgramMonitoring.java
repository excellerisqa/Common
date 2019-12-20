package bloodMonitoring.objects;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class BM_ProgramMonitoring {
	public WebDriver driver;

	@FindBy(id = "graphOrTable-Table")
	public static WebElement tableWithNotesCheckbox;
	@FindBy(id = "graphOrTable-Graph")
	public static WebElement graphCheckbox;
	@FindBy(css = "#patientListIndex > tbody > tr > td.sorting_1")
	public static List<WebElement> patientList;
	@FindBy(id = "AbnormalOrCriticalChk")
	public static WebElement abnormalOrCriticalCheckbox;
	@FindBy(css = "#resultsNotesTable > table > tbody > tr > td:nth-child(2) > table > tbody > tr > td:nth-child(2) > img")
	public static List<WebElement> resultList;
	@FindBy(id = "date-filter")
	public static WebElement reviewDatesFilter;
	@FindBy(id = "test-filter")
	public static WebElement groupByFilter;
	@FindBy(xpath = "//div[@id='resultsNotesTable']/table/thead/tr/td[1]/b")
	public static WebElement column1Table;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[1]/span")
	public static WebElement patientHeader;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/a")
	public static WebElement patientHeaderMore;
	@FindBy(xpath = "//li[@id='patient_details_tab']/a")
	public static WebElement PatientDetailsLink;
	@FindBy(xpath = "//li[@id='event_log_tab']/a")
	public static WebElement eventLog;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[2]/div[1]/div[2]/span")
	public static WebElement patientEnrollmentDate;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/span")
	public static WebElement patientLeftDate;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button")
	public static WebElement close;
	@FindBy(xpath = "//table[@id='patientListIndex']/tbody/tr[1]/td[2]")
	public static WebElement pname;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[3]/div/div[2]/a")
	public static WebElement resetTestDueDates;
	@FindBy(xpath = "//div[@id='DueDateWindow']/div/div[1]/div")
	public static WebElement resetTestDueDatesWindow;
	@FindBy(css = "#chartTemplate0 > div.chartContainer.k-chart > svg > g > g:nth-child(3) > g:nth-child(4) > g > image:nth-child(2)")
	public static WebElement hCTResulticon;
	@FindBy(css = "#chartTemplate0 > div.chartContainer.k-chart > svg > g > g:nth-child(3) > g:nth-child(4) > g > image")
	public static WebElement hCTResulticon1;
	@FindBy(css = "#chartTemplate1 > div.chartContainer.k-chart > svg > g > g:nth-child(3) > g:nth-child(4) > g > image")
	public static WebElement iTPResulticon;
	@FindBy(css = "#chartTemplate2 > div.chartContainer.k-chart > svg > g > g:nth-child(3) > g:nth-child(4) > g > image")
	public static WebElement TSHResulticon1;
	@FindBy(xpath = "//div[@id='NoteWindow']/div/div/div/div[2]/div[3]/button")
	public static WebElement ReportButton;

	@FindBy(id = "ack")
	public static WebElement ackCheckbox;
	@FindBy(xpath = "//div[@id='AddNoteWindow']/div/div/div[4]/input[1]")
	public static WebElement ackOkButoon;
	@FindBy(xpath = "//div[@id='NoteDetailsWindow']/div/div/div[5]/input[1]")
	public static WebElement ackOK;
	@FindBy(xpath = "//div[@id='NoteWindow']/div/div/div/div[1]/div[2]/span[1]")

	public static WebElement hCTResult;
	@FindBy(xpath = "//div[@id='NoteWindow']/div/div/div/div[1]/div[6]")
	public static WebElement manualEntryTestResult;

	@FindBy(xpath = "//div[@id='NoteWindow']/div/div/div/div[2]/div[2]/button")
	public static WebElement NotesButton;
	@FindBy(xpath = "//div[@id='NoteDetailsWindow']/div/div/div[3]/button")
	public static WebElement AddNotesButton;

	@FindBy(xpath = "//div[@id='NoteWindow']/div/div/div/div[2]/div[4]/button")
	public static WebElement closeResult;

	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/table/tbody/tr[1]/td")
	public static WebElement programName;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/table/tbody/tr[3]/th")
	public static WebElement firstInfusion;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/table/tbody/tr[4]/th")
	public static WebElement lastInfusion;

	public final static Logger logger = Logger.getLogger("ProgramMonitoring");

	public BM_ProgramMonitoring(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void selectingPatientFromList(String patient) throws Exception {
		Thread.sleep(3000);
		// InfusionHistory.iframe(driver);
		ObjectHelper.driver.switchTo().frame("ifInbox");
		// clicking on Blood monitor Tab
		CommonFunctions.waitandClick(By.id("btnBloodMonitor"), 30);
		CommonFunctions.waitForVisiblity(By.xpath("//table[@id='patientListIndex']/tbody/tr[1]/td[2]"), 30);
		// getting the patients count in the list
		List<WebElement> patientsize = ObjectHelper.driver
				.findElements(By.cssSelector("#patientListIndex > tbody > tr > td.sorting_1"));
		System.out.println("patientList size =" + patientsize.size());
		// loop to iterate and select the patient from list
		for (int i = 1; i <= patientsize.size(); i++) {
			WebElement patientName = ObjectHelper.driver
					.findElement(By.xpath("//table[@id='patientListIndex']/tbody/tr[" + i + "]/td[3]"));
			System.out.println("patientname : " + patientName.getText());
			if (patientName.getText().equals(patient)) {
				patientName.click();
				break;
			}
		}
	}

	public static void selectingPatientFromBMList(String patient) throws Exception {
		CommonFunctions.waitForVisiblity(By.xpath("//table[@id='patientListIndex']/tbody/tr[1]/td[3]"), 5);
		// getting the patients count in the list
		List<WebElement> patientsize = ObjectHelper.driver
				.findElements(By.cssSelector("#patientListIndex > tbody > tr > td.sorting_1"));
		System.out.println("patientList size =" + patientsize.size());
		// loop to iterate and select the patient from list
		for (int i = 1; i <= patientsize.size(); i++) {
			WebElement patientName = ObjectHelper.driver
					.findElement(By.xpath("//table[@id='patientListIndex']/tbody/tr[" + i + "]/td[3]"));
			System.out.println("patientname : " + patientName.getText());
			if (patientName.getText().equalsIgnoreCase(patient)) {
				((JavascriptExecutor) ObjectHelper.driver).executeScript("arguments[0].scrollIntoView(true);",
						patientName);
				Thread.sleep(2000);
				patientName.click();
				break;
			}
		}
	}

	public void programonitorTableView_18366(String patient) throws Exception {
		selectingPatientFromList(patient);
		CommonFunctions.waitForVisiblity(By.id("graphOrTable-Table"), 5);
		Assert.assertTrue(graphCheckbox.getAttribute("value").contains("Graph"));
		Assert.assertTrue(tableWithNotesCheckbox.getAttribute("value").contains("Table"));
		tableWithNotesCheckbox.click();
		CommonFunctions.waitForVisiblity(By.id("AbnormalOrCriticalChk"), 5);
		abnormalOrCriticalCheckbox.click();
		System.out.println("resultList size =" + resultList.size());
		int rownum3 = 0;
		for (int i = 2; i <= resultList.size(); i++) {
			WebElement rows = ObjectHelper.driver
					.findElement(By.xpath("//div[@id='resultsNotesTable']/table/tbody/tr[1]/td"));
			String x = rows.getAttribute("rowspan");
			int rownum = Integer.parseInt(x);
			CommonFunctions.waitForVisiblity(
					By.xpath("//div[@id='resultsNotesTable']/table/tbody/tr[" + i + "]/td[2]/table/tbody/tr/td[2]/img"),
					3);
			WebElement resultName = ObjectHelper.driver.findElement(By
					.xpath("//div[@id='resultsNotesTable']/table/tbody/tr[" + i + "]/td[2]/table/tbody/tr/td[2]/img"));
			System.out.println("result" + i);
			if (i == rownum || i == rownum3) {
				i++;
				WebElement rows1 = ObjectHelper.driver
						.findElement(By.xpath("//div[@id='resultsNotesTable']/table/tbody/tr[" + i + "]/td"));
				String x1 = rows1.getAttribute("rowspan");
				int rownum1 = Integer.parseInt(x1);
				int rownum2 = rownum1 + i;
				rownum3 = rownum2 - 1;
			}
			Assert.assertTrue(resultName.isDisplayed());
		}
		Assert.assertTrue(column1Table.getText().equals("Test Date"));
		groupByFilter.click();
		CommonFunctions.waitandClick(By.xpath("//select[@id='test-filter']/option[2]"), 5);
		Thread.sleep(5000);
		// WebElement column1 = ObjectHelper.driver
		// .findElement(By.xpath("//div[@id='resultsNotesTable']/table/thead/tr/td[1]/b"));
		Assert.assertTrue(column1Table.getText().equals("Test"));
		reviewDatesFilter.click();
		List<String> resultList = Arrays.asList("Custom...", "Last 30 Days", "Last 3 Months", "Last 6 Months",
				"Last 1 Year", "Last 2 Years", "Last 3 Years", "Last 5 Years", "Since Enrollment", "All");
		for (int i = 1; i <= 10; i++) {
			WebElement datesFilter = ObjectHelper.driver
					.findElement(By.xpath("//select[@id='date-filter']/option[" + i + "]"));
			Assert.assertTrue(datesFilter.getText().contentEquals(resultList.get(i - 1)));
		}
	}

	public void programonitorDefaultGraphView_16967(String patient) throws Exception {
		selectingPatientFromList(patient);
		CommonFunctions.waitForVisiblity(By.id("graphOrTable-Table"), 5);
		System.out.println("checkbox checked =" + graphCheckbox.getAttribute("checked"));
		Assert.assertTrue(graphCheckbox.getAttribute("checked").contains("true"));
		Assert.assertTrue(tableWithNotesCheckbox.getAttribute("value").contains("Table"));
		tableWithNotesCheckbox.click();
		CommonFunctions.waitForVisiblity(By.id("graphOrTable-Table"), 5);
		System.out.println("checkbox checked =" + tableWithNotesCheckbox.getAttribute("checked"));
		Assert.assertTrue(tableWithNotesCheckbox.getAttribute("checked").contains("true"));
	}

	public void patientHeaderView_16943(String patient, ITestContext con) throws Exception {
		Thread.sleep(3000);
		patientHeaderViewCommonFunction(patient, con);
		CommonFunctions.waitForVisiblity(By.id("PatientDetailsLink"), 5);
		PatientDetailsLink.click();
		patientHeaderViewCommonFunction(patient, con);
		eventLog.click();
		patientHeaderViewCommonFunction(patient, con);
	}

	public void patientHeaderViewCommonFunction(String patient, ITestContext con) throws Exception {
		CommonFunctions.waitForVisiblity(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/span"), 5);
		Assert.assertTrue(patientHeader.getText().contains(patient));
		String testDataFileName = con.getCurrentXmlTest().getParameter("testDataFile");
		String[] patients = XLHandler.readexcel("Sheet1", 14, testDataFileName);
		String[] expecteds = XLHandler.readexcel("Sheet1", 15, testDataFileName);
		// patient BIG ETHEL details
		List<String> resultList = Arrays.asList(patients[1], patients[2], patients[3], patients[4], patients[5],
				patients[6], patients[7], patients[8]);
		for (int i = 1; i <= 8; i++) {
			WebElement header = ObjectHelper.driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/span[" + i + "]"));
			System.out.println("header: " + header.getText());
			Assert.assertTrue(header.getText().contains(resultList.get(i - 1)));
		}
		Assert.assertTrue(patientHeaderMore.getText().contains("More..."));
		List<String> resultList1 = Arrays.asList(expecteds[1], expecteds[2], expecteds[3]);
		for (int i = 1; i <= 3; i++) {
			WebElement header = ObjectHelper.driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/span[3]/span[" + i + "]"));
			System.out.println("header: " + header.getText());
			Assert.assertTrue(resultList1.get(i - 1).contains(header.getText()));
		}
	}

	public static boolean PatientEnrollmentDate_16806(ITestContext con) throws Exception {
		// getting test data from excel sheet
		boolean finalresult = false;
		BM_ProgramMonitoring pm = new BM_ProgramMonitoring(ObjectHelper.driver);
		String testDataFileName = con.getCurrentXmlTest().getParameter("testDataFile");
		String[] patients = XLHandler.readexcel("Sheet1", 3, testDataFileName);
		String[] expecteds = XLHandler.readexcel("Sheet1", 4, testDataFileName);
		List<String> patient = Arrays.asList(patients[1], patients[2], patients[3]);
		List<String> expected = Arrays.asList(expecteds[1], expecteds[2], expecteds[3]);
		selectingPatientFromList(patient.get(0));
		CommonFunctions.waitForVisiblity(By.xpath("/html/body/div[2]/div[5]/div[1]/div[2]/div[1]/div[2]/span"), 15);
		// BaseClass.bh.addactionstep(2);
		boolean result1;
		boolean result2 = false;
		if (patientEnrollmentDate.getText().contains(expected.get(0))) {
			// BaseClass.bh.addactionstep(2);
			result1 = true;
		} else {
			// BaseClass.bh.addexpected(2);
			result1 = false;
		}
		BM_ProgramMonitoring.close.click();
		CommonFunctions.waitForVisiblity(pname, 25);
		for (int i = 1; i < 3; i++) {
			selectingPatientFromBMList(patient.get(i));
			CommonFunctions
					.waitForVisiblity(By.xpath("html/body/div[2]/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/span"), 25);
			if (patientLeftDate.getText().contains(expected.get(i))) {
				// BaseClass.bh.addactionstep(2 + i);
				result2 = true;
			} else {
				// BaseClass.bh.addexpected(2 + i);
				result2 = false;
				break;
			}
			BM_ProgramMonitoring.close.click();
		}
		if (result1 && result2)
			return finalresult = true;
		else
			return finalresult = false;
	}

	public static boolean isAttribtuePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

}
