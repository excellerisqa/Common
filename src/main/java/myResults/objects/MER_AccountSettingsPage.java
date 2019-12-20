package myResults.objects;

import org.openqa.selenium.By;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class MER_AccountSettingsPage {
	public static By welcomeHeader = By.xpath("//h2[@class='main-title text-center ng-binding ng-scope']");
	public static By changeEmailLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Change Email Address')]");
	public static By changePasswordLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Change Password')]");
	public static By changeSecuityQuesLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Change Security Questions')]");
	public static By changeSecurityPhraseLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Change Security Phrase')]");
	public static By personalInfoLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Personal Information')]");
	public static By changeConsentContactedLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Change Consent')]");
	public static By removeCookieLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Remove Security Question')]");
	public static By addRemovePeopleLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Add or Remove People')]");

	public static By removeSecurityQuestionCookieLink = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Remove Security Question Cookie')]");

	public static By changeEmailActualEmailText = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Change Email Address')]//span");
	public static By changeSecurityPhraseActualPhraseText = By
			.xpath("//div[@class='my-account-list ng-scope']//a[contains(.,'Change Security Phrase')]//span");

	public static By currentSettings = By.xpath("//span[@class='dynamic-indicator ng-binding']");

	public static boolean goToChangeEmailAddress() {
		try {
			CommonFunctions.waitandClick(changeEmailLink, 20);

			return CommonFunctions.waitForVisiblity(MER_ChangeEmailPage.saveButton, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToChangePassword() {
		try {
			CommonFunctions.waitandClick(changePasswordLink, 20);

			return CommonFunctions.waitForVisiblity(MER_ChangePasswordPage.saveButton, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToChangeSecurityQuestions() {
		try {
			CommonFunctions.waitandClick(changeSecuityQuesLink, 20);

			return CommonFunctions.waitForVisiblity(MER_ChangeSecurityQuesPage.question1Dropdown, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToChangeSecurityPhrase() {
		try {
			CommonFunctions.waitandClick(changeSecurityPhraseLink, 20);

			return CommonFunctions.waitForVisiblity(MER_ChangeSecurityPhrasePage.saveButton, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToPersonalInformation() {
		try {
			CommonFunctions.waitandClick(personalInfoLink, 20);

			return CommonFunctions.waitForVisiblity(MER_ChangePersonalInfoPage.saveButton, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToConsentToBeContacted() {
		try {
			CommonFunctions.waitandClick(changeConsentContactedLink, 20);

			return CommonFunctions.waitForVisiblity(MER_ChangeConsentPage.saveButton, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToRemoveSecurityQuestionsCookie() {
		try {
			CommonFunctions.waitandClick(removeCookieLink, 20);

			return CommonFunctions.waitForVisiblity(MER_RemoveSecurityQuestionCookiePage.removeButton, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean goToAddRemovePeople() {
		try {
			CommonFunctions.waitandClick(addRemovePeopleLink, 20);

			return CommonFunctions.waitForVisiblity(MER_AddOrRemovePeoplePage.addAnotherPersonButton, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isCurrentConsentYes() {
		try {
			return ObjectHelper.driver.findElements(currentSettings).get(2).getText().contains("Yes");

		} catch (Exception e) {
			return false;
		}
	}

}
