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

public class PersonalInformationPage {
	WebDriver driver;

	public static String personalinfotitlepath = "//h3[contains(.,'Personal Information ')]";

	public static String firstnametextboxpath = "//*[@id='changeaccountprofile']/form/div[3]/div/div/div/div[1]/div[1]/input";
	public static String lastnametextboxpath = "//*[@id='changeaccountprofile']/form/div[3]/div/div/div/div[1]/div[2]/input";
	// div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[1]/div/div[1]/div/ul/li[32]/a/span[@class='text'
	// and contains(.,'1988')]
	public static String birthdateyearcombopath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[1]/div/div[1]/button/span[1]";
	public static String birthdateyearpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[1]/div/div[1]/div/ul/li[33]/a/span[@class='text' and text()= '1987']"; // Change_Year
	public static String birthdatemonthcombopath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[2]/div/div[1]/button/span[1]";
	public static String birthdatemonthpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[2]/div/div[1]/div/ul/li[11]/a/span[@class='text' and text()= 'October']"; // Change_Month
	public static String birthdatedatecombopath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[3]/div/div[1]/button/span[1]";
	public static String birthdatedatepath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[3]/div/div[1]/div/ul/li[32]/a/span[@class='text' and text()= '31']"; // Change_Day

	public static String streetaddresstextboxpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[2]/div/input";
	public static String citytextboxpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[3]/div[1]/input";
	public static String postalcodetextboxpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[3]/div[2]/input";
	public static String provincecombopath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[4]/div[1]/div[1]/select";
	public static String provincecombopathselected = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[4]/div[1]/div[1]/select//option[@ng-selected='true']";
	public static String provincecomboListpath = "//*[@id='changeaccountprofile']/form/div[3]/div/div/div/div[4]/div[1]/div/select//option";
	public static String phonenumbertextboxpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[2]/div[2]/input";

	public static String agewarninglabelpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/p[1][contains(.,'You must be 16 years or older to create a ')]";
	public static String savebuttonpath = "//*[@id='changeaccountprofile']/form/div[4]/p/button[text()='SAVE']";
	public static String cancelbuttonpath = "//*[@id='changeaccountprofile']/form/div[4]/p/a[contains(text(),'CANCEL')]";

	public static String discardpopupokbuttonpath = "//button[text()='OK']";
	public static String discardpopupcancelbuttonpath = "//button[text()='CANCEL']";

	public static String successpopupokbuttonpath = "//button[text()='OK']";
	public static String successmessagepath = "//p[contains(text(),'successfully')]";

	@FindBy(xpath = "//div[@id='changeaccountprofile']//div[@ng-message='required']")
	public static List<WebElement> postalCodeRequiredValidationMsgList;

	@FindBy(xpath = "//div[contains(@ng-messages,'accountProfileForm.zipOrPostalCode')]//div[@ng-message='pattern']")
	public static WebElement postalCodeInvalidValidationMsg;
	@FindBy(xpath = "//div[contains(@ng-messages,'accountProfileForm.zipOrPostalCode')]//div[@ng-message='required']")
	public static WebElement postalCodeRequiredValidationMsg;
	@FindBy(xpath = "//div[contains(@ng-messages,'accountProfileForm.givenName')]//div[@ng-message='required']")
	public static WebElement firstNameRequiredValidationMsg;
	@FindBy(xpath = "//div[contains(@ng-messages,'accountProfileForm.surName')]//div[@ng-message='required']")
	public static WebElement lastNameRequiredValidationMsg;
	@FindBy(xpath = "//div[contains(@ng-messages,'accountProfileForm.address1')]//div[@ng-message='required']")
	public static WebElement streetRequiredValidationMsg;
	@FindBy(xpath = "//div[contains(@ng-messages,'accountProfileForm.city')]//div[@ng-message='required']")
	public static WebElement cityRequiredValidationMsg;
	@FindBy(xpath = "//div[@id='changeaccountprofile']//p[@translate='REGISTERUSERFORM_FUTURE_DATE_WARNING']")
	public static WebElement futureBirthDateValidationMsg;

	@FindBy(xpath = "//h3[contains(.,'Personal Information ')]")
	public static WebElement personalinfotitle;

	@FindBy(xpath = "//*[@id='changeaccountprofile']/form/div[3]/div/div/div/div[1]/div[1]/input")
	public static WebElement firstnametextbox;

	@FindBy(xpath = "//*[@id='changeaccountprofile']/form/div[3]/div/div/div/div[1]/div[2]/input")
	public static WebElement lastnametextbox;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[1]/div/div[1]/button/span[1]")
	public static WebElement birthdateyearcombo;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[2]/div/div[1]/button/span[1]")
	public static WebElement birthdatemonthcombo;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[3]/div/div[1]/button/span[1]")
	public static WebElement birthdatedatecombo;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[2]/div/input")
	public static WebElement streetaddresstextbox;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[3]/div[1]/input")
	public static WebElement citytextbox;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[3]/div[2]/input")
	public static WebElement postalcodetextbox;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[3]/div/div/div/p[1][contains(.,'You must be 16 years or older to create a ')]")
	public static WebElement agewarninglabel;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[4]/p/button[text()='SAVE']")
	public static WebElement savebutton;

	@FindBy(xpath = "//div[@id='changeaccountprofile']/form/div[4]/p/a[contains(text(),'CANCEL')]")
	public static WebElement cancelbutton;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement successpopupokbutton;

	@FindBy(xpath = "//div[@id='changeaccountprofile']//select[@name='StateOrProvince']")
	public static WebElement provincecombo;

	@FindBy(xpath = "//div[@id='changeaccountprofile']//select[@name='StateOrProvince']//option[@ng-selected='true']")
	public static WebElement provincecomboselected;

	@FindBy(xpath = "//div[@id='changeaccountprofile']//select[@name='StateOrProvince']//option")
	public static List<WebElement> provincecomboList;

	@FindBy(xpath = "//div[@id='changeaccountprofile']//input[@name='phoneNumber']")
	public static WebElement phonenumbertextbox;

	@FindBy(xpath = "//button[text()='OK' or contains(text(),'Discard')]")
	public static WebElement discardpopupokbutton;

	@FindBy(xpath = "//button[text()='CANCEL']")
	public static WebElement discardpopupcancelbutton;

	public PersonalInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean changepersonalinfo(String firstname, String lastname, String year, String month, String day, String streetaddress, String city, String postalcode, String province,
			String phonenumber, boolean saveflag) throws Exception {
		boolean err = false;
		CommonFunctions.waitandClear(By.xpath(firstnametextboxpath), 30);
		lastnametextbox.clear();
		streetaddresstextbox.clear();
		citytextbox.clear();
		postalcodetextbox.clear();
		phonenumbertextbox.clear();

		Thread.sleep(2000);

		firstnametextbox.sendKeys(firstname);
		lastnametextbox.sendKeys(lastname);

		// Click on year box and click on year
		CommonFunctions.clickUsingJavaExecutor(birthdateyearcombo);
		CommonFunctions.waitandClick(By.xpath("// div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[1]/div/div[1]/div/ul/li/a/span[@class='text' and contains(.,'" + year + "')]"), 10);
		// click on month box and click on month
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor(birthdatemonthcombo);
		CommonFunctions.waitandClick(By.xpath("//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[2]/div/div[1]/div/ul/li/a/span[@class='text' and contains(.,'" + month + "')]"), 10);
		// Click on Day box and click on day
		Thread.sleep(1000);
		CommonFunctions.clickUsingJavaExecutor(birthdatedatecombo);
		CommonFunctions.waitandClick(By.xpath("//div[@id='changeaccountprofile']/form/div[3]/div/div/div/div[6]/div/div/div[3]/div/div[1]/div/ul/li/a/span[@class='text' and contains(.,'" + day + "')]"), 10);
		streetaddresstextbox.sendKeys(streetaddress);
		citytextbox.sendKeys(city);
		postalcodetextbox.sendKeys(postalcode);

		Select provinceSelector = new Select(ObjectHelper.driver.findElement(By.xpath("//div[@id='changeaccountprofile']//select[@name='StateOrProvince']")));
		provinceSelector.selectByVisibleText(province);

		phonenumbertextbox.sendKeys(phonenumber);

		if (saveflag) {
			CommonFunctions.clickUsingJavaExecutor(savebutton);

			try {
				CommonFunctions.clickonmodalpopup(successpopupokbuttonpath, successmessagepath);

			} catch (Exception e) {
				err = true;
			}

		} else {
			err = true;
		}
		return err;
	}

	public static void selectBirthdate(String year, String month, String day) throws Exception {
		// Click on year box and click on year
		CommonFunctions.clickUsingJavaExecutor(birthdateyearcombo);
		CommonFunctions.clickUsingJavaExecutor("//div[@id='changeaccountprofile']//ul/li/a/span[@class='text' and text()='" + year + "']");
		Thread.sleep(1500);
		// click on month box and click on month
		CommonFunctions.clickUsingJavaExecutor(birthdatemonthcombo);
		CommonFunctions.clickUsingJavaExecutor("//div[@id='changeaccountprofile']//ul/li/a/span[contains(text(),'" + month + "')]");
		Thread.sleep(1500);
		// Click on Day box and click on day
		CommonFunctions.clickUsingJavaExecutor(birthdatedatecombo);
		CommonFunctions.clickUsingJavaExecutor("//div[@id='changeaccountprofile']//ul/li/a/span[@class='text' and text()='" + day + "']");

	}

}
