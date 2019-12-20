package ccofit.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderEntry_ReqInfo {

	WebDriver driver;

	public static String oEntryForm = "requesterInformation-table";
	@FindBy(id = "requesterInformation-table")
	public static WebElement orderEntryForm;

	// 1-Requester Information
	// Requester Type-radio buttons
	public static String rtPhysician = "//label[@for='RequesterTypeId_1']";
	public static By rbPhysician = By.xpath("//label[@for='RequesterTypeId_1']");
	@FindBy(xpath = "//label[@for='RequesterTypeId_1']")
	public static WebElement radPhysician;

	public static String rtNurPractitioner = "//table[@id='requesterInformation-table']//tr[2]//span[3]";
	public static By rbNursePract = By.xpath("//label[@for='RequesterTypeId_2']");
	@FindBy(xpath = "//table[@id='requesterInformation-table']//tr[2]//span[3]")
	public static WebElement radNursePract;

	public static String rtMobCoach = "//label[@for='RequesterTypeId_3']";
	public static By rbMobileCoach = By.xpath("//label[@for='RequesterTypeId_3']");
	@FindBy(xpath = "//table[@id='requesterInformation-table']//tr[2]//span[4]")
	public static WebElement radMobileCoach;

	public static String rtTelHealth = "//label[@for='RequesterTypeId_4']";
	public static By rbTeleHealth = By.xpath("//label[@for='RequesterTypeId_4']");
	@FindBy(xpath = "//table[@id='requesterInformation-table']//tr[2]//span[5]")
	public static WebElement radTeleHealth;

	// textBoxes
	public static String tbmobCoachId = "//input[@id='MobileCoachId']";
	public static By mobileCoachId = By.id("MobileCoachId");
	@FindBy(id = "MobileCoachId")
	public static WebElement mobCoachId;

	public static String tbCpsoNum = "//input[@id='CpsoCnoNumber']";
	public static By cpsoNumber = By.id("CpsoCnoNumber");
	@FindBy(xpath = "//input[@id='CpsoCnoNumber']")
	public static WebElement cpsoNum;

	public static String tbOhipBilling = "//input[@id='OhipBillNumber']";
	public static By ohipBillingNumber = By.id("OhipBillNumber");
	@FindBy(xpath = "//input[@id='OhipBillNumber']")
	public static WebElement ohipBillingNum;

	// requester demographic information
	public static String tbRlastName = "//input[@id='RequesterLastName']";
	public static By reqLastName = By.id("RequesterLastName");
	@FindBy(xpath = "//input[@id='RequesterLastName']")
	public static WebElement reqLN;

	public static String tbRmiddleName = "//input[@id='RequesterMiddleName']";
	public static By reqMiddleName = By.id("RequesterMiddleName");
	@FindBy(xpath = "//input[@id='RequesterMiddleName']")
	public static WebElement reqMN;

	public static String tbRfirstName = "//input[@id='RequesterFirstName']";
	public static By reqFirstName = By.id("RequesterFirstName");
	@FindBy(xpath = "//input[@id='RequesterFirstName']")
	public static WebElement reqFN;

	public static String tbOffAdd = "//input[@id='RequesterOfficeAddress']";
	public static By reqOfficeAddress = By.id("RequesterOfficeAddress");
	@FindBy(xpath = "//input[@id='RequesterOfficeAddress']")
	public static WebElement reqOffAdd;

	public static String tbOffCity = "//input[@id='RequesterOfficeCity']";
	public static By reqOfficeCity = By.id("RequesterOfficeCity");
	@FindBy(xpath = "//input[@id='RequesterOfficeCity']")
	public static WebElement reqOffCity;

	public static String provDD = "//span[@aria-owns='RequesterOfficeProvince_listbox']//span[@class='k-select']//span";
	public static By reqProvinceDD = By
			.xpath("//span[@aria-owns='RequesterOfficeProvince_listbox']//span[@class='k-select']//span");
	@FindBy(xpath = "//span[@aria-owns='RequesterOfficeProvince_listbox']//span[@class='k-select']//span")
	public static WebElement reqProvDD;

	public static String tbPostalCode = "//input[@id='RequesterOfficePostalCode']";
	public static By reqPostalCode = By.id("RequesterOfficePostalCode");
	@FindBy(xpath = "//input[@id='RequesterOfficePostalCode']")
	public static WebElement reqPostCode;

	public static String tbRoffPhone = "//input[@id='RequesterOfficePhoneNumber']";
	public static By reqOfficePhone = By.id("RequesterOfficePhoneNumber");
	@FindBy(xpath = "//input[@id='RequesterOfficePhoneNumber']")
	public static WebElement reqOffPhone;

	public static String tbRfaxNum = "//input[@id='RequesterOfficeFaxNumber']";
	public static By reqFaxNumber = By.id("RequesterOfficeFaxNumber");
	@FindBy(xpath = "//input[@id='RequesterOfficeFaxNumber']")
	public static WebElement reqFaxNum;

	public static By copyToFirstName = By.id("CopytoFirstName");
	public static By copyToLastName = By.id("CopytoLastName");
	public static By copyToMiddleName = By.id("CopytoMiddleName");
	public static By copyToOfficeAddress = By.id("CopytoOfficeAddress");
	public static By copyToOfficePhone = By.id("CopytoOfficePhoneNumber");
	public static By copyToOfficeFax = By.id("CopytoOfficeFaxNumber");

	public static By cancelBtn = By.id("btnCancel");
	public static By mergeBtn = By.id("btnMerge");
	public static By saveBtn = By.id("btnSave");
	public static By saveProbQBtn = By.id("btnSaveProblemQueue");
	public static By saveKittinBtn = By.id("btnSaveKitting");

	public static By errorMsg = By.id("error-message-area");
	public static By cancelErrMsgBtn = By.id("btCancleErrorMessagePopup");

	public OrderEntry_ReqInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
