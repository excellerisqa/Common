package ccofit.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class LoginPage {

	WebDriver driver;

	public static String welcomeImg = "//img[@alt='LifeLabs FIT System']";
	@FindBy(xpath = "//img[@alt='LifeLabs FIT System']")
	public static WebElement welcomeImage;

	public static String logInBtn = "//a[@href='/Account/SignIn']";
	@FindBy(xpath = "//a[@href='/Account/SignIn']")
	public static WebElement logIn;

	public static String logOutBtn = "//a[@href='/Account/SignOut']";
	@FindBy(xpath = "//a[@href='/Account/SignOut']")
	public static WebElement logOut;

	public static String dataEntryLogin = "//div[contains(text(),'Anubhav@lifelabsccofit.onmicrosoft.com')]";
	@FindBy(xpath = "//div[contains(text(),'Anubhav@lifelabsccofit.onmicrosoft.com')]")
	public static WebElement dElogIn;

	public static String dataEntryLogOut = "//small[contains(text(),'Anubhav@lifelabsccofit.onmicrosoft.com')]";
	@FindBy(xpath = "//small[contains(text(),'Anubhav@lifelabsccofit.onmicrosoft.com')]")
	public static WebElement dElogOut;

	public static String probAnalystLogin = "//div[contains(text(),'AnubhavPA@lifelabsccofit.onmicrosoft.com')]";
	@FindBy(xpath = "//div[contains(text(),'AnubhavPA@lifelabsccofit.onmicrosoft.com')]")
	public static WebElement pAlogIn;

	public static String problemAnalystLogOut = "//small[contains(text(),'AnubhavPA@lifelabsccofit.onmicrosoft.com')]";
	@FindBy(xpath = "//small[contains(text(),'AnubhavPA@lifelabsccofit.onmicrosoft.com')]")
	public static WebElement pAlogOut;

	public static String admLogin = "//div[contains(text(),'AnubhavAdmin@lifelabsccofit.onmicrosoft.com')]";
	@FindBy(xpath = "//div[contains(text(),'AnubhavAdmin@lifelabsccofit.onmicrosoft.com')]")
	public static WebElement adminlogIn;

	public static String administratorLogOut = "//small[contains(text(),'AnubhavAdmin@lifelabsccofit.onmicrosoft.com')]";
	@FindBy(xpath = "//small[contains(text(),'AnubhavAdmin@lifelabsccofit.onmicrosoft.com')]")
	public static WebElement adminlogOut;

	public static String useAnotherAccount = "otherTileText";
	@FindBy(id = "otherTileText")
	public static WebElement useNewAccount;

	public static String emailTxtBox = "i0116";
	@FindBy(id = "i0116")
	public static WebElement email;

	public static String passwordTxtBox = "i0118";
	@FindBy(id = "i0118")
	public static WebElement password;

	public static String signInBtn = "idSIButton9";
	@FindBy(id = "idSIButton9")
	public static WebElement signIn;

	public static String errorMsgLogin = "//div[@id='passwordError']";
	@FindBy(xpath = "//div[@id='passwordError']")
	public static WebElement errMsgLogin;

	public static String userInfo = "//div[@class='navUserInfo']//div";
	@FindBy(xpath = "//div[@class='navUserInfo']//div")
	public static WebElement userInformation;

	public static String helpLink = "//a[@href='mailto:ITServicedesk@lifelabs.com']";
	@FindBy(xpath = "//a[@href='mailto:ITServicedesk@lifelabs.com']")
	public static WebElement llHelpLink;

	public static String helpinfo = "//p[contains(text(),'LifeLabs IT Help desk number: 1-800-465-6001')]";
	@FindBy(xpath = "//p[contains(text(),'LifeLabs IT Help desk number: 1-800-465-6001')]")
	public static WebElement llHelpInfo;

	public static boolean verifyMainPageNavigation() {
		boolean navSuccess = false;
		CommonFunctions.waitForVisiblity(welcomeImage, 30);
		if (welcomeImage.isDisplayed() == true) {
			navSuccess = true;
		}
		return navSuccess;
	}

	public static void dataEntrylogin(String emailID, String pswd) {
		CommonFunctions.waitForVisiblity(logIn, 25);
		logIn.click();
		CommonFunctions.waitForVisiblity(email, 15);
		email.sendKeys(emailID);
		signIn.click();
		CommonFunctions.waitForVisiblity(password, 15);
		password.sendKeys(pswd);
		signIn.click();
	}

	public static void loginWithNewAcc(String emailID, String pswd) {
		CommonFunctions.waitForVisiblity(logIn, 25);
		logIn.click();
		CommonFunctions.waitForVisiblity(useNewAccount, 25);
		useNewAccount.click();
		CommonFunctions.waitForVisiblity(email, 15);
		email.clear();
		email.sendKeys(emailID);
		signIn.click();
		CommonFunctions.waitForVisiblity(password, 15);
		password.clear();
		password.sendKeys(pswd);
		signIn.click();
	}

	public static void dElogin2ndTime(String pswd) {
		CommonFunctions.waitForVisiblity(logIn, 25);
		logIn.click();
		CommonFunctions.waitForVisiblity(dElogIn, 15);
		if (dElogIn.isDisplayed() == true) {
			System.out.println("Data Entry login is auto populated");
		}
		dElogIn.click();
		CommonFunctions.waitForVisiblity(password, 15);
		password.sendKeys(pswd);
		signIn.click();
	}

	public static void pAlogin2ndTime(String pswd) {
		CommonFunctions.waitForVisiblity(logIn, 25);
		logIn.click();
		CommonFunctions.waitForVisiblity(pAlogIn, 15);
		if (pAlogIn.isDisplayed() == true) {
			System.out.println("Problem Analyst login is auto populated");
		}
		pAlogIn.click();
		CommonFunctions.waitForVisiblity(password, 15);
		password.sendKeys(pswd);
		signIn.click();
	}

	public static void adminlogin2ndTime(String pswd) {
		CommonFunctions.waitForVisiblity(logIn, 25);
		logIn.click();
		CommonFunctions.waitForVisiblity(adminlogIn, 15);
		if (adminlogIn.isDisplayed() == true) {
			System.out.println("Admin login is auto populated");
		}
		adminlogIn.click();
		CommonFunctions.waitForVisiblity(password, 15);
		password.sendKeys(pswd);
		signIn.click();
	}

	public static boolean verifyLoginError() {
		boolean msgVerified = false;
		if (errMsgLogin.getText().contains("Your account or password is incorrect. If you don't remember your password")) {
			msgVerified = true;
		}
		return msgVerified;
	}

	public static void enterPassword(String pswd) {
		CommonFunctions.waitForVisiblity(password, 15);
		password.sendKeys(pswd);
		signIn.click();
	}

	public static boolean verifySuccessfulLogin(String username) {
		boolean successfulLogin = false;
		CommonFunctions.waitForVisiblity(userInformation, 25);
		if (userInformation.getText().contains(username)) {
			successfulLogin = true;
		}
		return successfulLogin;
	}

	public static void logOut(String roleType) {
		CommonFunctions.waitForVisiblity(logOut, 25);
		logOut.click();
		roleType = roleType.toLowerCase();
		switch (roleType) {
		case "de":
			CommonFunctions.waitForVisiblity(dElogOut, 25);
			dElogOut.click();
			break;
		case "pa":
			CommonFunctions.waitForVisiblity(pAlogOut, 25);
			pAlogOut.click();
			break;
		case "admin":
			CommonFunctions.waitForVisiblity(adminlogOut, 25);
			adminlogOut.click();
			break;
		}

	}

	public static boolean verifySuccessfulLogout() {
		boolean successfulLogOut = false;
		if (verifyMainPageNavigation() == true) {
			successfulLogOut = true;
		}
		return successfulLogOut;
	}

	public static boolean verifyHelpSection() {
		boolean helpSecDisplayed = false;
		if (llHelpInfo.isDisplayed() == true && llHelpLink.isDisplayed() == true) {
			helpSecDisplayed = true;
		}
		return helpSecDisplayed;
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
