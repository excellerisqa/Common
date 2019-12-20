package lars.objects;

import java.util.List;

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

public class LARS_BankDepositPage extends LoadableComponent<LARS_BankDepositPage> {

	

	


/* new code */
	
	
	@FindBy(xpath = "//img[@class='logo']")
	public WebElement lifelabsLogo;
	
	@FindBy(xpath = "//div[contains(text(),'Slip')]")
	public WebElement headerText;
	
	@FindBy(xpath = "//a[@href='#/deposit']")
	public WebElement bankDepositsTab;
	
	@FindBy(xpath = "//a[@href='#/reconcile']")
	public WebElement reconciliationsTab;
	
	@FindBy(xpath = "//a[@href='#/collect']")
	public WebElement dailyCollectionTotalForPSCTab;
	
	@FindBy(xpath = "//div[contains(text(),'Bank Deposit Slip')]")
	public WebElement bankDepositSlipTitle;
	
	@FindBy(xpath = "//div[contains(text(),'Total For PSC')]")
	public WebElement totalForPSCTitle;
	
	@FindBy(xpath = "//input[@name='collectDate']")
	public WebElement pscDateInput;
	
	@FindBy(xpath = "//input[@name='reconcileDate']")
	public WebElement eodDateInput;
	
	@FindBy(xpath = "//select[@id='selectedPsc']")
	public WebElement pscSelect;
	
	@FindBy(xpath = "//button[@id='btn-collect-go']")
	public WebElement pscGetCollectionTotalButton;
	
	@FindBy(xpath = "//button[@id='btn-currency-go']")
	public WebElement getPaymentButton;
	
	@FindBy(xpath = "//button[@id='btn-psc-go']")
	public WebElement getEODSButton;
	
	@FindBy(xpath = "//button[@class='btn btn-primary' and @data-ng-click='save();']")
	public WebElement submitButton;
	
	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	public WebElement printReportButton;
	
	@FindBy(xpath = "//textarea[@id='comment']")
	public WebElement commentTextBox;
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope' and contains(text(), 'Reconcile success')]")
	public WebElement messageDialog;
	
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope' and contains(text(), 'This end of day has already been confirmed.')]")
	public WebElement eodConfirmed;
	
	
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope' and contains(text(), 'This end of day is not exist')]")
	public WebElement eodNotExist;
	
	
	//select[@id='selectedPsc']
	
	// By psc = By.cssSelector("input[type=checkbox][value='980 - Testing BPL']");
	

	@FindBy(xpath = "//label[@class='navbarText' and contains(text(),'Cash')]")
	public WebElement cashCountLabel;
	
	
	@FindBy(xpath = "//div[@class='ng-binding' and contains(text(), '980')]/input[@id='selectedPsc']")
	public WebElement pscCheckBox;
	
	@FindBy(xpath = "//input[@data-ng-model='numOf5DollarNotes']")
	public WebElement cashCount_5Input;
	
	@FindBy(xpath = "//input[@data-ng-model='numOf10DollarNotes']")
	public WebElement cashCount_10Input;
	
	@FindBy(xpath = "//input[@data-ng-model='numOf20DollarNotes']")
	public WebElement cashCount_20Input;
	
	@FindBy(xpath = "//input[@data-ng-model='numOf50DollarNotes']")
	public WebElement cashCount_50Input;
	
	@FindBy(xpath = "//input[@data-ng-model='numOf100DollarNotes']")
	public WebElement cashCount_100Input;
	
	@FindBy(xpath = "//input[@data-ng-model='numOf1DollarCoins']")
	public WebElement coin_1Input;
	
	@FindBy(xpath = "//input[@data-ng-model='numOf2DollarCoins']")
	public WebElement coin_2Input;
	
	@FindBy(xpath = "//td[@class='col-sm-2 ng-binding' and text()=' $325.00']")
	public WebElement totalCashNotesLabel;
	
	@FindBy(xpath = "//td[@class='col-sm-2 ng-binding' and text()=' $15.50']")
	public WebElement totalCoinsLabel;
	
	@FindBy(xpath = "//td[@class='col-sm-2 ng-binding' and text()=' $340.50']")
	public WebElement totalCashCoinsLabel;
	
	
	
	
	
	
/* new code end */
	
	
	WebDriver driver = null;

	public LARS_BankDepositPage(WebDriver driver) {
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

/* new code start */
	
	public boolean clickBankDepositsTab(LARS_BankDepositPage bankDepositPage) {

		try {
			
			CommonFunctions.waitandClick(this.bankDepositsTab, 30);
	
			return CommonFunctions.waitForVisiblity(bankDepositPage.bankDepositSlipTitle, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickReconciliationsTab(LARS_BankDepositPage bankDepositPage) {

		try {
			
			CommonFunctions.waitandClick(this.reconciliationsTab, 30);
	
			return CommonFunctions.waitForVisiblity(bankDepositPage.headerText, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean clickDailyCollectionTotalForPSCTab(LARS_BankDepositPage bankDepositPage) {

		try {
			
			CommonFunctions.waitandClick(this.dailyCollectionTotalForPSCTab, 30);
	
			return CommonFunctions.waitForVisiblity(bankDepositPage.totalForPSCTitle, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean selectPSCAndClickPaymentButton(LARS_BankDepositPage bankDepositPage) {

		try {
			
			CommonFunctions.waitandClick(this.pscCheckBox, 30);
			CommonFunctions.waitandClick(this.getPaymentButton, 30);
			return CommonFunctions.waitForVisiblity(bankDepositPage.cashCountLabel, 30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean verifyTotal(String aCashCount_5, String aCashCount_10, String aCashCount_20, String aCashCount_50, String aCashCount_100, String aCoin_1, String aCoin_2,LARS_BankDepositPage bankDepositPage ) {

		try {
			
			CommonFunctions.waitandClear(cashCount_5Input, 30);
			cashCount_5Input.sendKeys(aCashCount_5);
		//	cashCount_5Input.sendKeys(Keys.TAB);
			CommonFunctions.waitandClear(cashCount_10Input, 30);
			cashCount_10Input.sendKeys(aCashCount_10);
			CommonFunctions.waitandClear(cashCount_20Input, 30);
			cashCount_20Input.sendKeys(aCashCount_20);
			CommonFunctions.waitandClear(cashCount_50Input, 30);
			cashCount_50Input.sendKeys(aCashCount_50);
			CommonFunctions.waitandClear(cashCount_100Input, 30);
			cashCount_100Input.sendKeys(aCashCount_100);
			
			CommonFunctions.waitandClear(coin_1Input, 30);
			coin_1Input.sendKeys(aCoin_1);
			CommonFunctions.waitandClear(coin_2Input, 30);
			coin_2Input.sendKeys(aCoin_2);
			
			return (CommonFunctions.waitForVisiblity(bankDepositPage.totalCashNotesLabel, 30) && CommonFunctions.waitForVisiblity(bankDepositPage.totalCoinsLabel, 30)
					&& CommonFunctions.waitForVisiblity(bankDepositPage.totalCashCoinsLabel, 30));
			
			
			
			
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

	/**
	 * DESCRIPTION: Enter date and click getCollectionTotal button,
	 * RETURNS: list if result:
	 */
	
	public int searchPSC(String aDate) {
	
		int aPSCResult = 0;
		
		
		try {
			
				CommonFunctions.waitandClear(pscDateInput, 30);
				pscDateInput.sendKeys(aDate);
	
				CommonFunctions.waitandClick(pscGetCollectionTotalButton, 30);
				
				//Thread.sleep(2000);
				
				
				
				aPSCResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M')]")).size();	
	
				
								
				System.out.println("Number of PSC for this table found: " + aPSCResult);
	
				return (aPSCResult);
	
		} catch (Exception e) {
			return aPSCResult;
		}
	
	}

	/**
	 * DESCRIPTION: Enter date, psc and click get EOD button,
	 * RETURNS: list if result:
	 */
	
	public int searchEOD(String aDate, String aPSC, String aAmount) {
	
		int aPSCResult = 0;
		
		
		try {
			
				CommonFunctions.waitandClear(eodDateInput, 30);
				eodDateInput.sendKeys(aDate);
				
				CommonFunctions.waitandClear(pscSelect, 30);
				pscSelect.sendKeys(aPSC);
	
				CommonFunctions.waitandClick(getEODSButton, 30);
				
				//Thread.sleep(2000);
				
				
				
				// aPSCResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M')]")).size();	
	
				//aPSCResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aAmount + "')]")).size();	
				
				aPSCResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'CASH')]")).size();
								
				System.out.println("Number of PSC for this table found: " + aPSCResult);
	
				return (aPSCResult);
	
		} catch (Exception e) {
			return aPSCResult;
		}
	
	}
	
	public boolean printReport(String aComment) {

		try {
			// Select psc = new Select(selectPscDropdown);
			// psc.selectByVisibleText(pscToSelect);
			Thread.sleep(2000);
			// searchButton.click();
			if (printReportButton.isDisplayed()) {
				commentTextBox.sendKeys(aComment);
				printReportButton.click(); 
				
				// verify a file is downloaded
				Thread.sleep(2000);
				if (CommonFunctions.waitForDownload("EODPaymentSummary.pdf"))
					return false;
				else {
					Thread.sleep(2000);
					CommonFunctions.archiveFile(ObjectHelper.downloadsFolder, "EODPaymentSummary.pdf");
					return true;
				}
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean submitReport(String aComment) {

		try {
			// Select psc = new Select(selectPscDropdown);
			// psc.selectByVisibleText(pscToSelect);
			Thread.sleep(2000);
			// searchButton.click();
			if (submitButton.isDisplayed()) {
				// commentTextBox.sendKeys(aComment);
				submitButton.click(); 
				
				// verify a file is downloaded
				// Thread.sleep(2000);
				if (CommonFunctions.waitForVisiblity(messageDialog, 10))
					return true;
				else {
					return false;
				}
			} else
				return false;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean EODHasBeenConfirmed() {

//		boolean eod = false;
		int eodMessageCount = 0;
		try {
			// Select psc = new Select(selectPscDropdown);
			// psc.selectByVisibleText(pscToSelect);
			//Thread.sleep(2000);
			// searchButton.click();
			eodMessageCount = driver.findElements(By.xpath("//span[@class='ng-binding ng-scope' and contains(text(), 'This end of day has already been confirmed.')]")).size();

			// No message, EOD has not been done
			if (eodMessageCount == 0) {
				return false;
			}
			
			// EOD has been confirmed.
			else
				return true;
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * DESCRIPTION: Enter date, psc and click get EOD button,
	 * RETURNS: list if result:
	 */
	
	public int searchInvalidEntry(String aDate, String aPSC, String aAmount) {
	
		int aPSCResult = 0;
		
		
		try {
			
				CommonFunctions.waitandClear(eodDateInput, 30);
				eodDateInput.sendKeys(aDate);
				
				CommonFunctions.waitandClear(pscSelect, 30);
				pscSelect.sendKeys(aPSC);
	
				CommonFunctions.waitandClick(getEODSButton, 30);
				
				//Thread.sleep(2000);
				
				
				
				// aPSCResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'M')]")).size();	
	
				aPSCResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'" + aAmount + "')]")).size();	
				
				//aPSCResult = ObjectHelper.driver.findElements(By.xpath("//td[contains(text(),'CASH')]")).size();
								
				System.out.println("Number of PSC for this table found: " + aPSCResult);
	
				return (aPSCResult);
	
		} catch (Exception e) {
			return aPSCResult;
		}
	
	}
	
	
}