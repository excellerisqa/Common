package bloodMonitoring.objects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BM_EventLog {
	public static WebDriver driver;
	@FindBy(id = "date-filter")
	public WebElement dateFilter;
	@FindBy(id = "graphOrTable-Graph")
	public static WebElement graphCheckbox;
	@FindBy(css = "#patientListIndex > tbody > tr > td.sorting_1")
	public static List<WebElement> patientList;
	@FindBy(id = "event_log_tab")
	public static WebElement eventLog;
	@FindBy(css = "body > div.container-fluid.body-content > div.ng-scope > div:nth-child(2) > div > div > table > tbody > tr > td:nth-child(2) > span")
	public static List<WebElement> eventLogList;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/div[1]/label/input")
	public static WebElement critcalAlertsCheckbox;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/div[2]/label/input")
	public static WebElement abnormalAlertsCheckbox;
	@FindBy(xpath = "//div[@class='col-lg-11']/div[4]/label/input")
	public static WebElement missedAppointmentsCheckbox;
	@FindBy(xpath = "//div[@class='col-lg-11']/div[5]/label/input")
	public static WebElement upcomingAppointmentsCheckbox;

	public BM_EventLog(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void eventLogPatientAlertHis_18271(String patient) throws Exception {
		BM_ProgramMonitoring.selectingPatientFromList(patient);
		CommonFunctions.waitandClick(By.id("event_log_tab"), 5);
		// eventLog.click();
		CommonFunctions.waitForVisiblity(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[1]/label/input"), 5);
		List<String> resultList = Arrays.asList("criticalAlerts", "abnormalAlerts", "uninterpretableAlerts",
				"missedAppointments", "upcomingAppointments", "testDueDateChanged", "infusionAdministered", "noteAdded",
				"noteEdited", "returnFromSuspended");
		for (int i = 1; i <= 10; i++) {
			WebElement Filter = ObjectHelper.driver
					.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[" + i + "]/label/input"));
			Assert.assertTrue(Filter.getAttribute("type").equals("checkbox"));
			Assert.assertTrue(Filter.getAttribute("ng-model").contains(resultList.get(i - 1)));
		}
		dateFilter.click();
		CommonFunctions.waitandClick(By.xpath("//select[@id='date-filter']/option[1]"), 3);
		List<String> resultDateList = Arrays.asList("6 Months", "1 Year", "2 Years", "3 Years", "5 Years",
				"All results");
		for (int i = 1; i <= 6; i++) {
			WebElement Filter = ObjectHelper.driver
					.findElement(By.xpath("//select[@id='date-filter']/option[" + i + "]"));
			Assert.assertTrue(Filter.getText().contentEquals(resultDateList.get(i - 1)));
		}
	}

	public void eventLogAlertList_18270(String patient) throws Exception {
		CommonFunctions.waitandClick(By.id("event_log_tab"), 5);
		CommonFunctions.waitForVisiblity(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/table/thead/tr/td[1]/a"), 3);
		List<String> resultList = Arrays.asList("Event", "Date", "Method", "Destination / User",
				"Message Text / Event Detail", "Status");
		// checking for the header Column Names
		for (int i = 1; i <= 6; i++) {
			WebElement element = ObjectHelper.driver
					.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/table/thead/tr/td[" + i + "]/a"));
			System.out.println("element" + element.getText());
			Assert.assertTrue(element.getText().contentEquals(resultList.get(i - 1)));
		}
	}

	public boolean commonFunctionForEventLogList(String AlertType) throws Exception {
		Boolean finalResult = false;
		Thread.sleep(5000);
		System.out.println("eventLogList.size()" + eventLogList.size());
		for (int i = 1; i <= eventLogList.size(); i++) {
			WebElement Event = ObjectHelper.driver
					.findElement(By.xpath("//div[@class='col-lg-12']/div/table/tbody/tr[" + i + "]/td[2]/span"));
			System.out.println("element" + Event.getText());
			if (Event.getText().contentEquals(AlertType)) {
				finalResult = false;
			} else {
				finalResult = true;
			}
			// Assert.assertFalse(Event.getText().contentEquals(AlertType));
		}
		return finalResult;
	}

	public void eventLogAlertHistory_16825() throws Exception {
		CommonFunctions.waitForVisiblity(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[1]/label/input"), 5);
		Thread.sleep(5000);
		critcalAlertsCheckbox.click();
		critcalAlertsCheckbox.sendKeys(Keys.ENTER);
		commonFunctionForEventLogList("Critical Results");
		// clicking on abnormal results checkbox
		CommonFunctions.waitandClick(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/label/input"), 5);
		commonFunctionForEventLogList("Abnormal Results");
		// clicking on missed appointments checkbox
		CommonFunctions.waitandClick(By.xpath("//div[@class='col-lg-11']/div[4]/label/input"), 5);
		commonFunctionForEventLogList("Missed Appointments");
		// clicking on upcoming appointments checkbox
		CommonFunctions.waitandClick(By.xpath("//div[@class='col-lg-11']/div[5]/label/input"), 5);
		commonFunctionForEventLogList("Upcoming Appointments");

	}
}
