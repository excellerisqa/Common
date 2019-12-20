package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MER_RemoveSecurityQuestionCookiePage {
	public static By removeButton = By.xpath("//button[text()='REMOVE']");

	public static By removeSuccessOKButton = By
			.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");

	public static By successMessage = By.xpath("//p[@translate='MODAL_REMOVESECURITYQUESTIONCOOKIE']");

	public static boolean removeSecurityQuestionCookie() {

		try {
			CommonFunctions.waitandClick(removeButton, 20);

			CommonFunctions.waitForVisiblity(successMessage, 20);

			return (CommonFunctions
					.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(successMessage),
							ObjectHelper.driver.findElement(removeSuccessOKButton))
					.contains("Your security question cookie has been removed successfully."));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
