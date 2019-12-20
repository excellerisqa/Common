package myResults.objects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonFunctions;
import utils.ObjectHelper;
import utils.XLHandler;

public class MER_LoginPage {

	public static By usernameField = By.id("emailInput");
	public static By passwordField = By.id("passwordInput");
	public static By loginButton = By
			.xpath("//div[@id='loginform']//button[@class='btn btn-primary btn-block btnPHover ng-binding']");
	public static By securityQuesAnswerField = By
			.xpath("//div[@id='answerchallengeform']//input[@ng-model='answerChallengeFormData.answer']");
	public static By securityQues = By.xpath("//div[@id='answerchallengeform']/div/form/p[1]/label");
	public static By securityQuesVerifyButton = By
			.xpath("//div[@id='answerchallengeform']//button[contains(text(), 'VERIFY')]");
	public static By donotasksecurityquesCheckboxLink = By.xpath("//div[@class='checkbox remember-bg']/label");

	public static By createAccountLink = By.xpath("//div[@id='loginform']//a[contains(@href,'Registration')]");

	public static By globalizationLinksTop = By
			.xpath("// ul[@class='nav nav-pills navbar-right topnav']/li/div/a[@data-toggle='dropdown']");
	public static By languageOptionsLinksTop = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a");

	public static By globalizationLinksBottom = By
			.xpath("// ul[@class='list-inline xs-center']/li/div/a[@data-toggle='dropdown']");
	public static By languageOptionsLinksBottom = By.xpath("//ul[@class='dropdown-menu dropdown-menu-left']/li/a");

	public static By aboutUsLinks = By.xpath("//a[text()='About Us']");
	public static By faqLink = By.xpath("//a[text()='FAQ']");
	public static By supportLink = By.xpath("//a[text()='Support']");
	public static By privacyLink = By.xpath("//a[text()='Privacy Statement']");
	public static By termOfUseLink = By.xpath("//a[text()='Terms of Use']");
	public static By copyrightText = By.xpath("//p[@class='xs-center ng-binding']");
	public static By howCanIAccessResultsLink = By.xpath("//a[text()='How can I access lab results online?']");
	public static By forgotPasswordLink = By.xpath("//a[text()='Forgot your password or account locked?']");
	public static By forgotPasswordCancelLink = By.xpath("//a[text()='CANCEL']");

	public static By landingPageHeading = By.xpath("//h2[@translate='LANDINGPAGE_HEADING']");
	public static By forgotPasswordEmailTextbox = By.xpath("//input[@ng-model='forgotPasswordFormData.emailAddress']");
	public static By privacyHeading = By.xpath("//h1[text()='PRIVACY STATEMENT']");
	public static By termsOfUseHeading = By.xpath("//h1[text()='TERMS OF USE']");

	public static By copyright = By.xpath("//p[contains(text(),'All rights reserved')]");

	public static By doNotAskSecurityQuestionCheckbox = By.xpath("//label[@translate='FIELD_SKIPQUESTION']");

	String user;
	String pwd;
	XLHandler data;

	/*
	 * Description : read username and password from test data file Parameters : @1
	 * XLHandler object initiated for test data file Returns : void Author : Sindhu
	 * Rajaguru Modified By:
	 */
	public void readLoginData(XLHandler objXLHandler) {
		/*
		 * user = objXLHandler.getDatabyCell(0, 0, 1); pwd =
		 * objXLHandler.getDatabyCell(0, 1, 1);
		 */
		user = objXLHandler.readCorrespondingValueFromTestDataName("Login", "Username");
		pwd = objXLHandler.readCorrespondingValueFromTestDataName("Login", "Password");
	}

	/*
	 * Description : read corresponding security answers from test data file
	 * Parameters : @1 XLHandler object initiated for test data file Returns :
	 * String - answer for the question on screen Author : Sindhu Rajaguru Modified
	 * By:
	 */
	public String answerSecurityQuestion(XLHandler objXLHandler) {
		String ques = ObjectHelper.driver.findElement(securityQues).getText();
		String ans = "abc";
		int n = objXLHandler.getNumberOfRows("Security Ques");
		for (int i = 0; i < n; i++) {
			String quesData = objXLHandler.getDatabyCell("Security Ques", i, 0);
			if (ques.contains(quesData)) {
				ans = objXLHandler.readCorrespondingValueFromTestDataName("Security Ques", quesData);
				break;
			}
		}
		/*
		 * if (ques.contains("Question 1")) ans =
		 * objXLHandler.readCorrespondingValueFromTestDataName("Security Ques"
		 * ,"Question A"); else if (ques.contains("Question B")) ans =
		 * objXLHandler.readCorrespondingValueFromTestDataName("Security Ques"
		 * ,"Question B"); else if (ques.contains("Question C")) ans =
		 * objXLHandler.readCorrespondingValueFromTestDataName("Security Ques"
		 * ,"Question C");
		 */
		return ans;
	}

	/*
	 * Description : enter login credentials, answer security questions and login
	 * Parameters : @1 XLHandler object initiated for test data file Returns : void
	 * Author : Sindhu Rajaguru Modified By:
	 */
	public void login(XLHandler objXLHandler) throws InterruptedException {
		CommonFunctions.waitForVisiblity(usernameField, 50);
		readLoginData(objXLHandler);
		ObjectHelper.driver.findElement(usernameField).sendKeys(user);
		ObjectHelper.driver.findElement(passwordField).sendKeys(pwd);
		ObjectHelper.driver.findElement(loginButton).click();
		Thread.sleep(4000);

		if (ObjectHelper.driver.findElement(securityQuesAnswerField).isDisplayed()) {
			ObjectHelper.driver.findElement(securityQuesAnswerField).sendKeys(answerSecurityQuestion(objXLHandler));
			CommonFunctions.waitForVisiblity(securityQuesVerifyButton, 20);
			ObjectHelper.driver.findElement(securityQuesVerifyButton).click();
			Thread.sleep(4000);
		}
		CommonFunctions.waitForVisiblity(MER_MainPage.dashboardLink, 30);
	}

	public boolean loginAndVerify(XLHandler objXLHandler) {
		try {
			CommonFunctions.waitForVisiblity(usernameField, 50);
			readLoginData(objXLHandler);
			ObjectHelper.driver.findElement(usernameField).sendKeys(user);
			ObjectHelper.driver.findElement(passwordField).sendKeys(pwd);
			ObjectHelper.driver.findElement(loginButton).click();
			// Thread.sleep(4000);
			CommonFunctions.waitForVisiblity(securityQuesAnswerField, 50);

			if (ObjectHelper.driver.findElement(securityQuesAnswerField).isDisplayed()) {
				ObjectHelper.driver.findElement(securityQuesAnswerField).sendKeys(answerSecurityQuestion(objXLHandler));
				CommonFunctions.waitForVisiblity(securityQuesVerifyButton, 20);
				ObjectHelper.driver.findElement(securityQuesVerifyButton).click();
				Thread.sleep(4000);
			} else
				System.out.println("Security question is not asked.");
			return CommonFunctions.waitForVisiblity(MER_MainPage.dashboardLink, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean loginWithSelectDoNotAskSecurityQuestionAndVerify(XLHandler objXLHandler) {
		try {
			CommonFunctions.waitForVisiblity(usernameField, 50);
			readLoginData(objXLHandler);
			ObjectHelper.driver.findElement(usernameField).sendKeys(user);
			ObjectHelper.driver.findElement(passwordField).sendKeys(pwd);
			ObjectHelper.driver.findElement(loginButton).click();
			Thread.sleep(4000);

			if (ObjectHelper.driver.findElement(securityQuesAnswerField).isDisplayed()) {
				ObjectHelper.driver.findElement(securityQuesAnswerField).sendKeys(answerSecurityQuestion(objXLHandler));

				// select checkbox - do not ask security questions
				ObjectHelper.driver.findElement(doNotAskSecurityQuestionCheckbox).click();

				CommonFunctions.waitForVisiblity(securityQuesVerifyButton, 20);
				ObjectHelper.driver.findElement(securityQuesVerifyButton).click();
				Thread.sleep(4000);
			}
			return CommonFunctions.waitForVisiblity(MER_MainPage.dashboardLink, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean loginWithNewEmailAndVerify(XLHandler objXLHandler) {
		try {

			CommonFunctions.waitForVisiblity(usernameField, 50);
			readLoginData(objXLHandler);

			String newEmail = objXLHandler.readCorrespondingValueFromTestDataName("Data", "New Email");
			System.out.println("Logging in with new email address: " + newEmail);

			ObjectHelper.driver.findElement(usernameField).sendKeys(newEmail);
			ObjectHelper.driver.findElement(passwordField).sendKeys(pwd);
			ObjectHelper.driver.findElement(loginButton).click();
			Thread.sleep(4000);

			if (ObjectHelper.driver.findElement(securityQuesAnswerField).isDisplayed()) {
				ObjectHelper.driver.findElement(securityQuesAnswerField).sendKeys(answerSecurityQuestion(objXLHandler));
				CommonFunctions.waitForVisiblity(securityQuesVerifyButton, 20);
				ObjectHelper.driver.findElement(securityQuesVerifyButton).click();
				Thread.sleep(4000);
			}
			return CommonFunctions.waitForVisiblity(MER_MainPage.dashboardLink, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToCreateAccount() {
		try {
			Thread.sleep(5000);
			ObjectHelper.driver.findElement(createAccountLink).click();
			return (CommonFunctions.waitForVisiblity(MER_Registration.accountProfileHeading, 20));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyGlobalizationInHeader() {
		System.out.println("Inside verifyGlobalizationInHeader ");
		return verifyGlobalization(globalizationLinksTop, languageOptionsLinksTop);
	}

	public boolean verifyGlobalizationInFooter() {
		return verifyGlobalization(globalizationLinksBottom, languageOptionsLinksBottom);
	}

	public boolean verifyAboutUsInHeader() {
		try {
			CommonFunctions.waitForVisiblity(aboutUsLinks, 5);
			ObjectHelper.driver.findElements(aboutUsLinks).get(0).click();
			return verifyAboutUsURL();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyFAQInHeader() {
		try {
			CommonFunctions.waitandClick(faqLink, 20);
			return CommonFunctions.waitForVisiblity(MER_FAQPage.faqHeading, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyMyResultsIcon() {
		try {

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifySupportInHeader() {
		try {
			CommonFunctions.waitandClick(supportLink, 20);

			return CommonFunctions.waitForVisiblity(MER_MainPage.supportHeading, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyForgotPasswordLink() {
		try {
			CommonFunctions.waitandClick(forgotPasswordLink, 20);
			boolean isForgotPasswordTextboxDisplayed = CommonFunctions.waitForVisiblity(forgotPasswordEmailTextbox, 10);
			ObjectHelper.driver.findElement(forgotPasswordCancelLink).click();
			Thread.sleep(2000);
			return isForgotPasswordTextboxDisplayed;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyHowCanIAccessLink() {
		try {
			CommonFunctions.waitandClick(howCanIAccessResultsLink, 20);
			return CommonFunctions.waitForVisiblity(MER_FAQPage.faqHeading, 20);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyGlobalization(By languageDropdown, By languageOptions) {
		try {
			System.out.println("Inside verifyGlobalization");
			boolean globalizationVerified = false;
			CommonFunctions.waitandClick(languageDropdown, 20);

			Thread.sleep(2000);
			List<WebElement> languageOptionsList = ObjectHelper.driver.findElements(languageOptions);
			System.out.println("languageOptionsList found size: " + languageOptionsList.size()
					+ languageOptionsList.get(0).getText() + languageOptionsList.get(1).getText()
					+ languageOptionsList.get(2).getText() + languageOptionsList.get(3).getText());
			if (CommonFunctions.waitForVisiblity(languageOptions, 10)) {

				boolean isENVerified = false, isFRVerified = false, isZHVerified = false, isPAVerified = false;

				for (WebElement language : languageOptionsList) {
					String lang = language.getAttribute("translate");
					switch (lang) {
					case ("LANG_EN"):
						if (!isENVerified) {
							System.out.println("Inside EN");
							Thread.sleep(5000);
							if (!(language.isDisplayed())) {
								ObjectHelper.driver.findElement(languageDropdown).click(); // expands
								CommonFunctions.waitandClick(language, 10);
								System.out.println("Inside IF ..language clicked");
							} else {
								language.click();
								System.out.println("Inside else..language clicked");
							}

							if (CommonFunctions.waitForVisiblity(landingPageHeading, 10)) {

								globalizationVerified = ObjectHelper.driver.findElement(landingPageHeading).getText()
										.contains("Providing patients with secure access to their lab results");
							}
							if (!globalizationVerified) {
								// finally change it to English
								Thread.sleep(5000);
								// ObjectHelper.driver.findElement(languageDropdown).click(); // expands
								CommonFunctions.waitandClick(languageDropdown, 10);
								Thread.sleep(5000);
								CommonFunctions.waitandClick(languageOptionsList.get(0), 10);
								System.out.println("EN selected.. returning false");
								return false;
							} else {
								isENVerified = true;
								System.out.println("EN verified: true");
							}
						}
						break;
					case ("LANG_FR"):
						if (!isFRVerified) {
							System.out.println("Inside FR");
							Thread.sleep(5000);
							if (!(language.isDisplayed())) {
								ObjectHelper.driver.findElement(languageDropdown).click(); // expands
								CommonFunctions.waitandClick(language, 10);
								System.out.println("Inside IF ..language clicked");
							} else {
								language.click();
								System.out.println("Inside else ..language clicked");
							}

							if (CommonFunctions.waitForVisiblity(landingPageHeading, 10)) {

								globalizationVerified = ObjectHelper.driver.findElement(landingPageHeading).getText()
										.contains("de laboratoire");

							}
							if (!globalizationVerified) {
								// finally change it to English
								Thread.sleep(5000);
								// ObjectHelper.driver.findElement(languageDropdown).click(); // expands
								CommonFunctions.waitandClick(languageDropdown, 10);
								Thread.sleep(5000);
								CommonFunctions.waitandClick(languageOptionsList.get(0), 10);
								System.out.println("EN selected.. returning false");
								return false;
							} else {
								isFRVerified = true;
								System.out.println("FR verified: true");
							}
						}

						break;
					case ("LANG_ZH"):
						if (!isZHVerified) {
							System.out.println("Inside ZH");
							Thread.sleep(5000);
							if (!(language.isDisplayed())) {
								ObjectHelper.driver.findElement(languageDropdown).click(); // expands
								CommonFunctions.waitandClick(language, 10);
								System.out.println("Inside IF ..language clicked");
							} else {
								language.click();
								System.out.println("Inside else ..language clicked");
							}

							if (CommonFunctions.waitForVisiblity(landingPageHeading, 10)) {

								globalizationVerified = !(ObjectHelper.driver.findElement(landingPageHeading).getText()
										.contains("Providing patients with secure access to their lab results"));
							}
							if (!globalizationVerified) {
								// finally change it to English
								Thread.sleep(5000);
								// ObjectHelper.driver.findElement(languageDropdown).click(); // expands
								CommonFunctions.waitandClick(languageDropdown, 10);
								Thread.sleep(5000);
								CommonFunctions.waitandClick(languageOptionsList.get(0), 10);
								System.out.println("EN selected.. returning false");
								return false;
							} else {
								isZHVerified = true;
								System.out.println("ZH verified: true");
							}
						}

						break;
					case ("LANG_PA"):
						if (!isPAVerified) {
							System.out.println("Inside PA");
							Thread.sleep(5000);
							if (!(language.isDisplayed())) {
								ObjectHelper.driver.findElement(languageDropdown).click(); // expands
								CommonFunctions.waitandClick(language, 10);
								System.out.println("Inside IF ..language clicked");
							} else {
								language.click();
								System.out.println("Inside else ..language clicked");
							}

							if (CommonFunctions.waitForVisiblity(landingPageHeading, 10)) {

								globalizationVerified = !(ObjectHelper.driver.findElement(landingPageHeading).getText()
										.contains("Providing patients with secure access to their lab results"));
							}
							if (!globalizationVerified) {
								// finally change it to English
								Thread.sleep(5000);
								// ObjectHelper.driver.findElement(languageDropdown).click(); // expands
								CommonFunctions.waitandClick(languageDropdown, 10);
								Thread.sleep(5000);
								CommonFunctions.waitandClick(languageOptionsList.get(0), 10);
								System.out.println("EN selected.. returning false");
								return false;
							} else {
								isPAVerified = true;
								System.out.println("PA verified: true");
							}
						}
						break;

					default:
						System.out.println("Unidentified Language found");
						break;
					}
				}

				// finally change it to English
				Thread.sleep(5000);
				// ObjectHelper.driver.findElement(languageDropdown).click(); // expands
				CommonFunctions.waitandClick(languageDropdown, 10);
				Thread.sleep(5000);
				CommonFunctions.waitandClick(languageOptionsList.get(0), 10);
				System.out.println("EN selected.. FINALLY");

				return (isENVerified && isFRVerified && isZHVerified && isPAVerified);

			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyAboutUsInFooter() {
		try {
			CommonFunctions.waitForVisiblity(aboutUsLinks, 5);
			ObjectHelper.driver.findElements(aboutUsLinks).get(1).click();
			return verifyAboutUsURL();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean verifyAboutUsURL() throws Exception {
		CommonFunctions.waitForNewTabToOpen(2, 10);

		ArrayList<String> tabs = new ArrayList<String>();
		if (!CommonFunctions.waitForNewTabToOpen(2, 20))
			return false;
		else {
			// Switch to new tab
			tabs = new ArrayList<String>(ObjectHelper.driver.getWindowHandles());
			Thread.sleep(5000);
			ObjectHelper.driver.switchTo().window(tabs.get(1));// go to second tab

			String currentUrl = ObjectHelper.driver.getCurrentUrl();
			System.out.println("Redirected to the URL: " + currentUrl);

			ObjectHelper.driver.close();
			ObjectHelper.driver.switchTo().window(tabs.get(0));

			return currentUrl.equals("http://www.lifelabs.com/corporate/Pages/default.aspx");
		}
	}

	public boolean verifyPrivacyStatement() {
		try {
			CommonFunctions.waitandClick(privacyLink, 10);
			return CommonFunctions.waitForVisiblity(privacyHeading, 10);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyTermsOfUse() {
		try {
			CommonFunctions.waitandClick(termOfUseLink, 10);
			return CommonFunctions.waitForVisiblity(termsOfUseHeading, 10);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyCopyrightYear() {
		try {
			// CommonFunctions.waitForVisiblity(copyright, 10);
			Thread.sleep(5000);
			String copyrightText = ObjectHelper.driver.findElement(copyright).getText();
			String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			return copyrightText.contains(currentYear);

		} catch (Exception e) {
			return false;
		}
	}

}
