package bclis.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class BCLIS_AddTestPage extends LoadableComponent<BCLIS_AddTestPage> {

	@FindBy(id = "search_test")
	public WebElement searchTestTextbox;

	@FindBy(xpath = "//button[contains(text(),'Add Test')]")
	public WebElement addTestButton;

	@FindBy(xpath = "//div[@id='pane2']//button[contains(text(),'Submit Accession')]")
	public WebElement submitAccessionButton;

	@FindBy(xpath = "//div[@class='row']//h5[contains(text(),'Created Successfully')]")
	public WebElement orderCreatedModalMessage;

	@FindBy(xpath = "//div[@class='row']//h5[contains(text(),'Created Successfully')]/../button[contains(text(),'Close')]")
	public WebElement closeButton;

	@FindBy(xpath = "//button[text()='OK' and @ng-click='specialInfoViewModel.submit()']")
	public WebElement OkOnModalButton;

	@FindBy(id = "question0")
	public WebElement testFlipQuestionTextbox;

	@FindBy(xpath = "//select[@id='question0']")
	public WebElement testQuestionPatientIdProvidedDropdown;

	@FindBy(id = "question1")
	public WebElement testQuestion1Textbox;

	@FindBy(xpath = "//select[@id='question2']")
	public WebElement testQuestion2Dropdown;

	@FindBy(xpath = "//input[@id='question2']")
	public WebElement testQuestion2Textbox;

	@FindBy(xpath = "//select[@id='question3']")
	public WebElement testQuestion3Dropdown;

	@FindBy(xpath = "//button[@ng-click='questionnaire.submit()']")
	public WebElement testQuestionbButton;

	@FindBy(id = "questionnaireResponseY0")
	public WebElement testPtYesRadioButton;

	@FindBy(xpath = "//button[@ng-click='questionnaire.submit()']")
	public WebElement testPtQuestionbButton;

	@FindBy(xpath = "//select[contains(@ng-change,'updateClaim')]")
	// *[@id="tests"]/div[2]/table/tbody/tr[1]/td[4]/select
	public WebElement claimTypeDropdown;

	@FindBy(xpath = "//select[contains(@ng-change,'updatePriority')]")
	public WebElement priorityeDropdown;

	@FindBy(xpath = "//button[@ng-click='deleteConfirmationViewModel.okClicked()']")
	public WebElement deleteConfirmationOKButton;

	@FindBy(xpath = "//i[@class='icon icon-delete']")
	public List<WebElement> allDeleteIcons;

	@FindBy(xpath = "//*[@id=\"fax_number\"]")
	public WebElement faxNumberTextBOX;

	@FindBy(xpath = "//*[@id=\"stat\"]")
	public WebElement staCheckBox;

	@FindBy(xpath = "//*[@id=\"estimated_time\"]")
	public WebElement arrivalTime;

	@FindBy(xpath = "//*[@id=\"tests\"]/div[2]/table/tbody/tr/td[7]/p/a/i")
	public WebElement infoIcon;

	@FindBy(xpath = "//*[@id=\"special-info-modal\"]/div/div/div[2]/form/div/button[1]")
	public WebElement okButton;

	WebDriver driver = null;

	public BCLIS_AddTestPage(WebDriver driver) {
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
	 * DESCRIPTION: Searches and Adds tests PARAMETERS: comma separated test codes
	 * RETURNS : new page object as it is refreshed after adding the tests AUTHOR:
	 * Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean searchAndAddTests(String testCodes, BCLIS_AddTestPage addTestPage) throws Exception {

		try {
			String[] tests = testCodes.split(",");
			// there may be a pop up coming up as soon as you land on this page, for a
			// previously added test
			if (!(CommonFunctions.waitForVisiblity(searchTestTextbox, 10))) {
				if (testPtYesRadioButton.isDisplayed()) {
					testPtYesRadioButton.click();
					testPtQuestionbButton.click();
					testFlipQuestionTextbox.sendKeys("COWA");
					testQuestionbButton.click();
				}
			}
			for (String test : tests) {
				CommonFunctions.waitandClear(searchTestTextbox, 20);
				searchTestTextbox.sendKeys(test);
				CommonFunctions.waitandClick(addTestButton, 20);

				switch (test) {

				case "FLIP":
					CommonFunctions.waitandClick(OkOnModalButton, 20);
					CommonFunctions.waitandClear(testFlipQuestionTextbox, 20);
					testFlipQuestionTextbox.sendKeys("12");
					testQuestionbButton.click();

					System.out.println("Added FLIP");
					break;

				case "PT":
					CommonFunctions.waitandClick(testPtYesRadioButton, 20);
					testPtQuestionbButton.click();
					testFlipQuestionTextbox.sendKeys("COWA");
					testQuestionbButton.click();

					System.out.println("Added PT");
					break;

				case "DIG":
					CommonFunctions.waitandClear(testFlipQuestionTextbox, 20);

					testFlipQuestionTextbox.sendKeys(getYesterdaysDate());
					testQuestion1Textbox.sendKeys("1800");
					Select sel = new Select(testQuestion2Dropdown);
					sel.selectByVisibleText("BID");
					testQuestionbButton.click();

					System.out.println("Added DIG");
					break;

				case "TFAD":
					CommonFunctions.waitandClear(testFlipQuestionTextbox, 20);
					testFlipQuestionTextbox.sendKeys("0");
					testQuestionbButton.click();

					System.out.println("Added TFAD");
					break;

				case "UDP":
					CommonFunctions.waitForVisiblity(testQuestionPatientIdProvidedDropdown, 20);
					Select selPatientIdProvided = new Select(testQuestionPatientIdProvidedDropdown);
					selPatientIdProvided.selectByVisibleText("Y");
					testQuestion1Textbox.sendKeys(getYesterdaysDate());
					testQuestion2Textbox.sendKeys("9:00");
					Select selTemperature = new Select(testQuestion3Dropdown);
					selTemperature.selectByVisibleText("Y - Temperature in range");

					testQuestionbButton.click();

					System.out.println("Added UDP");
					break;

				case "BGRT":
					CommonFunctions.waitandClick(testPtYesRadioButton, 20);
					testPtQuestionbButton.click();
					CommonFunctions.waitandClick(OkOnModalButton, 20);
					// *[@id="questionnaire-modal"]/div/div/div[2]/form/div/div[2]/button[2]

					System.out.println("Added BGRT");
					break;

				case "PNHBSAG":

					CommonFunctions.waitandClick(OkOnModalButton, 20);
					// *[@id="questionnaire-modal"]/div/div/div[2]/form/div/div[2]/button[2]

					System.out.println("Added PNHBSAG");
					break;

				case "HBVD":

					CommonFunctions.waitandClick(OkOnModalButton, 20);
					// *[@id="questionnaire-modal"]/div/div/div[2]/form/div/div[2]/button[2]

					System.out.println("Added HBVD");
					break;

				default:
					System.out.println("Added " + test);
					break;
				}

			}
			addTestPage = new BCLIS_AddTestPage(ObjectHelper.driver);
			// check whether all the intended tests are added
			return addTestPage.areAllTestsAdded(testCodes);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: returns yesterday's date as String PARAMETERS: RETURNS: returns
	 * yesterday's date as String AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public String getYesterdaysDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		return String.valueOf(dateFormat.format(cal.getTime()));
	}

	/**
	 * DESCRIPTION: clicks submit accession PARAMETERS: RETURNS: AUTHOR: Bhavna
	 * Karanjekar MODIFIED BY:
	 */
	public boolean submitAccession() throws Exception {
		try {
			Thread.sleep(5000); // inserting delay add/delete tests if any and then submit
			CommonFunctions.waitandClick(submitAccessionButton, 20);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: verifies Success message on submitting accession PARAMETERS:
	 * RETURNS: Accession number AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public String verifySuccessMessageAndClose() throws Exception {
		try {
			String message = CommonFunctions.getMessageOnModalPopupAndClose(orderCreatedModalMessage, closeButton);

			// if successfully created returns the Accession Number
			if (message.contains("Created Successfully"))
				return message.split("#")[1].split("Created")[0].trim();
			else
				return "error";
		} catch (Exception e) {

			return "error";
		}

	}

	/**
	 * DESCRIPTION: verifies whether all intended tests are added PARAMETERS: comma
	 * separated test codes RETURNS: true if all tests are added AUTHOR: Bhavna
	 * Karanjekar MODIFIED BY:
	 */
	public boolean areAllTestsAdded(String testCodes) throws Exception {

		try {
			boolean areAllTestsAdded = false;
			String[] tests = testCodes.split(",");
			// CommonFunctions.waitForVisiblity(By.xpath("//p[text() = '" + tests[0] +
			// "']"), 20);
			Thread.sleep(3000);
			for (String test : tests) {
				if (ObjectHelper.driver.findElement(By.xpath("//p[text() = '" + test + "']")).isDisplayed())
					areAllTestsAdded = true;
				else {
					areAllTestsAdded = false;
					break;
				}

			}
			return areAllTestsAdded;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: selects claim type PARAMETERS: claim type RETURNS: AUTHOR:
	 * Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean selectClaimType(String claimType) throws Exception {
		try {
			CommonFunctions.waitForVisiblity(claimTypeDropdown, 20);

			Select selectClaimType = new Select(claimTypeDropdown);
			if (!selectClaimType.getFirstSelectedOption().getText().equals(claimType))
				selectClaimType.selectByVisibleText(claimType);
			// check for the selected claim
			return getClaimType().equals(claimType);
		} catch (Exception e) {
			return false;
		}

	}

	public boolean selectpriority(String priority) throws Exception {
		try {

			CommonFunctions.waitForVisiblity(priorityeDropdown, 20);

			Select selectClaimType = new Select(priorityeDropdown);
			if (!selectClaimType.getFirstSelectedOption().getText().equals(priority))
				selectClaimType.selectByVisibleText(priority);

			switch (priority) {

			case "Fax":
				CommonFunctions.waitandClick(infoIcon, 20);
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

			// check for the selected claim
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
			return "cannot read claim";
		}

	}

	/**
	 * DESCRIPTION: deletes the first test in the list PARAMETERS: RETURNS: AUTHOR:
	 * Bhavna Karanjekar MODIFIED BY:
	 */

	public boolean deleteFirstTest() throws Exception {

		// CommonFunctions.waitandClick(allDeleteIcons.get(0), 20); //gave stale element
		// exception
		try {
			Thread.sleep(3000);
			allDeleteIcons.get(0).click();
			CommonFunctions.waitandClick(deleteConfirmationOKButton, 20);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}