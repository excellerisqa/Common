package lars.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class LARS_PractitionersPage extends LoadableComponent<LARS_PractitionersPage> {

	@FindBy(id = "doctorWildcardLastNameInput")
	public WebElement lastnameTextbox;

	@FindBy(id = "doctorWildcardFirstNameInput")
	public WebElement firstnameTextbox;

	@FindBy(id = "doctorWildcardGo")
	public WebElement searchButton;

	@FindBy(xpath = "//div[contains(text(),'Provider')]/following::div[1]")
	public WebElement providerId;

	@FindBy(xpath = "//div[@class='doctorDetailTitle col-sm-5 col-md-5 col-lg-5 ng-binding']")
	public List<WebElement> addresses;

	@FindBy(xpath = "//span[text()='Doctor Names']")
	public WebElement doctorNamesTab;

	@FindBy(id = "doctorNameInput")
	public WebElement doctorNameTextbox;

	@FindBy(id = "doctorNameGo")
	public WebElement doctorNameSearchButton;

	@FindBy(xpath = "//span[text()='Provider Number']")
	public WebElement providerNumberTab;

	@FindBy(id = "doctorProviderInput")
	public WebElement providerTextbox;

	@FindBy(id = "doctorProviderGo")
	public WebElement providerSearchButton;

	@FindBy(id = "selectFeeOperations")
	public WebElement createEditPractitionerDropdown;

	@FindBy(id = "feeOperationGo")
	public WebElement goButton;

	@FindBy(id = "practitionerNumber")
	public WebElement practitionerNumberTextbox;

	@FindBy(id = "practitionerType")
	public WebElement practitionerTypeDropdown;

	@FindBy(id = "lastName")
	public WebElement lastNameOnPopupTextbox;

	@FindBy(id = "firstName")
	public WebElement firstNameOnPopupTextbox;

	@FindBy(id = "middleName")
	public WebElement middleNameOnPopupTextbox;

	@FindBy(id = "activeDate")
	public WebElement activeDateTextbox;

	@FindBy(id = "inactiveDate")
	public WebElement inactiveDateTextbox;

	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement submitButton;

	@FindBy(xpath = "//button[text()='Submit']/following-sibling::button")
	public WebElement closeButton;

	@FindBy(xpath = "//div[contains(text(),'LifeLabs Practitioners')]")
	public WebElement headerText;

	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//img[@src='/Content/images/spinner.gif']")
	public WebElement spinners;

	WebDriver driver = null;

	public LARS_PractitionersPage(WebDriver driver) {
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

	public boolean searchByLastnameAndVerify(String last) {

		try {

			spinnersChecking();
			CommonFunctions.waitandClear(lastnameTextbox, 10);
			lastnameTextbox.sendKeys(last);
			searchButton.click();
			spinnersChecking();
			boolean isFound = CommonFunctions.waitForVisiblity(By.xpath("//td[contains(text(),'" + last + "')]"), 20);
			// By.xpath("//div[contains(text(),'Payer')]/following::div[contains(text(),'" +
			// last + "')]"), 10);
			// if (isFound) {
			// System.out.println("Provider #: " + providerId.getText());
			// System.out.println("Addresses found: " + addresses.size());
			// }

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByFirstnameAndVerify(String first) {

		try {
			spinnersChecking();
			CommonFunctions.waitandClear(firstnameTextbox, 10);
			firstnameTextbox.sendKeys(first);
			searchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions.waitForVisiblity(By.xpath("//td[contains(text(),'" + first + "')]"), 20);
			// By.xpath("//div[contains(text(),'Payer')]/following::div[contains(text(),'" +
			// first + "')]"), 10);

			// if (isFound) {
			// System.out.println("Provider #: " + providerId.getText());
			// System.out.println("Addresses found: " + addresses.size());
			// }

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByLastAndFirstnameAndVerify(String last, String first) {

		try {
			spinnersChecking();
			CommonFunctions.waitandClear(firstnameTextbox, 10);
			lastnameTextbox.clear();
			lastnameTextbox.sendKeys(last);
			firstnameTextbox.sendKeys(first);
			searchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions.waitForVisiblity(By.xpath("//td[contains(text(),'" + first + "')]"), 20)
					&& CommonFunctions.waitForVisiblity(By.xpath("//td[contains(text(),'" + last + "')]"), 20);

			// "//div[contains(text(),'Payer')]/following::div[contains(text(),'" + last +
			// ", " + first + "')]"),
			// 10);

			// if (isFound) {
			// System.out.println("Provider #: " + providerId.getText());
			// System.out.println("Addresses found: " + addresses.size());
			// }

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToDoctorNamesTab() {

		try {
			Thread.sleep(5000);
			doctorNamesTab.click();
			return CommonFunctions.waitForVisiblity(doctorNameSearchButton, 10);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByDoctorNameAndVerify(String doctorName) {

		try {
			spinnersChecking();
			CommonFunctions.waitandClear(doctorNameTextbox, 10);
			doctorNameTextbox.sendKeys(doctorName);
			doctorNameSearchButton.click();
			spinnersChecking();

			// boolean isFound = CommonFunctions.waitForVisiblity(
			// By.xpath("//div[contains(text(),'Payer')]/following::div[contains(text(),'" +
			// doctorName + "')]"),
			// 10);
			boolean isFound = CommonFunctions
					.waitForVisiblity(By.xpath("//td[contains(text(),'" + doctorName.split(",")[0] + "')]"), 20);

			// if (isFound) {
			// System.out.println("Provider #: " + providerId.getText());
			// System.out.println("Addresses found: " + addresses.size());
			// }

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToProviderNumberTab() {

		try {
			Thread.sleep(5000);
			providerNumberTab.click();
			return CommonFunctions.waitForVisiblity(providerSearchButton, 10);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean searchByProviderNumberAndVerify(String providerNumber) {

		try {
			spinnersChecking();
			CommonFunctions.waitandClear(providerTextbox, 10);
			providerTextbox.sendKeys(providerNumber);
			providerSearchButton.click();
			spinnersChecking();

			boolean isFound = CommonFunctions
					.waitForVisiblity(By.xpath("//td[contains(text(),'" + providerNumber + "')]"), 20);

			// if (isFound) {
			// System.out.println("Provider #: " + providerId.getText());
			// System.out.println("Addresses found: " + addresses.size());
			// }

			return isFound;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean goToMenuPage(LARS_MenuPage menuPage) {

		try {
			// CommonFunctions.waitandClick(lifelabsLogo, 20);
			Thread.sleep(5000);
			lifelabsLogo.click();
			return menuPage.verifyOptionsAvailableOnMenuPage();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean createNewPractitioner(String number, String type, String lastname, String firstname,
			String middlename, String activedate, String inactivedate) {

		try {
			spinnersChecking();
			//CommonFunctions.waitandClear(firstnameTextbox, 30);

			Thread.sleep(1000);
			CommonFunctions.waitandClick(searchButton, 30);
			//searchButton.click();
			spinnersChecking();

			if (!(CommonFunctions.waitForVisiblity(createEditPractitionerDropdown, 10))) {
				System.out.println("Create Practitioner Dropdown not found.");
				return false;
			}

			Select selAddNewPractitioner = new Select(createEditPractitionerDropdown);
			selAddNewPractitioner.selectByVisibleText("Create New Practitioner");

			goButton.click();
			String newPractitionerNumber = "";

			// Enter New Practitioner data
			if (CommonFunctions.waitForVisiblity(practitionerNumberTextbox, 10)) {
				Random rand = new Random();
				newPractitionerNumber = String.valueOf(Integer.parseInt(number) + rand.nextInt(100));

				practitionerNumberTextbox.sendKeys(newPractitionerNumber);

				Select selType = new Select(practitionerTypeDropdown);
				selType.selectByVisibleText(type);
				Thread.sleep(2000);

				lastNameOnPopupTextbox.sendKeys(lastname);
				firstNameOnPopupTextbox.sendKeys(firstname);
				middleNameOnPopupTextbox.sendKeys(middlename);

				activeDateTextbox.sendKeys(getTodaysDatePlusDays(Integer.parseInt(activedate)));
				Thread.sleep(1000);
				inactiveDateTextbox.sendKeys(getTodaysDatePlusDays(Integer.parseInt(inactivedate)));
				Thread.sleep(4000);
				
				CommonFunctions.waitandClick(this.submitButton, 30);
				//submitButton.click();
				Thread.sleep(2000);
				// close the pop-up
				CommonFunctions.waitandClick(this.closeButton, 30);
				//closeButton.click();
				//lastNameOnPopupTextbox.sendKeys(Keys.ESCAPE);
				Thread.sleep(2000);

			} else {
				System.out.println("practitionerNumberTextbox is not visible");
				return false;
			}

			boolean isCreated = CommonFunctions.waitForVisiblity(goButton, 10)
					&& ObjectHelper.driver
							.findElement(
									By.xpath("//td[@class='ng-binding' and text()='" + newPractitionerNumber + "']"))
							.isDisplayed()
					&& ObjectHelper.driver
							.findElement(By.xpath("//td[@class='ng-binding' and text()='" + lastname + "']"))
							.isDisplayed()
					&& ObjectHelper.driver
							.findElement(By.xpath("//td[@class='ng-binding' and text()='" + firstname + "']"))
							.isDisplayed()
					&& ObjectHelper.driver
							.findElement(By.xpath("//td[@class='ng-binding' and text()='" + middlename + "']"))
							.isDisplayed();

			return isCreated;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updatePractitioner(String number, String type, String lastname, String firstname, String middlename,
			String activedate, String inactivedate) {

		try {
			CommonFunctions.waitandClear(firstnameTextbox, 10);

			searchButton.click();

			if (!(CommonFunctions.waitForVisiblity(createEditPractitionerDropdown, 10))) {
				System.out.println("Create Practitioner Dropdown not found.");
				return false;
			}

			Select selAddNewPractitioner = new Select(createEditPractitionerDropdown);
			selAddNewPractitioner.selectByVisibleText("Update Practitioner");

			// select practitioner here by last name
			ObjectHelper.driver.findElement(By.xpath("//td[@class='ng-binding' and text()='" + lastname + "']"))
					.click();

			goButton.click();

			// String newPractitionerNumber = "";

			// Enter New Practitioner data
			if (CommonFunctions.waitForVisiblity(firstNameOnPopupTextbox, 10)) {
				// Random rand = new Random();
				// newPractitionerNumber = String.valueOf(Integer.parseInt(number) +
				// rand.nextInt(100));

				// practitionerNumberTextbox.sendKeys(newPractitionerNumber);

				Select selType = new Select(practitionerTypeDropdown);
				selType.selectByVisibleText(type);
				Thread.sleep(2000);

				// lastNameOnPopupTextbox.sendKeys(lastname);
				firstNameOnPopupTextbox.clear();
				firstNameOnPopupTextbox.sendKeys(firstname);

				middleNameOnPopupTextbox.clear();
				middleNameOnPopupTextbox.sendKeys(middlename);

				activeDateTextbox.clear();
				activeDateTextbox.sendKeys(getTodaysDatePlusDays(Integer.parseInt(activedate)));

				inactiveDateTextbox.clear();
				inactiveDateTextbox.sendKeys(getTodaysDatePlusDays(Integer.parseInt(inactivedate)));

				Thread.sleep(2000);
				//submitButton.click();
				CommonFunctions.waitandClick(this.submitButton, 30);
				Thread.sleep(2000);
				// close the pop-up
				// closeButton.click();
				CommonFunctions.waitandClick(this.closeButton, 30);
				//lastNameOnPopupTextbox.sendKeys(Keys.ESCAPE);

			} else {
				System.out.println("practitionerNumberTextbox is not visible");
				return false;
			}

			boolean isUpdated = CommonFunctions.waitForVisiblity(goButton, 10)

					&& ObjectHelper.driver
							.findElement(By.xpath("//td[@class='ng-binding' and text()='" + lastname + "']"))
							.isDisplayed()
					&& ObjectHelper.driver
							.findElement(By.xpath("//td[@class='ng-binding' and text()='" + firstname + "']"))
							.isDisplayed()
					&& ObjectHelper.driver
							.findElement(By.xpath("//td[@class='ng-binding' and text()='" + middlename + "']"))
							.isDisplayed();

			return isUpdated;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public String getTodaysDatePlusDays(int plusDays) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, plusDays);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return String.valueOf(dateFormat.format(cal.getTime()));
	}
	
	public void spinnersChecking() {
		
		boolean spinnersExist = false;
		int startTime2;
		int elapsedTime2;
		
		try {
			
			
				startTime2 = 400;
				elapsedTime2 = startTime2 - 10;
				spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				
				while (spinnersExist == false && elapsedTime2 > 10) {
					elapsedTime2 = elapsedTime2 -10;
					spinnersExist = CommonFunctions.waitForInVisiblity(spinners, 1);
				}
				// System.out.println("Spinners is not here or timeout: " + spinnersExist);
				
		} catch (Exception e) {
			System.out.println("Spinners is still here or timeout: " + spinnersExist);
		}
	}	

}