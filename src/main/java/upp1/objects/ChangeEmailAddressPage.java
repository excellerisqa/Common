package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class ChangeEmailAddressPage {
	WebDriver driver;

	public static String emailtextpath = "//input[@type='email' and @ng-model='accountSettingsData.newEmail']";
	public static String retypeemailtextpath = "//input[@name='confirmemail']";
	public static String savebuttonpath = "//div[@id='changeemail']//button[text()='SAVE']";
	public static String cancelbuttonpath = "//div[@id='changeemail']//a[text()='CANCEL']";
	public static String emailsuccessmessagepath = "//p[contains(.,'Your email address has been changed successfully.')]";
	public static String okbuttonpath = "//button[text()='OK']";
	public static String failedtoloadpopupokpath = "//button[@class='btn btn-primary btnPHover ng-scope' and text()='OK']";
	public static String failedtoloadmessagepopuppath = "//p[text()='Failed to load account information. Your session is timed out. Please login again.']";
	public static String visibleValidationErrorPath = "//div[@id='changeemail']//div[@class='ng-active']";
	// "//div[@id='changeemail']//div[@class='validation-error-messages ng-scope']";

	@FindBy(xpath = "//input[@name='email' and @ng-model='accountSettingsData.newEmail']")
	public static WebElement emailtext;

	@FindBy(xpath = "//input[@name='confirmemail']")
	public static WebElement retypeemailtext;

	@FindBy(xpath = "//div[@id='changeemail']//button[contains(text(),'Next')]")
	public static WebElement savebutton;

	@FindBy(xpath = "//div[@id='changeemail']//a[contains(text(),'Cancel')]")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//p[text()='Your email address has been changed successfully.']")
	public static WebElement emailsuccessmessage;

	@FindBy(xpath = "//button[contains(.,'OK')]")
	public static WebElement okbutton;

	@FindBy(xpath = "//button[@class='btn btn-primary btnPHover ng-scope' and text()='OK']")
	public static WebElement failedokbutton;

	@FindBy(xpath = "//p[text()='Failed to load account information. Your session is timed out. Please login again.']")
	public static WebElement failedtoloadmessagepopup;

	public static void ChangeEmailAddress(String email) throws Exception {

		emailtext.sendKeys(email);
		retypeemailtext.sendKeys(email);
		CommonFunctions.clickUsingJavaExecutor(savebutton);
		// cancelbuttonCommonFunctions.clickUsingJavaExecutor();

	}

	public ChangeEmailAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
