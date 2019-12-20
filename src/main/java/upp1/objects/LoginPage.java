package upp1.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LoginPage {
	WebDriver driver;

	public static String usernametextpath = "//input[@id='emailInput']";
	public static String passwordtextpath = "//input[@id='passwordInput']";
	public static String loginbuttonpath = "//button[contains(.,'Login')]";
	public static String createaccountbuttonpath = "//a[@class='btn btn-other bg-light-gray ng-scope' and text()='Create an Account']";
	public static String securityquestionlabelpath = "//p[@class='pad-top-8']//i[@class='ng-binding']";
	public static String securitytextpath = "//input[@name='answer']";
	public static String remembermecheckboxpath = "//label[@for='rememberMe']";
	public static String verifybuttonpath = "//button[@type='submit' and text()='VERIFY']";
	public static String securitycancelbuttonpath = "//div[@id='answerchallengeform']//a[text()='CANCEL']";
	public static String answerincorrectlabelpath = "//*[@id='answerchallengeform']//div[text()='Answer is incorrect.']";
	public static String cancelbuttonACStep5path = "//button[contains(.,'Login')]//following-sibling::a[contains(text(),'CANCEL')]";
	public static String liteaccountnotActivatedLabelPath = "//*[@id='loginform']/form/div[3]/div/div";
	public static String newPasswordtextBoxPath = "//div[@class='col-md-6']//input[@name='password']";
	public static String retypenewPasswordtextBoxPath = "//div[@class='col-md-6']//input[@name='confirmPassword']";
	public static String resetPasswordButtonPath = "//p[@class='pad-top']//button[contains(.,'RESET PASSWORD')]";
	public static String cancelButtonPath = "//a[contains(.,'CANCEL') and @class='btn btn-default mleft-10 pad-lr-15 mbottom-10 btnSmall-xs ng-scope']";
	public static String securityAnswerErrorOccuredPath = "//input[@name='answer']//parent::p//following-sibling::div[3]//div//div[contains(.,'An error has occurred.  Please contact support.')]";

	public static String wrongpasswordErrorMessagePath = "//div[@id='loginform']//span[contains(.,'The username or password you entered did not match our records. Try again or click')]";
	public static String forgotpasswordErrorHyperLinkPath = "//div[@id='loginform']//div[@ng-message='combinationUnknown']//a[contains(.,'Forgot password?')]";
	public static String needHelpLoginErrorHyperLinkPath = "//div[@id='loginform']//div[@ng-message='combinationUnknown']//a[contains(.,'Need help logging in or account locked?')]";
	public static String accountLockedMessagePath = "//div[@id='loginform']//span[contains(.,'Your account has been locked from too many failed logins. Wait 4 hours before trying to log in again or click')]";
	public static String accountlockedNeedHelpHyperLinkPath = "//div[@id='loginform']//div[@ng-message='locked']//a[contains(.,'Need help logging in or account locked?')]";
	public static String needHelpModalTitlePath = "//span[contains(.,'Help Logging in or Account Locked')]";
	public static String modalClickResetPasswordHyperLinkPath = "//p//a[contains(.,'click here to reset password.')]";
	public static String modalClickUnlockAccountPath = "//p//a[contains(.,'click here to unlock your account.')]";
	public static String modalCloseIconPath = "//button[@class='close']";
	public static String showPasswordIconPath = "//i[@title='Show Password']";
	public static String hidePasswordIconPath = "//i[@title='Hide Password']";
	public static String capslockMessagePath = "//span[contains(.,'Caps Lock is On!')]";
	public static String forgotPasswordHyperLinkPath = "//a[contains(.,'Forgot password?')]";
	public static String needHelpLoginHyperLinkPath = "//a[contains(.,'Need help logging in or account locked?')]";

	@FindBy(xpath = "//input[@id='emailInput']")
	public static WebElement usernametext;

	@FindBy(xpath = "//input[@id='passwordInput']")
	public static WebElement passwordtext;

	@FindBy(xpath = "//button[contains(.,'Login')]")
	public static WebElement loginbutton;

	@FindBy(xpath = "//a[@class='btn btn-other bg-light-gray ng-scope' and text()='Create an Account']")
	public static WebElement createaccountbutton;

	@FindBy(xpath = "//p[@class='pad-top-8']//i[@class='ng-binding']")
	public static WebElement securityquestionlabel;

	@FindBy(xpath = "//input[@name='answer']")
	public static WebElement securitytext;

	@FindBy(xpath = "//label[@for='rememberMe']")
	public static WebElement remembermecheckbox;

	@FindBy(xpath = "//button[@type='submit' and text()='VERIFY']")
	public static WebElement verifybutton;

	@FindBy(xpath = "//div[@id='answerchallengeform']//a[text()='CANCEL']")
	public static WebElement securitycancelbutton;

	@FindBy(xpath = "//*[@id='answerchallengeform']//div[text()='Answer is incorrect.']")
	public static WebElement answerincorrectlabel;

	@FindBy(xpath = "//button[contains(.,'Login')]//following-sibling::a[contains(text(),'CANCEL')]")
	public static WebElement cancelbuttonACStep5;

	@FindBy(xpath = "//div[@class='col-md-6']//input[@name='password']")
	public static WebElement newPasswordtextBox;

	@FindBy(xpath = "//div[@class='col-md-6']//input[@name='confirmPassword']")
	public static WebElement retypenewPasswordtextBox;

	@FindBy(xpath = "//p[@class='pad-top']//button[contains(.,'RESET PASSWORD')]")
	public static WebElement resetPasswordButton;

	@FindBy(xpath = "//a[contains(.,'CANCEL') and @class='btn btn-default mleft-10 pad-lr-15 mbottom-10 btnSmall-xs ng-scope']")
	public static WebElement cancelButton;

	@FindBy(xpath = "//div[@id='loginform']//span[contains(.,'The username or password you entered did not match our records. Try again or click')]")
	public static WebElement wrongpasswordErrorMessage;

	@FindBy(xpath = "//div[@id='loginform']//div[@ng-message='combinationUnknown']//a[contains(.,'Forgot password?')]")
	public static WebElement forgotpasswordErrorHyperLink;

	@FindBy(xpath = "//div[@id='loginform']//div[@ng-message='combinationUnknown']//a[contains(.,'Need help logging in or account locked?')]")
	public static WebElement needHelpLoginErrorHyperLink;

	@FindBy(xpath = "//div[@id='loginform']//span[contains(.,'Your account has been locked from too many failed logins. Wait 4 hours before trying to log in again or click')]")
	public static WebElement accountLockedMessage;

	@FindBy(xpath = "//div[@id='loginform']//div[@ng-message='locked']//a[contains(.,'Need help logging in or account locked?')]")
	public static WebElement accountlockedNeedHelpHyperLink;

	@FindBy(xpath = "//span[contains(.,'Help Logging in or Account Locked')]")
	public static WebElement needHelpModalTitle;

	@FindBy(xpath = "//p//a[contains(.,'click here to reset password.')]")
	public static WebElement modalClickResetPasswordHyperLink;

	@FindBy(xpath = "//p//a[contains(.,'click here to unlock your account.')]")
	public static WebElement modalClickUnlockAccount;

	@FindBy(xpath = "//button[@class='close']")
	public static WebElement modalCloseIcon;

	@FindBy(xpath = "//i[@title='Show Password']")
	public static WebElement showPasswordIcon;

	@FindBy(xpath = "//i[@title='Hide Password']")
	public static WebElement hidePasswordIcon;

	@FindBy(xpath = "//span[contains(.,'Caps Lock is On!')]")
	public static WebElement capsLockMessage;

	@FindBy(xpath = "//a[contains(.,'Forgot password?')]")
	public static WebElement forgotPasswordHyperLink;

	@FindBy(xpath = "//a[contains(.,'Need help logging in or account locked?')]")
	public static WebElement needHelpLoginHyperLink;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean login(String username, String password) throws Exception {
		boolean result = true;
		ObjectHelper.driver.get(ObjectHelper.enviURL);
		Thread.sleep(5000);
		CommonFunctions.waitandClear(By.xpath(usernametextpath), 10);
		CommonFunctions.clearUsingJavaExecutor(passwordtext);
		usernametext.sendKeys(username);
		passwordtext.sendKeys(password);

		CommonFunctions.clickUsingJavaExecutor(loginbutton);
		/*
		 * if(CommonFunctions.waitForVisiblity(DashBoardPage.failedactivityokbutton,
		 * 10)) CommonFunctions.clickonmodalpopup(DashBoardPage.failedactivityokbutton);
		 */

		securityquestion(username, password);

		// popuphandler();

		if (DashBoardPage.popupimportappointmentscloseicon != null && DashBoardPage.popupimportappointmentscloseicon.size() > 0) {
			// CommonFunctions.clickUsingJavaExecutor(DashBoardPage.popupimportappointmentscloseicon.get(0));
			CommonFunctions.chainclicksonpopup(DashBoardPage.popupimportappointmentscloseicon.get(0));
		}

		return result;
	}

	public static boolean login(String username, String password, String url) throws Exception {
		boolean result = true;
		ObjectHelper.driver.navigate().to(url);

		CommonFunctions.waitandClear(By.xpath(usernametextpath), 40);
		passwordtext.clear();
		usernametext.sendKeys(username);
		passwordtext.sendKeys(password);

		CommonFunctions.clickUsingJavaExecutor(loginbutton);

		securityquestion(username, password);

		// popuphandler();

		// CommonFunctions.waitForVisiblity(DashBoardPage.popupimportappointmentscloseicon.get(0),
		// 30);
		if (DashBoardPage.popupimportappointmentscloseicon != null && DashBoardPage.popupimportappointmentscloseicon.size() > 0) {
			// CommonFunctions.clickUsingJavaExecutor(DashBoardPage.popupimportappointmentscloseicon.get(0));
			CommonFunctions.chainclicksonpopup(DashBoardPage.popupimportappointmentscloseicon.get(0));
		}

		return result;
	}

	public static boolean firsttimelogin(String username, String password, String url) throws Exception {
		boolean result = true;
		// navigate to verification url
		ObjectHelper.driver.navigate().to(url);

		ObjectHelper.driver.navigate().refresh();

		Thread.sleep(10000);
		CommonFunctions.waitandClear(By.xpath(usernametextpath), 40);
		passwordtext.clear();
		usernametext.sendKeys(username);
		passwordtext.sendKeys(password);

		CommonFunctions.clickUsingJavaExecutor(loginbutton);

		securityquestion(username, password);

		if (DashBoardPage.popupimportappointmentscloseicon != null && DashBoardPage.popupimportappointmentscloseicon.size() > 0) {
			// CommonFunctions.clickUsingJavaExecutor(DashBoardPage.popupimportappointmentscloseicon.get(0));
			CommonFunctions.chainclicksonpopup(DashBoardPage.popupimportappointmentscloseicon.get(0));
		}

		return result;
	}

	public static void securityquestion(String username, String password) {
		try {
			if (CommonFunctions.waitForVisiblity(By.xpath(verifybuttonpath), 30)) {
				String securityquestion = securityquestionlabel.getText();
				Thread.sleep(2000);
				if (securityquestion.toLowerCase().contains("what was the color of your first car?")) {
					securitytext.sendKeys("Silver");
				} else if (securityquestion.toLowerCase().contains("on which wrist do you wear your watch?")) {
					securitytext.sendKeys("Left");
				} else if (securityquestion.toLowerCase().contains("what is the color of your eyes?")) {
					securitytext.sendKeys("Black");
				} else if (securityquestion.toLowerCase().contains("question a")) {
					securitytext.sendKeys("Aldergrove");
				} else if (securityquestion.toLowerCase().contains("question b")) {
					securitytext.sendKeys("burnaby");
				} else if (securityquestion.toLowerCase().contains("question c")) {
					securitytext.sendKeys("cloverdale");
				}

				CommonFunctions.clickUsingJavaExecutor(remembermecheckbox);
				verifybutton.click();
				Thread.sleep(3000);
				if (CommonFunctions.waitForVisiblity(verifybutton, 5)) {
					CommonFunctions.clickUsingJavaExecutor(verifybutton);
				}
			}
			Thread.sleep(1000);

			/*
			 * if (!CommonFunctions.waitForVisiblity(MenuPage.dashboardmenu, 30)) {
			 * verifybuttonCommonFunctions.clickUsingJavaExecutor();
			 * securitycancelbuttonCommonFunctions.clickUsingJavaExecutor();
			 * 
			 * CommonFunctions.waitForVisiblity(usernametext, 10);
			 * 
			 * usernametext.sendKeys(username); passwordtext.sendKeys(password);
			 * 
			 * loginbuttonCommonFunctions.clickUsingJavaExecutor();
			 * 
			 * } else
			 */ if (CommonFunctions.waitForVisiblity(CreateAccountPage.step5NoRegisterAnothertimeRadioButton, 15)) {
				// CommonFunctions.waitForVisiblity(CreateAccountPage.step5NoRegisterAnothertimeRadioButton,
				// 10);
				CommonFunctions.clickUsingJavaExecutor(CreateAccountPage.step5NoRegisterAnothertimeRadioButton);
				CommonFunctions.clickUsingJavaExecutor(CreateAccountPage.step5NextButton);
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public static boolean securityquestionForForgotPassword(String newpassword) {
		try {
			if (CommonFunctions.waitForVisiblity(By.xpath(verifybuttonpath), 30)) {
				String securityquestion = securityquestionlabel.getText();
				Thread.sleep(2000);
				if (securityquestion.toLowerCase().contains("what was the color of your first car?")) {
					securitytext.sendKeys("Silver");
				} else if (securityquestion.toLowerCase().contains("on which wrist do you wear your watch?")) {
					securitytext.sendKeys("Left");
				} else if (securityquestion.toLowerCase().contains("what is the color of your eyes?")) {
					securitytext.sendKeys("Black");
				}
				CommonFunctions.clickUsingJavaExecutor(verifybutton);
				CommonFunctions.clickUsingJavaExecutor(verifybutton);

				if (CommonFunctions.waitForVisiblity(newPasswordtextBox, 10)) {
					newPasswordtextBox.clear();
					retypenewPasswordtextBox.clear();

					newPasswordtextBox.sendKeys(newpassword);
					retypenewPasswordtextBox.sendKeys(newpassword);

					CommonFunctions.clickUsingJavaExecutor(resetPasswordButton);

					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

	public static void popuphandler() throws Exception {
		ObjectHelper.driver.switchTo().activeElement();
		if (CommonFunctions.waitForVisiblity(MenuPage.failedtoloadhistorypopup, 2)) {
			CommonFunctions.clickUsingJavaExecutor(MenuPage.okbuttonopopup);
		}

		// Closing the Modal Dialog
		ObjectHelper.driver.switchTo().activeElement();
		if (CommonFunctions.waitForVisiblity(DashBoardPage.failedactivityokbutton, 2)) {
			CommonFunctions.clickUsingJavaExecutor(DashBoardPage.failedactivityokbutton);
		}

		ObjectHelper.driver.switchTo().activeElement();
	}

}
