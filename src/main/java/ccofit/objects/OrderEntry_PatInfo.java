package ccofit.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderEntry_PatInfo {

	WebDriver driver;

	public static String oEntryForm = "requesterInformation-table";
	@FindBy(id = "requesterInformation-table")
	public static WebElement orderEntryForm;

	// 2-Patient Information
	public static By notePatInfo = By.xpath("//p[contains(text(),'Cancer Care Ontario')]");
	public static By patLastName = By.id("PatientLastName");
	public static By patMiddleName = By.id("PatientMiddleName");
	public static By patFirstName = By.id("PatientFirstName");
	public static By patDOBtb = By.id("PatientDateOfBirth");
	public static By patOHIPNumber = By.id("PatientOhipNumber");
	public static By patOHIPversion = By.id("PatientOhipVersion");
	public static By patSexMale = By.xpath("//label[@for='PatientSexId_1']");
	public static By patSexFemale = By.xpath("//label[@for='PatientSexId_2']");
	public static By patAddress = By.id("PatientAddress");
	public static By patCity = By.id("PatientCity");
	public static By patProvinceDD = By
			.xpath("//span[@aria-owns='PatientProvince_listbox']//span[@class='k-select']//span");
	public static By patPostalcode = By.id("PatientPostalCode");
	public static By patPrimPhNum = By.id("PatientPrimaryPhoneNumber");
	public static By patPhExt = By.id("PatientPhoneExtension");
	public static By patCellPhNum = By.id("PatientCellPhoneNumber");
	public static By typeWork = By.xpath("// label[@for='PatientPhoneTypeId_1']");
	public static By typeHome = By.xpath("// label[@for='PatientPhoneTypeId_2']");
	public static By typeCell = By.xpath("// label[@for='PatientPhoneTypeId_3']");

	public static By cancelBtn = By.id("btnCancel");
	public static By mergeBtn = By.id("btnMerge");
	public static By saveBtn = By.id("btnSave");
	public static By saveProbQBtn = By.id("btnSaveProblemQueue");
	public static By saveKittinBtn = By.id("btnSaveKitting");

	public static By errorMsg = By.id("error-message-area");
	public static By cancelErrMsgBtn = By.id("btCancleErrorMessagePopup");

	public OrderEntry_PatInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
