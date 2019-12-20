package lifelabs.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class LLRegistrationPage {

	WebDriver driver;

	public LLRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String agreebuttonpath = "//input[@type='submit']";
	public static String firstnametextboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$txtFirstName']";
	public static String lastnametextboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$txtLastName']";
	public static String provinceComboboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$ComboProvince']";
	public static String provinceComboListPath = "//div[@id='ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_ComboProvince_DropDown']/div/ul//li"; // list
	public static String phonenumbertextboxpath = "//input[@id='ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_txtPhoneHome']";
	public static String emailaddresstextboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$UserName']";
	public static String confirmemailtextboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$ConfirmEmail']";
	public static String passwordtextboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$Password']";
	public static String confirmpasswordtextboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$ConfirmPassword']";
	public static String emailconfirmationcheckboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$chkEmailConfirmations']";
	public static String securityquestionComboboxpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$Question']";
	public static String securityquestionComboboxListPath = "//div[@id='ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_Question_DropDown']/div/ul//li";
	public static String securityanswertextboxpath = "//input[@id='ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_Answer'] ";
	public static String registerbuttonpath = "//input[@value='REGISTER']";
	public static String accountsuccessLabelPath = "//h3[contains(.,'Confirmed Appointments')]";
	public static String emailexistsLabelPath = "//span[text()='This e-mail address is already in use.']";

	@FindBy(xpath = "//input[@type='submit']")
	public static WebElement agreebutton;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$txtFirstName']")
	public static WebElement firstnametextbox;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$txtLastName']")
	public static WebElement lastnametextbox;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$ComboProvince']")
	public static WebElement provinceCombobox;

	@FindBy(xpath = "//div[@id='ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_ComboProvince_DropDown']/div/ul//li")
	public static List<WebElement> provinceComboList;

	@FindBy(xpath = "//input[@id='ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_txtPhoneHome']")
	public static WebElement phonenumbertextbox;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$UserName']")
	public static WebElement emailaddresstextbox;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$ConfirmEmail']")
	public static WebElement confirmemailtextbox;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$Password']")
	public static WebElement passwordtextbox;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$ConfirmPassword']")
	public static WebElement confirmpasswordtextbox;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$chkEmailConfirmations']")
	public static WebElement emailconfirmationcheckbox;

	@FindBy(xpath = "//input[@name='ctl00$MainContent$CreateUserWizard1$CreateUserStepContainer$Question']")
	public static WebElement securityquestionCombobox;

	@FindBy(xpath = "//div[@id='ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_Question_DropDown']/div/ul//li")
	public static List<WebElement> securityquestionComboboxList;

	@FindBy(xpath = "//input[@id='ctl00_MainContent_CreateUserWizard1_CreateUserStepContainer_Answer'] ")
	public static WebElement securityanswertextbox;

	@FindBy(xpath = "//input[@value='REGISTER']")
	public static WebElement registerbutton;

	@FindBy(xpath = "//h3[contains(.,'Confirmed Appointments')]")
	public static WebElement accountsuccessLabel;

	@FindBy(xpath = "//span[text()='This e-mail address is already in use.']")
	public static WebElement emailexistsLabel;

	public static boolean registrationform(String firstname, String lastname, String province, String phonenumber, String email, String confirmemail, String password, String confirmpassword,
			String securityquestion, String securityanswer) throws Exception {
		boolean result = false;
		try {
			agreebutton.click();

			Thread.sleep(3000);

			firstnametextbox.clear();
			lastnametextbox.clear();
			phonenumbertextbox.clear();
			emailaddresstextbox.clear();
			confirmemailtextbox.clear();
			passwordtextbox.clear();
			confirmemailtextbox.clear();
			securityanswertextbox.clear();
			Thread.sleep(1000);
			firstnametextbox.sendKeys(firstname);
			lastnametextbox.sendKeys(lastname);
			CommonFunctions.sendKeysUsingJavaExecutor(phonenumbertextbox, phonenumber);
			emailaddresstextbox.sendKeys(email);
			confirmemailtextbox.sendKeys(confirmemail);
			passwordtextbox.sendKeys(password);
			confirmpasswordtextbox.sendKeys(confirmpassword);
			securityanswertextbox.sendKeys(securityanswer);

			provinceCombobox.click();
			// select province
			loop: for (int i = 0; i < provinceComboList.size(); i++) {
				if (provinceComboList.get(i).getText().contains(province)) {
					provinceComboList.get(i).click();
					break loop;
				}
			}

			securityquestionCombobox.click();
			// select security question
			loop: for (int i = 0; i < securityquestionComboboxList.size(); i++) {
				if (securityquestionComboboxList.get(i).getText().contains(securityquestion)) {
					securityquestionComboboxList.get(i).click();
					Thread.sleep(2000);
					break loop;
				}
			}

			Thread.sleep(3000);
			registerbutton.click();

			Thread.sleep(3000);
			if (CommonFunctions.waitForVisiblity(accountsuccessLabel, 5) || CommonFunctions.waitForVisiblity(emailexistsLabel, 3)) {
				result = true;
			} else {
				result = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}

}
