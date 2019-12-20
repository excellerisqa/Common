package bclis.objects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
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

public class BCLIS_PatientNotesPage extends LoadableComponent<BCLIS_PatientNotesPage> {

	@FindBy(id = "add_new_note_button")
	public WebElement addNewNoteButton;

	@FindBy(id = "lineOneNote")
	public List<WebElement> allNoteTextboxes;

	@FindBy(xpath = "//select[@id='Freq']")
	public List<WebElement> allFrequencyDropdowns;

	@FindBy(xpath = "//button[contains(text(),'Save Note')]")
	public List<WebElement> allSaveNoteButtons;

	@FindBy(xpath = "//i[@class='fa fa-pencil-square-o']")
	public List<WebElement> allEditNoteButtons;

	@FindBy(id = "new_accession_btn")
	public WebElement newAccessionButton;

	@FindBy(id = "tabDemographics")
	public WebElement patientDemographicsTab;

	@FindBy(id = "tabStandingOrders")
	public WebElement standingOrdersTab;

	@FindBy(xpath = "//span[@class='input-group-addon top-right']/i")
	public List<WebElement> deleteNoteIcons;

	WebDriver driver = null;

	public BCLIS_PatientNotesPage(WebDriver driver) {
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
	 * DESCRIPTION: adds a new note with a text and random number suffix PARAMETERS:
	 * note text and frequency RETURNS: new note text AUTHOR: Bhavna Karanjekar
	 * MODIFIED BY:
	 */
	public String addNewNote(String newNote, String frequency) throws Exception {
		try {
			int suffix = new Random().nextInt();
			CommonFunctions.waitandClick(addNewNoteButton, 20);
			WebElement newNoteTextbox = allNoteTextboxes.get(allNoteTextboxes.size() - 1);

			CommonFunctions.waitandClear(newNoteTextbox, 20);
			newNoteTextbox.sendKeys(newNote + String.valueOf(suffix));

			Select newFrequency = new Select(allFrequencyDropdowns.get(allFrequencyDropdowns.size() - 1));

			newFrequency.selectByVisibleText(frequency);

			WebElement saveNewNoteButton = allSaveNoteButtons.get(allSaveNoteButtons.size() - 1);
			saveNewNoteButton.click();
			return newNote + String.valueOf(suffix);
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * DESCRIPTION: edits a note PARAMETERS: note number to edit, new note text, new
	 * frequency RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public void editNote(String noteNumber, String newNoteText, String newFrequency) throws Exception {

		if (!CommonFunctions.waitForVisiblity(allEditNoteButtons.get(0), 20))
			throw new Exception("No Note is seen to be able to edit.");

		WebElement noteToEditIcon = allEditNoteButtons.get(Integer.parseInt(noteNumber) - 1);

		CommonFunctions.waitForVisiblity(noteToEditIcon, 20);
		noteToEditIcon.click();

		WebElement noteToEditTextbox = allNoteTextboxes.get(Integer.parseInt(noteNumber) - 1);
		CommonFunctions.waitandClear(noteToEditTextbox, 20);
		noteToEditTextbox.sendKeys(newNoteText);

		Select frequencyToEdit = new Select(allFrequencyDropdowns.get(Integer.parseInt(noteNumber) - 1));
		frequencyToEdit.selectByValue(newFrequency);

		WebElement saveNewNoteButton = allSaveNoteButtons.get(Integer.parseInt(noteNumber) - 1);
		saveNewNoteButton.click();

	}

	/**
	 * DESCRIPTION: clicks new accession button PARAMETERS: RETURNS: void AUTHOR:
	 * Bhavna Karanjekar MODIFIED BY:
	 */
	public void goToNewAccession() throws Exception {
		CommonFunctions.waitandClick(newAccessionButton, 20);
	}

	/**
	 * DESCRIPTION: hovers and clicks patient demographics tab PARAMETERS: none
	 * RETURNS: void AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public void goToPatientDemographics() throws Exception {
		Thread.sleep(3000);
		CommonFunctions.waitForVisiblity(patientDemographicsTab, 20);

		new Actions(driver).moveToElement(patientDemographicsTab).build().perform();

		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.attributeContains(patientDemographicsTab, "class", "k-state-hover"));
		patientDemographicsTab.click();

	}

	/**
	 * DESCRIPTION: find a note with the note text and verifies its frequency
	 * PARAMETERS: noteText to look for and frequency to verify RETURNS: void
	 * AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean verifyFrequencyForNote(String noteText, String frequency) throws Exception {
		try {
			Thread.sleep(3000);

			CommonFunctions.waitForVisiblity(
					By.xpath("//span[text()='" + frequency + "']/../../..//span[contains(text(),'" + noteText + "')]"),
					20);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DESCRIPTION: hovers and clicks Standing Order tab PARAMETERS: RETURNS: void
	 * AUTHOR: Bhavna Karanjekar MODIFIED BY:
	 */
	public void goToStandingOrder() throws Exception {
		Thread.sleep(3000);

		new Actions(driver).moveToElement(standingOrdersTab).build().perform();

		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.attributeContains(standingOrdersTab, "class", "k-state-hover"));
		standingOrdersTab.click();
	}

	public boolean deleteExistingNotes() throws Exception {
		try {
			for (WebElement icon : deleteNoteIcons) {
				CommonFunctions.waitandClick(icon, 20);
				CommonFunctions.waitForAlertAndAccept(10);

			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteNote(String noteText, String frequency) throws Exception {
		try {
			CommonFunctions.waitandClick(By.xpath("//span[text()='" + frequency + "']/../../..//span[contains(text(),'"
					+ noteText + "')]/../../../following-sibling::div//span[@class='input-group-addon top-right']/i"),
					20);
			CommonFunctions.waitForAlertAndAccept(10);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
