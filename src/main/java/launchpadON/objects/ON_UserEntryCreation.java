package launchpadON.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class ON_UserEntryCreation extends LoadableComponent<ON_UserEntryCreation> {

	// User Elements
	@FindBy(id = "ChkLocked")
	public static WebElement userlockedCheckBox;

	@FindBy(id = "UserID")
	public static WebElement userID;

	@FindBy(id = "First_Name")
	public static WebElement userFirstNameText;

	@FindBy(id = "Last_Name")
	public static WebElement userLastNameText;

	@FindBy(id = "User_Phone")
	public static WebElement userPhoneNumberText;

	@FindBy(id = "User_Street1")
	public static WebElement userAddress1Text;

	// @FindBy(id = "User_Street2")
	// public static WebElement userAddress2Text;

	@FindBy(id = "User_City")
	public static WebElement userCityText;

	@FindBy(id = "User_Province")
	public static WebElement userProvinceText;

	@FindBy(id = "User_PostalCode")
	public static WebElement userPostalCodeText;

	@FindBy(id = "Description")
	public static WebElement userDescriptionText;

	@FindBy(id = "ExpiryDate")
	public static WebElement userExpiryDateText;

	@FindBy(id = "NewPassword")
	public static WebElement userNewPasswordText;

	@FindBy(id = "txtPwdconfirm")
	public static WebElement userConfirmedPasswordText;

	// Manage Link
	@FindBy(id = "btnAttributesView")
	public static WebElement userAttributeLink;

	@FindBy(id = "btnProfilesView")
	public static WebElement userProfilesLink;

	@FindBy(id = "btnProvidersView")
	public static WebElement userProvidersLink;

	// control button
	@FindBy(id = "btnCancel")
	public static WebElement userCancelButton;

	@FindBy(id = "btnSave")
	public static WebElement userSaveButton;

	@FindBy(id = "btnDelete")
	public static WebElement userDeleteButton;

	// User Profile Elements
	@FindBy(id = "Organization")
	public static WebElement userOrganziationDropDown;

	@FindBy(id = "Location")
	public static WebElement userLocationDropDown;

	@FindBy(id = "OrganizationUnit")
	public static WebElement userOrganizationUnitDropDown;

	@FindBy(id = "UserRole")
	public static WebElement userRoleDropDown;

	@FindBy(id = "btnProfilesHide")
	public static WebElement userProfileCloseButton;

	@FindBy(id = "btnProfilePrintInbox")
	public static WebElement userProfilePrintButton;

	@FindBy(id = "btnProfileAdd")
	public static WebElement userProfileAddButton;

	@FindBy(id = "btnProfileRemove")
	public static WebElement userProfileRemoveButton;

	// User Delegation Elements
	@FindBy(id = "ProviderOrganization")
	public static WebElement userProviderOrganizationDropDown;

	@FindBy(id = "ProviderLocation")
	public static WebElement userProviderLocationDropDown;

	@FindBy(id = "ProviderOrganizationUnit")
	public static WebElement userProviderOrganizationUnitDropDown;

	@FindBy(id = "ProviderIDInput")
	public static WebElement userProviderIDText;

	@FindBy(id = "btnProviderAdd")
	public static WebElement userProviderAddButton;

	// PageFactory
	WebDriver driver = null;

	public ON_UserEntryCreation(WebDriver driver) {
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
	public static void FillUserInformation(String[] rowData) throws Exception {

		// String[] rowData = XLHandler.readexcel(2, 1, "testdata2.xlsx"); // get
		// testdata from sheet

		userFirstNameText.clear();
		userFirstNameText.sendKeys(rowData[1]);

		userLastNameText.clear();
		userLastNameText.sendKeys(rowData[2]);

		userPhoneNumberText.clear();
		userPhoneNumberText.sendKeys(rowData[3]);

		userAddress1Text.clear();
		userAddress1Text.sendKeys(rowData[4]);

		userCityText.clear();
		userCityText.sendKeys(rowData[5]);

		userProvinceText.clear();
		userProvinceText.sendKeys(rowData[6]);

		userPostalCodeText.clear();
		userPostalCodeText.sendKeys(rowData[7]);

		userDescriptionText.clear();
		userDescriptionText.sendKeys(rowData[8]);

		userExpiryDateText.clear();
		userExpiryDateText.sendKeys(rowData[9]);

		userNewPasswordText.clear();
		userNewPasswordText.sendKeys(rowData[10]);

		userConfirmedPasswordText.clear();
		userConfirmedPasswordText.sendKeys(rowData[11]);

	}

	// Fill up user profile information
	public static void FillUserProfile(String[] rowData) throws Exception {

		// String[] rowData = XLHandler.readexcel(2, 2, "testdata2.xlsx"); // get
		// testdata from sheet

		Select selectOrganziation = new Select(userOrganziationDropDown);
		selectOrganziation.selectByVisibleText(rowData[1]);

		Select selectLocation = new Select(userLocationDropDown);
		selectLocation.selectByVisibleText(rowData[2]);

		Select selectOrgUnit = new Select(userOrganizationUnitDropDown);
		selectOrgUnit.selectByVisibleText(rowData[3]);

		Select selectRole = new Select(userRoleDropDown);
		selectRole.selectByVisibleText(rowData[4]);

	}

	// Fill up user provider information
	public static void FillUserProvider(String[] rowData) throws Exception {

		// String[] rowData = XLHandler.readexcel(2, 2, "testdata2.xlsx"); // get
		// testdata from sheet

		userProviderIDText.clear();
		userProviderIDText.sendKeys(rowData[5]);

	}

	public void click(String element) {
		switch (element) {
		case "Save":
			userSaveButton.click();
			break;
		case "Cancel":
			userCancelButton.click();
			break;
		case "Delete":
			userDeleteButton.click();
			break;
		}
	}
}
