package myResults.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_ChangeSecurityQuesPage {
	public static By question1Dropdown = By
			.xpath("//ng-form[@name='securitySettingsAnswerForm1']//select[@name='cannedQuestion']");
	public static By question2Dropdown = By
			.xpath("//ng-form[@name='securitySettingsAnswerForm2']//select[@name='cannedQuestion']");
	public static By question3Dropdown = By
			.xpath("//ng-form[@name='securitySettingsAnswerForm3']//select[@name='cannedQuestion']");
	public static By answer1Field = By.xpath("//ng-form[@name='securitySettingsAnswerForm1']//input[@name='answer']");
	public static By answer2Field = By.xpath("//ng-form[@name='securitySettingsAnswerForm2']//input[@name='answer']");
	public static By answer3Field = By.xpath("//ng-form[@name='securitySettingsAnswerForm3']//input[@name='answer']");
	public static By saveButton = By.xpath("//div[@id='changesecurityquestions']//button[text()='SAVE']");
	public static By cancelButton = By.xpath("//div[@id='changesecurityquestions']//a[text()='CANCEL']");
	public static By changeSuccessOKButton = By
			.xpath("//div[@class='modal-content']//button[@ng-if='ok' and text()='OK']");

	public static By successMessage = By.xpath("//p[@translate='MODAL_SECURITYQUESTIONS_CHANGED']");

	public static boolean changeSecurityQues(XLHandler objXLHandler) {
		try {
			String ansCar = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", "car");
			String ansEyes = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", "eyes");
			String ansWatch = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", "watch");
			String ansAnimal = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", "animal");

			CommonFunctions.waitForVisiblity(question1Dropdown, 20);

			Select ques1 = new Select(ObjectHelper.driver.findElement(question1Dropdown));
			if (ques1.getFirstSelectedOption().getText().contains("car")) {
				ques1.selectByValue("What is the color of your eyes?");
				ObjectHelper.driver.findElement(answer1Field).sendKeys(ansEyes);
			} else if (ques1.getFirstSelectedOption().getText().contains("eyes")) {
				ques1.selectByValue("What was the color of your first car?");
				ObjectHelper.driver.findElement(answer1Field).sendKeys(ansCar);
			} else if (ques1.getFirstSelectedOption().getText().contains("city")) {
				ques1.selectByValue("What is the color of your eyes?");
				ObjectHelper.driver.findElement(answer1Field).sendKeys(ansEyes);
			}
			ObjectHelper.driver.findElement(answer2Field).sendKeys(ansAnimal);
			ObjectHelper.driver.findElement(answer3Field).sendKeys(ansWatch);
			ObjectHelper.driver.findElement(saveButton).click();
			CommonFunctions.waitForVisiblity(successMessage, 20);

			return (CommonFunctions
					.getMessageOnModalPopupAndClose(ObjectHelper.driver.findElement(successMessage),
							ObjectHelper.driver.findElement(changeSuccessOKButton))
					.contains("Your security questions have been updated successfully."));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

}
