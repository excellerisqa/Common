package upp1.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class AnalyticsPage {
	WebDriver driver;

	public AnalyticsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String completeaccountprofilebuttonpath = "//a[@title='Complete Account Profile']";
	public static String addlabreportsbuttonpath = "//a[@title='Add Lab Reports for Me or Another Person']";

	@FindBy(xpath = "//a[@title='Complete Account Profile']")
	public static WebElement completeaccountprofilebutton;

	@FindBy(xpath = "//a[@title='Add Lab Reports for Me or Another Person']")
	public static WebElement addlabreportsbutton;

	@FindBy(xpath = "//div[@id='analyticstable']/div/div[4]/table/tbody")
	public static WebElement analyticsTable;

	@FindBy(xpath = "//div[@id='analyticSummary']//button[@class='multiselect dropdown-toggle btn btn-default']")
	public static WebElement userNameDropdownButton;

	@FindBy(xpath = "//div[@id='analyticSummary']//ul[@class='multiselect-container dropdown-menu']")
	public static WebElement userNameDropdownList;

	@FindBy(xpath = "//div[@id='analyticstable']//div[contains(@class,'showOnly checkbox filter')]/label")
	public static WebElement showOutOfRangeCheckbox;

	@FindBy(xpath = "//div[@id='analyticstable']//button[@data-id='labTestSelectPicker']")
	public static WebElement showResultsDropdown;

	@FindBy(xpath = "//div[@id='analyticstable']//button[@data-id='labVisitSelectPicker']")
	public static WebElement lastVisitsDropdown;

	@FindBy(xpath = "//div[@id='analyticsview']")
	public static WebElement analyticsView;

	@FindBy(xpath = "//div[@id='analyticsview']//h2")
	public static WebElement analyticsViewTableHeading;

	@FindBy(xpath = "//div[@id='analyticsview']//table//tbody")
	public static WebElement analyticsViewTable;

	public static boolean selectUser(String userName) {
		boolean err = false;
		try {
			CommonFunctions.waitForVisiblity(userNameDropdownButton, 40);
			CommonFunctions.clickUsingJavaExecutor(userNameDropdownButton);
			// the below line is added to intentionally fail and make the script wait
			CommonFunctions.waitForVisiblity(DashBoardPage.detailedAppointmentCloseButton, 1);
			CommonFunctions.waitandClick(ObjectHelper.driver.findElement(By.xpath("//div[contains(text(),'" + userName + "')]")), 2);
			// ObjectHelper.driver.findElement(By.xpath("//div[contains(text(),'" + userName
			// + "')]"))CommonFunctions.clickUsingJavaExecutor();
			CommonFunctions.waitForVisiblity(userNameDropdownButton, 40);
		} catch (Exception e) {
			e.printStackTrace();
			err = true;
		}
		return err;
	}

	public static boolean verifyShowOutOfRange() throws InterruptedException {
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor(showOutOfRangeCheckbox);
		//showOutOfRangeCheckbox.click();
		// adding this failed wait to make the script wait for table load
		CommonFunctions.waitForVisiblity(ReportsPage.reportsView, 1);
		boolean err = false;
		if (CommonFunctions.waitForVisiblity(analyticsTable, 2)) {
			List<WebElement> reportTableRow = analyticsTable.findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				// Thread.sleep(1000);
				try {
				if(rTableRow.findElement(By.xpath(".//td/h5")).getText().toLowerCase().contains("no tests for")) {
					err = false;
					break;
				}
				} catch (Exception e) {
					e.printStackTrace();
					err = true;
				}
				try {
				
					rTableRow.findElement(By.xpath(".//td[4]//span[contains(@class,'tablesaw-cell-content')]/img[@ng-show='column.isOutOfRange && results.rows[$index].markOutOfRange']"));
					err = false;
				
				} catch (Exception e) {
					e.printStackTrace();
					err = true;
				}
				
			}
		}
		CommonFunctions.clickUsingJavaExecutor(showOutOfRangeCheckbox);
		return err;
	}

	public static boolean verifyShowResultsOptions(String testName, String[] expectedTestResultName) throws InterruptedException {
		boolean err = false;
		if (testName != "") {
			CommonFunctions.clickUsingJavaExecutor(showResultsDropdown);

			CommonFunctions.waitForVisiblity(showResultsDropdown, 40);
			CommonFunctions.clickUsingJavaExecutor(ObjectHelper.driver.findElement(By.xpath("//span[contains(text(),'" + testName + "')]")));
			Thread.sleep(1000);
			int rowNum = 0;
			if (analyticsTable.isDisplayed()) {
				List<WebElement> reportTableRow = analyticsTable.findElements(By.tagName("tr"));
				for (WebElement rTableRow : reportTableRow) {
					Thread.sleep(1000);
					rowNum++;
					String actualTestResultName = rTableRow.findElement(By.xpath(".//td[3]//span[contains(@class,'ng-binding ng-scope')]")).getText();
					int zStat = 0;
					for (int z = 0; z < expectedTestResultName.length; z++) {
						if (actualTestResultName.contains(expectedTestResultName[z])) {
							zStat = 1;
							break;
						}
					}
					if (zStat == 0)
						err = true;
				}
			}
			CommonFunctions.clickUsingJavaExecutor(showResultsDropdown);
			Thread.sleep(1000);
			CommonFunctions.clickUsingJavaExecutor(ObjectHelper.driver.findElement(By.xpath("//span[contains(text(),'Show all test results')]")));
		}
		return err;
	}

	public static int viewAnalyticsReport() throws InterruptedException {
		int stat = 0;
		CommonFunctions.waitForVisiblity(analyticsTable, 20);
		Thread.sleep(2000);
		String analyticsTest = analyticsTable.findElement(By.xpath(".//tr[1]/td[3]//span[2]/span")).getText();
		CommonFunctions.clickUsingJavaExecutor(analyticsTable.findElement(By.xpath(".//tr[1]/td[3]")));
		System.out.println(analyticsTest);
		if (!CommonFunctions.waitForVisiblity(analyticsView, 10))
			stat = 1;
		else {
			if (!analyticsViewTableHeading.getText().equals(analyticsTest))
				stat = 1;
			CommonFunctions.clickUsingJavaExecutor(analyticsViewTable.findElement(By.xpath(".//tr/td[3]")));
			if (!CommonFunctions.waitForVisiblity(ReportsPage.reportsPatientNameInfo, 10)) {
				stat = 2;
			} else
				CommonFunctions.clickUsingJavaExecutor(ReportsPage.reportsViewBackButton);
		}

		return stat;
	}

	public static boolean verifyLastVisitsFilter(String filterName) throws InterruptedException {
		boolean err = false;
		if (filterName != "") {
			CommonFunctions.clickUsingJavaExecutor(lastVisitsDropdown);

			CommonFunctions.waitForVisiblity(lastVisitsDropdown, 40);
			CommonFunctions.clickUsingJavaExecutor(ObjectHelper.driver.findElement(By.xpath("//span[contains(text(),'" + filterName + "')]")));
			Thread.sleep(1000);
			// int rowNum = 0;
			String collectiondate[] = { "0", "0", "0", "0", "0" };
			if (filterName.contains("5 Days")) {

				for (int n = 4; n >= 0; n--) {
					collectiondate[n] = CommonFunctions.getDate(0 - (n),"yyyy-MM-dd");
					System.out.println(collectiondate[n]);
				}
				if (analyticsTable.isDisplayed()) {
					if (analyticsTable.findElement(By.xpath(".//tr//td")).getText().contains("no tests for the selected")) {
						err = false;
					} else {
						List<WebElement> reportTableRow = analyticsTable.findElements(By.tagName("tr"));

						for (WebElement rTableRow : reportTableRow) {
							Thread.sleep(1000);
							// rowNum++;
							String rowCollectionDate = rTableRow.findElement(By.xpath(".//td[2]//span[contains(@class,'ng-binding ng-scope')]")).getText();
							int zStat = 0;
							for (int z = 0; z < collectiondate.length; z++) {
								if (rowCollectionDate.contains(collectiondate[z])) {
									zStat = 1;
									break;
								}
							}
							if (zStat == 0)
								err = true;
						}
					}
					CommonFunctions.clickUsingJavaExecutor(lastVisitsDropdown);
					Thread.sleep(1000);
					CommonFunctions.clickUsingJavaExecutor(ObjectHelper.driver.findElement(By.xpath("//span[contains(text(),'All Visits')]")));
				}
			}
		}
		return err;
	}

	public static int getAnalyticsRowCount() {
		return analyticsTable.findElements(By.xpath(".//tr")).size();
	}
}
