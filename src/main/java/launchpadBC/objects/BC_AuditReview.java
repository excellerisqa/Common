package launchpadBC.objects;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BC_AuditReview {

	static String accession;
	public static By reportBtn = By.id("btnReport");
	public static By otherEntity = By.id("FilterType2");
	public static By entityTypeID = By.id("EntityValue");
	public static By trailCount = By.id("TrailCount");
	public static By accColumnTitle = By.xpath("//th[text()='ACC#:']");
			
	
	//public static By entity = By.id("Entity");

	public static void selectentitytype(String etype) {
		WebElement entitydd = ObjectHelper.driver.findElement(By.id("Entity"));
		Select entityDropDown = new Select(entitydd);
		entityDropDown.selectByVisibleText(etype);
	}

	public static int auditTrailCount(String trailText) {
		int count = 0;
		count = Integer.parseInt(StringUtils.substringAfterLast(trailText, ": "));
		return count;
	}
	
	public static int auditResult(String aAccession) {
		int auditResult = 0;
		try {
			if (CommonFunctions.waitForVisiblity(accColumnTitle, 10)) {
				auditResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aAccession + "')]")).size();		
			}	
			return auditResult;
			
		} catch (Exception e) {
			return auditResult;
		}
	}
}
