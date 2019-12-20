package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;


public class MEH_ChangeSecurityPhrasePage {
	public static By phraseField = By.id("ctl00_ContentPlaceHolder1_SecurityPhraseTextBox");
	public static By saveButton = By.id("ctl00_ContentPlaceHolder1_SecretPhraseChangeButton");
	public static By cancelButton = By.id("ctl00_ContentPlaceHolder1_SecretPhraseCancelButton");
	public static By changeSuccessOKText = By.id("ctl00_ContentPlaceHolder1_AccountStepsDescLabel");
	public static By homeButton = By.id("ctl00_ContentPlaceHolder1_MyeHealthButton");
	
	/*
	 * Description : updates security phrase and saves changes
	 * Parameters : @1 XLHandler object initiated for test data file
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean changeSecurityPhrase(String newPhrase) {
		boolean err = false;
		CommonFunctions.waitForVisiblity(phraseField, 30);
		ObjectHelper.driver.findElement(phraseField).clear();
		ObjectHelper.driver.findElement(phraseField).sendKeys(newPhrase);
		ObjectHelper.driver.findElement(saveButton).click();
		if(ObjectHelper.driver.findElement(changeSuccessOKText).getText().contains("security phrase has been changed")) {
			ObjectHelper.driver.findElement(homeButton).click();
		}
		else
			err = true;
		return err;
	}

}
