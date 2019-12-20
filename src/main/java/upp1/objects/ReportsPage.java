package upp1.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.Screenshots;

public class ReportsPage {
	WebDriver driver;

	public static String completeaccountprofilebuttonpath = "//a[@title='Complete Account Profile']";
	public static String addlabreportsbuttonpath = "//a[@title='Add Lab Reports for Me or Another Person']";
	public static String reporttablelistPath = "//div[@id='reportstable']/div/div[4]/table/tbody//tr"; // list
	public static String reporttableForwardArrowlistPath = "//div[@id='reportstable']/div/div[4]/table/tbody//tr//td[6]"; // list

	@FindBy(xpath = "//select[@id='multiple-select-with-html3']")
	public static WebElement userNameDropdown;

	@FindBy(xpath = "//div[@id='reportsList']//button[@class='multiselect dropdown-toggle btn btn-default']")
	public static WebElement userNameDropdownButton;

	@FindBy(xpath = "//div[@id='reportsList']//div[@class='dropdown-two-lines ng-binding']//ul[@class='multiselect-container dropdown-menu']")
	public static WebElement userNameDropdownList;

	@FindBy(xpath = "//div[@class='dropdown-report']//ul/li//div[contains(@class,'content-heading')]")
	public static List<WebElement> nameFromUserNameDropdownList;

	@FindBy(xpath = "//div[@id='reportstable']/div/div[4]/table/tbody")
	public static WebElement reportsTable;

	@FindBy(xpath = "//div[@id='reportstable']/div/div[4]/table/thead//th")
	public static List<WebElement> reportsTableHeader;

	@FindBy(xpath = "//div[@id='reportstable']/div/div[4]/table/tbody//tr")
	public static List<WebElement> reporttablelist;

	@FindBy(xpath = "//div[@id='reportstable']/div/div[4]/table/tbody//tr//td[6]")
	public static List<WebElement> reporttableForwardArrowlist;

	@FindBy(xpath = "//div[@id='reportstable']//ul[@class='dropdown-menu inner']")
	public static WebElement showResultsDropdownList;

	@FindBy(xpath = "//div[@id='reportstable']//button[@class='btn dropdown-toggle btn-default']")
	public static WebElement showResultsDropdown;

	@FindBy(xpath = "//div[@id='reportstable']//div[contains(@class,'showOnly checkbox filter')]/label")
	public static WebElement showOutOfRangeCheckbox;

	@FindBy(xpath = "//div[@id='reportsview']")
	public static WebElement reportsView;

	@FindBy(xpath = "//span[@id='_ReportPatientNameInfo']")
	public static WebElement reportsPatientNameInfo;

	@FindBy(xpath = "//span[@class='ng-binding' and text()='BACK']") // div[@id='reportsList']//a[@class='btn-back ng-scope']")
	public static WebElement reportsViewBackButton;

	@FindBy(xpath = "//a[@title='Complete Account Profile']")
	public static WebElement completeaccountprofilebutton;

	@FindBy(xpath = "//a[@title='Add Lab Reports for Me or Another Person']")
	public static WebElement addlabreportsbutton;

	@FindBy(xpath = "//div[@id='reportsList']//span[contains(.,'PRINT PDF')]")
	public static WebElement reportPrintButton;

	@FindBy(xpath = "//p[contains(text(),'Failed to generate a pdf file')]")
	public static WebElement pdfPrintFailText;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public static WebElement pdfPrintFailOKButton;

	@FindBy(xpath = "//p[contains(text(),'Failed to load')]")
	public static WebElement reportLoadFailText;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public static WebElement reportLoadFailOKButton;

	@FindBy(xpath = "//p[@translate='REPORTVIEW_CONFIDENTIALMSG']")
	public static WebElement sensitiveReportMsg;

	@FindBy(xpath = "//div[@id='reportsview']//p[@translate='REPORTVIEW_SINGLE_CONFIDENTIALMSG']")
	public static WebElement sensitiveReportMsgReportView;

	public static int testTypeFilter(int testListNum, String test, int userCount, String testType) throws InterruptedException {
		int stat = 0;
		CommonFunctions.waitForVisiblity(showResultsDropdown, 40);
		CommonFunctions.clickUsingJavaExecutor(showResultsDropdown);
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor(showResultsDropdownList.findElement(By.xpath(".//li[" + testListNum + "]")));
		// testResultCommonFunctions.clickUsingJavaExecutor();
		int rowNum = 0;
		if (reportsTable.isDisplayed()) {
			List<WebElement> reportTableRow = reportsTable.findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				Thread.sleep(1000);
				rowNum++;
				// System.out.println("Row:" +
				// rTableRow.findElements(By.xpath(".//td[4]//span[1][not(contains(@class,'ng-binding'))
				// and not(contains(@ng-if,'$root.isArray(cell)'))]")));
				// int sectionColumn =
				// rTableRow.findElements(By.xpath(".//td[4]//span[1][not(contains(@class,'ng-binding'))
				// and not(contains(@ng-if,'$root.isArray(cell)'))]")).size();
				int sectionColumn = reportsTable.findElements(By.xpath(".//tr[" + rowNum + "]//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]")).size();
				if (sectionColumn != 1) {
					stat = 1;
				} else {
					if (!rTableRow.findElement(By.xpath(".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]")).getText().contains(test))
						stat = 1;
				}
			}
		}
		return stat;
	}

	public static boolean viewReport(String expectedNameInReport) throws Exception {
		boolean err = false;
		CommonFunctions.waitForVisiblity(reportsTable, 40);
		Thread.sleep(5000);
		CommonFunctions.clickUsingJavaExecutor(reportsTable.findElement(By.xpath(".//tr/td[2]")));
		CommonFunctions.waitForVisiblity(reportsView, 40);
		// Thread.sleep(2000);
		if (!CommonFunctions.waitForVisiblity(reportsPatientNameInfo, 40)) {
			// reportsViewBackButtonCommonFunctions.clickUsingJavaExecutor();
			CommonFunctions.clickUsingJavaExecutor(MenuPage.reportmenu);
			CommonFunctions.waitForVisiblity(reportsTable, 40);
			CommonFunctions.clickUsingJavaExecutor(reportsTable.findElement(By.xpath(".//tr/td[2]")));
			CommonFunctions.waitForVisiblity(reportsView, 40);
		}
		String actualName = reportsPatientNameInfo.getText();
		System.out.println("name:" + actualName);
		if (!expectedNameInReport.toLowerCase().contains(actualName.toLowerCase()))
			err = true;
		CommonFunctions.clickUsingJavaExecutor(reportsViewBackButton);

		return err;
	}

	@SuppressWarnings("unused")
	public static boolean verifyShowResultsOptions() throws InterruptedException {
		// BaseClass.rp.showResultsDropdownCommonFunctions.clickUsingJavaExecutor();
		boolean err = false;
		CommonFunctions.waitForVisiblity(showResultsDropdown, 40);
		List<WebElement> resultsList = showResultsDropdownList.findElements(By.tagName("li"));
		int listNum = 1;
		for (WebElement testResult : resultsList.subList(1, resultsList.size())) {
			listNum++;
			String testType = showResultsDropdownList.findElement(By.xpath(".//li[" + listNum + "]/a/span[1]")).getAttribute("innerHTML");
			System.out.println(listNum + "test:" + testType);
			if (testType.contains("letter")) {
				int stat = 0;
				CommonFunctions.clickUsingJavaExecutor(showResultsDropdown);
				Thread.sleep(1000);
				CommonFunctions.clickUsingJavaExecutor(showResultsDropdownList.findElement(By.xpath(".//li[" + listNum + "]")));
				// testResultCommonFunctions.clickUsingJavaExecutor();
				if (reportsTable.isDisplayed()) {
					List<WebElement> reportTableRow = reportsTable.findElements(By.tagName("tr"));
					for (WebElement rTableRow : reportTableRow) {
						// System.out.println("Row:" +
						// rTableRow.findElements(By.xpath(".//td[4]//span[1][not(contains(@class,'ng-binding'))
						// and not(contains(@ng-if,'$root.isArray(cell)'))]")));
						if (rTableRow.findElements(By.xpath(".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]")).size() == 0) {
							System.out.println("letter pass");
						} else {
							System.out.println("Fail Letter");
							err = true;
						}

					}
				}

			} else if (testType.contains("Hematology Panel")) {
				if (testTypeFilter(listNum, "Haematology", 0, testType) == 1)
					err = true;
			} else if (testType.contains("Urine Culture")) {
				if (testTypeFilter(listNum, "Microbiology", 0, testType) == 1)
					err = true;
			} else if (testTypeFilter(listNum, "Chemistry", 0, testType) == 1)
				err = true;
		}
		CommonFunctions.clickUsingJavaExecutor(showResultsDropdown);
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor(showResultsDropdownList.findElement(By.xpath(".//li[1]")));
		return err;
	}

	public static boolean verifyShowResultsOptions(String testName, String expectedSectionName) throws InterruptedException {
		boolean err = false;
		if (testName != "") {
			CommonFunctions.clickUsingJavaExecutor(showResultsDropdown);

			CommonFunctions.waitForVisiblity(showResultsDropdown, 40);
			CommonFunctions.clickUsingJavaExecutor(ObjectHelper.driver.findElement(By.xpath("//span[contains(text(),'" + testName + "')]")));
			Thread.sleep(1000);
			int rowNum = 0;
			if (reportsTable.isDisplayed()) {
				List<WebElement> reportTableRow = reportsTable.findElements(By.tagName("tr"));
				for (WebElement rTableRow : reportTableRow) {
					Thread.sleep(1000);
					rowNum++;
					int sectionColumn = reportsTable.findElements(By.xpath(".//tr[" + rowNum + "]//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]")).size();
					if (sectionColumn != 1) {
						err = true;
					} else {
						if (!rTableRow.findElement(By.xpath(".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]")).getText().toLowerCase().contains(expectedSectionName.toLowerCase()))
							err = true;
						System.out.println(rTableRow.findElement(By.xpath(".//td[4]//span[1][not(contains(@class,'ng-binding')) and not(contains(@ng-if,'$root.isArray(cell)'))]")).getText().toLowerCase());
						System.out.println(expectedSectionName);
					}
				}
			}
			CommonFunctions.clickUsingJavaExecutor(showResultsDropdown);
			Thread.sleep(1000);
			CommonFunctions.clickUsingJavaExecutor(showResultsDropdownList.findElement(By.xpath(".//li[1]")));
		}
		return err;
	}

	public static boolean verifyShowOutOfRange() throws Exception {
		Thread.sleep(3000);
		boolean err = false;
		CommonFunctions.waitForVisiblity(reportsTable, 40);
		CommonFunctions.waitandClick(showOutOfRangeCheckbox, 2);
		Thread.sleep(5000);
		if (reportsTable.isDisplayed()) {
			List<WebElement> reportTableRow = reportsTable.findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				Thread.sleep(1000);
				if(rTableRow.findElement(By.xpath(".//td/h5")).getText().toLowerCase().contains("no tests for")) {
					err = false;
					break;
				}
				else {
				int sectionColumn = rTableRow.findElements(By.xpath(".//td[4]//span[contains(@class,'out-of-range')]")).size();
				// System.out.println("Table row value:" +
				// rTableRow.findElement(By.xpath(".//td[4]//span[1][not(contains(@class,'ng-binding'))
				// and not(contains(@ng-if,'$root.isArray(cell)'))]")).getText());
				if (sectionColumn < 1) {
					err = true;
				}
				}
			}
		}
		CommonFunctions.clickUsingJavaExecutor(showOutOfRangeCheckbox);
		CommonFunctions.waitForVisiblity(reportsTable, 40);
		return err;
	}

	public static boolean selectUser(String userName) {
		boolean err = false;
		try {
			CommonFunctions.waitForVisiblity(ReportsPage.userNameDropdownButton, 4);

			CommonFunctions.clickUsingJavaExecutor(ReportsPage.userNameDropdownButton);
			// the below line is added to intentionally fail and make the script wait
			CommonFunctions.waitForVisiblity(DashBoardPage.detailedAppointmentCloseButton, 1);
			CommonFunctions.clickUsingJavaExecutor("//div[contains(text(),'" + userName + "')]");
			// ObjectHelper.driver.findElement(By.xpath("//div[contains(text(),'" + userName
			// + "')]"))CommonFunctions.clickUsingJavaExecutor();
			CommonFunctions.waitForVisiblity(ReportsPage.userNameDropdownButton, 4);
			CommonFunctions.waitForVisiblity(ReportsPage.reportsTable, 4);
			// List<WebElement> userList =
			// ReportsPage.userNameDropdownList.findElements(By.tagName("li"));
			// // int i = 0;
			// for (int i = 1; i <= userList.size(); i++) {
			// userNameDropdownButtonCommonFunctions.clickUsingJavaExecutor();
			// Thread.sleep(1000);
			// if (ReportsPage.userNameDropdownList.findElement(By.xpath(".//li[" + i +
			// "]")).getText().contains(userName)) {
			// ReportsPage.userNameDropdownList.findElement(By.xpath(".//li[" + i +
			// "]"))CommonFunctions.clickUsingJavaExecutor();
			// CommonFunctions.waitForVisiblity(ReportsPage.userNameDropdownButton, 30);
			// if (!CommonFunctions.waitForVisiblity(ReportsPage.reportsTable, 30))
			// err = true;
			// break;
			// } else
			// try {
			// ObjectHelper.driver.findElement(By.xpath("//div[@class='dropdown-backdrop']"))CommonFunctions.clickUsingJavaExecutor();
			// } catch (Exception e) {
			// userNameDropdownButtonCommonFunctions.clickUsingJavaExecutor();
			// }
			// }
			/*
			 * for (WebElement user : userList) { i++;
			 * ReportsPage.userNameDropdownButtonCommonFunctions.clickUsingJavaExecutor();
			 * if (ReportsPage.userNameDropdownList.findElement(By.xpath(".//li[" + i +
			 * "]")).getText() .contains(userName)) {
			 * ReportsPage.userNameDropdownList.findElement(By.xpath(".//li[" + i +
			 * "]"))CommonFunctions.clickUsingJavaExecutor();
			 * CommonFunctions.waitForVisiblity(ReportsPage.userNameDropdownButton, 30); if
			 * (!CommonFunctions.waitForVisiblity(ReportsPage.reportsTable, 30)) err = true;
			 * 
			 * } else
			 * ReportsPage.userNameDropdownButtonCommonFunctions.clickUsingJavaExecutor(); }
			 */
			CommonFunctions.scrolltoElement(userNameDropdownButton);
		} catch (Exception e) {
			e.printStackTrace();
			err = true;
		}
		return err;
	}

	public static boolean printReportView() {// check the downloaded report name after env is fixed
		boolean err = false;
		try {
			CommonFunctions.waitForVisiblity(reportsView, 40);
			CommonFunctions.waitForVisiblity(reportPrintButton, 40);
			CommonFunctions.clickUsingJavaExecutor(reportPrintButton);
			if (CommonFunctions.waitForVisiblity(pdfPrintFailText, 30)) {
				CommonFunctions.clickonmodalpopup(pdfPrintFailOKButton);
				err = true;
				Screenshots.takeScreenshot("printReportViewError");
				CommonFunctions.clickUsingJavaExecutor(reportsViewBackButton);
			} else {
				if (CommonFunctions.waitForDownload("Report.pdf"))
					err = true;
				else
					CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Report.pdf");
				CommonFunctions.clickUsingJavaExecutor(reportsViewBackButton);
			}
		} catch (Exception e) {
			e.printStackTrace();
			err = true;
		}
		return err;
	}

	public static int getReportCount() {

		CommonFunctions.waitForVisiblity(ReportsPage.reportsTable, 4);

		return reportsTable.findElements(By.xpath(".//tr[not(@class='ng-scope ng-hide')]")).size();
	}

	public static String[] getAllUserNames() {
		String[] reportUserName;
		CommonFunctions.waitForVisiblity(ReportsPage.userNameDropdownButton, 2);
		CommonFunctions.clickUsingJavaExecutor(ReportsPage.userNameDropdownButton);
		// the below line is added to intentionally fail and make the script wait
		CommonFunctions.waitForVisiblity(DashBoardPage.detailedAppointmentCloseButton, 30);
		reportUserName = new String[ReportsPage.nameFromUserNameDropdownList.size()];
		for (int j = 0; j < ReportsPage.nameFromUserNameDropdownList.size(); j++) {
			reportUserName[j] = ReportsPage.nameFromUserNameDropdownList.get(j).getText();
		}
		CommonFunctions.clickUsingJavaExecutor(ReportsPage.userNameDropdownButton);
		return reportUserName;
	}

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
