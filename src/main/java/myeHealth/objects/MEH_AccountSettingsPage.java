package myeHealth.objects;

import org.openqa.selenium.By;

public class MEH_AccountSettingsPage {
	public static By welcomeHeader = By.xpath("//h1[@id='ctl00_ContentPlaceHolder1_AccountsTitleDesc']");
	public static By changeEmailLink = By.id("ctl00_ContentPlaceHolder1_ChangeEmailAddressLabel");
	public static By changePasswordLink = By.id("ctl00_ContentPlaceHolder1_ChangePasswordLabel");
	public static By changeSecuityQuesLink = By.id("ctl00_ContentPlaceHolder1_ChangeSecurityQuestionsLabel");
	public static By changeSecurityPhraseLink = By.id("ctl00_ContentPlaceHolder1_ChangeSecretPhraseLabel");
	public static By mergeAccountsLink = By.id("ctl00_ContentPlaceHolder1_MaangeClientLabel");
	public static By changeConsentContactedLink = By.id("ctl00_ContentPlaceHolder1_ChangeSurveyConsentLabel");
	public static By removeCookieLink = By.id("ctl00_ContentPlaceHolder1_RemoveSecurityQuestionCookieLabel");
	public static By registerAnotherPersonLink = By.id("ctl00_ContentPlaceHolder1_AddNewPatientLabel");
}
