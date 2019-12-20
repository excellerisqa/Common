package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_ChangePasswordPage {
	public static By currentPasswordField = By.xpath("//div[@id='changepassword']//input[@name='currentPassword']");
	public static By newPasswordField = By.xpath("//div[@id='changepassword']//input[@name='password']");
	public static By retypePasswordField = By.xpath("//div[@id='changepassword']//input[@name='confirmPassword']");
	public static By saveButton = By.xpath("//div[@id='changepassword']//button[text()='SAVE']");
	public static By cancelButton = By.xpath("//div[@id='changepassword']//a[text()='CANCEL']");
	public static By changeSuccessOKButton = By
			.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");
	public static By successMessage = By.xpath("//p[@translate='MODAL_PASSWORD_CHANGED']");

	public static boolean changePassword(XLHandler objXLHandler) {
		try {
			String currentPassword = objXLHandler.readCorrespondingValueFromTestDataName("Login", "Password");
			String newPassword = objXLHandler.readCorrespondingValueFromTestDataName("Login", "New Password");

			CommonFunctions.waitForVisiblity(currentPasswordField, 20);

			ObjectHelper.driver.findElement(currentPasswordField).clear();
			ObjectHelper.driver.findElement(currentPasswordField).sendKeys(currentPassword);

			ObjectHelper.driver.findElement(newPasswordField).clear();
			ObjectHelper.driver.findElement(newPasswordField).sendKeys(newPassword);

			ObjectHelper.driver.findElement(retypePasswordField).clear();
			ObjectHelper.driver.findElement(retypePasswordField).sendKeys(newPassword);

			ObjectHelper.driver.findElement(saveButton).click();
			CommonFunctions.waitForVisiblity(successMessage, 20);

			// TODO update the current and new passwords in test data
			// write New password to current password field
			objXLHandler.setDatabyCell(0, 1, 1, newPassword); // write invoice number to sheet
			// write invoice number to excel
			String nextTimeNewPassword = newPassword.substring(0, 12)
					+ (Integer.parseInt(newPassword.split("Dominion")[1]) + 1);
			objXLHandler.setDatabyCell(0, 2, 1, nextTimeNewPassword); // write invoice number to sheet

			return (CommonFunctions
					.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(successMessage),
							ObjectHelper.driver.findElement(changeSuccessOKButton))
					.contains("Your password has been changed successfully."));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// return false;
			return false;
		}

	}

}
