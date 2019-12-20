package upp1.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class AccountSettingsPage {

	WebDriver driver;

	public static String changeemailaddresspath = "//a[text()='Change Email Address ']";
	public static String changepasswordandsingninsecuritypath = "//a[text()='Change Password & Sign-in Security']";
	public static String changesecurityquestionspath = "//a[text()='Change Security Questions']";
	public static String changesecurityphrasepath = "//a[text()='Change Security Phrase ']";
	public static String personalinformationpath = "//a[text()='Personal Information ']";
	public static String changeconsentpath = "//a[text()='Change Consent to be Contacted ']";
	public static String addorremoveaccountregistrationpath = "//a[@ng-click='loadAccountUserList()']";
	public static String accountsettingstitlepath = "//h3[contains(.,'Account Settings ')]";
	public static String deviceactivitysecurityinfopath = "//a[starts-with(text(),'Device Activity & Security Notifications ')]";

	public static String sharedreportspath = "//a[@data-target='#collapse9']";
	public static String reportsyouhavesharedpath = "//h4[text()='Reports You Have Shared ']";
	public static String reportsotherpeoplehavesharedpath = "//h4[text()='Reports Other People Have Shared  ']";
	public static String linkedwebsitedandapplicationspath = "//h4[text()='Linked Websites & Applications ']";

	@FindBy(xpath = "//h3[contains(.,'Account Settings ')]")
	public static WebElement accountsettingstitle;

	@FindBy(xpath = "//a[text()='Change Email Address ']")
	public static WebElement changeemailaddress;

	@FindBy(xpath = "//a[text()='Change Password & Sign-in Security']")
	public static WebElement changepasswordandsingninsecurity;

	@FindBy(xpath = "//a[text()='Change Security Questions']")
	public static WebElement changesecurityquestions;

	@FindBy(xpath = "//a[text()='Change Security Phrase ']")
	public static WebElement changesecurityphrase;

	@FindBy(xpath = "//a[text()='Personal Information ']")
	public static WebElement personalinformation;

	@FindBy(xpath = "//a[text()='Change Consent to be Contacted ']")
	public static WebElement changeconsent;

	@FindBy(xpath = "//a[contains(text(),'Re-enable Login Security')]")
	public static WebElement removeCookieLink;

	@FindBy(xpath = "//a[@ng-click='loadAccountUserList()']")
	public static WebElement addorremoveaccountregistration;

	@FindBy(xpath = "//a[starts-with(text(),'Device Activity & Security Notifications ')]")
	public static WebElement deviceactivitysecurityinfo;

	@FindBy(xpath = "//a[@data-target='#collapse9']")
	public static WebElement sharedreports;

	@FindBy(xpath = "//h4[text()='Reports You Have Shared ']")
	public static WebElement reportsyouhaveshared;

	@FindBy(xpath = "//h4[text()='Reports Other People Have Shared  ']")
	public static WebElement reportsotherpeoplehaveshared;

	@FindBy(xpath = "//h4[text()='Linked Websites & Applications ']")
	public static WebElement linkedwebsitedandapplications;

	@FindBy(xpath = "//button[@class='btn btn-primary btnPHover ng-scope' and text()='OK']")
	public static WebElement discardChangesOKButton;

	@FindBy(xpath = "//a[contains(.,'Re-enable Login Security Question')]")
	public static WebElement reenableLoginSecurityQuestion;

	public AccountSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void navigateaccountsettingsfromlogin(String username, String password) throws Exception {

		// click on OK button of email success message pop up
		// BaseClass.ceap.okbuttonCommonFunctions.clickUsingJavaExecutor();
		// checking the failed message is displayed or not
		if (CommonFunctions.waitForVisiblity(ChangeEmailAddressPage.failedtoloadmessagepopup, 30)) {
			CommonFunctions.clickUsingJavaExecutor(ChangeEmailAddressPage.failedokbutton);
		}
		Thread.sleep(2000);
		ObjectHelper.driver.navigate().to(ObjectHelper.enviURL);
		// login to UPP with new email id
		LoginPage.login(username, password);

		// if (CommonFunctions.waitForVisiblity(MenuPage.failedtoloadhistorypopup,
		// 30)) {
		// MenuPage.okbuttonopopupCommonFunctions.clickUsingJavaExecutor();
		// }
		//
		// CommonFunctions.waitForVisiblity(By.xpath(MenuPage.dashboardmenupath),
		// 30);
		// Thread.sleep(2000);

		// Navigate to My Account > Account Settings > Add or Remove Account
		// Registrations
		CommonFunctions.clickUsingJavaExecutor(MenuPage.myaccountlink);

		CommonFunctions.clickUsingJavaExecutor(MenuPage.accountsettingslink);

		Thread.sleep(2000);
		// Checking account Settings page is Visible or not
		CommonFunctions.waitForVisiblity(By.xpath(AccountSettingsPage.accountsettingstitlepath), 10);

	}

	public static void navigatemyaccounttoaccountsettings() throws Exception {

		// Navigate to My Account > Account Settings > Add or Remove Account
		// Registrations
		CommonFunctions.clickUsingJavaExecutor(MenuPage.myaccountlink);

		CommonFunctions.clickUsingJavaExecutor(MenuPage.accountsettingslink);

		Thread.sleep(1000);

		CommonFunctions.clickUsingJavaExecutor(AccountSettingsPage.sharedreports);

	}

	public static void gotoDashboardThenAccountSettingsPage() {
		// -----------this can be removed after the bug is fixed
		ObjectHelper.driver.navigate().refresh();
		CommonFunctions.clickUsingJavaExecutor(MenuPage.dashboardmenu);
		if (CommonFunctions.waitForVisiblity(discardChangesOKButton, 30)) {
			CommonFunctions.clickUsingJavaExecutor(discardChangesOKButton);
		}
		CommonFunctions.waitForVisiblity(DashBoardPage.viewmyreportdata, 40);
		/*
		 * if (CommonFunctions.waitForVisiblity(DashBoardPage.
		 * popupimportappointmentscloseicon.get(0), 20)) {
		 * CommonFunctions.clickUsingJavaExecutor(DashBoardPage.
		 * popupimportappointmentscloseicon.get(0)); }
		 */
		// ----------------------
		CommonFunctions.clickUsingJavaExecutor(MenuPage.myaccountlink);
		CommonFunctions.clickUsingJavaExecutor(MenuPage.accountsettingslink);
		CommonFunctions.waitForVisiblity(AccountSettingsPage.changeemailaddress, 40);

	}

	public static void gotoAccountSettingsPage() {
		CommonFunctions.clickUsingJavaExecutor(MenuPage.myaccountlink);
		CommonFunctions.clickUsingJavaExecutor(MenuPage.accountsettingslink);
		CommonFunctions.waitForVisiblity(AccountSettingsPage.changeemailaddress, 40);

	}

}
