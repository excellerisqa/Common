package launchpadBC.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import utils.ObjectHelper;

public class BC_Inbox {
	public static String title;
	public static By shealthCard = By.xpath("//*[@id=\"PatientNumber\"]");
	public static By results = By.xpath("//*[@id=\"ResultTable\"]/tbody/tr[1]");
	public static By printedtonew = By.xpath("//*[@id=\"PrintedToNew\"]/div");
	public static By cleartoviewed = By.xpath("//*[@id=\"ClearToViewed\"]/div");
	public static By viewedtoclear = By.xpath("//*[@id=\"ViewedToClear\"]/div");
	public static By filterbtn = By.xpath("//*[@id=\"btnFilter\"]");
	public static By apply = By.xpath(
			"/html/body/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/input");
	public static By testfilter = By.xpath("//*[@id=\"chkTest\"]");
	public static By physicianfilter = By.xpath("//*[@id=\"chkPhysician\"]");
	public static By section = By.xpath("//*[@id=\"iSection-1396591\"]/label");
	public static By individual = By.xpath("//*[@id=\"Individual\"]/div");
	public static By multiple = By.xpath("//*[@id=\"Multiple\"]/div");
	public static By viewbtn = By
			.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/input[3]");
	public static By inboxrefresh = By.xpath("//*[@id=\"inboxRefresh\"]/input");
	public static By dateOfbirth = By.xpath("//*[@id=\"DateOfBirth\"]");
	public static By inboxcount = By.xpath("//*[@id=\"InfoMessage\"]");
	public static By patienthistorysearch = By.xpath("//*[@id=\"ResultTable\"]/tbody/tr[1]/td[3]");
	public static By printbtn = By
			.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/input[4]");
	public static By printall = By.xpath("//*[@id=\"PrintAll\"]/div");
	public static By printallfinal = By.xpath("//*[@id=\"PrintAllFinal\"]/div");
	public static By printselection = By.xpath("//*[@id=\"PrintSelection\"]/div");
	public static By selTest_drop = By.xpath("//*[@id=\"selTest_drop\"]");
	public static By selTest_item_2 = By.xpath("//*[@id=\"selTest_item_2\"]");
	public static By selPhysician_drop = By.xpath("//*[@id=\"selPhysician_drop\"]");
	public static By selPhysician_item_1 = By.xpath("//*[@id=\"selPhysician_item_1\"]");
	public static By x = By.xpath(
			"/html/body/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[3]/input");
	public static By next = By.xpath("//*[@id=\"next\"]/img");
	public static By close = By.xpath("//*[@id=\"close\"]");

	public static By tittle = By.xpath("//*[@id=\"tdWSTitle\"]");
	public static By printreport = By.xpath("//*[@id=\"printReport\"]");

	public static By alltonew = By.xpath("//div[@id='AllToNew']");
	public static By applyBtn = By.xpath("//input[@value='Apply']");

	public static By testcheckBox = By.id("chkTest");
	public static By testSectioncheckBox = By.id("chkTestSection");
	public static By abnormalcheckBox = By.id("chkAbnormal");
	public static By orderbycheckBox = By.id("chkOrderedBy");
	public static By inboxForcheckBox = By.id("chkPhysician");
	public static By otherReportcheckBox = By.id("chkOtherReports");
	public static By locationcheckBox = By.id("chkLocation");
	public static By patientcheckBox = By.id("chkPatient");
	public static By patientNameradioButton = By.id("rbPatientName");
	public static By phnradioButton = By.id("rbPHN");
	public static By patientNametextBox = By.id("txtPatientName");
	public static By phntextBox = By.id("txtPHN");

	public static By sextextBox = By.xpath("//input[@id=\"Sex_text\"]");

	public static By bcbcheckBox = By.xpath("//input[@id='BCB']");
	public static By othercheckBox = By.xpath("//input[@id='BCB|(Other)']");

	public static By vihacheckBox = By.xpath("//input[@id='VIHA']");
	public static By vihaEDcheckBox = By.xpath("//input[@id='VIHA|EDNRGH NRG']");

	public static By slastName = By.xpath("//input[@id='Last_Name'][1]");
	public static By sfirstName = By.xpath("//input[@id='First_Name'][1]");
	public static By searchbtn = By.id("SEARCH");
	public static By resultsBAFilter = By.xpath("//div[@id='ResultDiv']//table//tr");
	public static By multiResultsVerify = By.xpath("//input[@id='SwapAxisButton']");
	public static By status = By.xpath("//input[@value='Status']");
	public static By view = By.xpath("//input[@value='View']");
	public static By individualReportsView = By.xpath("//div[@id='Individual']");
	public static By multipleReportsView = By.xpath("//div[@id='Multiple']");
	public static By print = By.xpath("//input[@value='Print']");
	public static By closeFilter = By.xpath("//input[@value='X']");

	public static By resetFilter = By.xpath("//input[@value='Reset']");

	public static By printAll = By.xpath("//div[@id='PrintAll']");
	public static By printAllFinal = By.xpath("//div[@id='PrintAllFinal']");
	public static By printSummary = By.xpath("//div[@id='PrintSummary']");

	// Cumulative Tab
	public static By allVisitRadio = By.id("rbAll");

	public static By lastVisitRadio = By.id("rbVisits");
	public static By xVisitRadio = By.id("PreviousVisits");

	public static By dayVisitRadio = By.id("rbDays");
	public static By xdayVisitRadio = By.id("selDays");

	public static By dateVisitRadio = By.id("rbDateRange");
	public static By sdateVisitText = By.id("StartDate");
	public static By edateVisitText = By.id("EndDate");

	public static By createReportBtn = By.id("CreateReportButton");

	//
	public static By sortOrderbtn = By.id("SortingOrder");
	public static By swapAxisbtn = By.id("SwapAxis");
	public static By printCumbtn = By.id("PrintCumReport");

	public static By reportVerify = By.xpath("(//tr[@id='row1']//td)[1]");
	public static By closeReport = By.xpath("//input[@id='close']");
	public static By testFilter = By.id("selTest_text");
	public static By testSectionFilter = By.id("selTestSection_text");
	public static By filterBtn = By.id("btnFilter");
	public static By testFilterALT = By.id("selTest_item_2");
	public static By testFilterddBtn = By.id("selTest_drop");
	public static By patientFound = By.xpath("//table[@id='HistSearchResults']/tbody/tr/td/table/tbody/tr/td[2]");
	public static By patientFoundName = By.xpath("//table[@id='HistSearchResults']/tbody/tr/td/table/tbody/tr/td[3]");
	public static By patientFoundBirthday = By
			.xpath("//table[@id='HistSearchResults']/tbody/tr/td/table/tbody/tr/td[4]");
	public static By patientFoundSex = By.xpath("//table[@id='HistSearchResults']/tbody/tr/td/table/tbody/tr/td[5]");

	public static By consentObtained = By.xpath("//*[@id='chbConsentObtained']");
	public static By representative = By.xpath("//*[@id='chbRepresentative']");

	public static void enterText(String element, String text) {
		element.toLowerCase();
		switch (element) {
		case "healthcard":
			ObjectHelper.driver.findElement(shealthCard).clear();
			ObjectHelper.driver.findElement(shealthCard).sendKeys(text);
			break;
		case "lastname":
			ObjectHelper.driver.findElement(slastName).clear();
			ObjectHelper.driver.findElement(slastName).sendKeys(text);
			break;
		case "firstname":
			ObjectHelper.driver.findElement(sfirstName).clear();
			ObjectHelper.driver.findElement(sfirstName).sendKeys(text);
			break;
		case "dateOfbirth":
			ObjectHelper.driver.findElement(dateOfbirth).clear();
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

	public static void searchpatientbyname(String lastname, String firstname) throws InterruptedException {
		ObjectHelper.driver.switchTo().frame("ifPatientSearch");

		ObjectHelper.driver.findElement(slastName).clear();
		ObjectHelper.driver.findElement(slastName).sendKeys(lastname);

		ObjectHelper.driver.findElement(sfirstName).clear();
		ObjectHelper.driver.findElement(sfirstName).sendKeys(firstname);

		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) ObjectHelper.driver;
		executor.executeScript("arguments[0].click();", ObjectHelper.driver.findElement(searchbtn));
		ObjectHelper.driver.switchTo().defaultContent();
	}

	public static void searchpatientbynamebirthday(String lastname, String firstname, String birthday)
			throws InterruptedException {
		ObjectHelper.driver.switchTo().frame("ifPatientSearch");

		ObjectHelper.driver.findElement(slastName).clear();
		ObjectHelper.driver.findElement(slastName).sendKeys(lastname);

		ObjectHelper.driver.findElement(sfirstName).clear();
		ObjectHelper.driver.findElement(sfirstName).sendKeys(firstname);

		ObjectHelper.driver.findElement(dateOfbirth).clear();
		ObjectHelper.driver.findElement(dateOfbirth).sendKeys(birthday);

		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) ObjectHelper.driver;
		executor.executeScript("arguments[0].click();", ObjectHelper.driver.findElement(searchbtn));
		ObjectHelper.driver.switchTo().defaultContent();
	}

	public static void searchpatientbynamesex(String lastname, String firstname) throws InterruptedException {
		ObjectHelper.driver.switchTo().frame("ifPatientSearch");

		ObjectHelper.driver.findElement(slastName).clear();
		ObjectHelper.driver.findElement(slastName).sendKeys(lastname);

		ObjectHelper.driver.findElement(sfirstName).clear();
		ObjectHelper.driver.findElement(sfirstName).sendKeys(firstname);

		ObjectHelper.driver.findElement(By.xpath("//img[@id='Sex_drop']")).click();

		System.out
				.println("div text:" + ObjectHelper.driver.findElement(By.xpath("//div[@id='Sex_item_3']")).getText());
		ObjectHelper.driver.findElement(By.xpath("//div[@id='Sex_item_3']")).click();

		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) ObjectHelper.driver;
		executor.executeScript("arguments[0].click();", ObjectHelper.driver.findElement(searchbtn));
		ObjectHelper.driver.switchTo().defaultContent();
	}

	public static boolean isAlertPresent() {
		try {
			ObjectHelper.driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
