package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MER_ChangeConsentPage {
	public static By consentYesRadioButton = By.xpath("//form[@name='changeConsentForm']//label[@for='consentYes']");
	public static By consentYesInput = By.id("consentYes");

	public static By consentNoRadioButton = By.xpath("//form[@name='changeConsentForm']//label[@for='consentNo']");

	public static By consentNoInput = By.id("consentNo");

	public static By cancelButton = By.xpath("//form[@name='changeConsentForm']//a[text()='CANCEL']");
	public static By saveButton = By.xpath("//form[@name='changeConsentForm']//button[text()='SAVE']");

	public static By changeSuccessOKButton = By
			.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");
	public static By successMessage = By.xpath("//p[@translate='MODAL_CONSENT_CHANGED']");

	public static String newConsent = "";

	public static boolean changeConsent(boolean isYes) {

		try {
			CommonFunctions.waitForVisiblity(consentYesRadioButton, 20);

			if (isYes) {
				ObjectHelper.driver.findElement(consentNoRadioButton).click();
				newConsent = "no";

			} else {
				ObjectHelper.driver.findElement(consentYesRadioButton).click();
				newConsent = "yes";
			}

			ObjectHelper.driver.findElement(saveButton).click();
			return (CommonFunctions
					.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(successMessage),
							ObjectHelper.driver.findElement(changeSuccessOKButton))
					.contains("Your consent choice has been updated successfully."));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean verifyConsent() {
		if (newConsent.equals("yes")) {
			// boolean isyes =
			// ObjectHelper.driver.findElement(consentYesRadioButton).isSelected();
			boolean isyes = ObjectHelper.driver.findElement(consentYesInput).getAttribute("class")
					.equals("ng-untouched ng-valid ng-dirty ng-valid-parse");

			return isyes;
		}

		// if (newConsent.equals("no"))
		else {
			boolean isNo = ObjectHelper.driver.findElement(consentNoInput).getAttribute("class")
					.equals("ng-untouched ng-valid ng-dirty ng-valid-parse");
			return isNo;
		}
	}
}
