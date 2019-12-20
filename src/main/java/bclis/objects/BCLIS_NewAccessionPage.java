package bclis.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ObjectHelper;

public class BCLIS_NewAccessionPage extends LoadableComponent<BCLIS_NewAccessionPage> {

	@FindBy(id = "billing_number")
	public WebElement billingNumberTextbox;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	public WebElement searchButton;

	@FindBy(xpath = "//button[contains(text(),'Enter Test')]")
	public WebElement enterTestButton;

	// @FindBy(xpath = "//select[@name='claim_type']")
	// public WebElement claimTypeDropdown;

	@FindBy(xpath = "//select[@name='claim_type']")
	public WebElement claimTypeDropdown;

	@FindBy(xpath = "//*[@id=\"accessionForm\"]/div[1]/div/div[15]/div/span/span/span/span")
	public WebElement claimTypeArrow;

	@FindBy(xpath = "//button[contains(@ng-click, 'orderedBy')]")
	public WebElement orderedByButton;

	@FindBy(xpath = "//button[contains(@ng-click, 'copyTo1')]")
	public WebElement copyToButton;

	@FindBy(xpath = "//button[contains(@ng-click, 'copyTo2')]")
	public WebElement copyTo2Button;

	@FindBy(id = "ordered_by")
	public WebElement orderedByTextbox;

	@FindBy(xpath = "//div[@id='header']//h1")
	public WebElement headerText;

	@FindBy(id = "update_reason")
	public WebElement reasonForUpdatingTextbox;

	@FindBy(id = "other_question")
	public WebElement enterInformationTextbox;

	@FindBy(name = "delete")
	public WebElement deleteAccessionButton;

	@FindBy(xpath = "//*[@id=\"client-change-modal\"]/div/div/div/form/div/button[2]")
	public WebElement okButton;

	@FindBy(xpath = "//*[@id=\"client-change-modal\"]/div/div/div/form/div/div[1]/span/span")
	public WebElement reasonsToUpdateDoctorList;

	// @FindBy(xpath =
	// "//*[@id=\"client-change-modal\"]/div/div/div/form/div/div[1]/span/span/span[2]/span")
	@FindBy(xpath = "//form[@name='clientChangeForm']//span[@class='k-select']")
	public WebElement reasonArrow;

	@FindBy(id = "accession_notes")
	public WebElement accessionCommentTextBox;

	@FindBy(xpath = "//*[@id=\"accessionForm\"]/div[1]/div/div[35]/div/span/span/input[1]")
	public WebElement supplementalLabelsTextBox;

	@FindBy(xpath = "//*[@id=\"special-info-modal\"]/div/div/div[2]/form/div/button[2]")
	public WebElement submitAndCloseButton;

	@FindBy(xpath = "//*[@id=\"accessionForm\"]/div[1]/div/div[26]/div/span/span/span[2]/span")
	public WebElement resultsContactArrow;

	@FindBy(xpath = "//*[@id=\"fax_number\"]")
	public WebElement faxNumberTextBOX;

	@FindBy(xpath = "//*[@id=\"stat\"]")
	public WebElement staCheckBox;

	@FindBy(xpath = "//*[@id=\"estimated_time\"]")
	public WebElement arrivalTime;

	@FindBy(xpath = "//*[@id=\"tests\"]/div[2]/table/tbody/tr/td[7]/p/a/i")
	public WebElement infoIcon;

	@FindBy(xpath = "//*[@id=\"comment\"]")
	public WebElement commentTextBox;

	@FindBy(id = "infoModalOKButton")
	public WebElement infoModalOKButton;

	@FindBy(xpath = "//*[@id=\"search-modal\"]/div/div/div/div[4]/button")
	public WebElement addClientButton;

	@FindBy(xpath = "//*[@id=\"addform\"]/div[1]/div[2]/div/label")
	public WebElement locumCheckBox;

	@FindBy(xpath = "//*[@id=\"addform\"]/div[1]/div[1]/div/span/span/span[2]/span")
	public WebElement clienTypeDropdownArrow;

	@FindBy(xpath = "//*[@id=\"addform\"]/div[1]/div[4]/div/span/span")
	public WebElement designationDropdownArrow;

	@FindBy(xpath = "// *[@id=\"addform\"]/div[1]/div[5]/div/input")
	public WebElement addClientBilingNumberTextBox;

	@FindBy(xpath = "// *[@id=\"addform\"]/div[1]/div[10]/div/input")
	public WebElement lastNameTextBox;

	@FindBy(xpath = "// *[@id=\"addform\"]/div[1]/div[11]/div/input")
	public WebElement firstNameTextBox;

	@FindBy(xpath = "// *[@id=\"addform\"]/div[1]/div[13]/div/input")
	public WebElement address1Textbox;

	@FindBy(xpath = "// *[@id=\"addform\"]/div[1]/div[15]/div/input")
	public WebElement address2Textbox;

	@FindBy(xpath = "// *[@id=\"city\"]")
	public WebElement cityTextBox;

	@FindBy(xpath = "// *[@id=\"addform\"]/div[1]/div[18]/div[1]/span/span/span[2]/span")
	public WebElement provinceDropdownArrow;

	@FindBy(xpath = "// *[@id=\"addform\"]/div[1]/div[19]/div/input")
	public WebElement zipCodeTextBox;

	@FindBy(xpath = "//*[@id=\"addform\"]/div[1]/div[21]/div/span/span")
	public WebElement countryDropdownArrow;

	@FindBy(xpath = "// *[@id=\"primary_phone\"]")
	public WebElement phoneNumberTextBox;

	@FindBy(id = "fax_number")
	public List<WebElement> faxNumberTextBoxes;

	@FindBy(xpath = "//ul[@id='result_contact_listbox']/li[contains(text() ,'Fax')]")
	public List<WebElement> faxvalue;

	@FindBy(xpath = "// *[@id=\"addform\"]/div[1]/div[27]/button[1]")
	public WebElement saveButton;

	WebDriver driver = null;

	public BCLIS_NewAccessionPage(WebDriver driver) {
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
	 * DESCRIPTION: searches for a billing number and clicks on the row starting
	 * with this billing number PARAMETERS: billing number RETURNS: true or false
	 * AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchForClientByBillingNumberAndSelectDoctor(String billingNumber) throws Exception {
		try {
			CommonFunctions.waitandClear(billingNumberTextbox, 20);
			billingNumberTextbox.sendKeys(billingNumber);

			searchButton.click();

			CommonFunctions.waitandClick(
					driver.findElements(By.xpath("//b[starts-with(text(),'" + billingNumber + "')]")).get(0), 20);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: searches by a billing number then selects a row that starts with
	 * the 2nd parameter PARAMETERS: billingNumber, row that starts with the String-
	 * toSelect RETURNS: true or false AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchForClientByBillingNumberAndSelectDoctor(String billingNumber, String toSelect)
			throws Exception {
		try {
			CommonFunctions.waitandClear(billingNumberTextbox, 20);
			billingNumberTextbox.sendKeys(billingNumber);

			searchButton.click();

			CommonFunctions.waitandClick(
					driver.findElements(By.xpath("//b[starts-with(text(),'" + toSelect + "')]")).get(0), 20);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: selects claim type PARAMETERS: claim type RETURNS: true or false
	 * AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean selectClaimType(String claimType) throws Exception {

		try {
			Select selectClaimType = new Select(claimTypeDropdown);
			for (WebElement option : selectClaimType.getOptions()) {
				if (!option.isSelected() && option.getText().equals(claimType))
					option.click();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: reads claim type PARAMETERS: RETURNS: claim type AUTHOR: Bhavna
	 * Karanjekar MODIFIED BY:
	 */
	public String getClaimType() throws Exception {
		try {
			CommonFunctions.waitForVisiblity(claimTypeDropdown, 20);

			Select selectClaimType = new Select(claimTypeDropdown);
			return selectClaimType.getFirstSelectedOption().getText();
		} catch (Exception e) {
			return "no selected claim found";
		}
	}

	/**
	 * DESCRIPTION: enters reason to update an accession PARAMETERS: reason RETURNS:
	 * true or false AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean enterReasonForUpdating(String reason) {
		try {
			CommonFunctions.waitandClear(reasonForUpdatingTextbox, 20);
			reasonForUpdatingTextbox.sendKeys(reason);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: clicks enter test button PARAMETERS: RETURNS: true or false
	 * AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean goToEnterTest(BCLIS_AddTestPage addTestPage) throws Exception {
		try {
			CommonFunctions.waitandClick(enterTestButton, 20);
			// return (CommonFunctions.waitForVisiblity(addTestPage.searchTestTextbox, 20)
			// || addTestPage.testPtYesRadioButton.isDisplayed());
			return true; // sometime the search test box is not visible, because as soon
			// as enter test
			// button is clicked, a pop-up comes up for a previously added test
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: changes the ordering doctor PARAMETERS: billing number RETURNS:
	 * true or false AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean modifyOrderedByDoctor(String billingNumber) throws Exception {
		try {
			CommonFunctions.waitandClick(orderedByButton, 20);
			searchForClientByBillingNumberAndSelectDoctor(billingNumber);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: changes the CC doctor PARAMETERS: billing number RETURNS: true
	 * or false AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean modifyCopyToDoctor(String billingNumber) throws Exception {

		try {

			CommonFunctions.waitandClick(copyToButton, 20);

			searchForClientByBillingNumberAndSelectDoctor(billingNumber.split(",")[0], billingNumber.split(",")[1]);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * DESCRIPTION: searches for billing number, then selects a doc by the
	 * docToSelect, then searches the locumFor doc and selects it PARAMETERS:
	 * billingNumber, docToSelect, locumFor RETURNS: true or false AUTHOR: Bhavna
	 * Karanjekar MODIFIED BY:
	 */
	public boolean searchCCLocumDoctor(String billingNumber, String docToSelect, String locumFor) throws Exception {
		try {
			CommonFunctions.waitandClick(copyToButton, 20);
			searchForClientByBillingNumberAndSelectDoctor(billingNumber, docToSelect);
			searchForClientByBillingNumberAndSelectDoctor(locumFor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: enters information PARAMETERS: info RETURNS: true or false
	 * AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean enterInformation(String info) throws Exception {
		try {
			CommonFunctions.waitandClear(enterInformationTextbox, 20);
			enterInformationTextbox.sendKeys(info);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// public String getOrderingDoctor() throws Exception { //does not get text from
	// the textbox
	// CommonFunctions.waitForVisiblity(orderedByTextbox, 20);
	// String a = orderedByTextbox.getText(); // returns blank hence commented this
	// function
	//
	// return orderedByTextbox.getText();
	//
	// }

	/**
	 * DESCRIPTION: Deletes Accession PARAMETERS: none RETURNS: true or false
	 * Karanjekar MODIFIED BY:
	 */
	public boolean deleteAccession() throws Exception {

		try {
			CommonFunctions.waitandClick(deleteAccessionButton, 20);

			CommonFunctions.chainclicksonpopupOKAndClose();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean selectReasonfordoctorupdate(String reasonforupdate) throws Exception {
		// CommonFunctions.waitForVisiblity(testQuestionPatientIdProvidedDropdown, 20);
		try {
			CommonFunctions.clickonmodalpopup(reasonArrow);
			CommonFunctions.clickonmodalpopup(reasonArrow);
			CommonFunctions.clickonmodalpopup(reasonArrow);

			// CommonFunctions.waitandClick(
			// driver.findElement(
			// By.xpath("//ul[@id='client-change-reason_listbox']//li[text()='" +
			// reasonforupdate + "']")),
			// 2);
			CommonFunctions.clickUsingJavaExecutor(driver.findElement(
					By.xpath("//ul[@id='client-change-reason_listbox']//li[text()='" + reasonforupdate + "']")));

			// CommonFunctions.waitandClick(reasonsToUpdateDoctorList, 20);

			// Select reason = new Select(reasonsToUpdateDoctorList);
			// reason.selectByVisibleText(reasonforupdate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean enterAccessionComments(String accessioncomments) {
		try {
			CommonFunctions.waitandClear(accessionCommentTextBox, 20);
			accessionCommentTextBox.sendKeys(accessioncomments);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean searchOrderingLocumDoctor(String billingNumber, String docToSelect, String locumFor)
			throws Exception {

		try {
			searchForClientByBillingNumberAndSelectDoctor(billingNumber, docToSelect);
			searchForClientByBillingNumberAndSelectDoctor(locumFor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean entersupplementallabels(String supplementallabels) {
		try {

			CommonFunctions.ClearAndSetText(supplementalLabelsTextBox, supplementallabels);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean selectPatientClaimType(String claimtype) throws Exception {

		try {
			CommonFunctions.waitandClick(claimTypeArrow, 20);

			Thread.sleep(2000);

			CommonFunctions.waitandClick(driver.findElement(
					By.xpath("//ul[@id='claim_type_listbox']/li[contains(text() ,'" + claimtype + "')]")), 20);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean selectResultsContact(String priority) throws Exception {

		try {

			CommonFunctions.waitandClick(resultsContactArrow, 50);

			CommonFunctions.waitandClick(resultsContactArrow, 50);
			CommonFunctions.waitandClick(resultsContactArrow, 50);
			CommonFunctions.waitandClick(resultsContactArrow, 200);

			Thread.sleep(20000);

			ObjectHelper.driver
					.findElement(
							By.xpath("//ul[@id='result_contact_listbox']/li[contains(text() ,'" + priority + "')]"))
					.click();

			switch (priority) {

			case "Fax":
				faxNumberTextBOX.sendKeys("2365219999");
				staCheckBox.click();
				CommonFunctions.waitForVisiblity(arrivalTime, 20);
				arrivalTime.sendKeys("21:30");
				break;

			case "Phone":
				System.out.println("Phone Number Added ");
				break;

			default:
				System.out.println("Selected " + priority);
				break;

			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean enterTestLevelComments(String comments) {

		try {
			CommonFunctions.waitandClick(infoIcon, 20);

			CommonFunctions.waitandClear(commentTextBox, 20);

			commentTextBox.sendKeys(comments);
			Thread.sleep(2000);
			CommonFunctions.clickonmodalpopup(infoModalOKButton);

			return true;
		}

		catch (Exception e) {
			return false;

		}

	}

	public boolean addNewClient(String clientType, String designation, String billingNumber, String lastName,
			String firstName, String address1, String address2, String city, String province, String zipCode,
			String country, String phoneNumber, String faxNumber, String locum) throws Exception {
		try {

			CommonFunctions.waitandClear(billingNumberTextbox, 20);

			billingNumberTextbox.sendKeys(billingNumber);

			searchButton.click();
			CommonFunctions.waitandClick(addClientButton, 20);

			CommonFunctions.waitForVisiblity(provinceDropdownArrow, 20);

			if (!clientType.equals("No Change")) {
				CommonFunctions.waitandClick(clienTypeDropdownArrow, 20);

				Thread.sleep(2000);

				CommonFunctions.waitandClick(
						driver.findElement(
								By.xpath("//ul[@id=\"provider_listbox\"]/li[contains(text() ,'" + clientType + "')]")),
						20);
				Thread.sleep(2000);

			}

			if (!locum.equals("No Change")) {

				locumCheckBox.click();
			}

			if (!designation.equals("No Change")) {
				if (!designation.equals("No Change")) {
					CommonFunctions.waitandClick(designationDropdownArrow, 20);

					Thread.sleep(2000);

					CommonFunctions.waitandClick(
							driver.findElement(By.xpath(
									"//ul[@id=\"designation_listbox\"]/li[contains(text() ,'" + designation + "')]")),
							20);

					Thread.sleep(2000);
				}

				if (!billingNumber.equals("No Change")) {
					addClientBilingNumberTextBox.clear();
					addClientBilingNumberTextBox.sendKeys(billingNumber);
				}

				if (!lastName.equals("No Change")) {
					lastNameTextBox.clear();
					lastNameTextBox.sendKeys(lastName);
				}

				if (!firstName.equals("No Change")) {
					firstNameTextBox.clear();
					firstNameTextBox.sendKeys(firstName);
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
					cityTextBox.clear();
					cityTextBox.sendKeys(city);
				}

				if (!province.equals("No Change")) {
					CommonFunctions.waitandClick(provinceDropdownArrow, 20);
					Thread.sleep(2000);
					CommonFunctions.waitandClick(
							driver.findElement(By
									.xpath("//ul[@id=\"province_listbox\"]/li[contains(text() ,'" + province + "')]")),
							20);

					Thread.sleep(2000);

				}

			}

			if (!zipCode.equals("No Change")) {
				zipCodeTextBox.clear();
				zipCodeTextBox.sendKeys(zipCode);
			}

			if (!country.equals("No Change")) {
				CommonFunctions.waitandClick(countryDropdownArrow, 20);
				Thread.sleep(2000);
				CommonFunctions.waitandClick(driver.findElement(
						By.xpath("//ul[@id=\"country_listbox\"]/li[contains(text() ,'" + country + "')]")), 20);

				Thread.sleep(2000);
			}

			if (!phoneNumber.equals("No Change")) {
				phoneNumberTextBox.clear();
				phoneNumberTextBox.sendKeys(phoneNumber);
			}

			if (!faxNumber.equals("No Change")) {
				CommonFunctions.waitandClear(faxNumberTextBoxes.get(1), 20);
				faxNumberTextBoxes.get(1).sendKeys(faxNumber);
			}

			saveButton.click();
			return true;
		} catch (

		Exception e) {
			return false;
		}
	}
}
