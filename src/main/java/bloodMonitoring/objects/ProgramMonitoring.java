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


public class ProgramMonitoring {
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
	@FindBy(id = "patient_details_tab")
	public static WebElement PatientDetailsLink;
	@FindBy(id = "event_log_tab")
	public static WebElement eventLog;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[2]/div[1]/div[2]/span")
	public static WebElement patientEnrollmentDate;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/span")
	public static WebElement patientLeftDate;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button")
	public static WebElement close;
	@FindBy(xpath = "//table[@id='patientListIndex']/tbody/tr[1]/td[2]")
	public static WebElement pname;

	public final static Logger logger = Logger.getLogger("ProgramMonitoring");

	public ProgramMonitoring(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void selectingPatientFromList(String patient) throws Exception {
		Thread.sleep(3000);
		// InfusionHistory.iframe(driver);
		ObjectHelper.driver.switchTo().frame("ifInbox");
		// clicking on Blood monitor Tab
		CommonFunctions.waitandClick(By.id("btnBloodMonitor"), 3);
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
			if (patientName.getText().equals(patient)) {
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

	public void patientHeaderView_16943(String patient) throws Exception {
		Thread.sleep(3000);
		patientHeaderViewCommonFunction(patient);
		CommonFunctions.waitForVisiblity(By.id("PatientDetailsLink"), 5);
		PatientDetailsLink.click();
		patientHeaderViewCommonFunction(patient);
		eventLog.click();
		patientHeaderViewCommonFunction(patient);
	}

	public void patientHeaderViewCommonFunction(String patient) throws Exception {
		CommonFunctions.waitForVisiblity(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/span"), 5);
		Assert.assertTrue(patientHeader.getText().contains(patient));
		// patient BIG ETHEL details
		List<String> resultList = Arrays.asList("Male", "yr", "", "Phone:", "5555555555", "Mobile:", "5555555555",
				"bethel@hotmail.com");
		for (int i = 1; i <= 8; i++) {
			WebElement header = ObjectHelper.driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/span[" + i + "]"));
			System.out.println("header: " + header.getText());
			Assert.assertTrue(header.getText().contains(resultList.get(i - 1)));
		}
		Assert.assertTrue(patientHeaderMore.getText().contains("More..."));
		List<String> resultList1 = Arrays.asList("DOB:", "May 24, 1967", "9291393090");
		for (int i = 1; i <= 3; i++) {
			WebElement header = ObjectHelper.driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/span[3]/span[" + i + "]"));
			System.out.println("header: " + header.getText());
			Assert.assertTrue(header.getText().contains(resultList1.get(i - 1)));
		}
	}

	public static boolean PatientEnrollmentDate_16806() throws Exception {
		// getting test data from excel sheet
		boolean finalresult = false;
		ProgramMonitoring pm = new ProgramMonitoring(ObjectHelper.driver);
		String[] patients = XLHandler.readexcel("Sheet1", 3, "Test.xlsx");
		String[] expecteds = XLHandler.readexcel("Sheet1", 4, "Test.xlsx");
		List<String> patient = Arrays.asList(patients[1], patients[2], patients[3]);
		List<String> expected = Arrays.asList(expecteds[1], expecteds[2], expecteds[3]);
		selectingPatientFromList(patient.get(0));
		CommonFunctions.waitForVisiblity(By.xpath("/html/body/div[2]/div[5]/div[1]/div[2]/div[1]/div[2]/span"), 5);
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
		pm.close.click();
		CommonFunctions.waitForVisiblity(pname, 5);
		for (int i = 1; i < 3; i++) {
			selectingPatientFromBMList(patient.get(i));
			CommonFunctions
					.waitForVisiblity(By.xpath("html/body/div[2]/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/span"), 5);
			if (patientLeftDate.getText().contains(expected.get(i))) {
				// BaseClass.bh.addactionstep(2 + i);
				result2 = true;
			} else {
				// BaseClass.bh.addexpected(2 + i);
				result2 = false;
				break;
			}
			pm.close.click();
		}
		if (result1 && result2)
			return finalresult = true;
		else
			return finalresult = false;
	}

}
