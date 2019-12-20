package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MEH_RemoveSecurityCookiePage {
	
	public static By removeButton = By.id("ctl00_ContentPlaceHolder1_RemoveSecurityQuestionCookieButton");
	public static By cancelButton = By.id("ctl00_ContentPlaceHolder1_RemoveSecurityQuestionCookieCancelButton");
	public static By changeSuccessOKText = By.id("ctl00_ContentPlaceHolder1_AccountStepsDescLabel");
	public static By homeButton = By.id("ctl00_ContentPlaceHolder1_MyeHealthButton");
	
	public static boolean removeCookie() {
		boolean err = false;
		CommonFunctions.waitForVisiblity(removeButton, 10);
		ObjectHelper.driver.findElement(removeButton).click();
		if(ObjectHelper.driver.findElement(changeSuccessOKText).getText().contains("security cookie has been removed")) {
			ObjectHelper.driver.findElement(homeButton).click();
		}
		else
			err = true;
		return err;
	}

}
