package launchpadBC.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.ObjectHelper;

public class BC_StatusUpdate {

	public static By accessionListBox = By.id("AccessionListBox");
	public static By updateTypedd = By.id("UpdateTypeDropDown");
	public static By updateDocListBox = By.id("UpdateDoctorsListBox");
	public static By updateBtn = By.id("UpdateButton");
	public static By updateresults = By.id("UpdateResults");

	public static void selectupdatetype(String updateType) {
		WebElement updateTypedrop = ObjectHelper.driver.findElement(updateTypedd);
		Select updateTypes = new Select(updateTypedrop);
		updateTypes.selectByValue(updateType);
	}

}
