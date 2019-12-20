package bclis.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;

public class BCLIS_PatientSearchPage extends LoadableComponent<BCLIS_PatientSearchPage> {

	@FindBy(name = "selectProvince")
	public WebElement provinceDropdown;

	@FindBy(id = "inputHealthCardNumber")
	public WebElement healthCardNumberTextbox;

	@FindBy(id = "last_name")
	public WebElement lastNameTextbox;

	@FindBy(id = "first_name")
	public WebElement firstNameTextbox;

	@FindBy(id = "inputDOB")
	public WebElement dateOfBirthTextbox;

	@FindBy(id = "phone_number")
	public WebElement phoneNumberTextbox;

	@FindBy(id = "order_number")
	public WebElement orderNumberTextbox;

	@FindBy(id = "search")
	public WebElement searchButton;

	@FindBy(xpath = "//table[@role='grid' and @class='k-selectable']//td[1]")
	public WebElement firstSearchedPatient;

	@FindBy(id = "addPatientButton")
	public WebElement addPatientButton;

	@FindBy(xpath = "//table[@role='grid']//td/b")
	public WebElement patientResultRow;

	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement cancelButton;

	WebDriver driver = null;

	public BCLIS_PatientSearchPage(WebDriver driver) {
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
	 * DESCRIPTION: searches patient with health card number PARAMETERS: health card
	 * number RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchPatientWithHealthCardNumber(String healthCardNumber, BCLIS_PatientSearchPage patientSearchPage)
			throws Exception {
		try {
			CommonFunctions.waitandClear(healthCardNumberTextbox, 20);

			healthCardNumberTextbox.sendKeys(healthCardNumber);
			searchButton.click();
			// wait and check for patient in result
			return patientSearchPage.searchResultDisplayed(healthCardNumber);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: select province and searches patient with health card number
	 * PARAMETERS: health card number RETURNS: void AUTHOR: Bhavna Karanjekar
	 * MODIFIED BY:
	 */
	public boolean selectProvinceAndSearchPatientWithHealthCardNumber(String province, String healthCardNumber,
			BCLIS_PatientSearchPage patientSearchPage) throws Exception {
		try {

			CommonFunctions.waitandClear(healthCardNumberTextbox, 20);
			Select selProvince = new Select(provinceDropdown);
			selProvince.selectByVisibleText(province);

			healthCardNumberTextbox.sendKeys(healthCardNumber);
			searchButton.click();
			// wait and check for patient in result
			return patientSearchPage.searchResultDisplayed(healthCardNumber);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: searches patient with name and DOB PARAMETERS: lastName, first
	 * name and date of birth RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchPatientWithNameAndDOB(String lastName, String firstName, String dateOfBirth) throws Exception {
		try {
			CommonFunctions.waitandClear(healthCardNumberTextbox, 20);

			CommonFunctions.waitandClear(lastNameTextbox, 20);
			lastNameTextbox.sendKeys(lastName);

			CommonFunctions.waitandClear(firstNameTextbox, 20);
			firstNameTextbox.sendKeys(firstName);

			CommonFunctions.waitandClear(dateOfBirthTextbox, 20);
			dateOfBirthTextbox.sendKeys(dateOfBirth);

			searchButton.click();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * DESCRIPTION: searches patient with order number PARAMETERS: order number
	 * RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public void searchPatientWithOrderNumber(String orderNumber) throws Exception {
		CommonFunctions.waitandClear(orderNumberTextbox, 20);
		orderNumberTextbox.sendKeys(orderNumber);
		searchButton.click();
	}

	/**
	 * DESCRIPTION: checks if patient is found PARAMETERS: health card number
	 * RETURNS: true if patient found AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchResultDisplayed(String healthCardNumber) {
		try {
			Thread.sleep(3000);
			System.out.println("Result contains HC:" + patientResultRow.getText().contains(healthCardNumber));
			return patientResultRow.getText().contains(healthCardNumber);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * DESCRIPTION: gets count of matching search result PARAMETERS: first name,
	 * last name, date of birth RETURNS: count of matching results AUTHOR: Bhavna
	 * Karanjekar MODIFIED BY:
	 */
	public int countSearchResultDisplayed(String lastName, String firstName, String dateOfBirth) {
		try {
			Thread.sleep(3000);
			String query = lastName + " " + firstName + " " + dateOfBirth;
			return driver.findElements(By.xpath("//a[contains(text(),'" + query + "')]")).size();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	/**
	 * DESCRIPTION: selects the first patient in the result PARAMETERS: RETURNS:
	 * void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean selectFirstPatient(BCLIS_PatientDemographicsPage patientDemographicsPage) {
		try {
			System.out.println("Selecting first patient");
			Thread.sleep(3000);
			// CommonFunctions.waitandClick(firstSearchedPatient, 20);
			firstSearchedPatient.click();
			System.out.println("Selected first patient");
			// wait and check for patient demographics page
			return CommonFunctions.waitForVisiblity(patientDemographicsPage.confirmPatientButton, 20);
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: clicks add patient button PARAMETERS: RETURNS: void AUTHOR:
	 * Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean addPatient(BCLIS_PatientDemographicsPage patientDemographicsPage) throws Exception {
		try {
			CommonFunctions.waitandClick(addPatientButton, 20);
			if (CommonFunctions.waitForVisiblity(patientDemographicsPage.provinceDropdown, 20))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean cancel(BCLIS_MainMenuPage mainMenuPage) {
		try {
			CommonFunctions.waitandClick(cancelButton, 20);
			// wait and check for main menu page
			return CommonFunctions.waitForVisiblity(mainMenuPage.historicalAccessionsIcon, 20);
		} catch (Exception e) {
			return false;
		}

	}

}