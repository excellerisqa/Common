package bclis.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.CommonFunctions;

public class BCLIS_ContractServicesEntryPage extends LoadableComponent<BCLIS_ContractServicesEntryPage> {

	@FindBy(id = "cseAccountId")
	public WebElement cseAccountIdTextbox;

	@FindBy(xpath = "//button[@ng-click='viewModel.navContinue()']")
	public WebElement continueButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement cancelButton;

	WebDriver driver = null;

	public BCLIS_ContractServicesEntryPage(WebDriver driver) {
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
	 * DESCRIPTION: enters the account number and then selects the same from the
	 * dropdown and clicks continue PARAMETERS: account number RETURNS: AUTHOR:
	 * Bhavna Karanjekar MODIFIED BY:
	 */
	public boolean enterSelectAccountNumberAndContinue(String accountNumber, BCLIS_PatientSearchPage patientSearchPage)
			throws Exception {
		try {
			CommonFunctions.waitandClear(cseAccountIdTextbox, 20);
			cseAccountIdTextbox.sendKeys(accountNumber);
			CommonFunctions.waitandClick(By.xpath("//li[text()='" + accountNumber + "']"), 20);
			CommonFunctions.waitandClick(continueButton, 20);
			// wait and check for visibility of province dropdown on patientSearchPage page
			return CommonFunctions.waitForVisiblity(patientSearchPage.provinceDropdown, 20);
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
