package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MEH_ChangePasswordPage {
	public static By currentPasswordField = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_CurrentPassword']");
	public static By newPasswordField = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_Password']");
	public static By retypePasswordField = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_ConfirmPassword']");
	public static By saveButton = By.id("ctl00_ContentPlaceHolder1_PasswordChangeButton");
	public static By cancelButton = By.id("ctl00_ContentPlaceHolder1_PasswordCancelButton");
	public static By changeSuccessOKText = By.id("ctl00_ContentPlaceHolder1_AccountStepsDescLabel");
	public static By homeButton = By.id("ctl00_ContentPlaceHolder1_MyeHealthButton");
	//public static By changeSuccessOKButton = By.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");//need to check in production
	
	
	/*
	 * Description : updates new password and saves the changes
	 * Parameters : @1 String - old/current password
	 * 				@2 String - new password
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean changePassword(String curPassword, String newPassword) throws InterruptedException {
		boolean err = false;
		CommonFunctions.waitForVisiblity(currentPasswordField, 50);
		ObjectHelper.driver.findElement(currentPasswordField).clear();
		ObjectHelper.driver.findElement(currentPasswordField).sendKeys(curPassword);
		ObjectHelper.driver.findElement(newPasswordField).clear();
		ObjectHelper.driver.findElement(newPasswordField).sendKeys(newPassword);
		ObjectHelper.driver.findElement(retypePasswordField).clear();
		ObjectHelper.driver.findElement(retypePasswordField).sendKeys(newPassword);
		ObjectHelper.driver.findElement(saveButton).click();
		if(ObjectHelper.driver.findElement(changeSuccessOKText).getText().contains("password has been changed")) {
			ObjectHelper.driver.findElement(homeButton).click();
		}
		else
			err = true;
		return err;
	}

}
