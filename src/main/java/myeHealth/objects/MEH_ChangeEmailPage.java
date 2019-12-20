package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MEH_ChangeEmailPage {
	public static By emailField = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_EmailAddressTextBox']");
	public static By saveButton = By.id("ctl00_ContentPlaceHolder1_EmailAddressChangeButton");
	public static By cancelButton = By.id("ctl00_ContentPlaceHolder1_EmailAddressCancelButton");
	public static By changeSuccessOKText = By.id("ctl00_ContentPlaceHolder1_AccountStepsDescLabel");
	public static By homeButton = By.id("ctl00_ContentPlaceHolder1_MyeHealthButton");
	

	/*
	 * Description : enters new email id and saves the changes
	 * Parameters : String - the new email address
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */
	public static boolean changeEmail(String newEmail) {
		boolean err = false;
		CommonFunctions.waitForVisiblity(emailField, 30);
		ObjectHelper.driver.findElement(emailField).clear();
		ObjectHelper.driver.findElement(emailField).sendKeys(newEmail);
		ObjectHelper.driver.findElement(saveButton).click();
		CommonFunctions.waitForVisiblity(changeSuccessOKText, 30);
		if(ObjectHelper.driver.findElement(changeSuccessOKText).getText().contains("email address has been changed")) {
			ObjectHelper.driver.findElement(homeButton).click();
		}
		else
			err = true;
		return err;	
	}

}
