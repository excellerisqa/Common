package lifelabs.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class LLLoginPage {
	WebDriver driver;

	public LLLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String registernowlinkpath = "//a[text()='Register Now']";

	@FindBy(xpath = "//a[text()='Register Now']")
	public static WebElement registernowlink;
	
	@FindBy(id = "ctl00_MainContent_LoginView1_Login1_UserName")
	public static WebElement emailField;
	
	@FindBy(id = "ctl00_MainContent_LoginView1_Login1_Password")
	public static WebElement passwordField;
	
	@FindBy(id = "ctl00_MainContent_LoginView1_Login1_LoginButton")
	public static WebElement signInBtn;
	
	public static boolean login(String uName, String pwd) {
		boolean stat = true;
		try {
			CommonFunctions.waitForVisiblity(emailField, 10);
			emailField.clear();
			emailField.sendKeys(uName);
			passwordField.clear();
			passwordField.sendKeys(pwd);
			signInBtn.click();
			if (!CommonFunctions.waitForVisiblity(LLRegistrationPage.accountsuccessLabel, 10))
				stat = false;
		} catch (Exception e) {
			e.printStackTrace();
			stat = false;
		}

		return stat;
	}
}
