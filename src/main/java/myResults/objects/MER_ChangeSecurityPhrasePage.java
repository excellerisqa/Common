package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_ChangeSecurityPhrasePage {
	public static By phraseField = By.xpath("//div[@id='changesecurityphrase']//input[@name='securityPhrase']");
	public static By saveButton = By.xpath("//div[@id='changesecurityphrase']//button[text()='SAVE']");
	public static By cancelButton = By.xpath("//div[@id='changesecurityphrase']//a[text()='CANCEL']");
	public static By changeSuccessOKButton = By
			.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");

	public static By successMessage = By.xpath("//p[@translate='MODAL_SECURITYPHRASE_CHANGED']");

	public static boolean changeSecurityPhrase(XLHandler objXLHandler) {
		try {
			String securityPhrase = objXLHandler.readCorrespondingValueFromTestDataName("Data", "Security Phrase");
			String newPhrase = objXLHandler.readCorrespondingValueFromTestDataName("Data", "New Security Phrase");

			CommonFunctions.waitForVisiblity(phraseField, 20);

			if (ObjectHelper.driver.findElement(phraseField).getText().contains(securityPhrase)) {
				ObjectHelper.driver.findElement(phraseField).clear();
				ObjectHelper.driver.findElement(phraseField).sendKeys(newPhrase);
			} else if (ObjectHelper.driver.findElement(phraseField).getText().contains(newPhrase)) {
				ObjectHelper.driver.findElement(phraseField).clear();
				ObjectHelper.driver.findElement(phraseField).sendKeys(securityPhrase);
			}

			ObjectHelper.driver.findElement(saveButton).click();
			return (CommonFunctions
					.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(successMessage),
							ObjectHelper.driver.findElement(changeSuccessOKButton))
					.contains("Your security phrase has been changed successfully."));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
