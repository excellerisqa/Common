package upp1.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class ChangeConsentPage {
	WebDriver driver;

	public static String changeconsenttitlepath = "//h3[contains(.,'Change Consent to be Contacted')]";
	public static String yesradiopath = "//div[@id='changeconsent']/form/div/div/div[1]/div[2]/label[1]/div/span";
	public static String noradiopath = "//div[@id='changeconsent']/form/div/div/div[1]/div[2]/label[2]/div/span";

	public static String savebuttonpath = "//div[@id='changeconsent']//button[text()='SAVE']";
	public static String cancelbuttonpath = "//div[@id='changeconsent']//A[text()='CANCEL']";

	public static String consentpopupokbuttonpath = "//button[text()='OK']";
	public static String successconsentmessagepath = "//p[contains(.,'Your consent choice has been updated successfully.')]";

	@FindBy(xpath = "//h3[contains(.,'Change Consent to be Contacted')]")
	public static WebElement changeconsenttitle;

	@FindBy(xpath = "//input[@class='ng-valid ng-touched ng-dirty ng-valid-parse ng-empty']")
	public static WebElement yesradio1;

	@FindBy(xpath = "//input[@class='ng-valid ng-empty ng-dirty ng-valid-parse ng-touched']")
	public static WebElement yesradio2;

	@FindBy(xpath = "//input[@class='ng-valid ng-touched ng-dirty ng-valid-parse ng-not-empty']")
	public static WebElement noradio1;

	@FindBy(xpath = "//input[@class='ng-valid ng-dirty ng-valid-parse ng-touched ng-not-empty']")
	public static WebElement noradio2;

	@FindBy(xpath = "//div[@id='changeconsent']//button[text()='SAVE']")
	public static WebElement savebutton;

	@FindBy(xpath = "//div[@id='changeconsent']//a[contains(text(),'CANCEL')]")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement consentpopupokbutton;

	public ChangeConsentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void yesandsave() throws Exception {
		Thread.sleep(2000);

		if (CommonFunctions.waitForVisiblity(yesradio1, 5)) {
			CommonFunctions.clickUsingJavaExecutor(yesradio1);
		}
		if (CommonFunctions.waitForVisiblity(yesradio2, 5)) {
			CommonFunctions.clickUsingJavaExecutor(yesradio2);
		}

		CommonFunctions.clickUsingJavaExecutor(savebutton);

		CommonFunctions.clickonmodalpopup(consentpopupokbuttonpath, successconsentmessagepath);
	}

	public static void noandsave() throws Exception {
		Thread.sleep(2000);

		if (CommonFunctions.waitForVisiblity(noradio1, 5)) {
			CommonFunctions.clickUsingJavaExecutor(noradio1);
		}
		if (CommonFunctions.waitForVisiblity(noradio2, 5)) {
			CommonFunctions.clickUsingJavaExecutor(noradio2);
		}

		CommonFunctions.clickUsingJavaExecutor(savebutton);

		CommonFunctions.clickonmodalpopup(consentpopupokbuttonpath, successconsentmessagepath);
	}
}
