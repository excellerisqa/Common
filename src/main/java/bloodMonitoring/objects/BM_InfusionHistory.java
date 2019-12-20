package bloodMonitoring.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BM_InfusionHistory {
	public static WebDriver driver;
	@FindBy(id = "ctl00_mainContent_UserIDTextBox")
	public static WebElement userId;
	@FindBy(id = "ctl00_mainContent_PasswordTextBox")
	public static WebElement password;
	@FindBy(id = "ctl00_mainContent_OKButton")
	public static WebElement okButton;
	@FindBy(id = "btnBloodMonitor")
	public static WebElement bloodMonitor;
	@FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[3]/div/div[2]/button[3]")
	public static WebElement viewRefeRanges;
	@FindBy(xpath = "//table[@id='patientListIndex']/tbody/tr[1]/td[2]")
	public static WebElement patient1;
	@FindBy(id = "PatientDetailsLink")
	public static WebElement PatientDetailsLink;
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button")
	public static WebElement close;
	@FindBy(xpath = "//div[@id='mainForm']/div[1]/div[3]/div/div[2]/span/a")
	public static WebElement edit;
	@FindBy(xpath = "//div[@id='mainForm']/div[2]/div[20]/div/a")
	public static WebElement addInfusion;
	@FindBy(xpath = "//div[@id='infusion-history-modal-content']/div[2]/div[1]/span[1]/span/span[1]")
	public static WebElement chooseInfusion;
	@FindBy(xpath = "//div[@id='infusion-history-modal-content']/div[3]/p")
	public static WebElement splInstructions;
	@FindBy(xpath = "//ul[@id='SelectedDose_listbox']/li[3]")
	public static WebElement cycle2;
	@FindBy(xpath = "//div[@id='infusion-history-modal-content']/div[2]/div[3]/span[1]/span")
	public static WebElement adminDate;
	@FindBy(xpath = "//div[@id='infusion-history-modal-container']/div/div[2]/input[1]")
	public static WebElement addInf;
	@FindBy(id = "event_log_tab")
	public static WebElement eventLog;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/div[7]/label/input")
	public static WebElement infAdminCheckbox;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/div[6]/label/input")
	public static WebElement TestDueDtaeChangedCheckbox;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/div[8]/label/input")
	public static WebElement patientResultNoteAdded;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/div[3]/label/input")
	public static WebElement UniterpretableResultsCheckbox;
	@FindBy(xpath = "//div[@id=\"test-info-container\"]/div/table[1]")
	public static WebElement referenceTable;

	public BM_InfusionHistory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectingPatient() throws Exception {
		Thread.sleep(3000);
		iframe();
		ObjectHelper.driver.switchTo().frame("ifInbox");
		CommonFunctions.waitandClick(By.id("btnBloodMonitor"), 5);
		CommonFunctions.waitandClick(By.xpath("//table[@id='patientListIndex']/tbody/tr[1]/td[2]"), 25);
	}

	public void testInfusion_16802(String patient) throws Exception {
		BM_ProgramMonitoring.selectingPatientFromList(patient);
		CommonFunctions.waitForVisiblity(By.id("PatientDetailsLink"), 10);
		PatientDetailsLink.click();
		CommonFunctions.waitForVisiblity(By.xpath("//table[@id='infusion-history']/thead/tr/th[1]"), 5);
		List<String> supplierNames = Arrays.asList("Dosage", "Date", "Administered by", "Special Instructions");
		for (int i = 1; i <= 4; i++) {
			WebElement infusionColumns = ObjectHelper.driver
					.findElement(By.xpath("//table[@id='infusion-history']/thead/tr/th[" + i + "]"));
			System.out.println("infusionColumns" + infusionColumns.getText());
			System.out.println("supplierNames.get(i-1)" + supplierNames.get(i - 1));
			Assert.assertTrue(infusionColumns.getText().contentEquals(supplierNames.get(i - 1)));
		}
	}

	public void testAddInfusion_16875() throws Exception {
		// clicking on edit
		CommonFunctions.waitandClick(By.xpath("//div[@id='mainForm']/div[1]/div[3]/div/div[2]/span/a"), 5);
		List<WebElement> infusionSize = ObjectHelper.driver
				.findElements(By.cssSelector("#infusion-history > tbody > tr > td:nth-child(1)"));
		int i = infusionSize.size();
		System.out.println("infusion Size" + i);
		WebElement infusionDosage = ObjectHelper.driver
				.findElement(By.xpath("//table[@id='infusion-history']/tbody/tr[" + i + "]/td[1]"));
		WebElement infusionDate = ObjectHelper.driver
				.findElement(By.xpath("//table[@id='infusion-history']/tbody/tr[" + i + "]/td[2]"));
		String date = date();
		System.out.println("date" + date);
		if (infusionDosage.getText().contentEquals("Cycle 2") && infusionDate.getText().contentEquals(date)) {
			// clicking on cancel button
			CommonFunctions.waitandClick(By.xpath("//div[@id='mainForm']/div[1]/div[3]/div/div[2]/span/input"), 5);
		} else {
			// clicking on add infusion
			CommonFunctions.waitandClick(By.xpath("//div[@id='mainForm']/div[2]/div[20]/div/a"), 5);
			// clicking on cycle
			CommonFunctions.waitandClick(
					By.xpath("//div[@id='infusion-history-modal-content']/div[2]/div[1]/span[1]/span/span[1]"), 5);
			// selecting cycle2
			CommonFunctions.waitandClick(By.xpath("//ul[@id='SelectedDose_listbox']/li[3]"), 5);
			System.out.println("adminDate" + adminDate.getText());
			Assert.assertTrue(splInstructions.getText().contentEquals("Special Instructions"));
			addInf.click();
			CommonFunctions.waitForVisiblity(By.xpath("//table[@id='infusion-history']/tbody/tr[1]/td[1]"), 6);
			Thread.sleep(3000);
			List<WebElement> infusionSize1 = ObjectHelper.driver
					.findElements(By.cssSelector("#infusion-history > tbody > tr > td:nth-child(1)"));
			int size = infusionSize1.size();
			System.out.println("infusion Size" + size);
			WebElement infusionDosage1 = ObjectHelper.driver
					.findElement(By.xpath("//table[@id='infusion-history']/tbody/tr[" + size + "]/td[1]"));
			WebElement infusionDate1 = ObjectHelper.driver
					.findElement(By.xpath("//table[@id='infusion-history']/tbody/tr[" + size + "]/td[2]"));
			System.out.println("infusionDosage1" + infusionDosage1.getText());
			System.out.println("infusionDate1" + infusionDate1.getText());
			// String date = date();
			// System.out.println("date" + date);
			Assert.assertTrue(infusionDosage1.getText().contentEquals("Cycle 2"));
			Assert.assertTrue(infusionDate1.getText().contentEquals(date));
			// clicking on save button
			CommonFunctions.waitandClick(By.xpath("//div[@id='mainForm']/div[1]/div[3]/div/div[2]/span/input"), 5);
		}

	}

	public void testAddInfusionEventLog_22179() throws InterruptedException {
		Thread.sleep(10000);
		eventLog.click();
		Thread.sleep(3000);
		String emptyStateCeck = infAdminCheckbox.getAttribute("class");
		if (emptyStateCeck.contains("ng-empty")) {
			System.out.println("clicking on checkbox");
			infAdminCheckbox.click();
		}
		WebElement image = ObjectHelper.driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[1]/i"));
		Assert.assertTrue(image.getAttribute("class").contentEquals("fa fa-flask"));
		WebElement method = ObjectHelper.driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[5]/span"));
		Assert.assertTrue(method.getText().contentEquals("N/A"));
		WebElement Event = ObjectHelper.driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/span"));
		Assert.assertTrue(Event.getText().contentEquals("Infusion Administered"));
		WebElement infusionAdminCheckbox = ObjectHelper.driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[7]/label/input"));
		infusionAdminCheckbox.click();
		Thread.sleep(3000);
		WebElement Event1 = ObjectHelper.driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/span"));
		Assert.assertFalse(Event1.getText().contentEquals("Infusion Administered"));
	}

	public static String date() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String todaysDate = dateFormat.format(date);
		return todaysDate;
	}

	public static Date yesterday() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	public static Date Tomorrow() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		return cal.getTime();
	}

	public static String YesterdayDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Yesterday date = " + dateFormat.format(yesterday()));
		return dateFormat.format(yesterday());
	}

	public static String TomorrowDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Tomorrow date = " + dateFormat.format(Tomorrow()));
		return dateFormat.format(Tomorrow());
	}

	public static Date LastYear() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		return cal.getTime();
	}

	public static String LastYearDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("LastYear date = " + dateFormat.format(LastYear()));
		return dateFormat.format(LastYear());
	}

	public static Date Last6Month() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);
		return cal.getTime();
	}

	public static String Last6MonthDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Last6Month date = " + dateFormat.format(Last6Month()));
		return dateFormat.format(Last6Month());
	}

	public static Date Days34Fromtoday() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +34);
		return cal.getTime();
	}

	public static String Days34FromtodayDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(" date = " + dateFormat.format(Days34Fromtoday()));
		return dateFormat.format(Days34Fromtoday());
	}

	public static void main(String[] args) {
		String date = Days34FromtodayDate();
		System.out.println("date" + date);

	}

	public static void iframe() {
		List<WebElement> iframes = ObjectHelper.driver.findElements(By.tagName("iframe"));
		System.out.println("iframe" + iframes.size());
		for (int i = 0; i < iframes.size(); i++) {
			System.out.println("iframe" + iframes.get(i).getAttribute("id"));
		}
	}

}
