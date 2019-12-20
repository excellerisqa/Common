package upp1.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddorRemoveAccountRegistationPage {

	WebDriver driver;

	public static String addorremoveaccountregistrationtitlepath = "//h3[contains(.,'Add or Remove Account Registrations')]";
	public static String thFirstNamePath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[1]";
	public static String thLastNamePath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[2]";
	public static String thBirthDatePath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[3]";
	public static String thGenderPath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[4]";
	public static String thHealthCardNoPath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[5]";
	public static String thActionsPath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[6]";

	public static String tbFirstNameListPath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[1]";
	public static String tbLastNameListPath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[2]";
	public static String tbBirthDateListPath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[3]";
	public static String tbSexListPath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[4]";
	public static String tbHealthCardNoListPath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[5]";
	public static String tbActionsListPath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[6]//a[contains(.,'REMOVE')]";

	public static String tbFamilyUserIconListPath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[1]//i[@class='icon icon-exc-family-account text-light-blue  text-18']";
	public static String tbAccountHolderIconListPath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[1]//i[@class='icon icon-exc-patient text-light-blue text-18']";

	public static String tbAccountOwnerIconPath = "//i[@class='icon icon-exc-patient text-light-blue text-18']";

	public static String addorremoveButtonPath = "//a[contains(.,'ADD ANOTHER PERSON')]";
	public static String popupRemoveRegisteredUserTitlePath = "//span[contains(.,'Remove Registered User?')]";
	public static String popupRemoveRegisteredOkButtonPath = "//button[contains(.,'OK')]";
	public static String popupRemoveRegisteredCancelButtonPath = "//button[contains(.,'CANCEL')]";
	public static String popupUserRemovedSuccessfullyOkButtonPath = "//button[contains(.,'OK')]";

	@FindBy(xpath = "//i[@class='icon icon-exc-patient text-light-blue text-18']")
	public static WebElement tbAccountOwnerIcon;

	@FindBy(xpath = "//h3[contains(.,'Add or Remove Account Registrations')]")
	public static WebElement addorremoveaccountregistrationtitle;

	@FindBy(xpath = "//a[contains(.,'ADD ANOTHER PERSON')]")
	public static WebElement addorremoveButton;

	@FindBy(xpath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[1]")
	public static WebElement thFirstName;

	@FindBy(xpath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[2]")
	public static WebElement thLastName;

	@FindBy(xpath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[3]")
	public static WebElement thBirthDate;

	@FindBy(xpath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[4]")
	public static WebElement thGender;

	@FindBy(xpath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[5]")
	public static WebElement thHealthCardNo;

	@FindBy(xpath = "//div[@id='manageaccountusers']//div[@class='table-my-reports']//th[6]")
	public static WebElement thActions;

	@FindBy(xpath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[1]")
	public static List<WebElement> tbFirstNameList;

	@FindBy(xpath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[2]")
	public static List<WebElement> tbLastNameList;

	@FindBy(xpath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[3]")
	public static List<WebElement> tbBirthDateList;

	@FindBy(xpath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[4]")
	public static List<WebElement> tbSexList;

	@FindBy(xpath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[5]")
	public static List<WebElement> tbHealthCardNoList;

	@FindBy(xpath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[6]//a[contains(.,'REMOVE')]")
	public static List<WebElement> tbActionsList;

	@FindBy(xpath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[1]//i[@class='icon icon-exc-family-account text-light-blue  text-18']")
	public static List<WebElement> tbFamilyUserIconList;

	@FindBy(xpath = "//div[@id='manageaccountusers']/div/div/div/div[1]/div/table/tbody/tr/td[1]//i[@class='icon icon-exc-patient text-light-blue text-18']")
	public static List<WebElement> tbAccountOwnerIconList;

	@FindBy(xpath = "//span[contains(.,'Remove Registered User?')]")
	public static WebElement popupRemoveRegisteredUserTitle;

	@FindBy(xpath = "//button[contains(.,'OK')]")
	public static WebElement popupRemoveRegisteredOkButton;

	@FindBy(xpath = "//button[contains(.,'CANCEL')]")
	public static WebElement popupRemoveRegisteredCancelButton;

	@FindBy(xpath = "//button[contains(.,'OK')]")
	public static WebElement popupUserRemovedSuccessfullyOkButton;

	public AddorRemoveAccountRegistationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
