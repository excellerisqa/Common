package launchpadON.objects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.ObjectHelper;

public class ON_AuditReview {

	static String accession;
	public static By reportBtn = By.id("btnReport");
	public static By otherEntity = By.xpath("//input[@id=\"FilterType2\"]");
	public static By entityTypeID = By.id("EntityValue");
	public static By trailCount = By.id("TrailCount");

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
}
