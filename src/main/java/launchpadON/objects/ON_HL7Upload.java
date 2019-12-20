package launchpadON.objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import utils.ObjectHelper;

public class ON_HL7Upload {

	static String uploadstatus;
	public static By chooseFileLink = By.xpath("//input[@id='FileUpload']");
	public static By chooseFile = By.id("FileUpload");
	public static By uploadFileBtn = By.id("UploadButton");
	public static By uploadResults = By.id("UploadResults");

	public static boolean waitForHL7Upload() {
		try {
			Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(ObjectHelper.driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(2));
			fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(uploadResults));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
