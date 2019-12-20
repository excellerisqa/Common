package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MEH_ChangeConsentPage {
	public static By consentYesRadioButton = By.id("ctl00_ContentPlaceHolder1_SurveyConsentRadioButtonGroup_0");
	public static By consentNoRadioButton = By.id("ctl00_ContentPlaceHolder1_SurveyConsentRadioButtonGroup_1");
	public static By cancelButton = By.id("ctl00_ContentPlaceHolder1_SurveyConsentCancelButton");
	public static By saveButton = By.id("ctl00_ContentPlaceHolder1_SurveyConsentChangeButton");
	public static By changeSuccessOKText = By.id("ctl00_ContentPlaceHolder1_AccountStepsDescLabel");
	public static By homeButton = By.id("ctl00_ContentPlaceHolder1_MyeHealthButton");
	
	/*
	 * Description : updates consent to be contacted and saves changes
	 * Parameters : 
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public static boolean changeConsent() {
		boolean err = false;
		CommonFunctions.waitForVisiblity(saveButton, 30);
		String selectedValue = ObjectHelper.driver.findElement(By.xpath("//input[@checked='checked']")).getAttribute("value");
		if(selectedValue.equals("Y"))
			ObjectHelper.driver.findElement(consentNoRadioButton).click();
		else
			ObjectHelper.driver.findElement(consentYesRadioButton).click();		
		ObjectHelper.driver.findElement(saveButton).click();
		if(ObjectHelper.driver.findElement(changeSuccessOKText).getText().contains("consent selection has been changed")) {
			ObjectHelper.driver.findElement(homeButton).click();
		}
		else
			err = true;
		return err;
	}

}


