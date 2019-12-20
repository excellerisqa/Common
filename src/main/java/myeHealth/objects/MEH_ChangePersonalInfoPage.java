package myeHealth.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MEH_ChangePersonalInfoPage {
	public static By firstNameField = By.xpath("//div[@id='changeaccountprofile']//input[@name='givenName']");
	public static By lastNameField = By.xpath("//div[@id='changeaccountprofile']//input[@name='surName']");
	public static By streetAddressField = By.xpath("//div[@id='changeaccountprofile']//input[@name='address1']");
	public static By cityField = By.xpath("//div[@id='changeaccountprofile']//input[@name='city']");
	public static By postalcodeField = By.xpath("//div[@id='changeaccountprofile']//input[@name='zipOrPostalCode']");
	public static By birthYearDropdown = By.xpath("//div[@id='changeaccountprofile']//select[@name='birthYear']");
	public static By birthMonthDropdown = By.xpath("//div[@id='changeaccountprofile']//select[@name='birthMonth']");
	public static By birthDayDropdown = By.xpath("//div[@id='changeaccountprofile']//select[@name='birthDay']");
	public static By saveButton = By.xpath("//div[@id='changeaccountprofile']//button[text()='SAVE']");
	public static By cancelButton = By.xpath("//div[@id='changeaccountprofile']//a[text()='CANCEL']");
	public static By changeSuccessOKButton = By.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");
	
	boolean err = false;
	/*
	 * Description : updates street address and saves the changes
	 * Parameters : @1 String - new street address
	 * Returns : Boolean - false for success, true for failure
	 * Author : Sindhu Rajaguru
	 * Modified By:
	 * */	
	public boolean changeStreetAddress(String addr) {
			ObjectHelper.driver.findElement(streetAddressField).clear();
			ObjectHelper.driver.findElement(streetAddressField).sendKeys(addr);
			ObjectHelper.driver.findElement(saveButton).click();
			try {
				CommonFunctions.clickonmodalpopup(changeSuccessOKButton);
			}catch(Exception e) {
				err = true;			
			}
			return err;
	}

}
