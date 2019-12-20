
package bclis.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonFunctions;

public class BCLIS_PatientDemographicsPage extends LoadableComponent<BCLIS_PatientDemographicsPage> {

	@FindBy(name = "selectHealthCardProv")
	public WebElement provinceDropdown;

	@FindBy(id = "card_number")
	public WebElement healthCardNumberTextbox;

	@FindBy(id = "inputLastName")
	public WebElement lastNameTextbox;

	@FindBy(id = "inputFirstName")
	public WebElement firstNameTextbox;

	@FindBy(id = "inputMiddleName")
	public WebElement middleNameTextbox;

	@FindBy(id = "inputGender")
	public WebElement genderDropdown;

	@FindBy(id = "inputDOB")
	public WebElement dateOfBirthTextbox;

	@FindBy(id = "inputAddress1")
	public WebElement address1Textbox;

	@FindBy(id = "inputAddress2")
	public WebElement address2Textbox;

	@FindBy(id = "inputAddressCity")
	public WebElement cityTextbox;

	@FindBy(id = "state")
	public WebElement stateDropdown;

	@FindBy(id = "inputPostalZip")
	public WebElement postalZipTextbox;

	@FindBy(name = "country")
	public WebElement countryDropdown;

	@FindBy(id = "primary_phone")
	public WebElement primaryPhoneTextbox;

	@FindBy(id = "secondary_phone")
	public WebElement secondaryPhoneTextbox;

	@FindBy(id = "third_phone")
	public WebElement otherPhoneTextbox;

	@FindBy(name = "submit")
	public WebElement confirmPatientButton;

	@FindBy(id = "tabNotes")
	public WebElement patientNotesTab;

	@FindBy(id = "tabStandingOrders")
	public WebElement standingOrdersTab;

	@FindBy(id = "tabHistoricalAccessions")
	public WebElement historicalAccessionsTab;

	@FindBy(xpath = "//span[contains(text(),'Patient Notes ')]/span")
	public WebElement notesCount;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement successMessage;

	@FindBy(id = "new_accession_btn")
	public WebElement newAccessionButton;

	WebDriver driver = null;

	public BCLIS_PatientDemographicsPage(WebDriver driver) {
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

	/**
	 * DESCRIPTION: Edits patient details and confirms patient PARAMETERS: patient
	 * details RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean editPatientDetailsAndConfirmPatient(String province, String lastName, String firstName,
			String middleName, String gender, String dateofbirth, String address1, String address2, String city,
			String state, String postalZip, String country, String primaryPhone, String secondaryPhone,
			String otherPhone) throws Exception {

		// change the patient details and then confirm patient

		try {
			CommonFunctions.waitForVisiblity(provinceDropdown, 20);

			if (!province.equals("No Change")) {
				Select selectProvince = new Select(provinceDropdown);
				selectProvince.selectByVisibleText(province);
			}

			if (!lastName.equals("No Change")) {
				lastNameTextbox.clear();
				lastNameTextbox.sendKeys(lastName);
			}

			if (!firstName.equals("No Change")) {
				firstNameTextbox.clear();
				firstNameTextbox.sendKeys(firstName);
			}

			if (!middleName.equals("No Change")) {
				middleNameTextbox.clear();
				middleNameTextbox.sendKeys(middleName);
			}

			if (!gender.equals("No Change")) {
				Select selectGender = new Select(genderDropdown);
				selectGender.selectByVisibleText(gender);
			}

			if (!dateofbirth.equals("No Change")) {
				dateOfBirthTextbox.clear();
				dateOfBirthTextbox.sendKeys(dateofbirth);

			}
			if (!address1.equals("No Change")) {
				address1Textbox.clear();
				address1Textbox.sendKeys(address1);
			}

			if (!address2.equals("No Change")) {
				address2Textbox.clear();
				address2Textbox.sendKeys(address2);
			}

			if (!city.equals("No Change")) {
				cityTextbox.clear();
				cityTextbox.sendKeys(city);
			}

			if (!state.equals("No Change")) {
				Select selectState = new Select(stateDropdown);
				selectState.selectByVisibleText(state);
			}

			if (!postalZip.equals("No Change")) {
				postalZipTextbox.clear();
				postalZipTextbox.sendKeys(postalZip);
			}

			if (!country.equals("No Change")) {
				Select selectCountry = new Select(countryDropdown);
				selectCountry.selectByVisibleText(country);
			}

			if (!primaryPhone.equals("No Change")) {
				primaryPhoneTextbox.clear();
				primaryPhoneTextbox.sendKeys(primaryPhone);
			}

			if (!secondaryPhone.equals("No Change")) {
				secondaryPhoneTextbox.clear();
				secondaryPhoneTextbox.sendKeys(secondaryPhone);
			}

			if (!otherPhone.equals("No Change")) {
				otherPhoneTextbox.clear();
				otherPhoneTextbox.sendKeys(otherPhone);
			}

			confirmPatientButton.click();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: confirm patient without changing details PARAMETERS: RETURNS:
	 * void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean confirmPatientAsIs() throws Exception {
		try {
			CommonFunctions.waitandClick(confirmPatientButton, 5);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: hovers over the patient notes tab and clicks PARAMETERS:
	 * RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean goToPatienNotes() throws Exception {
		try {
			CommonFunctions.waitForVisiblity(patientNotesTab, 20);
			new Actions(driver).moveToElement(patientNotesTab).build().perform();
			Thread.sleep(3000);

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.attributeContains(patientNotesTab, "class", "k-state-hover"));
			Thread.sleep(3000);
			patientNotesTab.click();
			Thread.sleep(3000);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: hovers over the standing Orders tab and clicks PARAMETERS:
	 * RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean goToStandingOrder(BCLIS_StandingOrdersPage standingOrdersPage) throws Exception {
		try {
			Thread.sleep(3000);
			// CommonFunctions.waitForVisiblity(standingOrdersTab, 20); //does not work
			new Actions(driver).moveToElement(standingOrdersTab).build().perform();

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.attributeContains(standingOrdersTab, "class", "k-state-hover"));
			standingOrdersTab.click();
			return CommonFunctions.waitForVisiblity(standingOrdersPage.Order, 20);
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: clicks New accession button PARAMETERS: RETURNS: void AUTHOR:
	 * Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean goToNewAccession(BCLIS_NewAccessionPage newAccessionPage) {

		try {
			CommonFunctions.waitandClick(newAccessionButton, 20);

			// wait and check for Edit Accession page
			return (CommonFunctions.waitForVisiblity(newAccessionPage.enterTestButton, 20)
					&& newAccessionPage.headerText.getText().equals("Edit Accession"));

		} catch (Exception e) {
			return false;
		}

	}

	public boolean goToNewAccession() {

		try {
			CommonFunctions.waitandClick(newAccessionButton, 20);

			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: fills in details for a new patient PARAMETERS: all patient
	 * details RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean addNewPatient(String province, String healthCardNumber, String lastName, String firstName,
			String middleName, String gender, String dob, String address1, String address2, String city, String state,
			String postalZip, String country, String primaryPhone, String secondaryPhone, String otherPhone)
			throws Exception {
		try {
			CommonFunctions.waitForVisiblity(provinceDropdown, 20);

			if (!province.equals("No Change")) {
				Select selectProvince = new Select(provinceDropdown);
				selectProvince.selectByVisibleText(province);
			}

			if (!healthCardNumber.equals("No Change")) {
				healthCardNumberTextbox.clear();
				healthCardNumberTextbox.sendKeys(healthCardNumber);
			}

			if (!lastName.equals("No Change")) {
				lastNameTextbox.clear();
				lastNameTextbox.sendKeys(lastName);
			}

			if (!firstName.equals("No Change")) {
				firstNameTextbox.clear();
				firstNameTextbox.sendKeys(firstName);
			}

			if (!middleName.equals("No Change")) {
				middleNameTextbox.clear();
				middleNameTextbox.sendKeys(middleName);
			}

			if (!gender.equals("No Change")) {
				Select selectGender = new Select(genderDropdown);
				selectGender.selectByVisibleText(gender);
			}

			if (!dob.equals("No Change")) {
				dateOfBirthTextbox.clear();
				dateOfBirthTextbox.sendKeys(dob);
			}

			if (!address1.equals("No Change")) {
				address1Textbox.clear();
				address1Textbox.sendKeys(address1);
			}

			if (!address2.equals("No Change")) {
				address2Textbox.clear();
				address2Textbox.sendKeys(address2);
			}

			if (!city.equals("No Change")) {
				cityTextbox.clear();
				cityTextbox.sendKeys(city);
			}

			if (!state.equals("No Change")) {
				Select selectState = new Select(stateDropdown);
				selectState.selectByVisibleText(state);
			}

			if (!postalZip.equals("No Change")) {
				postalZipTextbox.clear();
				postalZipTextbox.sendKeys(postalZip);
			}

			if (!country.equals("No Change")) {
				Select selectCountry = new Select(countryDropdown);
				selectCountry.selectByVisibleText(country);
			}

			if (!primaryPhone.equals("No Change")) {
				primaryPhoneTextbox.clear();
				primaryPhoneTextbox.sendKeys(primaryPhone);
			}

			if (!secondaryPhone.equals("No Change")) {
				secondaryPhoneTextbox.clear();
				secondaryPhoneTextbox.sendKeys(secondaryPhone);
			}

			if (!otherPhone.equals("No Change")) {
				otherPhoneTextbox.clear();
				otherPhoneTextbox.sendKeys(otherPhone);
			}

			confirmPatientButton.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: verifies success message on patient confirmation PARAMETERS:
	 * RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public String verifySuccessMessage() throws Exception {
		CommonFunctions.waitForVisiblity(successMessage, 20);
		return successMessage.getText();
	}

	/**
	 * DESCRIPTION: gets the count of previously added notes PARAMETERS: RETURNS:
	 * count of notes as seen on the notes tab AUTHOR: Bhavna Karanjekar MODIFIED
	 * BY:
	 */
	public int getNotesCount() throws Exception {
		CommonFunctions.waitForVisiblity(notesCount, 20);
		return Integer.parseInt(notesCount.getText());
	}
}
