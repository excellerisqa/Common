package myeHealth.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MEH_AnalyticsPage {
	public static By userNameDropdown=By.id("ctl00_ContentPlaceHolder1_PatientDropDownList");
	public static By analyticsView = By.id("CummulativeReportsTableDiv");
	public static By analyticsViewTable = By.id("ctl00_ContentPlaceHolder1_CummulativeReportsTable");
	public static By analyticsViewGraphButton = By.xpath("//table[@id='ctl00_ContentPlaceHolder1_CummulativeReportsTable']//div[@class='CumHeaderChkBoxPanelStyle']");
	public static By analyticsViewGraphModal = By.id("ctl00_ContentPlaceHolder1_TestItemAnalyticsContainer");
	public static By analyticsViewGraphModalClose = By.id("ctl00_ContentPlaceHolder1_TestItemAnalyticsContainerCloseButton");
	public static By viewTestsCheckboxes = By.id("ctl00_ContentPlaceHolder1_FilterTestsDropDownList1");
	public static By lastVisitsDropdown = By.id("ctl00_ContentPlaceHolder1_FilterVisitDropDownList");
	public static By analyticsGetReportsButton = By.id("ctl00_ContentPlaceHolder1_GetTestHistoryButton");
	public static By noTestsLabel = By.id("ctl00_ContentPlaceHolder1_FilterTestsNoList");

	/*
	 * Description : selects all available test sections, gets analytics report, verifies report table display, verifies graph display if graph is available
	 * Parameters : Integer - The index of the user for whom this analytics report is generated (like 1, 2 etc.)
	 * Returns : void
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */
	public static void viewAnalyticsTable(int userCount){
		List<WebElement> testsList = ObjectHelper.driver.findElement(viewTestsCheckboxes)
				.findElements(By.tagName("span"));
		for (WebElement testResult : testsList) {
			// resultIndex++;
			//String testType = testResult.getText();
			//System.out.println("TestType:" + testType);
			testResult.click();
		}
		ObjectHelper.driver.findElement(analyticsGetReportsButton).click();
		CommonFunctions.waitForVisiblityWithException(analyticsViewTable, 40);
	}
	public static void viewAnalyticsGraph() {
		if (ObjectHelper.driver.findElement(analyticsViewTable).isDisplayed()) {
			//ObjectHelper.test.pass("Verify view analytics table for User " + userCount + ": Pass");
			List<WebElement> tablerows = ObjectHelper.driver.findElement(analyticsViewTable)
					.findElements(By.tagName("tr"));
			if (ObjectHelper.driver.findElement(analyticsViewTable)
					.findElements(By.xpath(".//img[@style='visibility:hidden;']")).size() != tablerows.size() - 1) {
				ObjectHelper.driver.findElement(analyticsViewGraphButton).click();
				System.out.println("clickon graph");
				CommonFunctions.waitForVisiblityWithException(analyticsViewGraphModal, 40);
				//ObjectHelper.test.pass("Verify view analytics graph for User " + userCount + ": Pass");
				ObjectHelper.driver.findElement(analyticsViewGraphModalClose).click();
			}
		}
	}
	
	public static boolean lastVisitFilter(){
		boolean err = false;
		try {
		Select lastVisit = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
		lastVisit.selectByVisibleText("Last 5 Days");
		if (!CommonFunctions.waitForVisiblity(noTestsLabel, 40)) {
			if (!CommonFunctions.waitForVisiblity(viewTestsCheckboxes, 40)) {
				err = true;
			}
		}
		Select lastVisit1 = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
		lastVisit1.selectByVisibleText("All Visits");
		Thread.sleep(2000);
		if (!CommonFunctions.waitForVisiblity(viewTestsCheckboxes, 40)) {
			err = true;
		}
		ObjectHelper.driver.findElement(viewTestsCheckboxes).findElement(By.tagName("span")).click();		
		ObjectHelper.driver.findElement(analyticsGetReportsButton).click();
		if(!CommonFunctions.waitForVisiblity(analyticsViewTable, 40))
			err = true;
		}catch(Exception e) {
			err = true;
			System.out.println("Error:"+e);
		}
		return err;
	}
}
	

