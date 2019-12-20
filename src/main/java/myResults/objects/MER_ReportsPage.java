package myResults.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_ReportsPage {
	public static By reportPageUserName = By.xpath("//div[@id='reportsList']//h2");
	public static By reportPagePatientName = By.xpath("	//div[@class='patient-name-select']//h2");
	public static By userNameDropdown = By
			.xpath("//div[@id='reportsList']//div[contains(@class,'patient-name-select')]");
	public static By userNameDropdownList = By.xpath(
			"//div[@id='reportsList']//div[contains(@class,'patient-name-select')]//ul[@class='dropdown-menu dropdown-menu-left']");
	public static By reportsListTable = By.xpath("//div[@id='reportstable']/div/div[4]/table/tbody");
	public static By reportsView = By.id("reportsview");
	public static By reportsPatientNameInfo = By.id("_ReportPatientNameInfo");
	public static By reportsViewBackButton = By.xpath("//div[@id='reportsList']//a[@class='btn-back ng-scope']");
	public static By showResultsDropdown = By
			.xpath("//div[@id='reportstable']//select[@name='all-tests' and @ng-model='filterData.selectedLabTest']");
	public static By lastVisitsDropdown = By
			.xpath("//div[@id='reportstable']//select[@name='all-tests' and @ng-model='filterData.selectedVisit']");
	public static By showOutOfRangeCheckbox = By
			.xpath("//div[@id='reportstable']//div[contains(@class,'showOnly checkbox filter')]");// By.id("showOnly");
	public static By selectAllCheckbox = By
			.xpath("//div[@id='reportstable']/div/div[4]/table//th//label[@for='selectAll']");
	public static By reportTablePrintButton = By.xpath("//div[@id='reportsList']//span[contains(text(),'PRINT PDF')]");

	public static By chemistryReports = By.xpath("//span[text()='Chemistry']");

	public static By firstReportCheckbox = By.xpath("//label[@for='select-0']");
	public static By thirdReportCheckbox = By.xpath("//label[@for='select-2']");

	public static boolean viewReport(int userCount) throws InterruptedException {
		boolean err = false;
		try {
			CommonFunctions.waitForVisiblity(MER_ReportsPage.reportsListTable, 40);
			ObjectHelper.driver.findElement(reportsListTable).findElement(By.xpath("//tr/td[4]")).click();
			Thread.sleep(3000);
			if (!CommonFunctions.waitForVisiblity(reportsView, 60))
				err = true;
			ObjectHelper.driver.findElement(reportsViewBackButton).click();
		} catch (Exception e) {
			err = true;
			System.out.println("Err:" + e);
		}
		return err;
	}

	public static boolean verifyLastVisitsOptions() {
		boolean err = false;
		try {
			Select lastVisit = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
			lastVisit.selectByVisibleText("Last 5 Days");
			Thread.sleep(2000);
			if (!CommonFunctions.waitForVisiblity(reportsListTable, 30))
				err = true;
			Select lastVisit1 = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
			lastVisit1.selectByVisibleText("All Visits");
			Thread.sleep(2000);
			if (!CommonFunctions.waitForVisiblity(reportsListTable, 30))
				err = true;

		} catch (Exception e) {
			System.out.println("Error:" + e);
			err = true;
		}
		return err;
	}

	public int countReport() {
		List<WebElement> numOfRows = ObjectHelper.driver.findElement(reportsListTable).findElements(By.tagName("tr"));
		return numOfRows.size();
	}

	public void testTypeFilter(String test, int userCount, String testType) throws InterruptedException {
		int stat = 0;
		Thread.sleep(1000);
		if (ObjectHelper.driver.findElement(reportsListTable).isDisplayed()) {
			List<WebElement> reportTableRow = ObjectHelper.driver.findElement(reportsListTable)
					.findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				Thread.sleep(1000);
				int sectionColumn = rTableRow.findElements(By.xpath(
						".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]"))
						.size();
				System.out.println("Table row value:" + rTableRow.findElement(By.xpath(
						".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]"))
						.getText());
				if (sectionColumn != 1) {
					stat = 1;
				} else {
					if (!rTableRow.findElement(By.xpath(
							".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]"))
							.getText().equalsIgnoreCase(test))
						stat = 1;
				}
			}
		}
		if (stat == 0) {
			System.out.println("Pass " + test + " for user" + userCount);
			ObjectHelper.test.pass("Show results for \"" + testType + "\" option for User" + userCount + " :Pass");
		} else {
			ObjectHelper.test.fail("Show results for \"" + testType + "\" option for User" + userCount + " :Fail");
			System.out.println("Fail " + test + " for user" + userCount);
		}

	}

	/*
	 * Description : select a test result filter based on data from test data file
	 * and verifies the report table Parameters : @1 XLHandler object initiated for
	 * test data file Returns : Boolean - false for success, true for failure Author
	 * : Sindhu Rajaguru Modified By:
	 */
	public static boolean verifyShowResultsOptions(XLHandler objXLHandler) throws InterruptedException {
		boolean err = false;
		String testType = objXLHandler.readCorrespondingValueFromTestDataName("Data", "Filter test");
		Select showResults = new Select(ObjectHelper.driver.findElement(showResultsDropdown));
		showResults.selectByVisibleText(testType);
		Thread.sleep(2000);
		String sectionText = objXLHandler.readCorrespondingValueFromTestDataName("Test Map", testType);
		// System.out.println("Testmap"+sectionText);
		CommonFunctions.waitForVisiblity(reportsListTable, 30);
		if (ObjectHelper.driver.findElement(reportsListTable).isDisplayed()) {
			List<WebElement> reportTableRow = ObjectHelper.driver.findElement(reportsListTable)
					.findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				Thread.sleep(1000);
				int sectionColumn = rTableRow.findElements(By.xpath(
						".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]"))
						.size();

				if (sectionColumn != 1) {
					err = true;
				} else {
					if (!rTableRow.findElement(By.xpath(
							".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]"))
							.getText().equalsIgnoreCase(sectionText))
						err = true;
				}
			}
		}
		return err;
	}

	public void verifyShowResultsOptions(int userCount) throws InterruptedException {
		// BaseClass.rp.showResultsDropdown.click();
		Select showResults = new Select(ObjectHelper.driver.findElement(showResultsDropdown));
		List<WebElement> resultsList = showResults.getOptions();
		// int resultIndex=0;
		for (WebElement testResult : resultsList.subList(1, resultsList.size())) {
			// resultIndex++;
			String testType = testResult.getText();
			// showResults.selectByIndex(resultIndex);
			showResults.selectByVisibleText(testType);
			Thread.sleep(1000);
			// System.out.println(resultIndex+"test:" + testType);
			if (testType.contains("letter")) {
				int stat = 0;
				// CommonFunctions.waitForVisiblity(reportsListTable, 20);
				Thread.sleep(1000);
				if (ObjectHelper.driver.findElement(reportsListTable).isDisplayed()) {
					List<WebElement> reportTableRow = ObjectHelper.driver.findElement(reportsListTable)
							.findElements(By.tagName("tr"));
					for (WebElement rTableRow : reportTableRow) {
						System.out.println("Row:" + rTableRow.findElements(By.xpath(
								".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]")));
						if (rTableRow.findElements(By.xpath(
								".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]"))
								.size() == 0) {

							System.out.println("Pass Letter for user" + userCount);
						} else {
							System.out.println("Fail Letter for user" + userCount);
							stat = 1;
						}

					}
				}
				if (stat == 0) {
					ObjectHelper.test.pass("Show results for \"Letter\" option for User" + userCount + " :Pass");
				} else
					ObjectHelper.test.fail("Show results for \"Letter\" for User" + userCount + " :Fail");
			} else if (testType.equalsIgnoreCase("Hematology Panel")) {
				testTypeFilter("Haematology", userCount, testType);
			} else if (testType.equalsIgnoreCase("Urine Culture")) {
				testTypeFilter("Microbiology", userCount, testType);
			} else
				testTypeFilter("Chemistry", userCount, testType);
		}

	}

	public void verifyLastVisitsOptions(int userCount) throws InterruptedException {
		Select showVisits = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
		List<WebElement> visitsList = showVisits.getOptions();
		// int visitsIndex=-1;
		for (WebElement visits : visitsList.subList(0, visitsList.size() - 1)) {// .subList(1,visitsList.size())) {
			// visitsIndex++;
			String visitsType = visits.getText();
			// showVisits.selectByIndex(visitsIndex);
			showVisits.selectByVisibleText(visitsType);
			Thread.sleep(1000);
			int count = countReport();
			System.out.println("Visit:" + visitsType + "Count:" + count);
			int expectedRowCount = 0;
			if (visitsType.contains("All Visits")) {
				expectedRowCount = 6;
			} else if (visitsType.contains("Last 5 Visits")) {
				expectedRowCount = 5;
			} else if (visitsType.contains("Last 10 Visits")) {
				expectedRowCount = 6;
			} else if (visitsType.contains("Last 20 Visits")) {
				expectedRowCount = 6;
			} else if (visitsType.contains("Last 30 Visits")) {
				expectedRowCount = 6;
			} else if (visitsType.contains("Last 50 Visits")) {
				expectedRowCount = 6;
			} else if (visitsType.contains("Days")) {
				expectedRowCount = 0;
			}
			if (count == expectedRowCount) {
				System.out.println("Pass " + visitsType + " for user" + userCount);
				ObjectHelper.test.pass("Filter for \"" + visitsType + "\" option for User" + userCount + " :Pass");
			} else {
				ObjectHelper.test.fail("Filter for \"" + visitsType + "\" option for User" + userCount + " :Fail");
				System.out.println("Fail " + visitsType + " for user" + userCount);
			}

		}
	}

	public static boolean verifyShowOutOfRange() throws InterruptedException {
		Thread.sleep(2000);
		ObjectHelper.driver.findElement(showOutOfRangeCheckbox).click();
		Thread.sleep(2000);
		boolean err = false;
		if (ObjectHelper.driver.findElement(reportsListTable).isDisplayed()) {
			List<WebElement> reportTableRow = ObjectHelper.driver.findElement(reportsListTable)
					.findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				Thread.sleep(1000);
				int sectionColumn = rTableRow.findElements(By.xpath(".//td[4]//span[contains(@class,'out-of-range')]"))
						.size();
				System.out.println("Table row value:" + rTableRow.findElement(By.xpath(
						".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]"))
						.getText());
				if (sectionColumn < 1) {
					err = true;
				}
			}
		}
		return err;
	}

	/*
	 * Description : prints/downloads all reports from the report table for a
	 * particular user Parameters : Integer - The index of the user whose report is
	 * being verified (like 1, 2 etc.) Returns : void Author : Sindhu Rajaguru
	 * Modified By:
	 */
	public static boolean printAllReport(int userCount) throws Exception {
		boolean err = false;
		CommonFunctions.waitForVisiblityWithException(reportsListTable, 60);
		CommonFunctions.waitandClick(selectAllCheckbox, 30);
		ObjectHelper.driver.findElement(reportTablePrintButton).click();
		CommonFunctions.waitForDownload("Reports.pdf");
		if (!CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Reports.pdf"))
			err = true;
		return err;
	}

	/*
	 * Description : prints/downloads report from the report details view for a
	 * particular user Parameters : Integer - The index of the user whose report is
	 * being verified (like 1, 2 etc.) Returns : void Author : Sindhu Rajaguru
	 * Modified By:
	 */
	public static boolean printReportView(int userCount) throws InterruptedException {
		boolean err = false;
		Thread.sleep(1000);
		CommonFunctions.waitForVisiblityWithException(reportsListTable, 60);
		ObjectHelper.driver.findElement(reportsListTable).findElement(By.xpath("//tr/td[4]")).click();
		Thread.sleep(3000);
		CommonFunctions.waitForVisiblityWithException(reportsView, 60);
		Thread.sleep(2000);
		ObjectHelper.driver.findElement(reportTablePrintButton).click();
		if (CommonFunctions.waitForDownload("Report.pdf"))
			err = true;
		else
			CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Report.pdf");
		ObjectHelper.driver.findElement(reportsViewBackButton).click();

		return err;
	}

	public static boolean viewReportAndVerifyData(XLHandler objXLHandler) {
		boolean err = false;

		try {

			String testname = objXLHandler.readCorrespondingValueFromTestDataName("Data", "testname");
			String testvalue = objXLHandler.readCorrespondingValueFromTestDataName("Data", "testvalue");

			CommonFunctions.waitForVisiblity(MER_ReportsPage.reportsListTable, 40);
			ObjectHelper.driver.findElement(reportsListTable).findElement(By.xpath("//tr/td[4]")).click();
			Thread.sleep(3000);
			if (!CommonFunctions.waitForVisiblity(reportsView, 60))
				err = true;
			if (!(ObjectHelper.driver.findElement(By.xpath("//span[text()='" + testname + "']")).isDisplayed()))
				return false;

			if (!(ObjectHelper.driver.findElement(By.xpath("//div[text()='" + testvalue + "']")).isDisplayed()))
				return false;
			else
				return true;

		} catch (Exception e) {
			err = true;
			System.out.println("Err:" + e);
		}
		return err;
	}

	public static boolean printPDF() {
		try {
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(reportTablePrintButton).click();
			Thread.sleep(2000);
			if (!(CommonFunctions.waitForDownload("Report.pdf")))
				return false;
			else {
				Thread.sleep(2000);
				CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Report.pdf");
				return true;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean printPDFNoArchive() {
		try {
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(reportTablePrintButton).click();
			Thread.sleep(2000);
			if (CommonFunctions.waitForDownload("Report.pdf"))
				return false;
			else {
				Thread.sleep(2000);
				// CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Report.pdf");
				return true;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean printPDFForMultipleReports() {
		try {
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(reportTablePrintButton).click();
			Thread.sleep(2000);
			if (CommonFunctions.waitForDownload("Reports.pdf"))
				return false;
			else {
				Thread.sleep(2000);
				// CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Reports.pdf");
				return true;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean selectTwoReportsAndPrintPDF() {

		try {
			Thread.sleep(2000);
			CommonFunctions.waitForVisiblity(MER_ReportsPage.firstReportCheckbox, 40);

			ObjectHelper.driver.findElement(firstReportCheckbox).click();

			CommonFunctions.waitForVisiblity(reportTablePrintButton, 20);
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(thirdReportCheckbox).click();
			Thread.sleep(2000);

			return printPDFForMultipleReports();

		} catch (Exception e) {
			return false;
		}

	}

}
