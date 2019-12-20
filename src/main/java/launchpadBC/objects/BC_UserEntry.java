package launchpadBC.objects;

import org.openqa.selenium.By;

import utils.ObjectHelper;

public class BC_UserEntry {

	public static By userid_txt = By.xpath("//input[@id='sUserID']");
	public static By searchbtn = By.id("btnSearch");
	public static By recFound = By.id("tdText");

	// Add by Sarah started
	public static By newButton = By.id("btnNew");

	// Add by Sarah end

	public static boolean verifySearchEntry() {
		boolean recordsFound;
		String actualText = ObjectHelper.driver.findElement(recFound).getText();
		String expText = "1 Records found";
		if (actualText.equalsIgnoreCase(expText)) {
			recordsFound = true;
		} else {
			recordsFound = false;
		}
		return recordsFound;
	}
}
