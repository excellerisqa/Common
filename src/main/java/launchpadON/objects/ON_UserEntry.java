package launchpadON.objects;

import org.openqa.selenium.By;

import utils.ObjectHelper;

public class ON_UserEntry {

	public static By userid_txt = By.xpath("//input[@id='sUserID']");
	public static By searchbtn = By.id("btnSearch");
	public static By recFound = By.id("tdText");
	public static By newButton = By.id("btnNew");

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
