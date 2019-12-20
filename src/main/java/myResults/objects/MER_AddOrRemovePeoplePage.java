package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_AddOrRemovePeoplePage {
	public static By addAnotherPersonButton = By
			.xpath("//div[@id='manageaccountusers']//a[contains(text(),'ADD ANOTHER')]");
	public static By cancelButton = By.xpath("//div[@id='manageaccountusers']//a[contains(text(),'CANCEL')]");
	public static By step1NextButton = By.xpath("//button[@id='btn_next_add_person']");
	public static By step1CancelButton = By.xpath("//a[@id='btn_cancel_add_person']");
	public static By step1CancelModalOKButton = By.xpath("//button[text()='OK']");

	public static By removeConfirmationMessage = By.xpath("//p[@translate='MODAL_REMOVEUSER']");

	public static By removeOKButton = By.xpath("//button[@ng-if='ok' and text()='OK']");

	public static By removeSuccessMessage = By.xpath("//p[@translate='MODAL_REMOVEUSERSUCCESS']");

	public static boolean addAnotherPerson() {
		try {
			CommonFunctions.waitandClick(addAnotherPersonButton, 20);

			return CommonFunctions.waitForVisiblity(MER_RegisterPatientPage.anotherIndividualRadiobutton, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean removePerson(XLHandler objXLHandler) {
		try {

			String HealthCardNumber = objXLHandler.readCorrespondingValueFromTestDataName("Data", "HealthCardNumber");

			CommonFunctions.waitandClick(
					ObjectHelper.driver.findElement(By
							.xpath("//td[text()='" + HealthCardNumber + "']/following-sibling::td/a[text()='REMOVE']")),
					20);

			CommonFunctions.waitForVisiblity(removeConfirmationMessage, 20);

			CommonFunctions.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(removeConfirmationMessage),
					ObjectHelper.driver.findElement(removeOKButton));

			return (CommonFunctions
					.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(removeSuccessMessage),
							ObjectHelper.driver.findElement(removeOKButton))
					.contains("User has been removed successfully!"));
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clickCancel() {
		try {
			CommonFunctions.waitandClick(cancelButton, 20);

			return CommonFunctions.waitForVisiblity(MER_AccountSettingsPage.addRemovePeopleLink, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isPatientInList(XLHandler objXLHandler) {

		try {

			String HealthCardNumber = objXLHandler.readCorrespondingValueFromTestDataName("Data", "HealthCardNumber");
			Thread.sleep(5000);

			// return CommonFunctions.waitForVisiblity(
			// ObjectHelper.driver.findElement(By.xpath("//td[text()='" + HealthCardNumber +
			// "']")), 5);
			return ObjectHelper.driver.findElement(By.xpath("//td[text()='" + HealthCardNumber + "']")).isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}

}
