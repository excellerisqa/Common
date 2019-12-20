package ccofit.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class Reports {

	WebDriver driver;

	public static String ddReport = "//span[@class='k-select']//span";
	@FindBy(xpath = "//span[@class='k-select']//span")
	public static WebElement reportsDD;

	public static String printBtn = "btnPrint";
	@FindBy(id = "btnPrint")
	public static WebElement print;

	public static String kitRep = "//li[contains(text(),'Kit Report')]";
	@FindBy(xpath = "//li[contains(text(),'Kit Report')]")
	public static WebElement kitReport;

	public static String hoursReport = "//li[contains(text(),'24 Hours Report')]";
	@FindBy(xpath = "//li[contains(text(),'24 Hours Report')]")
	public static WebElement hours24Report;

	public static String ineligReport = "//li[contains(text(),'Ineligible Report')]";
	@FindBy(xpath = "//li[contains(text(),'Ineligible Report')]")
	public static WebElement ineligibleReport;

	public static String monExpiryReport = "//li[contains(text(),'6 Month Expiry Report')]";
	@FindBy(xpath = "//li[contains(text(),'6 Month Expiry Report')]")
	public static WebElement monthlyExpirtyReport;

	public static void selectReportType(String report) {
		CommonFunctions.waitForVisiblity(reportsDD, 15);
		reportsDD.click();
		report.toLowerCase();
		switch (report) {
		case "kit":
			CommonFunctions.waitForVisiblity(kitReport, 20);
			kitReport.click();
			break;
		case "24hours":
			CommonFunctions.waitForVisiblity(hours24Report, 20);
			hours24Report.click();
			break;
		case "ineligible":
			CommonFunctions.waitForVisiblity(ineligibleReport, 20);
			ineligibleReport.click();
			break;
		case "monthly expiry":
			CommonFunctions.waitForVisiblity(monthlyExpirtyReport, 20);
			monthlyExpirtyReport.click();
			break;
		}
	}

	public Reports(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
