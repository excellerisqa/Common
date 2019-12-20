package upp1.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class AccountRegistrationPage {

	WebDriver driver;

	public static String Addanotherpersonlabelpath = "//label[@for='person-another']//strong";
	public static String melabelPath = "//label[@for='self']//strong";
	public static String step1nextbuttonpath = "//button[@id='btn_next_add_person']";
	public static String step1cancelbuttonpath = "//a[@id='btn_cancel_add_person']";

	public static String firstnametextpath = "//input[@name='givenName']";
	public static String lastnametextpath = "//input[@name='surName']";

	public static String birthdateyearcombopath = "//label[contains(text(),'Birth Date')]/parent::div//div//div//div//div[1]//button//span[text()='Year']";
	public static String birthdateselectyearpath = "//*[@id='registeruser']/form/div/div[2]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/ul//span[@class='text' and text()='2010']";// yearneedtochnageasreq

	public static String birthdatemonthcombopath = "//label[contains(text(),'Birth Date')]/parent::div//div[1]//div[2]//div//div[1]//button//span[@class='filter-option pull-left']";
	public static String birthdateselectmonthpath = "//*[@id='registeruser']/form/div/div[2]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/ul//span[@class='text' and text()='January']";// monthneedtochnageasreq

	public static String birthdatedaycombopath = "//label[contains(text(),'Birth Date')]/parent::div//div[1]//div[3]//div//div[1]//button//span[@class='filter-option pull-left']";
	public static String birthdateselecteddaypath = "//*[@id='registeruser']/form/div/div[2]/div[1]/div/div[2]/div/div/div[3]/div/div[1]/div/ul//span[@class='text' and text()='2']";// dayneedtochnageasreq

	public static String idonthaveontarioHCNpath = "//input[@id='provinceOther']//following-sibling::*[position()=1]";
	public static String healthcardnumberpath = "//input[@ng-model='registrationData.PHN']";
	public static String labvisitnumberpath = "//input[@name='accessCode']";

	public static String dateoflabvisityearcombopath = "//*[@id='registeruser']/form/div/div[5]/div/div/div[1]/div[1]/button/span[1]";
	public static String dateoflabvisitselectedyearpath = "//*[@id='registeruser']/form/div/div[5]/div/div/div[1]/div[1]/div/ul//span[@class='text' and text()='2017']";// yearneedtochangeasperrequirement
	public static String dateoflabvisitmonthcombopath = "//*[@id='registeruser']/form/div/div[5]/div/div/div[2]/div[1]/button/span[1]";
	public static String dateoflabvisitselectedmonth = "//*[@id='registeruser']/form/div/div[5]/div/div/div[2]/div[1]/div/ul//span[@class='text' and text()='February']";// monthneedtochnageasreq
	public static String dateoflabvisitdaycombopath = "//*[@id='registeruser']/form/div/div[5]/div/div/div[3]/div[1]/button/span[1]";
	public static String dateoflabvisitselecteddaypath = "//*[@id='registeruser']/form/div/div[5]/div/div/div[3]/div[1]/div/ul//span[@class='text' and text()='3']";// dayneedtochnageasreq

	public static String backbuttonpath = "//a[@data-target='#userRegistrationSlider']";
	public static String savebuttonpath = "//div[@class='col-md-12 xs-center']//button[contains(.,'NEXT')]";
	public static String cancelbuttonpath = "//a[@ng-click='promptContinueLater()']";

	public static String Sixteenyearsolderpath = "//p[@ng-hide='AccountHolderIsAdult']";
	public static String dateoflabvisitwithin30dayspath = "//div[@class='ng-binding ng-scope']";
	public static String me16pluspath = "//input[@id='self']//following-sibling::*[position()=1]";
	public static String anotherindividual16pluspath = "//input[@id='person-another']//following-sibling::*[position()=1]";

	public static String failurepopupokbuttonpath = "//button[text()='OK']";

	public static String sucessmessagepath = "//p[contains(.,'User Successfully Registered!')]";
	public static String sucesspopupokbuttonpath = "//p[contains(.,'User Successfully Registered!')]";

	public static String failedtoloadpatientinfomessagepath = "Failed to load patient information.";
	public static String failedtoloadpatientpopupokbuttonpath = "//button[text()='OK']";

	public static String patientalreadyaddedmessagpath = "//p[text()='Patient is already added.']";
	public static String patientalreadyaddedokpath = "//button[text()='OK']";

	public static String Step2IhaveBCPHNRadioButtonPath = "//strong[contains(.,'I have a British Columbia Personal Health Number')]//preceding-sibling::div//span";
	public static String Step2BCPHNTextBoxPath = "//input[@name='ont_phn_1']";
	public static String Step2IdonotHaveBCPHNRadioButtonPath = "//strong[contains(.,'I do NOT have a British Columbia Personal Health Number')]//preceding-sibling::div//span";
	public static String Step2IHaveVisitedLabInPastRadioButtonPath = "//strong[contains(.,'I have visited a lab in the past 30 days')]//preceding-sibling::div//span";
	public static String Step2IHaveLabNumberRadioButtonPath = "//strong[contains(.,'I was provided a lab visit number')]//preceding-sibling::div//span";
	public static String Step2LabNumberTextBoxPath = "//input[@name='accessCode']";
	public static String Step2LabVisitYearDropBoxPath = "//div[@class='col-md-4']//button//span[contains(.,'Year')]";
	public static String Step2LabVisitMonthDropBoxPath = "//div[@class='col-md-4']//button//span[contains(.,'Month')]";
	public static String Step2LabVisitDateDropBoxPath = "//div[@class='col-md-3']//button//span[contains(.,'Day')]";

	@FindBy(xpath = "//label[@for='person-another']//strong")
	public static WebElement Addanotherpersonlabel;

	@FindBy(xpath = "//label[@for='self']//strong")
	public static WebElement melabel;

	@FindBy(xpath = "//button[@id='btn_next_add_person']")
	public static WebElement step1nextbutton;

	@FindBy(xpath = "//a[@id='btn_cancel_add_person']")
	public static WebElement step1cancelbutton;

	@FindBy(xpath = "//input[@name='givenName']")
	public static WebElement firstnametext;

	@FindBy(xpath = "//input[@name='surName']")
	public static WebElement lastnametext;

	@FindBy(xpath = "//label[contains(text(),'Birth Date')]/parent::div//div[1]//div[1]//div//div[1]//button//span[@class='filter-option pull-left']")
	public static WebElement birthdateyearcombo;

	@FindBy(xpath = "//label[contains(text(),'Birth Date')]/parent::div//div[1]//div[2]//div//div[1]//button//span[@class='filter-option pull-left']")
	public static WebElement birthdatemonthcombo;

	@FindBy(xpath = "//label[contains(text(),'Birth Date')]/parent::div//div[1]//div[3]//div//div[1]//button//span[@class='filter-option pull-left']")
	public static WebElement birthdatedaycombo;

	@FindBy(xpath = "//input[@id='provinceOther']//following-sibling::*[position()=1]")
	public static WebElement idonthaveontarioHCN;

	@FindBy(xpath = "//input[@ng-model='registrationData.PHN']")
	public static WebElement healthcardnumber;

	@FindBy(xpath = "//input[@name='accessCode']")
	public static WebElement labvisitnumber;

	@FindBy(xpath = "//div[contains(text(),'Date of Lab Visit')]//button/span[text()='Year']")
	public static WebElement dateoflabvisityearcombo;

	@FindBy(xpath = "//div[contains(text(),'Date of Lab Visit')]//button/span[text()='Month']")
	public static WebElement dateoflabvisitmonthcombo;

	@FindBy(xpath = "//div[contains(text(),'Date of Lab Visit')]//button/span[text()='Day']")
	public static WebElement dateoflabvisitdaycombo;

	@FindBy(xpath = "//a[@data-target='#userRegistrationSlider']")
	public static WebElement backbutton;

	@FindBy(xpath = "//div[@class='col-md-12 xs-center']//button[contains(.,'NEXT')]")
	public static WebElement savebutton;
	
	@FindBy(xpath = "//form[@name='registerUserForm']//button[contains(text(),'NEXT')]")
	public static WebElement step2Nextbutton;

	@FindBy(xpath = "//a[@ng-click='promptContinueLater()']")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//input[@id='self']//following-sibling::*[position()=1]")
	public static WebElement me16plus;

	@FindBy(xpath = "//input[@id='person-another']//following-sibling::*[position()=1]")
	public static WebElement anotherindividual16plus;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement failurepopupokbutton;

	@FindBy(xpath = "//p[contains(.,'User Successfully Registered')]")
	public static WebElement sucessmessage;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement sucesspopupokbutton;

	@FindBy(xpath = "//p[text()='Failed to load patient information.']")
	public static WebElement failedtoloadpatientinfomessage;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement failedtoloadpatientpopupokbutton;

	@FindBy(xpath = "//p[text()='Patient is already added.']")
	public static WebElement patientalreadyaddedmessage;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement patientalreadyaddedok;

	@FindBy(xpath = "//span[contains(text(),'Failed to Add')]")
	public static WebElement failedToAddMsg;

	@FindBy(xpath = "//span[contains(text(),'Failed to Add')]//ancestor::div[@class='modal-content']//button[text()='OK']")
	public static WebElement failedToAddOKButton;

	// @FindBy(xpath = "//strong[contains(.,'I have a British Columbia Personal
	// Health Number')]//preceding-sibling::div//span")
	@FindBy(xpath = "//input[@id='provinceOntario']//following-sibling::span")
	public static WebElement Step2IhaveBCPHNRadioButton;

	@FindBy(xpath = "//input[@name='ont_phn_1']")
	public static WebElement Step2BCPHNTextBox;

	// @FindBy(xpath = "//strong[contains(.,'I do NOT have a British Columbia
	// Personal Health Number')]//preceding-sibling::div//span")
	@FindBy(xpath = "//input[@id='provinceOther']//following-sibling::span")
	public static WebElement Step2IdonotHaveBCPHNRadioButton;

	@FindBy(xpath = "//input[@id='lab-visit-provided']//following-sibling::span") // "//strong[contains(.,'I have a lab visit
																					// number')]//preceding-sibling::div//span")
	public static WebElement Step2IHaveVisitedLabInPastRadioButton;

	@FindBy(xpath = "//input[@name='accessCode']")
	public static WebElement Step2LabNumberTextBox;

	@FindBy(xpath = "//div[@class='col-md-4']//button//span[contains(.,'Year')]")
	public static WebElement Step2LabVisitYearDropBox;

	@FindBy(xpath = "//div[@class='col-md-4']//button//span[contains(.,'Month')]")
	public static WebElement Step2LabVisitMonthDropBox;

	@FindBy(xpath = "//div[@class='col-md-3']//button//span[contains(.,'Day')]")
	public static WebElement Step2LabVisitDateDropBox;

	public static boolean accountregistrationfillstep2(String firstname, String Lastname, String birthdateyear, String birthdatemonth, String birthdateday, String healthcardno, String labvisitno,
			String dateoflabvisityear, String dateoflabvisitmonth, String dateoflabvisitday) throws Exception {

		// after success of step1, validate the step2 title
		CommonFunctions.waitForVisiblity(By.xpath(CreateAccountPage.step2titlepath), 20);
		firstnametext.clear();
		firstnametext.sendKeys(firstname);
		lastnametext.clear();
		lastnametext.sendKeys(Lastname);

		Thread.sleep(3000);

		// click on drop down and then click the year
		CommonFunctions.clickUsingJavaExecutor(birthdateyearcombo);
		CommonFunctions.clickUsingJavaExecutor("//label[contains(text(),'Birth Date')]/parent::div//ul//span[@class='text' and text()='" + birthdateyear + "']");
		Thread.sleep(2000);
		// click on drop down and then click the Month
		CommonFunctions.clickUsingJavaExecutor(birthdatemonthcombo);
		CommonFunctions.clickUsingJavaExecutor("//label[contains(text(),'Birth Date')]/parent::div//ul//span[@class='text' and contains(text(),'" + birthdatemonth + "')]");
		Thread.sleep(2000);
		// click on drop down and then click the Day
		CommonFunctions.clickUsingJavaExecutor(birthdatedaycombo);
		CommonFunctions.clickUsingJavaExecutor("//label[contains(text(),'Birth Date')]/parent::div//ul//span[@class='text' and text()='" + birthdateday + "']");

		Thread.sleep(3000);

		// CommonFunctions.clickUsingJavaExecutor(Step2IhaveBCPHNRadioButton);
		Step2BCPHNTextBox.clear();
		Step2BCPHNTextBox.sendKeys(healthcardno);

		// Step2IHaveVisitedLabInPastRadioButtonCommonFunctions.clickUsingJavaExecutor();
		if (ObjectHelper.state.equals("BC")) {
			CommonFunctions.clickUsingJavaExecutor(Step2IHaveVisitedLabInPastRadioButton);
		}

		Thread.sleep(2000);
		Step2LabNumberTextBox.clear();
		Step2LabNumberTextBox.sendKeys(labvisitno);

		// click on drop down and then click the year
		CommonFunctions.clickUsingJavaExecutor(dateoflabvisityearcombo);
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor("//div[contains(text(),'Date of Lab Visit')]//ul//span[@class='text' and text()='" + dateoflabvisityear + "']");

		// click on drop down and then click the Month
		CommonFunctions.clickUsingJavaExecutor(dateoflabvisitmonthcombo);
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor("//div[contains(text(),'Date of Lab Visit')]//ul//span[@class='text' and contains(text(),'" + dateoflabvisitmonth + "')]");

		// click on drop down and then click the Day
		CommonFunctions.clickUsingJavaExecutor(dateoflabvisitdaycombo);
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor("//div[contains(text(),'Date of Lab Visit')]//ul//span[@class='text' and text()='" + dateoflabvisitday + "']");

		// BaseClass.arp.backbuttonCommonFunctions.clickUsingJavaExecutor();

		// BaseClass.arp.cancelbuttonCommonFunctions.clickUsingJavaExecutor();
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor(step2Nextbutton);

		Thread.sleep(3000);
		if (CommonFunctions.waitForVisiblity(By.xpath(sucesspopupokbuttonpath), 30)) {
			CommonFunctions.clickUsingJavaExecutor(sucesspopupokbutton);
			return true;
		} else {
			return false;
		}
	}

	public AccountRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
