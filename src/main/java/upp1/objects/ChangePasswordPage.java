package upp1.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class ChangePasswordPage {
	WebDriver driver;

	public static String currentpasswordtextpath = "//input[@name='currentPassword']";
	public static String newpasswordtextpath = "//p//input[@name='password']";
	public static String retypepasswordtextpath = "//input[@name='confirmPassword']";
	public static String savebuttonpath = "//div[@id=\"changepassword\"]/form/div/div/p[8]/button";
	public static String cancelbuttonpath = "//div[@id='changepassword']//a[@class='btn btn-default mleft-10 pad-lr-15 mbottom-10 btnSmall-xs ng-scope' and text()='CANCEL']";

	public static String discarddialogokbuttonpath = "//button[@class='btn btn-primary btnPHover ng-scope' and text()='OK']";

	public static String passwordsuccessmessagepath = "//p[contains(.,'successfully')]";
	public static String okbuttonpath = "//button[text()='OK']";
	public static String visibleValidationErrorPath = "//div[@id='changepassword']//div[@class='ng-active']";
	public static String popupemailusedErroMessagePath = "//p[contains(.,'New password has already been used previously.')]";
	public static String popupemailusedCloseIconPath = "//button//i[@class='icon icon-exc-close']";

	@FindBy(xpath = "//input[@name='currentPassword']")
	public static WebElement currentpasswordtext;

	@FindBy(xpath = "//p//input[@name='password']")
	public static WebElement newpasswordtext;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	public static WebElement retypepasswordtext;

	@FindBy(xpath = "//div[@id='changepassword']/form/div/div/p[8]/button")
	public static WebElement savebutton;

	@FindBy(xpath = "//div[@id='changepassword']//a[contains(text(),'CANCEL')]")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//button[@class='btn btn-primary btnPHover ng-scope' and text()='Discard Changes']")
	public static WebElement discarddialogokbutton;

	@FindBy(xpath = "//button[@translate='LINK_CANCEL' and text()='CANCEL']")
	public static WebElement popuUpCancelbutton;

	@FindBy(xpath = "//p[contains(.,'New password has already been used previously.')]")
	public static WebElement popupemailusedErroMessage;

	@FindBy(xpath = "//button//i[@class='icon icon-exc-close']")
	public static WebElement popupemailusedCloseIcon;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void ChangePassword(String currentpassword, String newpassword) throws Exception {

		currentpasswordtext.clear();
		newpasswordtext.clear();
		retypepasswordtext.clear();

		currentpasswordtext.sendKeys(currentpassword);
		newpasswordtext.sendKeys(newpassword);
		retypepasswordtext.sendKeys(newpassword);
		CommonFunctions.clickUsingJavaExecutor(savebutton);
		// cancelbuttonCommonFunctions.clickUsingJavaExecutor();
	}

	public void diacarddialog() throws Exception {
		ObjectHelper.driver.switchTo().activeElement();

		CommonFunctions.waitandClick(By.xpath(discarddialogokbuttonpath), 30);

		ObjectHelper.driver.switchTo().activeElement();
	}

}
