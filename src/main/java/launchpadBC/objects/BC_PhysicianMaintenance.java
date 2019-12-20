package launchpadBC.objects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class BC_PhysicianMaintenance extends LoadableComponent<BC_PhysicianMaintenance> {

	// User Elements
	@FindBy(id = "Title")
	public static WebElement phyTitle;

	@FindBy(id = "First_Name")
	public static WebElement phyFirstNameText;

	@FindBy(id = "Middle_Name")
	public static WebElement phyMidNameText;

	@FindBy(id = "Last_Name")
	public static WebElement phyLastNameText;

	@FindBy(id = "Specialty")
	public static WebElement phySpecialtyDropdown;

	@FindBy(id = "Address1")
	public static WebElement phyAddress1Text;

	// @FindBy(id = "Address2")
	// public WebElement phyAddress2Text;

	@FindBy(id = "City")
	public static WebElement phyCityText;

	@FindBy(id = "StateOrProvince")
	public static WebElement phyStateOrProvince;

	@FindBy(id = "Country")
	public static WebElement phyCountry;

	@FindBy(id = "ZipPostalCode")
	public static WebElement phyZipPostalCode;

	// Manage Link
	@FindBy(id = "btnAttributesView")
	public static WebElement phyAttributeLink;

	@FindBy(id = "btnPhoneNumbersView")
	public static WebElement phyPhoneNumberLink;

	@FindBy(id = "btnIdentifiersView")
	public static WebElement phyIdentifierLink;

	// control button
	@FindBy(id = "btnCancel")
	public static WebElement phyCancelButton;

	@FindBy(id = "btnSave")
	public static WebElement phySaveButton;

	@FindBy(id = "btnDelete")
	public static WebElement phyDeleteButton;

	// Physician Attributes Elements
	@FindBy(id = "AttributeType")
	public static WebElement phyAttributeType;

	@FindBy(id = "AttributeOption")
	public static WebElement phyAttributeOption;

	@FindBy(id = "btnAttributesHide")
	public static WebElement phyAttributeClosebtn;

	@FindBy(id = "btnAttributeAdd")
	public static WebElement phyAttributeAddbtn;

	@FindBy(id = "btnAttributeRemove")
	public static WebElement phyAttributeRemovebtn;

	@FindBy(id = "btnAttributeEdit")
	public static WebElement phyAttributeEditbtn;

	// Physician Phone number elements
	@FindBy(id = "PhoneType")
	public static WebElement phyPhoneType;

	@FindBy(id = "Number")
	public static WebElement phyNumber;

	@FindBy(id = "btnPhoneNumbersHide")
	public static WebElement phyPhoneNumberClosebtn;

	@FindBy(id = "btnPhoneAdd")
	public static WebElement phyPhoneAddbtn;

	@FindBy(id = "btnPhoneRemove")
	public static WebElement phyPhoneRemovebtn;

	// Physician Identifiers
	@FindBy(id = "AssigningAuthority")
	public static WebElement phyAssigningAuthority;

	@FindBy(id = "IdType")
	public static WebElement phyIdType;

	@FindBy(id = "Id")
	public static WebElement phyId;

	@FindBy(id = "btnIdAdd")
	public static WebElement phybtnIdAdd;

	// PageFactory
	WebDriver driver = null;

	public BC_PhysicianMaintenance(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	@Override
	protected void isLoaded() throws Error {

	}

	@Override
	protected void load() {

	}

	// Fill up user information
	public static void FillProviderInformation(String[] rowData) throws Exception {

		Select phyTitleIns = new Select(phyTitle);
		phyTitleIns.selectByVisibleText(rowData[1]);

		phyFirstNameText.clear();
		phyFirstNameText.sendKeys(rowData[2]);

		phyMidNameText.clear();
		phyMidNameText.sendKeys(rowData[3]);

		phyLastNameText.clear();
		phyLastNameText.sendKeys(rowData[4]);

		Select phySpecialty = new Select(phySpecialtyDropdown);
		phySpecialty.selectByVisibleText(rowData[5]);

		phyAddress1Text.clear();
		phyAddress1Text.sendKeys(rowData[6]);

		phyCityText.clear();
		phyCityText.sendKeys(rowData[7]);

		Select phyStateOrProvinceIns = new Select(phyStateOrProvince);
		phyStateOrProvinceIns.selectByVisibleText(rowData[8]);

		Select phyCountryIns = new Select(phyCountry);
		phyCountryIns.selectByVisibleText(rowData[9]);

		phyZipPostalCode.clear();
		phyZipPostalCode.sendKeys(rowData[10]);

	}

	// Add provider Identifiers
	public static void FillProviderIdentifiers() throws Exception {

		String AssigningAuthority = "";

		String IdType = "Provider number";
		String IdType1 = "Doctor";

		// Random to create doctor ID
		Random ran = new Random();
		int Idint = (100000 + ran.nextInt(999999));
		String Id = Integer.toString(Idint);

		AssigningAuthority = "British Columbia provincial government";
		Select AssigningAuthoritydroplist = new Select(phyAssigningAuthority);
		AssigningAuthoritydroplist.selectByVisibleText(AssigningAuthority);

		Select IdTypedroplist = new Select(phyIdType);
		IdTypedroplist.selectByVisibleText(IdType);

		phyId.clear();
		phyId.sendKeys(Id);

		// Click Add button to add Identifier
		phybtnIdAdd.click();

		String[] arr = new String[5];
		arr[0] = "Clinical & Systems Transformation Cardiology";
		arr[1] = "BC Biomedical";
		arr[2] = "BC Cancer Agency";
		arr[3] = "BC Cancer Agency (PAP)";
		arr[4] = "BC Cancer Agency Transcription";

		int counter = 0;

		while (counter < 5) { // 5
			AssigningAuthority = arr[counter];

			Select AssigningAuthoritydroplist1 = new Select(phyAssigningAuthority);
			AssigningAuthoritydroplist1.selectByVisibleText(AssigningAuthority);

			Select IdTypedroplist1 = new Select(phyIdType);
			IdTypedroplist1.selectByVisibleText(IdType1);

			phyId.clear();
			phyId.sendKeys(Id);

			// Click Add button to add Identifier
			phybtnIdAdd.click();

			counter++;

		}

	}

	// Add ALL provider Identifiers
	public static void FillAllProviderIdentifiers() throws Exception {

		String AssigningAuthority = "";

		String IdType = "Provider number";
		String IdType1 = "Doctor";

		// Random to create doctor ID
		Random ran = new Random();
		int Idint = (100000 + ran.nextInt(999999));
		String Id = Integer.toString(Idint);

		AssigningAuthority = "British Columbia provincial government";
		Select AssigningAuthoritydroplist = new Select(phyAssigningAuthority);
		AssigningAuthoritydroplist.selectByVisibleText(AssigningAuthority);

		Select IdTypedroplist = new Select(phyIdType);
		IdTypedroplist.selectByVisibleText(IdType);

		phyId.clear();
		phyId.sendKeys(Id);

		// Click Add button to add Identifier
		phybtnIdAdd.click();

		String[] arr = new String[48];
		arr[0] = "Clinical & Systems Transformation Cardiology";
		arr[1] = "BC Biomedical";
		arr[2] = "BC Cancer Agency";
		arr[3] = "BC Cancer Agency (PAP)";
		arr[4] = "BC Cancer Agency Transcription";
		arr[5] = "BC Centre for Disease Control";
		arr[6] = "BC Childrens + Women's Hospital";
		arr[7] = "BC Newborn Screening Program";
		arr[8] = "BCCA Screening Program";
		arr[9] = "Canada national government";
		arr[10] = "CIRION";
		arr[11] = "Clinical & Systems Transformation Cardiology";
		arr[12] = "Clinical & Systems Transformation Medical Imaging";
		arr[13] = "Clinical & Systems Transformation Notifications";
		arr[14] = "Clinical & Systems Transformation Transcription";
		arr[15] = "College of Physicians and Surgeons of BC";
		arr[16] = "EVF Transcription";
		arr[17] = "FHA Medical Imaging";
		arr[18] = "Forensic Psychiatric Institute Transcription";
		arr[19] = "Fraser Health Authority";
		arr[20] = "Fraser Health Authority Transcription";
		arr[21] = "GR Baker Hospital";
		arr[22] = "LifeLabs";
		arr[23] = "Lions Gate Hospital Notifications";
		arr[24] = "MTE";
		arr[25] = "Novavita Laboratory";
		arr[26] = "PHSA Environmental Bacteriology";
		arr[27] = "PHSA Reportable Communicable Diseases";
		arr[28] = "PLR";
		arr[29] = "Powell River Hospital";
		arr[30] = "Powell River Hospital Transcription";
		arr[31] = "Providence Health Care";
		arr[32] = "Providence Health Care Transcription";
		arr[33] = "Provincial Health Services Ambulatory";
		arr[34] = "Provincial Health Services Transcription";
		arr[35] = "St Mary's Hospital-Sechelt";
		arr[36] = "St Marys Hospital-Sechelt Transcription";
		arr[37] = "St. Paul's Hospital Notifications";
		arr[38] = "The University Health Network";
		arr[39] = "Valley Medical Labs";
		arr[40] = "Vancouver Coastal - Sunset";
		arr[41] = "Vancouver Coastal Transcription";
		arr[42] = "Vancouver Island Health Authority";
		arr[43] = "VIHA Clinical Document";
		arr[44] = "VIHA Diagnostic Imaging";
		arr[45] = "VPP Laboratories";
		arr[46] = "VPP Notifications";
		arr[47] = "Vancouver Coastal - Sunset";

		int counter = 0;

		while (counter < 48) { // 5
			AssigningAuthority = arr[counter];

			Select AssigningAuthoritydroplist1 = new Select(phyAssigningAuthority);
			AssigningAuthoritydroplist1.selectByVisibleText(AssigningAuthority);

			Select IdTypedroplist1 = new Select(phyIdType);
			IdTypedroplist1.selectByVisibleText(IdType1);

			phyId.clear();
			phyId.sendKeys(Id);

			// Click Add button to add Identifier
			phybtnIdAdd.click();

			counter++;

		}

	}

}
