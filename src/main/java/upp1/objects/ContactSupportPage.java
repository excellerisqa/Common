package upp1.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ObjectHelper;

public class ContactSupportPage {
	WebDriver driver;

	public static String fullnametextpath = "//input[@name='fullName']";
	public static String emailtextpath = "//input[@name='email' and @type='email']";
	public static String subjectcomboboxpath = "//select[@ng-model='supportFormData.subject']";
	public static String messagetextareapath = "//textarea[@name='message']";
	public static String iframerecaptchpath = "//iframe[@src='https://www.google.com/recaptcha/api2/anchor?k=6Lc2Fj0UAAAAABR-OjGS1avWhgTjjZaR2mlkPYUN&co=aHR0cDovLzEwLjEuMS4xMzk6NDQzMTk.&hl=en&v=v1522045847408&size=normal&cb=bhlqkx5pj4us']";
	public static String recaptchpath = "//label[@class='rc-anchor-center-item rc-anchor-checkbox-label']";
	public static String submitbuttonpath = "//button[@class='btn btn-primary btnPHover ng-scope' and @type='submit']";
	public static String contactsupporttitlepath = "//h1[text()='Contact Support']";
	public static String fullnameerrormessagepath = "//div[@ng-messages='supportForm.fullName.$error']//div[text()='This is a required field']";
	public static String emailerrormessagepath = "//div[@ng-messages='supportForm.email.$error']//div[text()='This is a required field']";
	public static String messageerrormessagepath = "//div[@ng-messages='supportForm.message.$error']//div[text()='This is a required field']";
	public static String iamnotroboterrormessagepath = "//span[@class='rc-anchor-error-msg']";
	public static String invalidemaileerrormessagepath = "//div[@ng-messages='supportForm.email.$error']//div[text()='Invalid email address']";
	public static String emailsentsuccessmessagepath = "//p[contains(.,'You will receive an e-mail from us shortly.')]";

	public static String popupverifyrecaptchamessagepath = "//p[text()='Please verify your presence by following the reCAPTCHA instructions.']";
	public static String popupcaptchaokbuttonpath = "//button[text()='OK']";

	@FindBy(xpath = "//h1[text()='Contact Support']")
	public static WebElement contactsupporttitle;

	@FindBy(xpath = "//input[@name='fullName']")
	public static WebElement fullnametext;

	@FindBy(xpath = "//input[@name='email' and @type='email']")
	public static WebElement emailtext;

	@FindBy(xpath = "//textarea[@name='message']")
	public static WebElement messagetextarea;

	@FindBy(xpath = "//label[@class='rc-anchor-center-item rc-anchor-checkbox-label']")
	public static WebElement recaptchcheckbox;

	@FindBy(xpath = "//button[@class='btn btn-primary btnPHover ng-scope' and @type='submit']")
	public static WebElement submitbutton;

	@FindBy(xpath = "//p[text()='Please verify your presence by following the reCAPTCHA instructions.']")
	public static WebElement popupverifyrecaptchamessage;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement popupcaptchaokbutton;

	@FindBy(xpath = "//select[@ng-model='supportFormData.subject']")
	public static WebElement subjectcombobox;

	@FindBy(xpath = "//div[@ng-messages='supportForm.email.$error']//div[text()='This is a required field']")
	public static WebElement emailerrormessage;

	@FindBy(xpath = "//p[contains(.,'You will receive an e-mail from us shortly.')]")
	public static WebElement emailsentsuccessmessage;

	@FindBy(xpath = "//div[@ng-messages='supportForm.message.$error']//div[text()='This is a required field']")
	public static WebElement messageerrormessage;

	public ContactSupportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean contactsupport(String fullname, String email, String message) throws Exception {
		boolean result = false;
		Thread.sleep(3000);
		fullnametext.sendKeys(fullname);
		emailtext.sendKeys(email);
		WebElement subjectelem = ObjectHelper.driver.findElement(By.xpath(subjectcomboboxpath));
		Select select = new Select(subjectelem);
		select.selectByVisibleText("Forgot Password");
		messagetextarea.sendKeys(message);
		// recaptchcheckboxCommonFunctions.clickUsingJavaExecutor();
		// submitbuttonCommonFunctions.clickUsingJavaExecutor();

		result = true;

		return result;
	}
}
