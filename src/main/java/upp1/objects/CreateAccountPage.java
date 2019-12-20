package upp1.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class CreateAccountPage {

	WebDriver driver;

	// Step1

	public static String yesihavelabvisitnumberradiobuttonpath = "//input[@id='discretionAcceptedY']//following-sibling::*[position()=1]";
	public static String noidonthavelabvisitnumberradiobuttonpath = "//input[@id='discretionAcceptedN']//following-sibling::*[position()=1]";
	public static String noidonthavepinfromlifelabsradiobuttonpath = "//input[@id='lastVisitPin']//following-sibling::*[position()=1]";
	public static String preferredlanguagecomboboxpath = "//button[@class='btn dropdown-toggle btn-default' and @role='button']//child::span";// doubt
	public static String emailtextpath = "//input[@id='email']";
	public static String retypeemailtoconfirmtextpath = "//input[@name='confirmEmail']";
	public static String passwordtextpath = "//input[@id='password']";
	public static String retypepasswordtoconfirmtextpath = "//input[@name='confirmPassword']";
	public static String firstnametextpath = "//input[@name='givenName']";
	public static String surnametextpath = "//input[@name='surName']";
	public static String provincecombolistpath = "//select[@name='StateOrProvince']//option";
	public static String phonenumbertextboxpath = "//input[@name='phoneNumber']";
	public static String birthdateyearcombopath = "//button[@title='Year']//span[@class='caret']";
	public static String birthdateyearpath = "//span[@class='text' and text()='2018']"; // Year needs to change as per
	// requirement
	public static String birthdatemonthcombopath = "//button[@title='Month']//span[@class='caret']";
	public static String birthdatemonthpath = "//span[@class='text' and text()='January']"; // Month needs to change as per
	public static String birthdatedatecombopath = "//button[@title='Day']//span[@class='caret']";
	public static String birthdatedatepath = "//span[@class='text' and text()='1']"; // Day needs to change as per requirement
	public static String streetaddresstextpath = "//input[@name='address1']";
	public static String citytextpath = "//input[@name='city']";
	public static String postalcodetextpath = "//input[@name='zipOrPostalCode']";
	public static String nextbuttonpath = "//button[@class='btn btn-primary  mr-10 ng-binding']";
	public static String cancelbuttonpath = " //div[@id='accountprofile']//a[@class='btn btn-secondary ng-binding' and @name='secondary' and contains(text(),'CANCEL')]";
	public static String step1titlepath = "//span[contains(text(),'Step 1')]";
	public static String step3TermsCheckBoxPath = "//form[@name='termsOfUseForm']//div[contains(.,'I accept the Terms and Conditions of use')]//span";
	public static String step3ReceiveEmailCheckBoxPath = "//form[@name='termsOfUseForm']//div[contains(.,'I agree to receive an email confirmation message when an appointment is booked or cancelled')]//span";
	public static String step3SurveyCheckBoxPath = "//form[@name='termsOfUseForm']//div[contains(.,'I agree to receive information about participating in surveys and focus groups')]//span";
	public static String step3WarningMessageTermsLabelPath = "//div[@class='col-md-12']//div[contains(.,'You must agree to the Terms of use and Privacy Policy to proceed.') and @ng-message='termsAgreement']";

	public static String step5RegsiterLabVisitNowTitlePath = "//span[contains(.,'Do you want to register a LifeLabs lab visit now')]";
	public static String step5YesRegisterLabVisitNowRadioButtonPath = "//strong[contains(.,'Yes, register a LifeLabs lab visit now')]//preceding-sibling::div//span";
	public static String step5YesIhaveLabVisitNumberRadioButtonPath = "//label[@title='Yes, I have a Lab Visit Number.']//span";
	public static String step5NoIdonothavelabvisitnumberRadioButtonPath = "//label[@title='No, I do not have a Lab Visit Number.']//span";
	public static String step5ContinueModalTitlePath = "//span[contains(.,'Continue Without Lab Visit Number')]";
	public static String step5ContinueModalOKButtonPath = "//button[contains(.,'OK')]";
	public static String step5NoRegisterAnothertimeRadioButtonPath = "//label[contains(@title,'register another time')]//span";
	public static String step5NextButtonPath = "//button[contains(.,'NEXT') and @id='btn_next_add_person']";

	@FindBy(xpath = "//input[@id='discretionAcceptedY']//following-sibling::*[position()=1]")
	public static WebElement yeslabvisitnumberradiobutton;

	@FindBy(xpath = "//input[@id='discretionAcceptedN']//following-sibling::*[position()=1]")
	public static WebElement noidonthavelabvisitnumberradiobutton;

	@FindBy(xpath = "//input[@id='lastVisitPin']//following-sibling::*[position()=1]")
	public static WebElement noidonthavepinfromlifelabradiobutton;

	@FindBy(xpath = "//input[@id='email']")
	public static WebElement emailtext;

	@FindBy(xpath = "//input[@name='confirmEmail']")
	public static WebElement retypeemailtext;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement passwordtext;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	public static WebElement retypepasswordtext;

	@FindBy(xpath = "//input[@name='givenName']")
	public static WebElement firstnametext;

	@FindBy(xpath = "//input[@name='surName']")
	public static WebElement surnametext;

	@FindBy(xpath = "//input[@name='address1']")
	public static WebElement streetaddresstext;

	@FindBy(xpath = "//input[@name='city']")
	public static WebElement citytext;

	@FindBy(xpath = "//input[@name='zipOrPostalCode']")
	public static WebElement postaltext;

	@FindBy(xpath = "//button[@title='Year']//span[@class='caret']")
	public static WebElement birthdateyearcombo;

	@FindBy(xpath = "//button[@title='Month']//span[@class='caret']")
	public static WebElement birthdatemonthcombo;

	@FindBy(xpath = "//button[@title='Day']//span[@class='caret']")
	public static WebElement birthdatedatecombo;

	@FindBy(xpath = "//div[@id='accountprofile']//a[@class='btn btn-secondary ng-binding' and @name='secondary' and contains(text(),'CANCEL')]")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//button[@class='btn btn-primary  mr-10 ng-binding']")
	public static WebElement nextbutton;

	@FindBy(xpath = "//select[@name='StateOrProvince']//option")
	public static List<WebElement> provincecombolist;

	@FindBy(xpath = "//input[@name='phoneNumber']")
	public static WebElement phonenumbertextbox;

	@FindBy(xpath = "//div[@class='col-md-12']//div[contains(.,'You must agree to the Terms of use and Privacy Policy to proceed.') and @ng-message='termsAgreement']")
	public static WebElement step3WarningMessageTermsLabel;

	@FindBy(xpath = "//span[contains(.,'Success! You have')]")
	public static WebElement step5FirstTimeRegsiterLabVisitNowTitle;

	@FindBy(xpath = "//span[contains(.,'Do you want to register a LifeLabs lab visit now')]")
	public static WebElement step5RegsiterLabVisitNowTitle;

	@FindBy(xpath = "//strong[contains(.,'Yes, register')]//preceding-sibling::div//span")
	public static WebElement step5YesRegisterLabVisitNowRadioButton;

	@FindBy(xpath = "//label[@title='No, I do not have a Lab Visit Number.']//span")
	public static WebElement step5NoIdonothavelabvisitnumberRadioButton;

	@FindBy(xpath = "//span[contains(.,'Continue Without Lab Visit Number')]")
	public static WebElement step5ContinueModalTitle;

	@FindBy(xpath = "//button[contains(.,'OK')]")
	public static WebElement step5ContinueModalOKButton;

	@FindBy(xpath = "//label[contains(@title,'register another time')]//span")
	public static WebElement step5NoRegisterAnothertimeRadioButton;

	@FindBy(xpath = "//button[contains(.,'NEXT') and @id='btn_next_add_person']")
	public static WebElement step5NextButton;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean fillstep1(String email, String password, String firstname, String lastname, String year, String month, String day, String street, String city, String postalcode,
			String province, String phonenumber) throws Exception {
		boolean response = false;
		// noidonthavelabvisitnumberradiobuttonCommonFunctions.clickUsingJavaExecutor();
		// noidonthavepinfromlifelabradiobuttonCommonFunctions.clickUsingJavaExecutor();
		// CommonFunctions.waitForVisiblity(By.xpath(preferredlanguagecomboboxpath),
		// 30);
		emailtext.sendKeys(email);
		retypeemailtext.sendKeys(email);
		passwordtext.sendKeys(password);
		retypepasswordtext.sendKeys(password);
		firstnametext.sendKeys(firstname);
		surnametext.sendKeys(lastname);

		// click on drop down and then click the year
		CommonFunctions.clickUsingJavaExecutor(birthdateyearcombo);
		CommonFunctions.clickUsingJavaExecutor("//span[@class='text' and text()='" + year + "']");

		// click on drop down and then click the Month
		CommonFunctions.clickUsingJavaExecutor(birthdatemonthcombo);
		CommonFunctions.clickUsingJavaExecutor("//span[@class='text' and text()='" + month + "']");

		// click on drop down and then click the Day
		CommonFunctions.clickUsingJavaExecutor(birthdatedatecombo);
		CommonFunctions.clickUsingJavaExecutor("//span[@class='text' and text()='" + day + "']");

		streetaddresstext.sendKeys(street);
		citytext.sendKeys(city);
		postaltext.sendKeys(postalcode);

		Select provinceSelector = new Select(ObjectHelper.driver.findElement(By.xpath("//select[@name='StateOrProvince']")));
		provinceSelector.selectByVisibleText(province);

		phonenumbertextbox.sendKeys(phonenumber);

		CommonFunctions.clickUsingJavaExecutor(nextbutton);
		// cancelbuttonCommonFunctions.clickUsingJavaExecutor();
		response = true;

		return response;
	}

	// step2
	public static String twofactorauthirdiopath = "//input[@id='twofactor']//following-sibling::*[position()=1]";
	public static String answerthreesecurityquestionsradiopath = "//input[@id='security-ques']//following-sibling::*[position()=1]";
	public static String question1checkboxpath = "//input[@name='customQuestionCheck1']//following-sibling::*[position()=1]";
	public static String question1questionpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][1]//input[@name='customQuestion']";
	public static String question1answerpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][1]//input[@name='answer']";
	public static String question2checkboxpath = "//input[@name='customQuestionCheck2']//following-sibling::*[position()=1]";
	public static String question2questionpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][2]//input[@name='customQuestion']";
	public static String question2answerpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][2]//input[@name='answer']";
	public static String question3checkboxpath = "//input[@name='customQuestionCheck3']//following-sibling::*[position()=1]";
	public static String question3questionpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][3]//input[@name='customQuestion']";
	public static String question3answerpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][3]//input[@name='answer']";
	public static String securityphrasepath = "//input[@name='secretConfirmationPhrase']";
	public static String step2backbuttonpath = "//div[@id='securitysettings']//a[@class='btn btn-secondary mr-10 ng-binding']";
	public static String step2nextbuttonpath = "//div[@id='securitysettings']//button[@class='btn btn-primary mr-10 ng-binding']";
	public static String step2cancelbuttonpath = "//div[@id='securitysettings']//a[@class='btn btn-secondary ng-binding']";
	public static String step2titlepath = "//span[contains(text(),'Step 2')]";
	public static String step2SideLabelPath = "//a[@title='Security Settings']";
	public static String step2warningcountlistpath = "//div[@ng-show='securityRadio == 2']//div[text()='This is a required field']";

	@FindBy(xpath = "//input[@id='twofactor']//following-sibling::*[position()=1]")
	public static WebElement twofactorauthradiobutton;

	@FindBy(xpath = "//input[@id='security-ques']//following-sibling::*[position()=1]")
	public static WebElement answerthreesecurityquestionsradiobutton;

	@FindBy(xpath = "//input[@name='customQuestionCheck1']//following-sibling::*[position()=1]")
	public static WebElement question1checkbox;

	@FindBy(xpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][1]//input[@name='customQuestion']")
	public static WebElement question1questiontext;

	@FindBy(xpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][1]//input[@name='answer']")
	public static WebElement question1answertext;

	@FindBy(xpath = "//input[@name='customQuestionCheck2']//following-sibling::*[position()=1]")
	public static WebElement question2checkbox;

	@FindBy(xpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][2]//input[@name='customQuestion']")
	public static WebElement question2questiontext;

	@FindBy(xpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][2]//input[@name='answer']")
	public static WebElement question2answertext;

	@FindBy(xpath = "//input[@name='customQuestionCheck3']//following-sibling::*[position()=1]")
	public static WebElement question3checkbox;

	@FindBy(xpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][3]//input[@name='customQuestion']")
	public static WebElement question3questiontext;

	@FindBy(xpath = "//div[@class='ng-scope']//div[@class='how-to-secure ng-scope'][3]//input[@name='answer']")
	public static WebElement question3answertext;

	@FindBy(xpath = "//input[@name='secretConfirmationPhrase']")
	public static WebElement securityphasetext;

	@FindBy(xpath = "//div[@id='securitysettings']//a[@class='btn btn-secondary mr-10 ng-binding']")
	public static WebElement step2backbutton;

	@FindBy(xpath = "//div[@id='securitysettings']//button[@class='btn btn-primary mr-10 ng-binding']")
	public static WebElement step2nextbutton;

	@FindBy(xpath = "//div[@id='securitysettings']//a[@class='btn btn-secondary ng-binding']")
	public static WebElement step2cancelbutton;

	@FindBy(xpath = "//a[@title='Security Settings']")
	public static WebElement step2SideLabel;

	@FindBy(xpath = "//div[@ng-show='securityRadio == 2']//div[text()='This is a required field']")
	public static List<WebElement> step2warningcountlist;

	public static boolean fillstep2(String question1text, String answer1text, String question2text, String answer2text, String question3text, String answer3text, String securitytext)
			throws Exception {
		boolean response = false;
		// twofactorauthradiobuttonCommonFunctions.clickUsingJavaExecutor();
		// answerthreesecurityquestionsradiobuttonCommonFunctions.clickUsingJavaExecutor();
		CommonFunctions.clickUsingJavaExecutor(question1checkbox);
		Thread.sleep(3000);
		CommonFunctions.waitForVisiblity(question1questiontext, 20);
		question1questiontext.sendKeys(question1text);
		question1answertext.sendKeys(answer1text);
		// question2checkboxCommonFunctions.clickUsingJavaExecutor();
		CommonFunctions.clickUsingJavaExecutor(question2checkbox);
		Thread.sleep(3000);
		CommonFunctions.waitForVisiblity(question2questiontext, 20);
		question2questiontext.sendKeys(question2text);
		question2answertext.sendKeys(answer2text);
		// question3checkboxCommonFunctions.clickUsingJavaExecutor();
		CommonFunctions.clickUsingJavaExecutor(question3checkbox);
		Thread.sleep(3000);
		CommonFunctions.waitForVisiblity(question3questiontext, 20);
		question3questiontext.sendKeys(question3text);
		question3answertext.sendKeys(answer3text);
		securityphasetext.sendKeys(securitytext);
		// step2backbuttonCommonFunctions.clickUsingJavaExecutor();
		// step2nextbuttonCommonFunctions.clickUsingJavaExecutor();
		// step2cancelbuttonCommonFunctions.clickUsingJavaExecutor();
		response = true;

		return response;
	}

	// step3

	public static String acceptedtermsandconditions = "//div[@id='termsofuse']//label[@class='normal no-margin ng-scope']";// doubt
	public static String iframestep3recaptch = "//iframe[@src='https://www.google.com/recaptcha/api2/anchor?k=6Lc2Fj0UAAAAABR-OjGS1avWhgTjjZaR2mlkPYUN&co=aHR0cDovLzEwLjEuMS4xMzk6NDQzMTk.&hl=en&v=v1522045847408&size=normal&cb=3a618cqekx8j']";
	public static String step3recapthpath = "//div[@class='recaptcha-checkbox-checkmark' and @role='presentation']";
	public static String step3backbuttonpath = "//div[@id='termsofuse']//a[@class='btn btn-secondary mr-10 ng-binding']";
	public static String step3createmyaccountbuttonpath = "//div[@id='termsofuse']//button[@id='btn_create_account']";
	public static String step3cancelbuttonpath = "//a[@id='btn_cancel_create_account']";
	public static String step3titlepath = "//h3//span[contains(.,'Check Terms of Use')]";
	public static String step3PrintButtonPath = "//button[contains(.,'PRINT')]";

	@FindBy(xpath = "//div[@id='termsofuse']//label[@class='normal no-margin ng-scope']")
	public static WebElement accepttermsandcontionscheckbox;

	@FindBy(xpath = "//div[@class='recaptcha-checkbox-checkmark' and @role='presentation']")
	public static WebElement step3recapthcheckbox;

	@FindBy(xpath = "//div[@id='termsofuse']//a[@class='btn btn-secondary mr-10 ng-binding']")
	public static WebElement step3backbutton;

	@FindBy(xpath = "//div[@id='termsofuse']//button[@id='btn_create_account']")
	public static WebElement step3createmyaccountbutton;

	@FindBy(xpath = "//a[@id='btn_cancel_create_account']")
	public static WebElement step3cancelbutton;

	@FindBy(xpath = "//button[contains(.,'PRINT')]")
	public static WebElement step3PrintButton;

	@FindBy(xpath = "//form[@name='termsOfUseForm']//div[contains(.,'I accept the Terms and Conditions of use')]//span")
	public static WebElement step3TermsCheckBox;

	@FindBy(xpath = "//form[@name='termsOfUseForm']//div[contains(.,'I agree to receive an email confirmation message when an appointment is booked or cancelled')]//span")
	public static WebElement step3ReceiveEmailCheckBox;

	@FindBy(xpath = "//form[@name='termsOfUseForm']//div[contains(.,'I agree to receive information about participating in surveys and focus groups')]//span")
	public static WebElement step3SurveyCheckBox;

	public static boolean fillstep3() throws Exception {
		boolean response = false;
		CommonFunctions.clickUsingJavaExecutor(step3TermsCheckBox);
		CommonFunctions.clickUsingJavaExecutor(step3ReceiveEmailCheckBox);
		CommonFunctions.clickUsingJavaExecutor(step3SurveyCheckBox);

		// step3recapthcheckboxCommonFunctions.clickUsingJavaExecutor();
		Thread.sleep(1000);
		// step3backbuttonCommonFunctions.clickUsingJavaExecutor();
		CommonFunctions.clickUsingJavaExecutor(step3createmyaccountbutton);
		// step3cancelbuttonCommonFunctions.clickUsingJavaExecutor();
		response = true;

		return response;
	}

	// Step4
	public static String step4titlepath = "//span[@class='text-bold ng-binding' and contains(text(),'Verify Account')]";
	public static String step4emailsuccessverificationpath = "//*[@id='verifyaccountstep']/div[@class='ng-scope']/p[2]/b[@class='ng-binding']";
	public static String step1accountprofilepath = "//span[text()='Account Profile']";

	public static String popupokbuttonpath = "//button[@class='btn btn-primary btnPHover ng-scope' and @ng-click='ok()']";

	public static String activationUrlPath = "//div[@id='verifyaccountstep']//div//div//a";

	@FindBy(xpath = "//span[text()='Account Profile']")
	public static WebElement step1accountprofile;

	@FindBy(xpath = "//div[@id='verifyaccountstep']//div//div//a")
	public static WebElement activationUrl;

	@FindBy(xpath = "//*[@id='verifyaccountstep']/div[@class='ng-scope']/p[2]/b[@class='ng-binding']")
	public static WebElement step4emailsuccessverification;

	@FindBy(xpath = "//span[@class='text-bold ng-binding' and contains(text(),'Verify Account')]")
	public static WebElement step4title;

}
