package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_ChangeEmailPage {
	public static By emailField = By.xpath("//div[@id='changeemail']//input[@name='email']");
	public static By confirmEmailField = By.xpath("//div[@id='changeemail']//input[@name='confirmemail']");
	public static By saveButton = By.xpath("//div[@id='changeemail']//button[text()='SAVE']");
	public static By cancelButton = By.xpath("//div[@id='changeemail']//a[text()='CANCEL']");
	public static By changeSuccessOKButton = By
			.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");

	public static By currentEmailMessage = By.xpath("//b[contains(text(),'Your Current Email Address:')]");

	public static By successMessage = By.xpath("//p[@translate='MODAL_EMAIL_CHANGED']");

	public static String currentEmail = "";

	public static boolean changeEmail(XLHandler objXLHandler) {

		try {
			String email = objXLHandler.readCorrespondingValueFromTestDataName("Data", "Email");
			String newEmail = objXLHandler.readCorrespondingValueFromTestDataName("Data", "New Email");

			CommonFunctions.waitForVisiblity(emailField, 20);

			currentEmail = ObjectHelper.driver.findElement(currentEmailMessage).getText().split(":")[1];

			if (currentEmail.trim().equals(email)) {
				ObjectHelper.driver.findElement(emailField).clear();
				ObjectHelper.driver.findElement(emailField).sendKeys(newEmail);
				ObjectHelper.driver.findElement(confirmEmailField).sendKeys(newEmail);

			} else if (currentEmail.trim().equals(newEmail)) {
				ObjectHelper.driver.findElement(emailField).clear();
				ObjectHelper.driver.findElement(emailField).sendKeys(email);
				ObjectHelper.driver.findElement(confirmEmailField).sendKeys(email);
			}

			ObjectHelper.driver.findElement(saveButton).click();
			CommonFunctions.waitForVisiblity(successMessage, 20);

			return (CommonFunctions
					.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(successMessage),
							ObjectHelper.driver.findElement(changeSuccessOKButton))
					.contains("Your email address has been changed successfully."));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
