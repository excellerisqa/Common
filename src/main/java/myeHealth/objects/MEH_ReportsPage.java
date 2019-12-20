package myeHealth.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.Screenshots;
import utils.XLHandler;


public class MEH_ReportsPage {
	public static By userNameDropdown=By.id("ctl00_ContentPlaceHolder1_PatientDropDownList");	
	public static By reportsList = By.id("ctl00_ContentPlaceHolder1_GridView1jEsCoOl_mainDiv");
	public static By reportsListTableContent = By.xpath("//div[@id='ctl00_ContentPlaceHolder1_GridView1jEsCoOl_tableDiv']//table");
	public static By noResultsSpan = By.id("ctl00_ContentPlaceHolder1_Lab_Error");
	public static By reportsView = By.xpath("//div[@id ='ctl00_ContentPlaceHolder1_ReportDiv']//div[@id='ReportContent']");
	public static By reportsViewCloseButton = By.id("ctl00_ContentPlaceHolder1_But_Close");
	public static By reportsViewPrintButton = By.id("ctl00_ContentPlaceHolder1_But_Print");
	public static By printReportsButton = By.id("ctl00_ContentPlaceHolder1_But_PrintReports");
	public static By viewReportsButton = By.id("ctl00_ContentPlaceHolder1_But_ViewReports");
	public static By showResultsDropdown = By.id("ctl00_ContentPlaceHolder1_FilterTestsDropDownList");
	public static By lastVisitsDropdown = By.id("ctl00_ContentPlaceHolder1_FilterVisitDropDownList");
	public static By showOutOfRangeCheckbox = By.xpath("//div[@id='Filter']//label");
	public static By showMorePtientDetailsCheckbox = By.id("chkbox");
	public static By showMorePatientDetailsContent = By.id("ReportHeaderControl1_ReportPatientDetailsContainer2");
	public static By noResultsLabel = By.id("ctl00_ContentPlaceHolder1_Lab_Error");
	public static By reportsViewTable = By.id("Reportbody");

	//public boolean err = false;
	/*
	 * Description : click on report from table and verifies report details view
	 * Parameters : Integer - The index of the user whose report is being verified (like 1, 2 etc.)
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static int viewReport(int userCount) throws InterruptedException {
		int errStep = 0;
		try {
			//ObjectHelper.driver.findElement(reportsListTableContent).findElement(By.xpath(".//tbody[2]/tr[2]/td[2]")).click();
			Thread.sleep(3000);
			Screenshots.takeScreenshot("reportView");
			if (!CommonFunctions.waitForVisiblity(reportsView, 60))
				errStep = 4;
			if (errStep == 0) {

				ObjectHelper.driver.findElement(showMorePtientDetailsCheckbox).click();
				if (!CommonFunctions.waitForVisiblity(showMorePatientDetailsContent, 60))
					errStep = 5;

				List<WebElement> reportViewResultRows = ObjectHelper.driver.findElement(reportsViewTable)
						.findElements(By.xpath(".//tr[@class='Tbl_Result_Item_Row']"));

				String resultData = "";
				for (WebElement row1 : reportViewResultRows) {
					int i = 0;
					List<WebElement> reportViewResultColumns = row1.findElements(By.tagName("td"));
					for (WebElement col : reportViewResultColumns) {
						i++;
						resultData = col.getText();
						// System.out.println(i+"resultString:"+resultData);
						if (resultData.contains("Test Name =") || resultData.contains("TEST ITEM ="))
							errStep = 6;
					}
				}
			}
				/*
				String resultData = row1.findElement(By.xpath(".//td[3]")).getText();
						//ObjectHelper.driver.findElement(reportsViewTable).findElement(By.xpath("//tr["+i+"]//td[3]")).getText();
				System.out.println("resultString td3:"+resultData);
				if(resultData.contains("Test Name =")||resultData.contains("TEST ITEM ="))
					err = true;
				resultData = row1.findElement(By.xpath(".//td[2]")).getText();
				System.out.println("resultString td2:"+resultData);
				if(resultData.contains("Test Name =")||resultData.contains("TEST ITEM ="))
					err = true;
			}*/
			ObjectHelper.driver.findElement(reportsViewCloseButton).click();
		} catch (Exception e) {
			errStep = 4;
		}
		return errStep;
	}
	public static boolean viewReportUsingButton() throws InterruptedException {
		boolean err = false;
		try {
			ObjectHelper.driver.findElement(reportsListTableContent).findElement(By.xpath(".//tbody[2]/tr[2]/td[1]/input"))
					.click();
			ObjectHelper.driver.findElement(viewReportsButton).click();
			Thread.sleep(3000);
			Screenshots.takeScreenshot("VerifyReportViewFromButton_ID_11810_reportView");
			if (!CommonFunctions.waitForVisiblity(reportsView, 60))
				err = true;
			ObjectHelper.driver.findElement(reportsViewCloseButton).click();
		} catch (Exception e) {
			err = true;
		}
		return err;
	}
	
	/*
	 * Description : prints/downloads all reports from the report table for a particular user
	 * Parameters : Integer - The index of the user whose report is being verified (like 1, 2 etc.)
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean printAllReport(int userCount) throws InterruptedException {
		boolean err = false;
			Thread.sleep(1000);
			CommonFunctions.waitForVisiblityWithException(reportsListTableContent, 60);
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(printReportsButton).click();
			CommonFunctions.waitForDownload("Report.pdf");
			if(!CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Report.pdf"))
				err = true;
				//ObjectHelper.test.fail("Reports couldn't be printed from the report table");	
			return err;	
	}
	
	/*
	 * Description : prints/downloads report from the report details view for a particular user
	 * Parameters : Integer - The index of the user whose report is being verified (like 1, 2 etc.)
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean printReportView(int userCount) throws InterruptedException {
		boolean err = false;
			Thread.sleep(1000);
			CommonFunctions.waitForVisiblityWithException(reportsListTableContent, 60);
			ObjectHelper.driver.findElement(reportsListTableContent).findElement(By.xpath(".//tbody[2]/tr[1]/td[2]")).click();
			Thread.sleep(3000);
			CommonFunctions.waitForVisiblityWithException(reportsView, 60);
			ObjectHelper.driver.findElement(reportsViewPrintButton).click();
			if(CommonFunctions.waitForDownload("Report.pdf"))
				err= true;
				//ObjectHelper.test.fail("Report couldn't be printed from the report view");
			else
			CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "Report.pdf");
				
			ObjectHelper.driver.findElement(reportsViewCloseButton).click();	
	return err;
	}

	/*
	 * Description : select a test result filter based on data from test data file and verifies the report table
	 * Parameters : @1 XLHandler object initiated for test data file
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean verifyShowResultsOptions(XLHandler objXLHandler) throws InterruptedException {
		boolean err = false;
		String testType = objXLHandler.readCorrespondingValueFromTestDataName("Data", "Filter test");
		Select showResults = new Select(ObjectHelper.driver.findElement(showResultsDropdown));
		showResults.selectByVisibleText(testType);
		Thread.sleep(3000);
		String sectionText = objXLHandler.readCorrespondingValueFromTestDataName("Test Map", testType);
		//System.out.println("Testmap"+sectionText);
		CommonFunctions.waitForVisiblity(reportsListTableContent, 30);
		if (ObjectHelper.driver.findElement(reportsListTableContent).isDisplayed()) {
			List<WebElement> reportTableRow = ObjectHelper.driver.findElement(reportsListTableContent).findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				Thread.sleep(1000);
				if (rTableRow.findElements(By.xpath(".//td[3]//span")).size() > 1) {
					err = true;
					System.out.println("Size mismatch");
				} else {
					if (!rTableRow.findElement(By.xpath(".//td[3]")).getText().contains(sectionText)) {
						err = true;
						System.out.println("Text mismatch" + rTableRow.findElement(By.xpath(".//td[3]")).getText());
					}
				}
			}
		}
		return err;

	}
	
	/*
	 * Description : select a last visit filter and verifies the report table
	 * Parameters : none
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean verifyLastVisitOptions() throws InterruptedException {
		boolean err = false;

		Select lastVisit = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
		lastVisit.selectByVisibleText("Last 5 Days");
		Thread.sleep(2000);
		if (!CommonFunctions.waitForVisiblity(noResultsLabel, 40)) {
			if (!CommonFunctions.waitForVisiblity(reportsListTableContent, 40)) {
				err = true;
			}
		}
		Select lastVisit1 = new Select(ObjectHelper.driver.findElement(lastVisitsDropdown));
		lastVisit1.selectByVisibleText("All Visits");
		Thread.sleep(2000);
		if (!CommonFunctions.waitForVisiblity(reportsListTableContent, 40)) {
			err = true;
		}

		return err;

	}
	
	/*
	 * Description : select a test result filter based on data from test data file and verifies the report table
	 * Parameters : none
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean verifyShowOutOfRange() throws InterruptedException {
		Thread.sleep(2000);
		CommonFunctions.waitForVisiblity(reportsListTableContent, 30);
		ObjectHelper.driver.findElement(showOutOfRangeCheckbox).click();
		Thread.sleep(2000);
		CommonFunctions.waitForVisiblity(reportsListTableContent, 30);
		boolean err = false;
		if (ObjectHelper.driver.findElement(reportsListTableContent).isDisplayed()) {
			List<WebElement> reportTableRow = ObjectHelper.driver.findElement(reportsListTableContent)
					.findElements(By.tagName("tr"));
			for (WebElement rTableRow : reportTableRow) {
				if (!rTableRow.findElement(By.xpath(".//td[6]")).getText().contains("Y")) {
					err = true;
					System.out.println("out of range column" + rTableRow.findElement(By.xpath(".//td[6]")).getText());
				} 
			}
		}
		return err;

	}

}
