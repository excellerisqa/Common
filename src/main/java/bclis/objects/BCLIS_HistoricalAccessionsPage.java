package bclis.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BCLIS_HistoricalAccessionsPage extends LoadableComponent<BCLIS_HistoricalAccessionsPage> {

	@FindBy(id = "inputHealthCardNumber")
	public WebElement healthCardNumberTextbox;

	@FindBy(id = "accession_number")
	public WebElement accessionNumberTextbox;

	@FindBy(id = "last_name")
	public WebElement lastNameTextbox;

	@FindBy(id = "first_name")
	public WebElement firstNameTextbox;

	@FindBy(id = "inputDOB")
	public WebElement dateOfBirthTextbox;

	@FindBy(id = "search")
	public WebElement searchButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement cancelButton;

	WebDriver driver = null;

	public BCLIS_HistoricalAccessionsPage(WebDriver driver) {
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
	 * DESCRIPTION: searches accession using health card number PARAMETERS: health
	 * card number RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchAccessionWithHealthCardNumber(String healthCardNumber,
			BCLIS_HistoricalAccessionsPage historicalAccessionsPage) throws Exception {
		try {
			CommonFunctions.waitandClear(healthCardNumberTextbox, 20);
			healthCardNumberTextbox.sendKeys(healthCardNumber);
			searchButton.click();

			// wait and check for patient in result
			return (historicalAccessionsPage.countSearchResultDisplayed(healthCardNumber) > 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: searches accession using accession number PARAMETERS: accession
	 * number RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchAccessionWithAccessionNumber(String accessionNumber,
			BCLIS_PatientDemographicsPage patientDemographicsPage) throws Exception {
		try {
			CommonFunctions.waitandClear(accessionNumberTextbox, 20);
			accessionNumberTextbox.sendKeys(accessionNumber);
			Thread.sleep(1000);
			searchButton.click();
			Thread.sleep(3000);
			// if (driver.getCurrentUrl().contains("/historicalAccession/search")) {
			if (driver.findElements(By.xpath("//button[@ng-click='close();']")).size() > 0) {
				ObjectHelper.driver.switchTo().activeElement();

				WebElement element = ObjectHelper.driver.findElement(By.xpath("//button[@ng-click='close();']"));
				JavascriptExecutor js = (JavascriptExecutor) ObjectHelper.driver;
				js.executeScript("arguments[0].click();", element);

				ObjectHelper.driver.switchTo().activeElement();

				CommonFunctions.waitandClick(cancelButton, 10);

				return false;
			} else
				return CommonFunctions.waitForVisiblity(patientDemographicsPage.confirmPatientButton, 3);

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: searches accession using last name first name and Date of birth
	 * PARAMETERS: last name first name and Date of birth RETURNS: void AUTHOR:
	 * Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchAccessionWithNameAndDOB(String lastName, String firstName, String dateOfBirth,
			BCLIS_HistoricalAccessionsPage historicalAccessionsPage) throws Exception {
		try {
			CommonFunctions.waitandClear(healthCardNumberTextbox, 20);

			CommonFunctions.waitandClear(lastNameTextbox, 20);
			lastNameTextbox.sendKeys(lastName);

			CommonFunctions.waitandClear(firstNameTextbox, 20);
			firstNameTextbox.sendKeys(firstName);

			CommonFunctions.waitandClear(dateOfBirthTextbox, 20);
			dateOfBirthTextbox.sendKeys(dateOfBirth);

			searchButton.click();
			return (historicalAccessionsPage.countSearchResultDisplayed(lastName, firstName, dateOfBirth) > 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: gets count of the search result rows that contains the health
	 * card number PARAMETERS: health card number RETURNS: count of the search
	 * result rows AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public int countSearchResultDisplayed(String healthCardNumber) throws Exception {
		CommonFunctions.waitForVisiblity(By.xpath("//a[contains(text(),'" + healthCardNumber + "')]"), 20);
		return driver.findElements(By.xpath("//a[contains(text(),'" + healthCardNumber + "')]")).size();
	}

	/**
	 * DESCRIPTION: gets count of the search result rows that contains the name and
	 * the DOB PARAMETERS: last name, first name and date of birth RETURNS: count of
	 * the search result rows AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public int countSearchResultDisplayed(String lastName, String firstName, String dateOfBirth) throws Exception {
		try {
			String queryName = lastName + " " + firstName;
			String queryDOB = dateOfBirth;
			CommonFunctions.waitForVisiblity(
					By.xpath("//a[contains(text(),'" + queryName + "') and contains(text()," + queryDOB + "')]"), 20);
			return (driver.findElements(
					By.xpath("//a[contains(text(),'" + queryName + "') and contains(text(),'" + queryDOB + "')]")))
							.size();
		} catch (Exception e) {
			return 0;
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
