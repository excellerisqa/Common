package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_ChangePersonalInfoPage {
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
	public static By changeSuccessOKButton = By
			.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");
	public static By successMessage = By.xpath("//p[@translate='MODAL_ACCOUNTINFO_CHANGED']");

	public static String newCitySet = "";

	public static boolean changeAddress(XLHandler objXLHandler) {

		try {
			String city = objXLHandler.readCorrespondingValueFromTestDataName("Data", "City");
			String newCity = objXLHandler.readCorrespondingValueFromTestDataName("Data", "New City");

			CommonFunctions.waitForVisiblity(cityField, 20);

			if (ObjectHelper.driver.findElement(cityField).getText().contains(city)) {
				ObjectHelper.driver.findElement(cityField).clear();
				ObjectHelper.driver.findElement(cityField).sendKeys(newCity);
				newCitySet = newCity;
			} else if (ObjectHelper.driver.findElement(cityField).getText().contains(newCity)) {
				ObjectHelper.driver.findElement(cityField).clear();
				ObjectHelper.driver.findElement(cityField).sendKeys(city);
				newCity = city;
			}

			ObjectHelper.driver.findElement(saveButton).click();
			return (CommonFunctions
					.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(successMessage),
							ObjectHelper.driver.findElement(changeSuccessOKButton))
					.contains("Your personal information has been updated successfully."));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean verifyCity() {
		return (ObjectHelper.driver.findElement(cityField).getText().contains(newCitySet));
	}

}
