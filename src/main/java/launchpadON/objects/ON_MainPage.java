package launchpadON.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utils.ObjectHelper;

//@SuppressWarnings("unused")
public class ON_MainPage {
	WebDriver driver;

	public static By logoutlink = By.xpath("//input[@value='LOG-OFF']");
	public static By hl7uploadlink = By.xpath("//tr[@id='MainHL7Upload']//a");
	public static By userEntryLink = By.xpath("//tr[@id='MainUserAdmin']//a");
	public static By physicianEntryLink = By.xpath("//tr[@id='MainProviderAdmin']//a");
	public static By locationEntryLink = By.xpath("//tr[@id='MainLocationAdmin']//a");
	public static By standTestCatlink = By.xpath("//tr[@id='MainStandardTestCatalogueAdmin']//a");
	public static By testcatalougeentrylink = By.xpath("//tr[@id='MainTestCatalogueAdmin']//a");
	public static By auditreviewlink = By.xpath("//tr[@id='MainAuditReview']//a");
	public static By statuspdate = By.xpath("//tr[@id='MainStatusUpdate']//a");
	public static By exceptionMangLink = By.xpath("//tr[@id='MainExceptionManagement']//a");
	public static By myeHealthPatMapLink = By.xpath("//tr[@id='MainPatientMapping']//a");

	public static void logout() {
		JavascriptExecutor executor = (JavascriptExecutor) ObjectHelper.driver;
		executor.executeScript("arguments[0].click();", ObjectHelper.driver.findElement(logoutlink));
	}

	public static String acceptalert() {
		String alertText = ObjectHelper.driver.switchTo().alert().getText();
		ObjectHelper.driver.switchTo().alert().accept();
		return alertText;
	}

}
