package launchpadBC.objects;

import org.openqa.selenium.By;

import utils.ObjectHelper;

public class BC_PatientSummary {
	public static String title;

	public static By totalrecords = By.xpath("//*[@id=\"MessageText\"]/text()");
	public static By selbox = By.xpath("//*[@id=\"selbox\"]");
	public static By resetstatus = By.xpath("//*[@id=\"btnResetStatus\"]");
	public static By bprint = By.xpath("//*[@id=\"bPrint\"]");
	public static By print = By.xpath("//*[@id=\"print\"]");
	public static By view = By.xpath("//*[@id=\"bView\"]");
	public static By PrintAll = By.xpath("//*[@id=\"PrintAll\"]/div");
	public static By PrintAllFinal = By.xpath("//*[@id=\"PrintAllFinal\"]/div");
	public static By PrintSelection = By.xpath("//*[@id=\"PrintSelection\"]/div");
	public static By recordstab5 = By.xpath("//*[@id=\"RecordTabs5\"]/a");
	public static By createreportbutton = By.xpath("// *[@id=\"CreateReportButton\"]");
	public static By printCumReport = By.xpath("// *[@id=\"PrintCumReport\"]");
	public static By close = By.xpath("//*[@id=\"close\"]");
	public static By next = By.xpath("//*[@id=\"next\"]/img");
	public static By tittle = By.xpath("//*[@id=\"tdWSTitle\"]");

	public static void viewreport() throws InterruptedException {
		ObjectHelper.driver.findElement(BC_Inbox.patienthistorysearch).click();
		Thread.sleep(2000);
		ObjectHelper.driver.findElement(view).click();
		Thread.sleep(2000);
		title = ObjectHelper.driver.findElement(tittle).getText();
		if (BC_Inbox.title.contains("Results For")) {
			ObjectHelper.driver.findElement(next).click();
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(print).click();
			Thread.sleep(2000);
			ObjectHelper.driver.findElement(close).click();
		}
	}

}
