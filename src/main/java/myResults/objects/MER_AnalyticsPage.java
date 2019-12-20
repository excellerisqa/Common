package myResults.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_AnalyticsPage {
	public static By analyticsPageUserName = By
			.xpath("//div[@id='analyticSummary']//div[contains(@class,'patient-name-select')]//h2");
	public static By userNameDropdown = By
			.xpath("//div[@id='analyticSummary']//div[contains(@class,'patient-name-select')]");
	public static By userNameDropdownList = By.xpath(
			"//div[@id='analyticSummary']//div[contains(@class,'patient-name-select')]//ul[@class='dropdown-menu dropdown-menu-left']");
	public static By analyticsListTable = By.xpath("//div[@id='analyticstable']//table/tbody");
	public static By analyticsView = By.id("analyticsview");
	public static By analyticsViewTable = By.xpath("//div[@id='analyticsview']//table/tbody");
	public static By analyticsViewGraph = By.xpath("//div[@id='analyticsview']//div[@id='analytics-chart']");
	// public static By reportsPatientNameInfo=By.id("_ReportPatientNameInfo");
	public static By analyticssViewBackButton = By.xpath("//div[@id='analyticSummary']//a[@class='btn-back ng-scope']");
	public static By showResultsDropdown = By
			.xpath("//div[@id='analyticstable']//select[@name='all-tests' and @ng-model='filterData.selectedLabTest']");
	public static By lastVisitsDropdown = By
			.xpath("//div[@id='analyticstable']//select[@name='all-tests' and @ng-model='filterData.selectedVisit']");
	public static By showOutOfRangeCheckbox = By
			.xpath("//div[@id='analyticstable']//div[contains(@class,'showOnly checkbox filter')]");

	public static By calender = By.xpath("//i[@class='icon-calendar']");

	public static By calenderYear = By.xpath("//select[@class='pika-select pika-select-year']");

	public static By resultRows = By.xpath(
			"//table[@class='table table-hover table-striped tablesaw tablesaw-stack tblReports  tblAnalyticsDetails']/tbody/tr");

	public static boolean verifyShowOutOfRange() throws InterruptedException {
		Thread.sleep(3000);
		// if (!(ObjectHelper.driver.findElement(showOutOfRangeCheckbox).isSelected()))
		ObjectHelper.driver.findElement(showOutOfRangeCheckbox).click();
		Thread.sleep(1000);
		boolean err = false;
		if (ObjectHelper.driver.findElement(analyticsListTable).isDisplayed()) {
			List<WebElement> reportTableRow = ObjectHelper.driver.findElement(analyticsListTable)
					.findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				Thread.sleep(1000);
				if (!rTableRow.findElement(By.xpath(".//td[4]//span[contains(@class,'tablesaw-cell-content')]/img"))
						.isDisplayed()) {
					err = true;
				}
			}
		}
		return err;
	}

	public static boolean verifyAnalyticsLastVisitsOptions() {
		boolean err = false;
		try {
			Thread.sleep(3000);
			Select lastVisit = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
			lastVisit.selectByVisibleText("Last 5 Days");
			Thread.sleep(2000);
			if (!CommonFunctions.waitForVisiblity(analyticsListTable, 30))
				err = true;
			Select lastVisit1 = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
			lastVisit1.selectByVisibleText("All Visits");
			Thread.sleep(2000);
			if (!CommonFunctions.waitForVisiblity(analyticsListTable, 30))
				err = true;

		} catch (Exception e) {
			System.out.println("Error:" + e);
			err = true;
		}
		return err;
	}

	public static boolean viewAnalyticsGraphTable() throws InterruptedException {
		Thread.sleep(3000);
		ObjectHelper.driver.findElement(analyticsListTable).findElement(By.xpath("//tr[2]/td[4]")).click();
		// System.out.println("sdfsdfdsf");
		boolean err = false;
		// Thread.sleep(2000);
		if (CommonFunctions.waitForVisiblity(analyticsViewTable, 40)) {
			if (!ObjectHelper.driver.findElement(analyticsViewGraph).isDisplayed()) {
				err = true;
			}
		} else
			err = true;
		ObjectHelper.driver.findElement(analyticssViewBackButton).click();
		return err;
	}

	public static boolean viewReportFromAnalyticsView() throws Exception {
		Thread.sleep(3000);
		boolean err = false;
		ObjectHelper.driver.findElement(By.xpath(
				"//table[@class='table table-hover table-striped tablesaw tablesaw-stack tblReports  tblAnalyticsDetails']/tbody//tr/td[2]"))
				.click();
		if (CommonFunctions.waitForVisiblity(MER_ReportsPage.reportsView, 30)) {
			ObjectHelper.driver.findElement(analyticssViewBackButton).click();
			CommonFunctions.waitForVisiblity(analyticsViewTable, 30);
			ObjectHelper.driver.findElement(analyticssViewBackButton).click();

		} else
			err = true;
		return err;
	}

	public void viewAnalyticsReport(int userCount) throws InterruptedException {
		Thread.sleep(3000);
		ObjectHelper.driver.findElement(analyticsListTable).findElement(By.xpath("//tr/td[4]")).click();
		CommonFunctions.waitForVisiblity(analyticsViewTable, 30);
		// WebElement
		// e=ObjectHelper.driver.findElement(analyticsViewTable).findElement(By.xpath("//tr/td[4]"));
		// ((JavascriptExecutor)ObjectHelper.driver).executeScript("arguments[0].click();",
		// e);
		ObjectHelper.driver.findElement(By.xpath(
				"//table[@class='table table-hover table-striped tablesaw tablesaw-stack tblReports  tblAnalyticsDetails']/tbody//tr/td[2]"))
				.click();
		Thread.sleep(3000);
		if (ObjectHelper.driver.findElement(MER_ReportsPage.reportsView).isDisplayed()) {
			// System.out.println("report view for user" + userCount +
			// ObjectHelper.driver.findElement(reportsPatientNameInfo).getText());
			ObjectHelper.test.pass("Verify view analytics report for User " + userCount + ": Pass");
			ObjectHelper.driver.findElement(analyticssViewBackButton).click();
			Thread.sleep(3000);
			CommonFunctions.waitForVisiblity(analyticsViewTable, 30);
			ObjectHelper.driver.findElement(analyticssViewBackButton).click();

		} else
			ObjectHelper.test.fail("Verify view analytics report for User " + userCount + ": Fail");

	}

	public static void selectUser(String user) {
		CommonFunctions.waitForVisiblity(userNameDropdown, 40);
		String currentUser = ObjectHelper.driver.findElement(userNameDropdown).getText();

		if (!(currentUser.equals(user))) {
			ObjectHelper.driver.findElement(userNameDropdown).click();
			ObjectHelper.driver.findElement(userNameDropdownList).findElement(By.xpath("//a[text()='" + user + "']"))
					.click();

		}
	}

	public static boolean selectUserAndViewAnalyticsGraphTable(XLHandler objXLHandler) throws InterruptedException {
		try {

			String user = objXLHandler.readCorrespondingValueFromTestDataName("Data", "User");

			selectUser(user);
			// find report and click
			verifyShowOutOfRange();
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(analyticsListTable).findElement(By.xpath("//tr[1]/td[4]")).click();
			// ObjectHelper.driver.findElement(analyticsListTable).findElement(By.xpath("//tr[2]/td[4]")).click();
			Thread.sleep(2000);
			if (CommonFunctions.waitForVisiblity(analyticsViewTable, 40)) {
				if (!ObjectHelper.driver.findElement(analyticsViewGraph).isDisplayed()) {
					return false;
				}
			} else
				return false;

			ObjectHelper.driver.findElement(analyticssViewBackButton).click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean selectDateRangeToExcludeAllTests(XLHandler objXLHandler) {
		try {
			String user = objXLHandler.readCorrespondingValueFromTestDataName("Data", "User");

			Thread.sleep(2000);
			ObjectHelper.driver.findElement(analyticsListTable).findElement(By.xpath("//tr[1]/td[4]")).click();
			// ObjectHelper.driver.findElement(analyticsListTable).findElement(By.xpath("//tr[2]/td[4]")).click();
			Thread.sleep(2000);
			if (CommonFunctions.waitForVisiblity(analyticsViewTable, 40)) {
				if (!ObjectHelper.driver.findElement(analyticsViewGraph).isDisplayed()) {
					return false;
				}
			} else
				return false;

			String excludeYear = objXLHandler.readCorrespondingValueFromTestDataName("Data", "ExcludeAllTestsDate");

			return !(changeDateRange(excludeYear, "1", excludeYear, "1")); // no result rows should be seen

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean selectDateRangeToDisplayTests(XLHandler objXLHandler) {
		try {
			Thread.sleep(2000);
			String displayResultsFromyear = objXLHandler.readCorrespondingValueFromTestDataName("Data",
					"ExcludeAllTestsDate");
			String displayResultsToYear = objXLHandler.readCorrespondingValueFromTestDataName("Data",
					"DisplayTestsDateTo");

			return changeDateRange(displayResultsFromyear, "1", displayResultsToYear, "1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean changeDateRange(String fromYearToSelect, String fromDayToSelect, String toYearToSelect,
			String toDayToSelect) {
		try {
			Thread.sleep(2000);
			// from date
			ObjectHelper.driver.findElements(calender).get(2).click();
			Thread.sleep(2000);
			Select year = new Select(ObjectHelper.driver.findElement(calenderYear));
			year.selectByVisibleText(fromYearToSelect);
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(By.xpath("//button[@class='pika-button pika-day' and @data-pika-year='"
					+ fromYearToSelect + "' and text()='" + fromDayToSelect + "']")).click();

			Thread.sleep(1000);

			// to date
			ObjectHelper.driver.findElements(calender).get(3).click();
			Thread.sleep(2000);

			List<WebElement> allYears = ObjectHelper.driver.findElements(calenderYear);
			Thread.sleep(2000);

			Select year1 = new Select(allYears.get(1));

			year1.selectByVisibleText(toYearToSelect);
			Thread.sleep(2000);

			List<WebElement> days = ObjectHelper.driver
					.findElements(By.xpath("//button[@class='pika-button pika-day' and @data-pika-year='"
							+ toYearToSelect + "' and text()='" + toDayToSelect + "']"));
			days.get(0).click();
			Thread.sleep(2000);
			// return CommonFunctions.waitForVisiblity(resultRows, 3);
			return ObjectHelper.driver.findElements(resultRows).size() > 0;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

}
